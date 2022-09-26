import java.util.Map;
import java.util.HashMap;

public final class ReferenceTable {

    private static final char[] CHARACTER_ARRAY = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789()*+,-./".toCharArray();
    private static final Map<Character, Integer> CHARACTER_TO_INDEX_MAP;

    public static final int SIZE = CHARACTER_ARRAY.length;
    
    static {
        CHARACTER_TO_INDEX_MAP = new HashMap<>();
        for (int i = 0; i < CHARACTER_ARRAY.length; i++) {
            CHARACTER_TO_INDEX_MAP.put(CHARACTER_ARRAY[i], i);
        }
    }

    private ReferenceTable() {} // private constructor for static class

    public static final char getCharacterFromIndex(int index) {
        return CHARACTER_ARRAY[index];
    }

    public static final boolean containsCharacter(char character) {
        return CHARACTER_TO_INDEX_MAP.containsKey(character);
    }

    public static final int getIndexFromCharacter(char character) {
        return CHARACTER_TO_INDEX_MAP.get(character);
    }
}
