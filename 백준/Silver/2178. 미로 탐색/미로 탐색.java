import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] maze;
    static boolean[][] visited;
    static int[] dx = { -1, 1, 0, 0 }; 
    static int[] dy = { 0, 0, -1, 1 }; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 미로 공간 할당
        maze = new int[N][M];

        // 방문했는지 여부 파악
        visited = new boolean[N][M];

        // 미로 그리기
        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < M; j++){
                maze[i][j] = str.charAt(j) - '0';
            }
        }

        // 시작점 방문
        visited[0][0] = true;
        bfs(0, 0);
        System.out.println(maze[N - 1][M - 1]);

    }
    public static void bfs(int start_x, int start_y){
        // 큐 공간 할당
        Queue<int[]> q = new LinkedList<>();

        // 큐에 시작점 삽입
        q.add(new int[] {start_x, start_y});

        while(!q.isEmpty()){
            // 노드 하나 꺼내서 x, y 값 추출
            int[] tail = q.poll();
            int tail_x = tail[0];
            int tail_y = tail[1];

            for(int i = 0; i < 4; i++){
                int next_x = tail_x + dx[i];
                int next_y = tail_y + dy[i];

                if(next_x < 0 || next_x >= N || next_y < 0 || next_y >= M){
                    continue;
                }
                if(visited[next_x][next_y] || maze[next_x][next_y] == 0){
                    continue;
                }
                // 같은 순위에 있는 큐들 삽입
                q.add(new int[]{next_x, next_y});
                // 방문했다 설정
                visited[next_x][next_y] = true;
                //거리 계산
                maze[next_x][next_y] = maze[tail_x][tail_y] + 1;
            }
        }

    }
}
