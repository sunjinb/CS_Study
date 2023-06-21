import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] parents;
    static ArrayList<ArrayList<Integer>> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int testCase = 1; testCase <= T; testCase++){
            N = Integer.parseInt(br.readLine());
            list = new ArrayList<>();
            for(int i = 0; i <= N; i++){
                list.add(new ArrayList<>());
            }

            parents = new int[N + 1];
            for(int i = 1; i < N; i++){
                st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());

                parents[B] = A;
                list.get(A).add(B);
            }

            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            int A_depth = getDepth(A);
            int B_depth = getDepth(B);

            int same = solve(A, A_depth, B, B_depth);
            System.out.println(same);
        }
    }

    private static int solve(int a, int aDepth, int b, int bDepth) {
        if(aDepth > bDepth){
            while(aDepth != bDepth){
                aDepth--;
                a = parents[a];
            }
        }

        else if(aDepth < bDepth){
            while(aDepth != bDepth){
                bDepth--;
                b = parents[b];
            }
        }

        while(a != b){
            a = parents[a];
            b = parents[b];
        }

        return a;
    }

    private static int getDepth(int val) {
        int ret = 0;
        int cur = val;
        while(cur != 0){
            ret++;
            cur = parents[cur];
        }
        return ret - 1;
    }
}
