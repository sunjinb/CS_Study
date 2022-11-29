import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int hour, minute = 0;
        hour = sc.nextInt();
        minute = sc.nextInt();

        if(minute >= 45){
            minute -= 45;
        }
        else{
            if(hour == 0){
                hour = 23;
                minute += 15;
            }
            else{
                hour -= 1;
                minute += 15;
            }
        }
        System.out.println(hour + " " + minute);
    }
}
