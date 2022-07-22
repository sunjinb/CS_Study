import java.util.Stack;

public class cs_p4 {
    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0}, {0,0,1,0,3}, {0,2,5,0,1}, {4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};

        int result = solution(board, moves);
        System.out.println(result);
    }

    static public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        int top = 0;
        //인형 집는 과정
        for(int i = 0; i < moves.length; i++){
            int move = moves[i];
            int[] array = board[move-1];
            //인형 위치 찾아서 바구니에 넣기
            for(int j = 0; j < array.length; j++){
                int item = array[array.length - j - 1];
                if(item != 0){
                    if(stack.size() != 0){
                        top = stack.peek();
                    }
                    //인형 같으면 터트리기
                    if(top == item){
                        stack.pop();
                        answer += 2;
                    }
                    //인형 다르면 추가
                    else{
                        stack.push(item);
                    }
                }
            }
        }
        return answer;
    }
}
