import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr1;
    static int[] arr2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr1 = new int[N];
        arr2 = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        int onePointer = 0;
        int twoPointer = 0;
        ArrayList<Integer> result = new ArrayList<>();
        while(onePointer < arr1.length && twoPointer < arr2.length){
            if(arr1[onePointer] < arr2[twoPointer]){
                result.add(arr1[onePointer]);
                onePointer++;
            }
            else{
                result.add(arr2[twoPointer]);
                twoPointer++;
            }
        }

        while(onePointer < arr1.length){
            result.add(arr1[onePointer]);
            onePointer++;
        }

        while(twoPointer < arr2.length){
            result.add(arr2[twoPointer]);
            twoPointer++;
        }

        for(int i = 0; i < result.size(); i++){
            sb.append(result.get(i) + " ");
        }
        System.out.println(sb);
    }
}
