import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for(int i = 0; i < N; i++){
            q.add(Integer.parseInt(br.readLine()));
        }

        int result = 0;
        while(!q.isEmpty()){
            int qSize = q.size();

            if(qSize == 1){
                break;
            }
            else{
                int tmp1 = q.poll();
                int tmp2 = q.poll();

                q.add(tmp1 + tmp2);
                result += tmp1 + tmp2;
            }
        }

        System.out.println(result);
    }
}
