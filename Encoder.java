import java.util.Random;

public class Encoder {

    private ReferenceTable referenceTable;
    private Random randomOffsetGenerator;

    public Encoder(ReferenceTable referenceTable) {
        this.referenceTable = referenceTable;
        randomOffsetGenerator = new Random();
    }

    public String encode(String plainText) {
        char[] plainTextCharArray = plainText.toCharArray();
        int offsetIndex = randomOffsetGenerator.nextInt(referenceTable.getSize());

        String encodedText = Character.toString(referenceTable.getEntryFromIndex(offsetIndex));
        for (int i = 0; i < plainTextCharArray.length; i++) {
            // if input character is space, add space to encoded text and continue
            // OR if input character is not in reference table, map back to itself
            if (!referenceTable.containsCharacter(plainTextCharArray[i])) {
                encodedText += plainTextCharArray[i];
                continue;
            }

            // calculate shifted index, wrapping around to end of table if shifted index is negative
            int shiftedIndex = (referenceTable.getIndexFromEntry(plainTextCharArray[i]) - offsetIndex) % referenceTable.getSize();
            if (shiftedIndex < 0) {
                shiftedIndex += referenceTable.getSize();
            }

            // append encoded character to final encoded text
            encodedText += referenceTable.getEntryFromIndex(shiftedIndex);
        }

        return encodedText;
    }

    public String decode(String encodedText) {
        char[] encodedTextCharArray = encodedText.toCharArray();
        int offsetIndex = referenceTable.getIndexFromEntry(encodedTextCharArray[0]);

        String plainText = "";
        for (int i = 1; i < encodedTextCharArray.length; i++) {
            // if input character is space, add space to encoded text and continue
            // OR if input character is not in reference table, map back to itself
            if (!referenceTable.containsCharacter(encodedTextCharArray[i])) {
                plainText += encodedTextCharArray[i];
                continue;
            }

            // calculate shifted index, wrapping around to start of table if shifted index exceeds last index
            int shiftedIndex = (referenceTable.getIndexFromEntry(encodedTextCharArray[i]) + offsetIndex) % referenceTable.getSize();

            // append encoded character to final decoded text
            plainText += referenceTable.getEntryFromIndex(shiftedIndex);
        }

        return plainText;
    }
}