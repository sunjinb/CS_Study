import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class cs_1043 {
    static int N, M;
    static int[] parents;
    static boolean[] knowInfo;
    static ArrayList<Integer>[] partyList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        knowInfo = new boolean[N + 1];
        st = new StringTokenizer(br.readLine());
        int knowTruePersonNum = Integer.parseInt(st.nextToken());
        for(int i = 0; i < knowTruePersonNum; i++){
            int tmp = Integer.parseInt(st.nextToken());
            knowInfo[tmp] = true;
        }

        makeSet();
        partyList = new ArrayList[M + 1];
        for(int i = 1; i <= M; i++){
            partyList[i] = new ArrayList<>();
        }
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int participantNum = Integer.parseInt(st.nextToken());
            for(int j = 1; j <= participantNum; j++){
                int tmp = Integer.parseInt(st.nextToken());
                partyList[j].add(tmp);
            }
        }
    }

    private static void makeSet() {
        parents = new int[N + 1];
        for(int i = 1; i <= N; i++){
            parents[i] = i;
        }
    }
}
