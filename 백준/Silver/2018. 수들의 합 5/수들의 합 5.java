import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int sum = 1;
        int onePointer = 1;
        int twoPointer = 1;

        int result = 0;
        while (onePointer <= twoPointer) {
            if(sum == N) result++;

            if(sum < N){
                twoPointer++;
                sum += twoPointer;
            }
            else if(sum >= N){
                sum -= onePointer;
                onePointer++;
            }
        }
        System.out.println(result);
    }
}
