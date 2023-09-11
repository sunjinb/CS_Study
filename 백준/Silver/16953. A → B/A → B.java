import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long A, B;
    static long result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());

        result = Long.MAX_VALUE;
        dfs(A, 0);

        if(result == Long.MAX_VALUE) System.out.println(-1);
        else System.out.println(result + 1);
    }

    private static void dfs(long point, int calCount) {
        if(point == B){
            result = Math.min(result, calCount);
            return;
        }

        if(B < point){
            return;
        }

        if(result < calCount){
            return;
        }

        dfs(point * 2, calCount + 1);
        dfs(point * 10 + 1, calCount + 1);
    }
}
