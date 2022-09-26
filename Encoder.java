import java.util.Random;

public class Encoder {
    private Random randomOffsetGenerator = new Random();

    public String encode(String plainText) {
        char[] plainTextCharArray = plainText.toCharArray();
        int offsetIndex = randomOffsetGenerator.nextInt(ReferenceTable.SIZE);

        String encodedText = Character.toString(ReferenceTable.getCharacterFromIndex(offsetIndex));
        for (int i = 0; i < plainTextCharArray.length; i++) {
            // if input character is space, add space to encoded text and continue
            // OR if input character is not in reference table, map back to itself
            if (!ReferenceTable.containsCharacter(plainTextCharArray[i])) {
                encodedText += plainTextCharArray[i];
                continue;
            }

            // calculate shifted index, wrapping around to end of table if shifted index is negative
            int shiftedIndex = (ReferenceTable.getIndexFromCharacter(plainTextCharArray[i]) - offsetIndex) % ReferenceTable.SIZE;
            if (shiftedIndex < 0) {
                shiftedIndex += ReferenceTable.SIZE;
            }

            // append encoded character to final encoded text
            encodedText += ReferenceTable.getCharacterFromIndex(shiftedIndex);
        }

        return encodedText;
    }

    public String decode(String encodedText) {
        char[] encodedTextCharArray = encodedText.toCharArray();
        int offsetIndex = ReferenceTable.getIndexFromCharacter(encodedTextCharArray[0]);

        String plainText = "";
        for (int i = 1; i < encodedTextCharArray.length; i++) {
            // if input character is space, add space to encoded text and continue
            // OR if input character is not in reference table, map back to itself
            if (!ReferenceTable.containsCharacter(encodedTextCharArray[i])) {
                plainText += encodedTextCharArray[i];
                continue;
            }

            // calculate shifted index, wrapping around to start of table if shifted index exceeds last index
            int shiftedIndex = (ReferenceTable.getIndexFromCharacter(encodedTextCharArray[i]) + offsetIndex) % ReferenceTable.SIZE;

            // append encoded character to final decoded text
            plainText += ReferenceTable.getCharacterFromIndex(shiftedIndex);
        }

        return plainText;
    }
}