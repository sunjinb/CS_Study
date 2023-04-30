import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static boolean[] isNotPrime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        isNotPrime = new boolean[1000004];
        isNotPrime[0] = isNotPrime[1] = true;
        for(int i = 2; i < isNotPrime.length; i++){
            if(!isNotPrime[i]){
                for(int j = i * 2; j < isNotPrime.length; j += i){
                    isNotPrime[j] = true;
                }
            }
        }

        while(true){
            N = Integer.parseInt(br.readLine());
            if(N == 0) break;

            int result = -1;
            for(int i = 3; i < N; i+=2){
                // 이번 홀수가 소수라면, 더할 녀석도 소수라면
                if(!isNotPrime[i] && !isNotPrime[N - i]){
                    result = i;
                    break;
                }
            }
            if(result == -1) sb.append("Goldbach's conjecture is wrong.\n");
            else sb.append(N + " = " + result + " + " + (N - result) + "\n");
        }
        System.out.println(sb);
    }
}
