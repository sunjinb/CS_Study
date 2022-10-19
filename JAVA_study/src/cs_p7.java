public class cs_p7 {
    public long solution(int price, int money, int count) {
        long answer = 0;
        long total_price = 0;
        long rest = 0;

        for(int i = 1; i <= count; i++){
            total_price = total_price + (price * i);
        }

        rest = money - total_price;

        if(rest > 0){
            answer = 0;
        }
        else{
            answer = total_price - money;
        }

        return answer;
    }
}
