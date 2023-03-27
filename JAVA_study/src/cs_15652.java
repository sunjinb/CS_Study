import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class cs_15652 {
    static int N, M;
    static int[] sel;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sel = new int[M];
        combR(1, 0);
        System.out.println(sb);
    }

    private static void combR(int idx, int count) {
        if(count == M){
            for(int i = 0; i < M; i++){
                sb.append(sel[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i = idx; i <= N; i++){
            sel[count] = i;
            combR(i, count + 1);
        }

    }
}
