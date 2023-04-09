import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[] parents;
    static PriorityQueue<Node> q;
    static int[] dRow = {-1, 1, 0, 0};
    static int[] dCol = {0, 0, -1, 1};
    static class Point{
        int row, col;
        public Point(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    static class Node implements Comparable<Node>{
        int from, to, cost;
        public Node(int from, int to, int cost){
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) map[i][j] = -1;
            }
        }

        // 1 ~ ? 까지 섬 번호 붙이기
        int islandCount = 1;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == -1){
                    islandNumbering(i, j, islandCount);
                    islandCount++;
                }
            }
        }
        islandCount--;

        // 만들 수 있는 모든 다리를 다 만듬
        // 그걸 PQ에 넣어서 이따 MST 구할꺼야
        q = new PriorityQueue<>();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] != 0){
                    makeBridge(i, j, map[i][j]);
                }
            }
        }

        // 각 섬의 부모를 자기 자신으로 설정
        makeSet(islandCount);

        int result = 0;
        int connectBridgeCount = 0;
        int qSize = q.size();
        for(int i = 0; i < qSize; i++){
            Node now = q.poll();

            // 아직 두개가 연결되지 않아서 연결해야함
            if(union(now.from, now.to)){
                result += now.cost;
                connectBridgeCount++;
            }
            
            // 섬의 개수 -1만큼 연결되면 더이상 안 가도 됨
//            if(connectBridgeCount == islandCount - 1) break;
        }

        if(result == 0 || connectBridgeCount != islandCount - 1) System.out.println(-1);
        else System.out.println(result);
    }

    private static boolean union(int from, int to) {
        int rootA = findRoot(from);
        int rootB = findRoot(to);

        if(rootA == rootB){
            return false;
        }
        else{
            parents[rootA] = rootB;
            return true;
        }
    }

    private static int findRoot(int val) {
        if(parents[val] == val) return val;
        else return parents[val] = findRoot(parents[val]);
    }

    private static void makeSet(int islandCount) {
        parents = new int[islandCount + 1];
        for(int i = 1; i <= islandCount; i++){
            parents[i] = i;
        }
    }

    private static void makeBridge(int row, int col, int islandNum) {
        for(int d = 0; d < 4; d++){
            int tmpRow = row;
            int tmpCol = col;
            int bridgeLength = 0;
            while(true){
                tmpRow = tmpRow + dRow[d];
                tmpCol = tmpCol + dCol[d];

                // 앞으로 나아갈 지점들이 범위를 벗어나면 안됨
                if(tmpRow < 0 || tmpCol < 0 || tmpRow >= N || tmpCol >= M) break;
                // 앞으로 나아갈 지점들이 내 섬이면 안됨
                if(map[tmpRow][tmpCol] == islandNum) break;

                // 다음 지점이 바다임
                if(map[tmpRow][tmpCol] == 0){
                    bridgeLength++;
                }

                // 다음 지점이 드디어 다른 섬을 만남
                else{
                    // 다리의 길이가 1보다 큼
                    if(bridgeLength > 1){
                        q.add(new Node(islandNum, map[tmpRow][tmpCol], bridgeLength));
                        break;
                    }
                    else{
                        break;
                    }
                }
            }
        }
    }

    private static void islandNumbering(int row, int col, int islandNumber) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(row, col));

        while(!q.isEmpty()){
            Point now = q.poll();
            map[now.row][now.col] = islandNumber;
            for(int i = 0; i < 4; i++){
                int nextRow = now.row + dRow[i];
                int nextCol = now.col + dCol[i];

                if(nextRow < 0 || nextCol < 0 || nextRow >= N || nextCol >= M) continue;
                if(map[nextRow][nextCol] != -1) continue;

                q.add(new Point(nextRow, nextCol));
            }
        }
    }

    private static void printMap() {
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
