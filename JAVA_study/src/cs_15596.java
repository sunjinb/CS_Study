import java.util.Scanner;

public class cs_15596 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        long result = sum(a);
    }
    public static long sum(int[] a){
        long result = 0;
        for(int i = 0; i < a.length; i++){
            result += a[i];
        }
        return result;
    }
}