import java.util.Scanner;
import java.io.FileInputStream;

class cs_s1989
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int result = 1;
            String str = sc.next();
            // 문자열 길이가 홀수라면
            char[] cArr = str.toCharArray();
            for(int i = 0; i < str.length() / 2; i++){
                if(!(cArr[i] == (cArr[str.length() - i - 1]))){
                    result = 0;
                    break;
                }
            }
            System.out.println("#" + test_case + " " + result);
        }
    }
}