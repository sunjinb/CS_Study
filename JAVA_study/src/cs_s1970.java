import java.util.Scanner;
import java.io.FileInputStream;

class cs_s1970
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            int[] money = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
            int[] count = new int[8];

            int rest = N;
            for(int i = 0; i < 8; i++) {
                while(rest >= money[i]) {
                    rest -= money[i];
                    count[i]++;
                }
            }
            System.out.println("#" + test_case);
            for(int i = 0; i < 8; i++) {
                System.out.print(count[i] + " ");
            }
            System.out.println();
        }
    }
}