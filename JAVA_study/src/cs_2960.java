import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class cs_2960 {
    static int N, K;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        visited[0] = visited[1] = true;

        int eraseCount = 0;
        int result = -1;
        L:for(int i = 2; i <= N; i++){
            if(!visited[i]){
                visited[i] = true;
                eraseCount++;
                if(eraseCount == K){
                    result = i;
                    break;
                }
                for(int j = 2 * i; j <= N; j += i){
                    if(!visited[j]){
                        visited[j] = true;
                        eraseCount++;
                        if(eraseCount == K){
                            result = j;
                            break L;
                        }
                    }
                }
            }
        }
        System.out.println(result);
    }
}
