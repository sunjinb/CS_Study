import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static class Rank implements Comparable<Rank>{
        int paperRack, interViewRank;
        public Rank(int paperRank, int interViewRank){
            this.paperRack = paperRank;
            this.interViewRank = interViewRank;
        }

        @Override
        public int compareTo(Rank o) {
            return Integer.compare(this.paperRack, o.paperRack);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int testCase = 1; testCase <= T; testCase++){
            N = Integer.parseInt(br.readLine());

            ArrayList<Rank> ranks = new ArrayList<>();

            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                int paperRank = Integer.parseInt(st.nextToken());
                int interViewRank = Integer.parseInt(st.nextToken());

                ranks.add(new Rank(paperRank, interViewRank));
            }

            Collections.sort(ranks);
            int result = 1;
            int interViewMin = ranks.get(0).interViewRank;
            for(int i = 1; i < N; i++){
                if(ranks.get(i).interViewRank < interViewMin){
                    result++;
                    interViewMin = ranks.get(i).interViewRank;
                }
            }
            sb.append(result + "\n");
        }
        System.out.println(sb);
    }
}
