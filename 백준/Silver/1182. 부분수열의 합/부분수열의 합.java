import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, S;
    static int result;
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        visited = new boolean[N];
        powerSet(0);
        if(S == 0) System.out.println(result - 1);
        else System.out.println(result);
    }

    private static void powerSet(int count) {
        if(count == N){
            int sum = 0;
            for(int i = 0; i < N; i++){
                if(visited[i]) sum += arr[i];
            }
            if(sum == S) result++;
            return;
        }

        visited[count] = true;
        powerSet(count + 1);

        visited[count] = false;
        powerSet(count + 1);
    }
}
