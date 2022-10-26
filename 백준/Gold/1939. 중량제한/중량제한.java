import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
    int to;
    int weight;

    public Node(int to, int weight){
        this.to = to;
        this.weight = weight;
    }
}

public class Main {
    static int N, M;
    static boolean[] visited;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        int max = 0;

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            max = Math.max(max, C); // 이분 탐색의 right가 될 값 구하기 (중량 중 최댓 값)
            graph.get(A).add(new Node(B, C));
            graph.get(B).add(new Node(A, C));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        // 이분 탐색
        int left = 0;
        int right = max;

        while(left <= right){
            int mid = (left + right) / 2;
            visited = new boolean[N + 1];

            // mid 중량으로 start에서 end까지 이동할 수 있다면 left 증가 -> 중량이 더 무거워 짐
            if(BFS(start, end, mid)){
                left = mid + 1;
            }
            // mid 중량으로 start에서 end까지 이동할 수 없다며 right 감소 -> 중량이 더 가벼워 짐
            else{
                right = mid - 1;
            }
        }
        System.out.println(right);
    }

    // start에서 end까지 이동할 수 있는지 확인하는 BFS
    public static boolean BFS(int start, int end, int mid){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int now = q.poll();

            // end에 도달했다면 성공
            if(now == end){
                return true;
            }

            for (Node next : graph.get(now)) {
                // 다음 섬이 아직 방문하지 않았으며, mid 중량이 다리를 건널 수 있다면
                if (!visited[next.to] && mid <= next.weight) {
                    visited[next.to] = true;
                    q.add(next.to);
                }
            }
        }
        return false;
    }
}