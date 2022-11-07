import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    static int n;
    static int Strike_cnt;
    static int Ball_cnt;
    static int question_cnt;
    static String[] numbers = new String[3];
    static ArrayList<Integer> list = new ArrayList<>(999);

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            String[] data = br.readLine().split(" ");

            // 123이 입력됐으면 numbers[0]에는 1, numbers[1]에는 2, numbers[2]에는 3이 들어간다.
            numbers[0] = data[0].charAt(0) + "";
            numbers[1] = data[0].charAt(1) + "";
            numbers[2] = data[0].charAt(2) + "";
            Strike_cnt = Integer.parseInt(data[1]);
            Ball_cnt = Integer.parseInt(data[2]);
            question_cnt++;

            calculate(numbers);
        }
        System.out.println(list.size());
    }

    static void calculate(String[] compare){
        int first, second, third = 0;
        ArrayList<Integer> tmp = new ArrayList<>();

        for(int i = 123; i <= 999; i++){
            int strike = 0;
            int ball = 0;

            first = i / 100;
            second = ((i - (first * 100)) / 10);
            third = (i - (first * 100) - (second * 10));

            if(first == 0 || second == 0 || third == 0){
                continue;
            }
            else if(first == second || second == third || third == first){
                continue;
            }
            int [] arr = {first, second, third};

            for(int j = 0; j < 3; j++){
                for(int k = 0; k < 3; k++){
                    if(arr[j] == Integer.parseInt(compare[k])){
                        if(j==k){
                            strike++;
                            continue;
                        }
                        ball++;
                    }
                }
            }

            if(Strike_cnt == strike && Ball_cnt == ball){
                tmp.add(i);
            }
        }

        if(question_cnt != 1){
            list.retainAll(tmp);
        }
        else{
            list.addAll(tmp);
        }
    }
}
