import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
	
		for(int testCase = 0; testCase < T; testCase++) {
			st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			
			int roomNum = 0;
			int floorNum = 0;
			if(N % H == 0) {
				floorNum = H;
				roomNum = N / H;
				
			}
			else {
				floorNum = N % H;
				roomNum = N / H + 1;
			}
			
			
			if(roomNum <= 9) System.out.println(floorNum + "0"  + roomNum);
			else System.out.println(floorNum + ""  + roomNum);
		}
	}

}