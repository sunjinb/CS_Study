import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int num = 0;
        int result = 0;
        int sum = 0;
        num = sc.nextInt();

        int[] cost = new int[num];

        for(int i = 0; i < num; i++){
            cost[i] = Integer.parseInt(sc.next());
        }

        Arrays.sort(cost);

        for(int i = 0; i < num; i++){
            sum += cost[i];
            result += sum;
        }
        
        System.out.print(result);
    }
}
