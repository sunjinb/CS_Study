import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int dasom = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }
        });
        for(int i = 1; i < N; i++){
            pq.add(Integer.parseInt(br.readLine()));
        }

        int result = 0;
        while(!pq.isEmpty()){
            int curMax = pq.poll();
            if(curMax < dasom){
                break;
            }
            dasom++;
            result++;
            pq.add(curMax - 1);
        }

        System.out.println(result);
    }
}
