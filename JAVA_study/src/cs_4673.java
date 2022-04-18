public class cs_4673 {
    public static void main(String[] args) {
        boolean[] check = new boolean[10001];

        for(int i = 1; i < 10001; i++){
            int n = Self(i);
            if (n < 10001){
                check[n] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < 10001; i++){
            if (!check[i]) {
                sb.append(i).append('\n');
            }
        }
        System.out.println(sb);
    }
    public static int Self(int n){
        int total = n;

        while(n != 0){
            total += (n % 10);
            n /= 10;
        }

        return total;
    }
}