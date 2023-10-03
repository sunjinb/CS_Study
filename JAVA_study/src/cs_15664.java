import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class cs_15664 {
    static int N, M;
    static int[] arr;
    static int[] sel;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        sel = new int[N];
        comb(0, 0);
        System.out.println(sb);
    }

    private static void comb(int idx, int count) {
        if(count == M){
            for(int i = 0; i < M; i++){
                sb.append(sel[i] + " ");
            }
            sb.append("\n");
            return;
        }

        int before = 0;
        for(int i = idx; i < N; i++){
            if (before != arr[i]) {
                sel[count] = arr[i];
                before = arr[i];
                comb(i + 1, count + 1);
            }
        }
    }
}
