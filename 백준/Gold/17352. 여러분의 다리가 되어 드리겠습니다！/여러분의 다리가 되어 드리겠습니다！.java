import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, parents[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        parents = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < N - 2; i++) {
            st = new StringTokenizer(br.readLine());
            union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (find(i) == i) {
                sb.append(i).append(' ');
            }
        }

        System.out.println(sb);
    }

    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if(rootA == rootB) return;

        parents[rootB] = rootA;
    }

    static int find(int val) {
        if(parents[val] == val) return val;
        else return parents[val] = find(parents[val]);
    }
}
