import java.util.Scanner;

public class cs_10950 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        int num1, num2 = 0;
        for(int i = 0; i < testcase; i++){
            num1 = sc.nextInt();
            num2 = sc.nextInt();
            System.out.println(num1 + num2);
        }
    }
}
