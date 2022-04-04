import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class cs_2525 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int hour, minute, oven = 0;
        hour = sc.nextInt();
        minute = sc.nextInt();
        oven = sc.nextInt();

        int result_h = 0, result_m = 0;
        if(minute + oven > 59){
            result_h = hour + ((minute + oven) / 60);
            if(result_h > 23){
                result_h = result_h - 24;
            }
            result_m = result_m + ((minute + oven) % 60);
        }
        else{
            result_h = hour;
            result_m = minute + oven;
        }
        System.out.println(result_h + " " + result_m);
    }
}