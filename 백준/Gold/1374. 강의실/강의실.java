import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static int N;
    static class Lesson implements Comparable<Lesson> {
        int num;
        int start;
        int end;

        @Override
        public int compareTo(Lesson o) {
            if (this.start == o.start) {
                return this.end - o.end;
            } else {
                return this.start - o.start;
            }
        }

        public Lesson(int num, int start, int end) {
            this.num = num;
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        List<Lesson> lessons = new ArrayList<>();
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lessons.add(new Lesson(num, start, end));
        }
        Collections.sort(lessons);

        PriorityQueue<Integer> q = new PriorityQueue<>();

        int count = 1;

        for (int i = 0; i < N; i++){
            while (!q.isEmpty() && q.peek()<=lessons.get(i).start){
                q.poll();
            }
            q.offer(lessons.get(i).end);
            count = Math.max(count, q.size());
        }
        System.out.println(count);
    }
}