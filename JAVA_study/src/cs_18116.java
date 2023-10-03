import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class cs_18116 {
    static int N;
    static final int INF = 1000004;
    static int[] parents;
    static int[] count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        parents = new int[INF];
        count = new int[INF];
        for(int i = 1; i < parents.length; i++){
            parents[i] = i;
            count[i] = 1;
        }

        for(int order = 0; order < N; order++){
            st = new StringTokenizer(br.readLine());

            char behavior = st.nextToken().charAt(0);

            if(behavior == 'I'){
                int tmp1 = Integer.parseInt(st.nextToken());
                int tmp2 = Integer.parseInt(st.nextToken());

                int root1 = findRoot(tmp1);
                int root2 = findRoot(tmp2);

                if(root1 == root2){
                    continue;
                }

                count[root1] += count[root2];
                parents[parents[root2]] = root1;
            }
            else if(behavior == 'Q'){
                int tmp = Integer.parseInt(st.nextToken());

                int root = findRoot(tmp);
                sb.append(count[root] + "\n");
            }
        }

        System.out.println(sb);
    }

    private static int findRoot(int val) {
        if(parents[val] == val) return val;
        else return parents[val] = findRoot(parents[val]);
    }
}
