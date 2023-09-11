import java.io.*;
import java.util.*;

public class Main {
	static int N;
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
	    StringTokenizer st;

	    PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1, o2);
			}
		});
	    
	    N = Integer.parseInt(br.readLine());
	    for(int i = 0; i < N; i++) {
	    	st = new StringTokenizer(br.readLine());
	    	int tmp = Integer.parseInt(st.nextToken());
	    	
	    	if(tmp > 0) q.add(tmp);
	    	if(tmp == 0) {
	    		if(q.size() == 0) sb.append(0 + "\n");
	    		else sb.append(q.poll() + "\n");
	    	}
	    }
	    
	    System.out.println(sb);
	}
}