import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        boolean flag = true;

        for(int i = 0; i < str.length() / 2; i++){
            char front = str.charAt(i);
            char back = str.charAt(str.length() - i - 1);

            if(front != back){
                flag = false;
                break;
            }
        }

        if(flag) System.out.println(1);
        else System.out.println(0);
    }
}
