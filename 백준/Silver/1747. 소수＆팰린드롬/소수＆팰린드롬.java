import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static boolean[] isPrimeN;
    static final int MAX = 1003004;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        isPrimeN = new boolean[MAX + 1];

        isPrimeN[0] = true;
        isPrimeN[1] = true;
        for(int i = 2; i <= Math.sqrt(MAX); i++){
            if(isPrimeN[i]) continue;

            for(int j = i * i; j <=  MAX; j += i){
                isPrimeN[j] = true;
            }
        }

        for(int i = N; i <= MAX; i++){
            if(!isPrimeN[i] && isValid(i)){
                System.out.println(i);
                break;
            }
        }
    }

    private static boolean isValid(int num) {
        StringBuilder str = new StringBuilder();
        str.append(num);
        if (str.toString().equals(str.reverse().toString())) {
            return true;
        }
        else{
            return false;
        }
    }
}
