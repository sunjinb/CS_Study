import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class cs_11060 {

    static ArrayList<Integer> list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        list = new ArrayList<Integer>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        // 입력 종료

        // N == 1일 경우, 어떤 숫자가 있어도 도착이므로 0 출력
        if (N == 1) {
            System.out.println(0);
        } else {
            Queue<Integer> q = new LinkedList<Integer>();

            q.add(0);
            visited[0] = true;

            int cnt = 0;
            while (!q.isEmpty()) {

                int size = q.size();

                for (int k = 0; k < size; k++) {

                    int v = q.poll();
                    for (int i = 0; i <= list.get(v); i++) {

                        if (v + i >= list.size() - 1) {
                            if (list.get(v) == 0) {
                                System.out.println(-1);
                                return;
                            }
                            System.out.println(cnt + 1);
                            return;
                        }

                        if (visited[v + i] == false) {
                            visited[v + i] = true;
                            q.add(v + i);
                        }
                    }
                }
                cnt++;

            }

            System.out.println(-1);

//		// 출력
//		for (int i = 0; i < N; i++) {
//			System.out.printf("%d ", list.get(i));
//		}

        }
    }
}