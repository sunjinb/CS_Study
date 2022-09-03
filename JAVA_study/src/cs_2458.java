import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class cs_2458 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] big_graph = new ArrayList[N];
        ArrayList<Integer>[] small_graph = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            small_graph[i] = new ArrayList<Integer>();
            big_graph[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            big_graph[a].add(b);
            small_graph[b].add(a);
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            // 0번쨰 학생부터 키순서 알아보기

            // 큰 사람 알아보기
            boolean[] visited = new boolean[N];
            visited[i] = true;
            int count = 0;
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            while (!q.isEmpty()) {
                int x = q.poll();
                for (int current_x : big_graph[x]) {
                    if (!visited[current_x]) {
                        q.add(current_x);
                        count++;
                        visited[current_x] = true;
                    }
                }
            }

            // 작은사람 알아보기
            q = new LinkedList<>();
            q.add(i);
            while (!q.isEmpty()) {
                int x = q.poll();
                for (int current_x : small_graph[x]) {
                    if (!visited[current_x]) {
                        q.add(current_x);
                        count++;
                        visited[current_x] = true;
                    }
                }
            }

            if (count == N - 1) {
                result++;
            }
        }
        System.out.println(result);
    }
}
