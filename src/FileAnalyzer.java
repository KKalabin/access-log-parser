import java.io.BufferedReader;
import java.io.FileReader;

public class FileAnalyzer {

    public static void analyzeFile(String path) {
        int countYaBot = 0;
        int countGooBot = 0;

        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader reader = new BufferedReader(fileReader);
            String line;

            int fileLines = 0;
            while ((line = reader.readLine()) != null) {
                fileLines++;
                String[] words = line.split("\"");
                for (String word : words) {
                    if (word.contains("Googlebot"))
                        countGooBot++;
                    if (word.contains("YandexBot"))
                        countYaBot ++;
                }
            }

            System.out.println("YandexBot: " + countYaBot);
            System.out.println("Googlebot: " + countGooBot);

            reader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
