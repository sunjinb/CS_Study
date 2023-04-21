import java.io.*;
import java.util.*;

public class Main {
	static int N;
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
	    StringTokenizer st;
	    
	    PriorityQueue<Integer> q = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(o2, o1);
			}
		});
	    
	    N = Integer.parseInt(br.readLine());
	    for(int i = 0; i < N; i++) {
	    	int X = Integer.parseInt(br.readLine());
	    	if(X > 0) q.add(X);
	    	if(X == 0) {
	    		if(q.size() == 0) sb.append(0 + "\n");
	    		else sb.append(q.poll() + "\n");
	    	}
	    }
	    System.out.println(sb);
	}
}