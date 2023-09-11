import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr1;
    static int[] arr2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            arr1 = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                arr1[i] = Integer.parseInt(st.nextToken());
            }

            arr2 = new int[M];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < M; i++){
                arr2[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr1);
            Arrays.sort(arr2);

            int result = 0;
            for(int i = 0; i < arr1.length; i++){
                int v1 = arr1[i];
//                1 1 3 7 8
//                1 3 6에서 더 큰거만 찾기
                for(int j = 0; j < arr2.length; j++){
                    int v2 = arr2[j];
                    if(v1 > v2){
                        result++;
                    }
                    else{
                        break;
                    }
                }
            }

            System.out.println(result);
        }
    }
}
