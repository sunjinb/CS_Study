import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int[] alphabet = new int[26];

        for(int i = 0; i < 26; i++){
            alphabet[i] = -1;
        }

        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);

            if(alphabet[ch - 'a'] == -1){
                alphabet[ch - 'a'] = i;
            }
        }

        for(int val : alphabet){
            System.out.print(val + " ");
        }
    }
}
