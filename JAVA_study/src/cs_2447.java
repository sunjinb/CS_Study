import java.util.Scanner;

public class cs_2447 {
    static char[][] arrays;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        arrays = new char[num][num];

        drawStar(0, 0, num, false);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < num; i++){
            for(int j = 0; j < num; j++){
                sb.append(arrays[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static void drawStar(int x, int y, int N, boolean blank) {
        if (blank) {
            for (int i = x; i < x + N; i++){
                for (int j = y; j < y + N; j++){
                    arrays[i][j] = ' ';
                }
            }
            return;
        }

        if (N == 1){
            arrays[x][y] = '*';
            return;
        }

        int size = N / 3;
        int count = 0;
        for (int i = x; i < x + N; i += size){
            for (int j = y; j < y + N; j+= size){
                count++;
                if(count == 5){
                    drawStar(i, j, size, true);
                }
                else{
                    drawStar(i, j, size, false);
                }
            }
        }
    }
}
