import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class cs_1446 {
    static int N, D;
    static final int INF = 987654321;
    static ArrayList<Node>[] list;
    static int[] distance;
    static class Node{
        int start, length;
        public Node(int start, int length){
            this.start = start;
            this.length = length;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        list = new ArrayList[10004];
        for(int i = 1; i < list.length; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());
            if(end > D) continue;
            if(end - start <= length) continue;
            list[end].add(new Node(start, length));
        }

        distance = new int[D + 1];
        Arrays.fill(distance, INF);
        distance[0] = 0;

        for(int i = 1; i <= D; i++){
            // 현재 위치까지 오는 지름길이 있다면
            if(list[i].size() > 0){
                for(Node next : list[i]){
                    if(distance[next.start] + next.length < distance[i]) {
                        distance[i] = Math.min(distance[next.start] + next.length, distance[i - 1] + 1);
                    }
                }
                continue;
            }
            distance[i] = distance[i - 1] + 1;
        }
        System.out.println(distance[D]);
    }
}
