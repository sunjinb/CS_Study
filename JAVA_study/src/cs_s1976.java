import java.util.Scanner;
import java.io.FileInputStream;

class cs_s1976
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int f_hour = sc.nextInt();
            int f_minute = sc.nextInt();
            int s_hour = sc.nextInt();
            int s_minute = sc.nextInt();

            int hour = 0;
            int minute = 0;

            hour = f_hour + s_hour;
            minute = f_minute + s_minute;

            if(minute >= 60){
                hour += 1;
                minute -= 60;
            }

            if(hour > 12){
                hour -= 12;
            }

            System.out.printf("#%d %d %d\n", test_case, hour, minute);
        }
    }
}