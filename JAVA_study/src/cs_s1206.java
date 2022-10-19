import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class cs_s1206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] result = new int[10];

        for(int i = 0; i < 10; i++){
            int N = Integer.parseInt(br.readLine());
            int[] height = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                height[j] = Integer.parseInt(st.nextToken());
            }
            for(int j = 2; j < N - 2; j++){
                int[] near = new int[4];
                near[0] = height[j] - height[j-1];
                near[1] = height[j] - height[j-2];
                near[2] = height[j] - height[j+1];
                near[3] = height[j] - height[j+2];

                if (near[0] < 0 || near[1] < 0 || near[2] < 0 || near[3] < 0) {
                    continue;
                }
                else {
                    Arrays.sort(near);
                    result[i] = result[i] + near[0];
                }
            }
        }

        for(int i = 0; i < 10; i++){
            System.out.println("#" + (i + 1) + " " + result[i]);
        }
    }
}
