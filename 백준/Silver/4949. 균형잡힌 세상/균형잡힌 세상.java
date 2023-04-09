import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){
            String str = br.readLine();
            if(str.equals(".")) break;
            Stack<Character> stack = new Stack<>();
            boolean flag = true;
            for(int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if(ch == '(' || ch == '[') {
                    stack.push(ch);
                }
                else if(ch == ')') {
                    if(stack.empty() || stack.peek() != '(') {
                        flag = false;
                        break;
                    }
                    else {
                        stack.pop();
                    }
                }
                else if(ch == ']') {
                    if(stack.empty() || stack.peek() != '[') {
                        flag = false;
                        break;
                    }
                    else {
                        stack.pop();
                    }
                }
            }
            if(stack.empty() && flag) {
                System.out.println("yes");
            }
            else {
                System.out.println("no");
            }
        }
    }
}
