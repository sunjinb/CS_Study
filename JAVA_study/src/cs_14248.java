import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class cs_14248 {
    static int N, S;
    static final int max = 100004;
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        S = Integer.parseInt(br.readLine());

        visited = new boolean[N + 1];
        Queue<Integer> q = new LinkedList<>();

        visited[S] = true;
        q.add(S);

        int count = 0;
        while(!q.isEmpty()){
            int now = q.poll();
            count++;

            int nextFront = now + arr[now];
            int nextBack = now - arr[now];

            if(nextFront < N + 1 && !visited[nextFront]){
                visited[nextFront] = true;
                q.add(nextFront);
            }

            if(0 < nextBack && !visited[nextBack]){
                visited[nextBack] = true;
                q.add(nextBack);
            }
        }

        System.out.println(count);
    }
}
