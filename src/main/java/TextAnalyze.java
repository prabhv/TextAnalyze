import java.io.IOException;

//main class used for calling the read, analyse and write functions
public class TextAnalyze {


    public TextAnalyze(String filePath1, String filePath2){
        ReadText reader1 = new ReadText(filePath1);;
        ReadText reader2 = new ReadText(filePath2);;
        WriteToFile fileWriter;
        String storeResults = "Results.txt";
        String[] result1;
        String[] result2;
        result1 = getDetails(reader1, filePath1);
        result2 = getDetails(reader2, filePath2);
        try {
            fileWriter = new WriteToFile(result1, result2, storeResults);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String[] getDetails(ReadText reader, String fileName){
        String[] strArray = new String[5];
        int i = 0;
        String s;
        s = "--------------- Results for File:" + fileName +"-----------------------------";
        System.out.println(s);
        strArray[i++] = s;
        s = String.format("Total number of words: %d", reader.getTotalCount());
        System.out.println(s);
        strArray[i++] = s;
        s = String.format("Total number of Unique words: %d", reader.getNumberofUniqueWords());
        System.out.println(s);
        strArray[i++] = s;
        s = String.format("Twenty most used words: %s", reader.getTwentyMostUsed());
        System.out.println(s);
        strArray[i++] = s;
        s = "-------------------------------------------------------------------------";
        System.out.println(s);
        strArray[i++] = s;

        return strArray;
    }


}
