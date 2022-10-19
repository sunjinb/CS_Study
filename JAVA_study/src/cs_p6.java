public class cs_p6 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int zero_count = 0;
        int official_count = 0;
        int high_count = 0;
        int low_count = 0;
        int high_rank = 0;
        int low_rank = 0;

        for(int i = 0; i < lottos.length; i++){
            if(lottos[i] == 0){
                zero_count += 1;
            }
        }

        for(int i = 0; i < lottos.length; i++){
            for(int j = 0; j < win_nums.length; j++){
                if(lottos[i] == win_nums[j]){
                    official_count += 1;
                }
            }
        }

        high_count = official_count + zero_count;
        low_count = official_count;

        switch(high_count){
            case 6: high_rank = 1;
                break;
            case 5: high_rank = 2;
                break;
            case 4: high_rank = 3;
                break;
            case 3: high_rank = 4;
                break;
            case 2: high_rank = 5;
                break;
            default: high_rank = 6;
                break;
        }

        switch(low_count){
            case 6: low_rank = 1;
                break;
            case 5: low_rank = 2;
                break;
            case 4: low_rank = 3;
                break;
            case 3: low_rank = 4;
                break;
            case 2: low_rank = 5;
                break;
            default: low_rank = 6;
                break;
        }

        answer[0] = high_rank;
        answer[1] = low_rank;

        return answer;
    }
}


