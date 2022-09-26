import java.util.Map;
import java.util.HashMap;

public class ReferenceTable {

    private char[] tableEntries;
    private Map<Character, Integer> entryToIndexMap;

    public ReferenceTable(char[] tableEntries) {
        this.tableEntries = tableEntries;
        
        entryToIndexMap = new HashMap<>();
        for (int i = 0; i < tableEntries.length; i++) {
            entryToIndexMap.put(tableEntries[i], i);
        }
    }

    public int getSize() {
        return tableEntries.length;
    }

    public char getEntryFromIndex(int index) {
        return tableEntries[index];
    }

    public boolean containsCharacter(char character) {
        return entryToIndexMap.containsKey(character);
    }

    public int getIndexFromEntry(char character) {
        return entryToIndexMap.get(character);
    }
}
