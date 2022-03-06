import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

//class handling the reading and analysis of each of text file
public class ReadText {

    private HashMap<String, Integer> wordMap = new HashMap<>();
    private int totalCount = 0;
    File file;

    public ReadText(String fileName){
        file = new File(fileName);
        analyzeText();
    }

    private void analyzeText() {
        String line;
        Scanner scanner = null;
        try {
            scanner = new Scanner(file, "UTF-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        scanner.useDelimiter("[.?!]");
        while (scanner.hasNext()) {
            line = scanner.next();
            line = line.replaceAll("\\r?\\n", " ");
            line = line.replaceAll("(\\[[^\\[]*\\]|-|,|\\p{Pd}|\\u00AB)", "");
            line = line.trim();
            String[] strArray = line.split(" ");
            for (int i = 0; i < strArray.length; i++) {
                if (strArray[i] != "") {
                    totalCount++;
                    String str = strArray[i].toLowerCase(Locale.ROOT);
                    if (wordMap.containsKey(str)) {
                        wordMap.put(str, wordMap.get(str) + 1);
                    } else {
                        wordMap.put(str, 1);
                    }
                }
            }

        }
    }

    public int getTotalCount(){
        return totalCount;
    }

    public int getNumberofUniqueWords(){
        return wordMap.size();
    }

    public String getTwentyMostUsed(){
        wordMap.remove("");
        LinkedHashMap<String, Integer> reverseSortedMap = new LinkedHashMap<>();
        wordMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));

        StringBuilder strBuilder = new StringBuilder();
        int i = 0;
        for (var entry : reverseSortedMap.entrySet()) {
            if( i < 20) {;
                strBuilder.append(entry.getKey());
                strBuilder.append(": ");
                strBuilder.append(entry.getValue());
                strBuilder.append(", ");
                i++;
            }
            else {
                break;
            }
        }

        return strBuilder.toString();
    }
}
