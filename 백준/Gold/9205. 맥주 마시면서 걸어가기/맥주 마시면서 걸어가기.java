import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static boolean flag;
    static boolean[] visited;
    static ArrayList<Point> list;
    static int[] house, festival;
    static Queue<Point> q;
    static class Point{
        int row, col, idx;
        public Point(int row, int col, int idx){
            this.row = row;
            this.col = col;
            this.idx = idx;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int testCase = 1; testCase <= T; testCase++){
            N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            house = new int[2];
            house[0] = Integer.parseInt(st.nextToken());
            house[1] = Integer.parseInt(st.nextToken());

            list = new ArrayList<>();
            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                int row = Integer.parseInt(st.nextToken());
                int col = Integer.parseInt(st.nextToken());
                list.add(new Point(row, col, i));
            }

            st = new StringTokenizer(br.readLine());
            festival = new int[2];
            festival[0] = Integer.parseInt(st.nextToken());
            festival[1] = Integer.parseInt(st.nextToken());

            flag = false;
            visited = new boolean[N];

            q = new LinkedList<>();
            q.add(new Point(house[0], house[1], -1));
            while (!q.isEmpty()) {
                Point now = q.poll();

                if (Math.abs(now.row - festival[0]) + Math.abs(now.col - festival[1]) <= 1000) {
                    flag = true;
                    break;
                }

                for(int i = 0; i < N; i++){
                    int nextRow = list.get(i).row;
                    int nextCol = list.get(i).col;

                    int distance = Math.abs(now.row - nextRow) + Math.abs(now.col - nextCol);

                    if(!visited[i] && distance <= 1000){
                        visited[i] = true;
                        q.add(new Point(nextRow, nextCol, i));
                    }
                }
            }
            if(flag) System.out.println("happy");
            else System.out.println("sad");
        }
    }
}
