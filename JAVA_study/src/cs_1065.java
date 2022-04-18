import java.util.Scanner;

public class cs_1065 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = hansu(n);
        System.out.println(result);
    }

    public static int hansu(int n){
        int cnt = n;
        if(n < 100){
            return cnt;
        }
        else{
            cnt = 99;
            if(n == 1000){
                n = 999;
            }

            for(int i = 100; i <= n; i++){
                int hund = i / 100;
                int ten = (i % 100) / 10;   // (i / 10) % 10
                int one = i % 10;

                if((hund - ten) == (ten - one)){
                    cnt++;
                }
            }

        }
        return cnt;
    }
}