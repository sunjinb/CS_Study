import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class cs_1325 {
    static int N, M;
    static int count, max;
    static boolean[] visited;
    static HashMap<Integer, ArrayList<Integer>> hashMap;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        hashMap = new HashMap<>();

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            if(hashMap.get(from) != null){
                hashMap.get(from).add(to);
            }
            else{
                hashMap.put(from, new ArrayList<>());
                hashMap.get(from).add(to);
            }
        }
        int[] ans = new int[N + 1];
        max = -1;
        for(int i = 1; i <= N; i++){
            if(hashMap.get(i) != null){
                count = 0;
                visited = new boolean[N + 1];
                solve1(i);
                ans[i] = count;
            }
        }

        for(int i = 1; i <= N; i++){
            if(max < ans[i]) max = ans[i];
        }

        ArrayList<Integer> resultList = new ArrayList<>();
        for(int i = 1; i <= N; i++){
            if(ans[i] == max) resultList.add(i);
        }
        for(int result : resultList){
            sb.append(result + " ");
        }
        System.out.println(sb);

    }

    private static void solve1(int start) {
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.add(start);

        while(!q.isEmpty()){
            int now = q.poll();
            if(hashMap.get(now) != null){
                for(int i = 0; i < hashMap.get(now).size(); i++){
                    int next = hashMap.get(now).get(i);
                    if(!visited[next]){
                        count++;
                        visited[next] = true;
                        q.add(next);
                    }
                }
            }
        }
    }
}
