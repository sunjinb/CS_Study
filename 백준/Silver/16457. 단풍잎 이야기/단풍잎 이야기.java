import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static int n, m, k;
    public static int[] sel;
    public static int[][] skillForQuest;
    public static int max = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        sel = new int[n];
        skillForQuest = new int[m][k];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < k; j++) {
                skillForQuest[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        comb(1, 0);

        System.out.println(max);

    }

    public static void comb(int idx, int count){
        if(count == n){
            boolean[] visited = new boolean[2 * n + 1];
            for(int num : sel)
                visited[num] = true;

            int clearCount = 0;
            for (int i = 0; i < m; i++) {
                int tmpCnt = 0;
                for (int j = 0; j < k; j++) {
                    if (visited[skillForQuest[i][j]])
                        tmpCnt += 1;
                }
                if (tmpCnt == k)
                    clearCount += 1;
            }

            if(clearCount > max){
                max = clearCount;
            }
            return;
        }

        for (int i = idx; i <= 2 * n; i++) {
            sel[count] = i;
            comb(i + 1, count + 1);
        }
    }
}