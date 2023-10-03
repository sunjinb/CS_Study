import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int V;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        V = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int countA = 0;
        int countB = 0;

        for(int i = 0; i < V; i++){
            char tmp = str.charAt(i);
            if(tmp == 'A') countA++;
            else if(tmp == 'B') countB++;
        }

        if(countB < countA) System.out.println("A");
        else if(countB > countA) System.out.println("B");
        else System.out.println("Tie");
    }
}
