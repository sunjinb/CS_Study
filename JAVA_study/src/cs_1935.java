import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class cs_1935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int[] array = new int[num];
        for(int i = 0; i < num; i++){
            array[i] = Integer.parseInt(br.readLine());
        }
        // 1 2 3 4 5
        Stack<Double> stack = new Stack<Double>();

        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if('A' <= ch && ch <= 'Z'){
                double data = array[ch - 'A'];  // 피연산자는 순서대로 나오므로
                stack.push(data);               // 스택에 쌓는 작업
            }
            else{
                double data1 = stack.pop();
                double data2 = stack.pop();
                double result = 0.0;
                switch (ch){
                    case '+':
                        result = data2 + data1;
                        break;
                    case '-':
                        result = data2 - data1;
                        break;
                    case '*':
                        result = data2 * data1;
                        break;
                    case '/':
                        result = data2 / data1;
                        break;
                }
                stack.push(result);
            }
        }
        System.out.printf("%.2f", stack.pop());
    }
}
