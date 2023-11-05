import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main{
    static int N, M;
    static class Word implements Comparable<Word>{
        int num;
        String str;

        public Word(String str, int num){
            this.num = num;
            this.str = str;
        }
        @Override
        public int compareTo(Word o) {
            return this.str.compareTo(o.str);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        String[] word = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};
        ArrayList<Word> list = new ArrayList<Word>();

        for (int i = M; i <= N; i++) {
            StringBuilder sb = new StringBuilder();
            char[] temp = Integer.toString(i).toCharArray();
            for (int j = 0; j < temp.length; j++) {
                sb.append(word[temp[j] - '0'] + " ");
            }
            list.add(new Word(sb.toString(), i));
        }
        Collections.sort(list);

        int n = 0;
        for(Word tmp : list) {
            System.out.print(tmp.num + " ");
            n++;
            if (n % 10 == 0) {
                System.out.println();
            }
        }
    }
}