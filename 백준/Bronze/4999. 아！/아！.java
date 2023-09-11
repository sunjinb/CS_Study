import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String one = br.readLine();
        String two = br.readLine();

        if (one.length() >= two.length()) {
            System.out.println("go");
        }
        else {
            System.out.println("no");
        }
    }
}
