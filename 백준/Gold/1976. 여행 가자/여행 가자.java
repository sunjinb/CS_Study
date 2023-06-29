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

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        parents = new int[N + 1];
        for(int i = 1; i <= N; i++){
            parents[i] = i;
        }

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                int tmp = Integer.parseInt(st.nextToken());

                if(tmp == 1){
                    int rootA = findRoot(i);
                    int rootB = findRoot(j);

                    if(rootA != rootB){
                        if(rootA < rootB){
                            parents[rootA] = rootB;
                        }
                        else{
                            parents[rootB] = rootA;
                        }
                    }
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int startRoot = findRoot(start);

        boolean flag = true;
        for(int i = 1; i < M; i++){
            int now = Integer.parseInt(st.nextToken());
            if(startRoot != findRoot(now)){
                flag = false;
                break;
            }
        }

        if(flag) System.out.println("YES");
        else System.out.println("NO");
    }

    private static int findRoot(int val) {
        if(parents[val] == val) return val;
        else return parents[val] = findRoot(parents[val]);
    }
}
