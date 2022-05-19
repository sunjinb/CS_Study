public class cs_p2 {
    public static void main(String[] args) {
        int[] lottos = new int[]{44, 1, 0, 0, 31, 25};
        int[] win_nums = new int[]{31, 10, 45, 1, 6, 9};
        int[] result = Solution(lottos, win_nums);
        for(int i = 0; i < result.length; i++){
            System.out.print(result[i] + " ");
        }
    }

    static int[] Solution(int[] lottos, int[] win_nums){
        int[] answer = new int[2];
        int[] count = new int[2];
        int delete_num = 0;
        int result_num = 0;

        for (int i = 0; i < lottos.length; i++) {
            if(lottos[i] == 0) {
                delete_num++;
            }
            else{
                for(int j = 0; j < lottos.length; j++){
                    if(win_nums[j] == lottos[i]){
                        result_num++;
                        break;
                    }
                }
            }
        }
        count[0] = result_num;
        count[1] = result_num + delete_num;

        for(int i = 0; i < answer.length; i++){
            if(count[i] == 6 ){
                answer[i] = 1;
            }
            else if(count[i] == 5){
                answer[i] = 2;
            }
            else if(count[i] == 4){
                answer[i] = 3;
            }
            else if(count[i] == 3){
                answer[i] = 4;
            }
            else if(count[i] == 2){
                answer[i] = 5;
            }
            else{
                answer[i] = 6;
            }
        }

        int temp;
        temp = answer[0];
        answer[0] = answer[1];
        answer[1] =  temp;

        return answer;
    }
}
