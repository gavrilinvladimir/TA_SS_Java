import java.util.Scanner;
import java.util.ArrayList;
import java.text.DecimalFormat;

class Main {
    private static ArrayList<Integer> interval;
    private static ArrayList<Integer> oddNum;
    private static ArrayList<Integer> evenNum;
    private static ArrayList<Integer> fibNum;
    private static int fn;

    public static void main(String args[]) {
        userInput();
        numbersSum();
        userFib();
        fibPercent();
    }

    public static void  userInput() {
        interval = new ArrayList<Integer>();
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите начало интервала: ");
        int start = scan.nextInt();
        System.out.println("Введите конец интервала: ");
        int end = scan.nextInt();
        if (start <= end) {
            for (int i = start - 1; i < end; i++) {
                interval.add(start);
                start = start + 1;
            }
        } else {
            System.out.println("Вы ввели неверный интервал");
            // System.exit(0);
        }
    }

    public static void numbersSum() {
        oddNum = new ArrayList<Integer>();
        evenNum = new ArrayList<Integer>();
        int oddSum = 0;
        int evenSum = 0;
        for (int i = 0; i < interval.size(); i++) {
            int num = interval.get(i);
            if (num % 2 == 0) {
                oddSum = oddSum + num;
                oddNum.add(num);
            } else {
                evenSum = evenSum + num;
                evenNum.add(num);
            }
        }
        System.out.println("Сумма нечетных чисел равна " + evenSum);
        System.out.println("Сумма четных чисел равна " + oddSum);
    }

    public static void userFib() {
        fibNum = new ArrayList<Integer>();
        Scanner scan = new Scanner(System.in);
        int f1 = oddNum.get(oddNum.size() - 1);
        int f2 = evenNum.get(evenNum.size() - 1);
        fibNum.add(f1);
        fibNum.add(f2);
        System.out.println("Введите желаемый размер набора чисел Фибоначчи: ");
        fn = scan.nextInt();
        for (int i = 0; i < fn - 2; i++) {
            int j = 0;
            j = fibNum.get(i) + fibNum.get(i + 1);
            fibNum.add(j);
        }
    }

    public static void fibPercent() {
        int oddCount = 0;
        int evenCount = 0;
        for (int i = 0; i < fibNum.size(); i++) {
            int num = fibNum.get(i);
            if (num % 2 == 0) {
                oddCount = oddCount + 1;
            } else {
                evenCount = evenCount + 1;
            }
        }
        String even = new DecimalFormat("#0.00").format((double) evenCount / fn * 100);
        String odd = new DecimalFormat("#0.00").format((double) oddCount / fn * 100);

        System.out.println("Процент нечетных чисел в наборе Фибоначчи " + even + "%");
        System.out.println("Процент четных чисел в наборе Фибоначчи " + odd + "%");
    }
}