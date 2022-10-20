import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        double[] score = new double[num];
        double[] new_score = new double[num];
        double max = 0;
        double sum = 0;

        for(int i = 0; i < num; i++){
            score[i] = sc.nextInt();
            if(score[i] > max){
                max = score[i];
            }
        }

        for(int i = 0; i < num; i++){
            new_score[i] = (score[i] / max) * 100;
            sum += new_score[i];
        }
        System.out.println(sum / num);
    }
}
