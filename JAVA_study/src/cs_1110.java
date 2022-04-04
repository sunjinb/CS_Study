import java.util.Scanner;

public class cs_1110 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int first = N / 10;
        int second = N % 10;
        int cycle = 0;
        int new_N = 0;

        while(true){
            cycle += 1;
            new_N = second * 10 + ((first+second)%10);
            if(N == new_N){
                break;
            }
            first = new_N / 10;
            second = new_N % 10;
        }


        System.out.println(cycle);
    }
}