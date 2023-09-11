import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        BigInteger N = new BigInteger(st.nextToken());
        BigInteger M = new BigInteger(st.nextToken());

        BigInteger zero = new BigInteger("0");

        if(M.equals(zero)){
            System.out.println(0);
            System.out.println(N);
        }
        else{
            System.out.println(N.divide(M));
            System.out.println(N.mod(M));
        }
    }
}
