import java.util.*;

public class Main {

    public static int stack[];
    public static int size = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        stack = new int[n];

        for(int i = 0; i < n; i++){
            String str = sc.next();

            switch (str){
                case "push":
                    int item = sc.nextInt();
                    push(item);
                    break;
                case "pop":
                    sb.append(pop()).append('\n');
                    break;
                case "size":
                    sb.append(size).append('\n');
                    break;
                case "empty":
                    if(size == 0){
                        sb.append('1').append('\n');
                    }
                    else
                        sb.append('0').append('\n');
                    break;
                case "top":
                    if(size == 0){
                        sb.append('-').append('1').append('\n');
                    }
                    else{
                        sb.append(stack[size-1]).append('\n');
                    }
                    break;
            }
        }
        System.out.println(sb);
    }

    public static void push(int item){
        stack[size] = item;
        size++;
    }

    public static int pop(){
        if(size >= 1){
            int item = stack[size-1];
            size--;
            return item;
        }
        else{
            return -1;
        }
    }
}
