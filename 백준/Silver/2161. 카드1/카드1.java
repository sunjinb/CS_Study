import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= N; i++){
            q.add(i);
        }

        ArrayList<Integer> result = new ArrayList<>();

        while (!q.isEmpty()) {
            int now = q.poll();
            result.add(now);

            if(q.size() == 0){
                break;
            }

            if(q.size() == 1){
                int tmp = q.poll();
                result.add(tmp);
                break;
            }

            int tmp2 = q.poll();
            q.add(tmp2);
        }

        for (int t : result){
            System.out.print(t + " ");
        }
    }
}
