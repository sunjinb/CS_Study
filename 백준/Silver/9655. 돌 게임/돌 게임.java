import java.io.*;
import java.util.*;

public class Main {
	static int N;
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
	    StringTokenizer st;
	    
	    N = Integer.parseInt(br.readLine());
	    if(N % 2 == 0) System.out.println("CY");
	    else System.out.println("SK");
	}
}