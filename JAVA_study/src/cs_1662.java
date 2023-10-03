import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class cs_1662 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<String> stack = new Stack<>();
        for(char ch : br.readLine().toCharArray()) {
            // 닫는 괄호가 아니라면 다 스택에 쌓기
            if(ch != ')') {
                stack.add(ch + "");
            }
            // 닫는 괄호라면
            else {
                int count = 0;
                // 여는 괄호를 일단 찾아
                while(!stack.peek().equals("(")) {
                    // 여는 괄호 바로 앞에 녀석이면 그 녀석의 길이만큼 더할꺼고 아님 1만 더함
                    count += stack.pop().equals("*") ? Integer.parseInt(stack.pop()) : 1;
                }
                // 여는 괄호 빼주기
                stack.pop();

                // 이제 다음 계산할 녀석 문자열 길이 넣고
                stack.push(String.valueOf(count * Integer.parseInt(stack.pop())));
                // 얘는 작업을 한 애야 표시
                stack.push("*");
            }
        }

        long answer = 0;
        while(!stack.isEmpty()) {
            answer += stack.pop().equals("*") ? Integer.parseInt(stack.pop()) : 1;
        }

        System.out.print(answer);
    }
}
