import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int testCase = 1; testCase <= T; testCase++){
            sb.append("Scenario " + testCase + ":\n");
            n = Integer.parseInt(br.readLine());
            k = Integer.parseInt(br.readLine());

            makeSet();

            for(int i = 0; i < k; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                union(a, b);
            }

            int m = Integer.parseInt(br.readLine());
            for(int i = 0; i < m; i++){
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                int rootU = findRoot(u);
                int rootV = findRoot(v);

                if(rootU == rootV){
                    sb.append(1 + "\n");
                }
                else{
                    sb.append(0 + "\n");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void union(int a, int b) {
        int rootA = findRoot(a);
        int rootB = findRoot(b);

        if(rootA != rootB){
            parents[rootA] = rootB;
        }
    }

    private static int findRoot(int val) {
        if(parents[val] == val) return val;
        else return parents[val] = findRoot(parents[val]);
    }

    private static void makeSet() {
        parents = new int[n];
        for(int i = 0; i < n; i++){
            parents[i] = i;
        }
    }
}
