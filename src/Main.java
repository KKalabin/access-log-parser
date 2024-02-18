import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите первое число:");
        int number=new Scanner(System.in) .nextInt();
        System.out.println("Введите второе число:");
        int numberTwo=new Scanner(System.in) .nextInt();
        int sum=number+numberTwo;
        int difference=number-numberTwo;
        int multiplication=number*numberTwo;
        double division= (double) number / numberTwo;
        System.out.println("Сумма числел = " + sum);
        System.out.println("Разность чисел = " + difference);
        System.out.println("Произведение чисел = " + multiplication);
        System.out.println("Частное чисел = " + division);
    }
}


/*
        public static void main(String[] args) {
        System.out.println("Введите текст и нажмите <Enter>:"); отображается текст в кавычках
        String text=new Scanner(System.in).nextLine();          команда которая читает из консоли переданную строку
        System.out.println("Длина текста: " +text.length());    команда которая выдает длину переданного текста
    }
}
*/