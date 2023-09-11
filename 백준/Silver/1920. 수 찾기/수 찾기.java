import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            int findNum = Integer.parseInt(st.nextToken());
            sb.append(binarySearch(findNum) + "\n");
        }
        System.out.println(sb);
    }

    private static int binarySearch(int findNum) {
        int low = 0;
        int high = N - 1;
        int result = 0;
        while(low <= high){
            int mid = (low + high) / 2;
            if(arr[mid] < findNum){
                low = mid + 1;
            }
            else if(findNum < arr[mid]){
                high = mid - 1;
            }
            else if(findNum == arr[mid]){
                result = 1;
                break;
            }
        }
        return result;
    }
}
