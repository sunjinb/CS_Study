import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    static int[] sel;
    static boolean[] visited;
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
        visited = new boolean[N];
        perm(0);
        System.out.println(sb);
    }

    private static void perm(int idx) {
        if(idx == M){
            for(int i = 0; i < M; i++){
                sb.append(sel[i] + " ");
            }
            sb.append("\n");
            return;
        }
        int before = 0;
        for(int i = 0; i < N; i++){
            if (!visited[i] && before != arr[i]) {
                sel[idx] = arr[i];
                before = arr[i];
                visited[i] = true;
                perm(idx + 1);
                visited[i] = false;
            }
        }
    }
}
