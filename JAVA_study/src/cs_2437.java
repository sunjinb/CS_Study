import java.util.Arrays;
import java.util.Scanner;

public class cs_2437 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] weight = new int[n];
        int sum = 0;

        for(int i = 0; i < n; i++){
            weight[i] = sc.nextInt();
        }

        Arrays.sort(weight);
        /*
        1 2   3 이면
        1 2 3 4 5 6    저울질 가능
        sum = 6
        answer : 7

        1 2   4 이면
        1 2 3 4 5 6 7  저울질 가능
        sum = 7
        answer = 8

        1 2   5 이면
        1 2 3   5 6 7  저울질 가능
        sum = 3
        answer : 4
        */
        for(int i = 0; i < n; i++){
            if(weight[i] <= sum + 1){
                sum += weight[i];
            }
            else break;
        }

        sum += 1;
        System.out.println(sum);
    }
}
