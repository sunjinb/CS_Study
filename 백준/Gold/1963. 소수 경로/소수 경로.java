import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited = new boolean[10000];
    static class Point{
        int num, depth;
        public Point(int num, int depth){
            this.num = num;
            this.depth = depth;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        boolean[] isNotPrime = new boolean[10004];

        isNotPrime[0] = isNotPrime[1] = true;
        for(int i = 2; i < Math.sqrt(10000); i++){
            if(!isNotPrime[i]){
                for(int j = i + i; j < 10000; j += i){
                    isNotPrime[j] = true;
                }
            }
        }

        int T = Integer.parseInt(br.readLine());
        for(int testCase = 1; testCase <= T; testCase++){
            int result = -1;

            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int last = Integer.parseInt(st.nextToken());

            Queue<Point> q = new LinkedList<>();
            visited = new boolean[10000];

            q.add(new Point(start, 0));
            visited[start] = true;

            while(!q.isEmpty()){
                Point now = q.poll();

                if(now.num == last){
                    result = now.depth;
                    break;
                }

                // 자리수
                for(int i = 0; i < 4; i++){
                    // 바꿀 숫자
                    for(int j = 0; j <= 9; j++){
                        // 첫 자리는 0일 수 없음
                        if(i == 0 && j == 0) continue;

                        int tmp = changeNum(now.num, i, j);
                        if(!visited[tmp] && !isNotPrime[tmp]){
                            visited[tmp] = true;
                            q.add(new Point(tmp, now.depth + 1));
                        }
                    }
                }
            }

            if(result == -1) System.out.println("Impossible");
            else System.out.println(result);
        }
    }

    private static int changeNum(int num, int pos, int changenum) {
        int tmpResult = 0;
        if(pos == 0){
            int rest = num % 1000;
            tmpResult = changenum * 1000 + rest;
        }
        else if(pos == 1) {
            int rest1 = num / 1000;
            int rest2 = num % 100;
            tmpResult = rest1 * 1000 + changenum * 100 + rest2;
        }
        else if(pos == 2){
            int rest1 = num / 100;
            int rest2 = num % 10;
            tmpResult = rest1 * 100 + changenum * 10 + rest2;
        }
        else if(pos == 3){
            int rest = num / 10;
            tmpResult = rest * 10 + changenum;
        }
        return tmpResult;
    }
}
