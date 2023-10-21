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

        makeSet();
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int order = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int rootA = findRoot(a);
            int rootB = findRoot(b);

            // 집합 합치기
            if(order == 0){
                if(rootA != rootB){
                    parents[rootA] = rootB;
                }
            }
            // 부모 같은지 체크
            else if(order == 1){
                if(rootA == rootB){
                    System.out.println("YES");
                }
                else{
                    System.out.println("NO");
                }
            }
        }
    }

    private static int findRoot(int val) {
        if(parents[val] == val){
            return val;
        }
        else return parents[val] = findRoot(parents[val]);

    }

    private static void makeSet() {
        parents = new int[N + 1];
        for(int i = 0; i <= N; i++){
            parents[i] = i;
        }
    }
}
