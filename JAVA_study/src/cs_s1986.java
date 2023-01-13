import java.util.Scanner;
import java.io.FileInputStream;

class cs_s1986
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int endNum = sc.nextInt();
            int sum = 0;
            for(int i = 1; i <= endNum; i++){
                // 홀수라면
                if(i % 2 == 1){
                    sum += i;
                }
                // 짝수라면
                else{
                    sum -= i;
                }
            }
            System.out.println("#" + test_case + " " + sum);
        }
    }
}