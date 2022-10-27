import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int[] house;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        house = new int[N];

        for(int i = 0; i < N; i++){
            house[i] = Integer.parseInt(br.readLine());
        }

        // 이분 탐색을 사용하기 위해 정렬
        Arrays.sort(house);

        int low = 1; // 최소 거리가 가질 수 있는 최소값
        int high = house[N - 1] - house[0] + 1; // 최소 거리가 가질 수 있는 최대값

        while(low < high){
            int mid = (low + high) / 2;
            // 공유기를 설치해야하는 개수보다 덜 설치될 경우
            if(canInstall(mid) < C) {
                // 거리를 좁혀 더 설치할 수 있도록
                high = mid;
            }
            // 공유기를 설치해야하는 개수보다 더 설치되거나 같다면
            else {
                // 거리를 벌려 최소거리가 가질 수 있는 최대 거리를 찾음
                low = mid + 1;
            }
        }
        // 결론적으로 low는 탐색 값을 초과하는 첫번째 값이므로 "-1"
        System.out.println(low - 1);
    }

    public static int canInstall(int distance){
        // 첫번째 집은 무조건 설치
        int count = 1;
        // 이전에 설치한 집의 좌표
        int lastLocate = house[0];

        for(int i = 1; i < house.length; i++){
            // 현재 설치할 집의 좌표
            int locate = house[i];

            // 현재 설치할 집의 좌표 - 이전에 설치한 집의 좌표 >= 최소 거리 라면 설치가 가능한 뜻이므로
            if(locate - lastLocate >= distance){
                count++;
                lastLocate = locate; // 이전의 설치한 집의 좌표 갱신
            }
        }
        return count;
    }
}





