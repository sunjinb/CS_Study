import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int result;
    static ArrayList<Integer> nums;
    static ArrayList<Character> ops;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        nums = new ArrayList<>();
        ops = new ArrayList<>();

        String str = br.readLine();
        for(int i = 0; i < N; i++){
            if(i % 2 == 0) {
                nums.add(str.charAt(i) - '0');
            }
            else{
                ops.add(str.charAt(i));
            }
        }

        result = Integer.MIN_VALUE;
        dfs(0, nums.get(0));
        System.out.println(result);
    }

    private static void dfs(int op_idx, int sum) {
        // 연산자 계산 완료됐으면 종료
        if (op_idx >= ops.size()) {
            result = Math.max(result, sum);
            return;
        }

        // 괄호를 치지않고 재귀
        int tmp = calc(sum, nums.get(op_idx + 1), ops.get(op_idx));
        dfs(op_idx + 1, tmp);

        // 괄호를 치고 재귀
        if(op_idx + 1 < ops.size()){
            // 다음 녀석 먼저 계산
            int nextTmp = calc(nums.get(op_idx + 1), nums.get(op_idx + 2), ops.get(op_idx + 1));
            int curTmp = calc(sum, nextTmp, ops.get(op_idx));
            dfs(op_idx + 2, curTmp);
        }
    }

    private static int calc(int num1, int num2, char op) {
        int res = 0;
        if(op == '+'){
            res = num1 + num2;
        }
        else if(op == '-'){
            res = num1 - num2;
        }
        else if(op == '*'){
            res = num1 * num2;
        }
        return res;
    }
}
