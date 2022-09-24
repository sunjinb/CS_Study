import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class cs_3020 {

    static int N;
    static int H;
    static int[] up;
    static int[] down;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        up = new int[N / 2]; // 종유석 배열
        down = new int[N / 2];  // 석순 배열
        int upIndex = 0;
        int downIndex = 0;
        int min = Integer.MAX_VALUE;
        int count = 1;

        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(br.readLine());
            if(i % 2 == 0) {
                // 석순의 높이 저장
                down[downIndex++] = num;
            }
            else{
                // 종유석의 높이 저장
                up[upIndex++] = num;
            }
        }

        // 이분 탐색을 위해 석순, 종유석 배열 정렬
        Arrays.sort(up);
        Arrays.sort(down);

        for(int i = 1; i <= H; i++){
            int downCrush = binarySearch(0, N / 2, i, down); // 석순에 부딫히는 수
            int upCrush = binarySearch(0, N / 2, H - i + 1, up); // 종유석에 부딫히는 수

            if(min > downCrush + upCrush){
                // 최소로 부딫힌다면 최솟값 갱신
                min = downCrush + upCrush;
                count = 1;
            }
            else if(min == downCrush + upCrush){
                // 같다면 경우의 수가 늘어난 것이기에 총 갯수 갱신
                count++;
            }
        }
        System.out.println(min + " " + count);
    }

    private static int binarySearch(int start, int end, int height, int[] arr) {
        // 이분 탐색하며 몇개가 부딫히는지 확인
        while(start < end){
            int mid = (start + end) / 2;

            // arr[mid]가 height 보다 크다면 mid 이후의 것들은 모두 부딫히는 것들
            if(arr[mid] >= height){
                end = mid;
            }
            else{
                start = mid + 1;
            }
        }
        return arr.length - end; // end 값 이후의 것들이 모두 부서지므로
    }
}
