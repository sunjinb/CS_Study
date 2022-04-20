import java.util.Scanner;

public class cs_1157 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] alphabet = new int[26];
        for (int i = 0; i < alphabet.length; i++){
            alphabet[i] = 0;
        }

        String str = sc.next();

        for (int i = 0; i < str.length(); i++){
            if ('A' <= str.charAt(i) && str.charAt(i) <= 'Z'){
                alphabet[str.charAt(i) - 'A']++;
            }
            else{
                alphabet[str.charAt(i) - 'a']++;
            }
        }

        int max = 0;
        char ch = '?';
        for(int i = 0; i < alphabet.length; i++){
            if(alphabet[i] > max){
                max = alphabet[i];
                ch = (char) (i + 65);
            }
            else if(alphabet[i] == max){
                ch = '?';
            }
        }
        System.out.print(ch);

    }
}