import java.util.*;
import java.io.*;

public class cs_9466 {
    static int N;
    static int count;
    static int[] arr;
    static boolean[] visited;
    static boolean[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int testCase = 1; testCase <= T; testCase++) {
            N = Integer.parseInt(br.readLine());

            arr = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            count = 0;
            result = new boolean[N + 1];
            visited = new boolean[N + 1];
            for (int i = 1; i <= N; i++) {
                dfs(i);
            }
            System.out.println(N - count);
        }
    }
    private static void dfs(int start) {
        if(visited[start]) return;

        visited[start] = true;
        int value = arr[start];

        if(!visited[value]) {
            dfs(value);
        }
        else{
            if(!result[value]) {
                // 노드가 끝나려면 싸이클을 무조건 거쳐야한다.
                // 따라서 현재 노드가 아닌 다음 노드 기준으로 하면 싸이클이 무조건 존재
                count++;
                for(int i= value; i != start; i = arr[i])
                    count++;
            }
        }

        result[start] = true;
    }
}