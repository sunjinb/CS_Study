import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int zeroCount;
    static int oneCount;
    static int zeroPlusOne;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int testCase = 1; testCase <= T; testCase++) {
            N = Integer.parseInt(br.readLine());
            fibo(N);
            System.out.println(zeroCount + " " + oneCount);
        }
    }

    private static void fibo(int n) {
        zeroCount = 1;
        oneCount = 0;
        zeroPlusOne = 1;

        for(int i = 0; i < N; i++){
            zeroCount = oneCount;
            oneCount = zeroPlusOne;
            zeroPlusOne = zeroCount + oneCount;
        }
    }

}
