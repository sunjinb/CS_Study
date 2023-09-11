import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parents = new int[N];
        for(int i = 0; i < N; i++){
            parents[i] = i;
        }

        int result = 0;
        for(int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            int rootFrom = findRoot(from);
            int rootTo = findRoot(to);

            if(rootFrom == rootTo){
                result = i;
                break;
            }
            else{
                parents[rootFrom] = rootTo;
            }
        }

        System.out.println(result);
    }

    private static int findRoot(int val) {
        if(parents[val] == val) return val;
        else return parents[val] = findRoot(parents[val]);
    }
}
