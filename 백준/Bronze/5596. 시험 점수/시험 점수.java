import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int result1 = 0;
		int result2 = 0;

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++){
			result1 += Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++){
			result2 += Integer.parseInt(st.nextToken());
		}

		if(result1 >= result2){
			System.out.println(result1);
		}
		else{
			System.out.println(result2);
		}
	}
}