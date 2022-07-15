import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class cs_1931 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int c_count = Integer.parseInt(br.readLine());

        int[][] time = new int[c_count][2];

        StringTokenizer st;

        for(int i = 0; i < c_count; i++){
            st = new StringTokenizer(br.readLine(), " ");
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(time, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2){

                // 종료시간이 같을 경우 시작시간이 빠른 순으로 정렬
                if(o1[1] == o2[1]){
                    return o1[0] - o2[0];
                }

                return o1[1] - o2[1];
            }
        });

        int count = 0;
        int prev_end_time = 0;

        for(int i = 0; i < c_count; i++){

            // 직전 종료시간이 다음 회의 시작 시간보다 작거나 같다면 갱신
            if(prev_end_time <= time[i][0]){
                prev_end_time = time[i][1];
                count++;
            }
        }

        System.out.println(count);

    }
}
