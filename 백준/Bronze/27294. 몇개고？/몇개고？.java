import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
	    StringTokenizer st;

		    
	    st = new StringTokenizer(br.readLine());
	    int T = Integer.parseInt(st.nextToken());
	    int S = Integer.parseInt(st.nextToken());
	    
	    // 점심식사면서 술과 같이 먹지 않는다면 320
	    
	    if(T >= 12 && T <= 16 && S == 0) System.out.println(320);
	    else System.out.println(280);
	}
}