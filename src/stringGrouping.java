import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
class StringGrouping {
    public StringGrouping() {
    }

    public Map<String, List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> groupedResults = new HashMap<>();

        // Group the strings
        for (String str : strings) {
            String[] parts = str.split(":");
            String index = parts[0];
            String value = parts[1];

            if (groupedResults.containsKey(index)) {
                List<String> words = groupedResults.get(index);
                words.add(value);
                groupedResults.put(index, words);
            } else {
                List<String> words = new ArrayList<>();
                words.add(value);
                groupedResults.put(index, words);
            }
        }

        return groupedResults;
    }

    public void outputGroupedResults(Map<String, List<String>> groupedResults) {
        int maxGroupSize = 0;


        for (List<String> words : groupedResults.values()) {
            maxGroupSize = Math.max(maxGroupSize, words.size());
        }


        for (Map.Entry<String, List<String>> entry : groupedResults.entrySet()) {
            String index = entry.getKey();
            List<String> words = entry.getValue();

            System.out.printf("%-10s", "Index: " + index);

            for (int i = 0; i < maxGroupSize; i++) {
                if (i < words.size()) {
                    System.out.printf("%-10s", words.get(i));
                } else {
                    System.out.printf("%-10s", words.get(words.size() - 1));
                }
            }

            System.out.println();
        }
    }
}