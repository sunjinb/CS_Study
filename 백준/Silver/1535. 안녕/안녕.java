import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] loseHp;
    static int[] getHappiness;
    static boolean[] visited;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        loseHp = new int[N];
        getHappiness = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            loseHp[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            getHappiness[i] = Integer.parseInt(st.nextToken());
        }

        result = 0;
        visited = new boolean[N];
        powerSet(0);

        System.out.println(result);
    }

    private static void powerSet(int now) {
        // 체력으로 가지치기 한 번 더

        if(now == N){
            int tmpHp = 100;
            int tmpHappy = 0;
            for(int i = 0; i < N; i++){
                if(visited[i]){
                    tmpHp -= loseHp[i];
                    tmpHappy += getHappiness[i];
                }
            }
            if(tmpHp > 0){
                result = Math.max(result, tmpHappy);
            }
            return;
        }

        visited[now] = true;
        powerSet(now + 1);

        visited[now] = false;
        powerSet(now + 1);
    }
}
