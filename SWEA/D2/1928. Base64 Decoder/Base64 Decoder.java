import java.util.Scanner;
import java.util.Base64;
public class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=1; t<=T; t++) {
            String encoded = sc.next();
            String decoded = new String(Base64.getDecoder().decode(encoded));
            System.out.format("#%d %s\n", t, decoded);
        }
    }
}