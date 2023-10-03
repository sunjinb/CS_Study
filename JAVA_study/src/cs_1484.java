import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class cs_1484 {
    static int G;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        G = Integer.parseInt(br.readLine());

        int left = 1;
        int right = 1;

        ArrayList<Integer> result = new ArrayList<>();
        while(true){
            int diff = left * left - right * right;
            if(left - right == 1 && diff > G){
                break;
            }

            if(diff < G) left++;
            else right++;

            if(diff == G){
                result.add(left);
            }
        }

        if(result.size() != 0){
            for (int res : result) {
                System.out.println(res);
            }
        }
        else{
            System.out.println(-1);
        }
    }
}
