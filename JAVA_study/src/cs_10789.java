import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class cs_10789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] arr = new String[5];

        for(int i = 0; i < 5; i++){
            String str = br.readLine();
            arr[i] = str;
        }

        for(int i = 0; i < 15; i++){
            for(int j = 0; j < 5; j++){
                if(arr[j].length() > i){
                    sb.append(arr[j].charAt(i));
                }
            }
        }

        System.out.println(sb);
    }
}
