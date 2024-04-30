import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int countPositivePath = 0;
        int totalLines = 0;
        int minLineLength = Integer.MAX_VALUE;
        int maxLineLength = Integer.MIN_VALUE;

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
                        if (length > maxLineLength) {
                            maxLineLength = length;
                        }
                        if (length < minLineLength) {
                            minLineLength = length;
                        }
                    }
                    reader.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (LineTooLongException ex) {
                    System.err.println(ex.getMessage());
                }

                System.out.println("1) Общее количество строк в файле: " + totalLines);
                System.out.println("2) Длина самой длинной строки в файле: " + maxLineLength);
                System.out.println("3) Длина самой короткой строки в файле: " + minLineLength);
            }
        }
    }
}