import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static boolean[] isNotPrime;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		isNotPrime = new boolean[N + 1];
		isNotPrime[0] = isNotPrime[1] = true;
		
		ArrayList<Integer> primeList = new ArrayList<>();
			
		for(int i = 2; i * i <= N; i++) {
			if(!isNotPrime[i]) {
				for(int j = i * i; j <= N; j += i) {
					isNotPrime[j] = true;
				}
			}
		}
		
		for(int i = 1; i <= N; i++) {
			if(!isNotPrime[i]) {
				primeList.add(i);
			}
		}
        
		int onePointer = 0;
		int twoPointer = 0;
		
		int sum = 0;
		int result = 0;
		
		while(true){
            // 합이 N 이상이라면
            if(sum >= N){
                sum -= primeList.get(onePointer);
                onePointer++;
            }
            else if(twoPointer == primeList.size()){
                break;
            }
            // 합이 N 미만이라면
            else{
                sum += primeList.get(twoPointer);
                twoPointer++;
            }
            // 목표 도달
            if(sum == N){
                result++;
            }
        }
		
		System.out.println(result);
	}
}

