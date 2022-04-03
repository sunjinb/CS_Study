import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class NumberBaseball {

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
            // data에는 123, 1, 1 의 값이 들어간다.

            numbers[0] = data[0].charAt(0) + "";
            numbers[1] = data[0].charAt(1) + "";
            numbers[2] = data[0].charAt(2) + "";
            // 123이 입력됐으면 numbers[0]에는 1, numbers[1]에는 2, numbers[2]에는 3이 들어간다.

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

            // strike 와 ball 을 판단/확인 개념
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
        
        // 기존의 List와 비교 과정
        if(question_cnt == 1){
            list.addAll(tmp);
            // 질문순서가 1인경우에는 비교할 list가 tmp의 모든 요소들을 add한다.
        }
        else{
            list.retainAll(tmp);
            // 질문순서가 2 이상인 경우에는 이전 질문에서 넣은 list와 tmp를 비교하여 그 둘의 교집합만 list에 남긴다.
        }
    }
}
