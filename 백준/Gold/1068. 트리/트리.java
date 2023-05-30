import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int result;
    static int rootNode;
    static boolean[] visited;
    static int[] parents;
    static int delNode;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        parents = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            parents[i] = Integer.parseInt(st.nextToken());
            if(parents[i] == -1) rootNode = i;
        }

        delNode = Integer.parseInt(br.readLine());
        deleteNode(delNode);

        visited = new boolean[N];
        countNode(rootNode);
        System.out.println(result);
    }

    private static void countNode(int tmp) {
        boolean isLeaf = true;
        visited[tmp] = true;
        if(parents[tmp] != -2){
            for(int i = 0; i < N; i++){
                if(parents[i] == tmp && !visited[i]){
                    countNode(i);
                    isLeaf = false;
                }
            }
            if(isLeaf) result++;
        }
    }

    private static void deleteNode(int delNode) {
        parents[delNode] = -2;
        for(int i = 0; i < N; i++){
            if(parents[i] == delNode){
                deleteNode(i);
            }
        }
    }
}
