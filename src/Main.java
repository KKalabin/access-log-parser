import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int countPositivePath = 0;
        while (true) {
            System.out.print("Укажите путь до файла: ");
            String path = new Scanner(System.in).nextLine();

            File file = new File(path);
            boolean fileExists = file.exists();
            boolean isDirectory = file.isDirectory();

            if (!fileExists || isDirectory) {
                System.out.println("Указанный файл не существует или путь не является путем к файлу"); continue;
            } else if (fileExists || isDirectory) {
                countPositivePath++;
                System.out.println("Путь указан верно");
            }

            System.out.println("Это файл номер "+ countPositivePath);
        }
        }
    }