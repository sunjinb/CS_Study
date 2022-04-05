import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class cs_10871 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N, X = 0;
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        int[] array = new int[N];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            array[i] = Integer.parseInt(st.nextToken());
            if(array[i] < X){
                System.out.print(array[i] + " ");
            }
        }

    }
}
