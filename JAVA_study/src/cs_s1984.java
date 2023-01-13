import java.util.Scanner;
import java.io.FileInputStream;

class cs_s1984
{
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int max = 0;
            int min = 10001;
            int sum = 0;
            for(int i = 0; i < 10; i++){
                int value = sc.nextInt();
                sum += value;
                if(max <= value){
                    max = value;
                }
                if(min >= value){
                    min = value;
                }
            }
            sum -= max;
            sum -= min;
            //반올림 로직만 변경
            double result = (double)sum / 8.0;
            System.out.println("#" + test_case + " " + Math.round(result));
        }
    }
}