import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int count = 1;
		int data = 1;
		if(A == 1) count = 1;
		else {
			count = 2;
			int plusNum = 6;
			while(true) {
				data += plusNum;
				if(data >= A) {
					break;
				}
				plusNum += 6;
				count++;
			}
		}
		System.out.println(count);
	}

}