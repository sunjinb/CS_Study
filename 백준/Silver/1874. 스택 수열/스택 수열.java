import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int count = sc.nextInt();

        int[] stack = new int[count];

        int index = 0;
        int header = 0;

        while (count-- > 0){
            int value = sc.nextInt();

            if(value > header) {
                for(int i = header + 1; i <= value; i++){
                    stack[index] = i;
                    index++;
                    sb.append('+').append('\n');
                }
                header = value;
            }

            else if(stack[index - 1] != value){
                System.out.println("NO");
                return;
            }
            
            index--;
            sb.append('-').append('\n');
        }
        System.out.println(sb);
    }
}

