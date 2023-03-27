import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class cs_2477 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int K = Integer.parseInt(br.readLine());
        int[] arr = new int[6];
        int dir = 0;
        int maxWidthIndex = 0, maxWidth = 0, maxHeight= 0, maxHeightIndex = 0;
        for(int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            dir = Integer.parseInt(st.nextToken());
            arr[i] = Integer.parseInt(st.nextToken());
            if(dir == 1 || dir == 2) {
                if(maxWidth < arr[i]){
                    maxWidthIndex = i;
                    maxWidth = arr[i];
                }
            }else if(dir == 3 || dir == 4){
                if(maxHeight < arr[i]){
                    maxHeightIndex = i;
                    maxHeight = arr[i];
                }
            }

        }

        int right = 0, left = 0, minWidth = 0, minHeight = 0;
        if(maxWidthIndex + 1 == 6) right = 0;
        else right = maxWidthIndex + 1;

        if(maxWidthIndex - 1 == -1) left = 5;
        else left = maxWidthIndex - 1;
        minHeight = Math.abs(arr[right] - arr[left]);

        if(maxHeightIndex + 1 == 6) right = 0;
        else right = maxHeightIndex + 1;

        if(maxHeightIndex - 1 == -1) left = 5;
        else left = maxHeightIndex - 1;
        minWidth = Math.abs(arr[right] - arr[left]);

        System.out.println(((maxWidth * maxHeight) - (minHeight * minWidth)) * K);
    }

}