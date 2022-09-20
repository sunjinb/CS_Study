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

        // 기준보다 큰 사람들 배열
        ArrayList<Integer>[] big_graph = new ArrayList[N];

        // 기준보다 작은 사람들 배열
        ArrayList<Integer>[] small_graph = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            //각각 한명 기준으로 크고 작은 그래프를 위함
            small_graph[i] = new ArrayList<Integer>();
            big_graph[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            // 1번부터 시작이므로 "-1"
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            big_graph[a].add(b);
            small_graph[b].add(a);
        }

        int result = 0;

        for (int i = 0; i < N; i++) {
            // 0번쨰 학생부터 키순서 알아보기
            boolean[] visited = new boolean[N];
            visited[i] = true;
            int count = 0;

            // 큰 사람 알아보기
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            while (!q.isEmpty()) {
                int x = q.poll();
                // 예시로 첫번째인 0번보다 큰 각각의 인원들을 큐에 넣는다.
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

            // count가 +1 되는 것은 한 학생과의 관계가 명확해지는 것
            // 따라서 6명이 총원이라면 5명과의 관계가 명확하다면 본인의 키가 몇번째인지 명확하게 아는 것
            if (count == N - 1) {
                result++;
            }
        }
        System.out.println(result);
    }
}
