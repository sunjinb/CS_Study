import java.util.Scanner;

public class Main {

    static int round_cnt = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int round, num1, num2 = 0;
        round = sc.nextInt();
        num1 = sc.nextInt();
        num2 = sc.nextInt();

        sc.close();

        calculate(round, num1, num2);
    }

    static void calculate(int round, int num1, int num2) {
        for (int i = 0; i < round; i++) {
            num1 = num1 / 2 + num1 % 2;
            num2 = num2 / 2 + num2 % 2;
            if (num1 == num2) {
                break;
            }
            round_cnt += 1;

        }
        System.out.println(round_cnt);
    }
}