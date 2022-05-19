import java.util.ArrayList;

public class cs_p3 {
    public static void main(String[] args) {
        String str = new String("...!@BaT#*..y.abcdefghijklm");
        String answer = solution(str);
        System.out.println(answer);
    }

    public static String solution(String new_id){
        String answer = "";

        char[] arr = new_id.toCharArray();
        ArrayList<Integer> ascii1 = new ArrayList<>();
        int[] ascii2 = new int[new_id.length()];

        for(int i = 0; i < ascii2.length; i++){
            ascii2[i] = arr[i];
        }

        for (int a : ascii2){
            ascii1.add(a);
        }

        for(int i = 0; i < 7; i++){
            if(i == 0){
                for(int j = 0; j < ascii2.length; j++){
                    if(ascii2[j] <= 90 && ascii2[j] >= 65){
                        ascii2[j] -= 32;
                    }
                }
            }
            else if(i == 1){
                for(int j = 0; j < ascii2.length; j++){
                    if((ascii2[j] >= 48 && ascii2[j] >= 57) || (ascii2[j] == 45) || (ascii2[j] == 46) || (ascii2[j] == 95) || (ascii2[j] >= 97 && ascii2[j] <= 122)){
                        continue;
                    }
                    else{
                        ascii1.remove(j);
                    }
                }
            }
        }

        return answer;
    }
}
