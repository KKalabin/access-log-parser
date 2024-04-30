import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int countPositivePath = 0;
        int totalLines = 0;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Укажите путь до файла: ");
            String path = null;
            try {
                path = scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Ошибка, попробуйте снова.");
                continue;
            }

            File file = new File(path);
            boolean fileExists = file.exists();
            boolean isDirectory = file.isDirectory();

            if (!fileExists || isDirectory) {
                System.out.println("Указанный файл не существует или путь не является путем к файлу");
                continue;
            } else {
                countPositivePath++;
                System.out.println("Путь указан верно");
                System.out.println("Это файл номер " + countPositivePath);
                try {
                    FileReader fileReader = new FileReader(path);
                    BufferedReader reader = new BufferedReader(fileReader);
                    String line;
                    while ((line = reader.readLine()) != null) {
                        totalLines++;
                        int length = line.length();
                        if (length > 1024) {
                            throw new LineTooLongException("Строка длиннее 1024 символов: " + line);
                        }
                    }
                    reader.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (LineTooLongException ex) {
                    System.err.println(ex.getMessage());
                }

                System.out.println(" Общее количество строк в файле: " + totalLines);

                FileAnalyzer.analyzeFile(path);
            }
        }
    }
}
