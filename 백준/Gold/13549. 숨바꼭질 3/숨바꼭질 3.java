import java.io.*;
import java.util.*;

public class Main {
	static int N, K;
	static final int INF = 1000001;
	static int[] times;
	static class Info implements Comparable<Info>{
		int point, time;
		public Info(int point, int time) {
			this.point = point;
			this.time = time;
		}
		@Override
		public int compareTo(Info o) {
			return Integer.compare(this.time, o.time);
		}
	}
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
	    StringTokenizer st;
	    
	    st = new StringTokenizer(br.readLine());
	    
	    N = Integer.parseInt(st.nextToken());
	    K = Integer.parseInt(st.nextToken());
	    
	    
	    times = new int[1000001];                 
	    
	    Arrays.fill(times, INF);
	    
	    PriorityQueue<Info> q = new PriorityQueue<>();
	    q.add(new Info(N, 0));
	    times[N] = 0;
	    int result = -1;
	    
	    while(!q.isEmpty()) {
	    	Info now = q.poll();
	    	
	    	if(now.point == K) {
	    		result = now.time;
	    		break;
	    	}
	    	
	    	if(now.time > times[now.point]) continue;
	    	
	    	
	    	int[] nextPoint = {now.point - 1, now.point + 1, now.point * 2};
	    	
	    	for(int i = 0; i < nextPoint.length; i++) {
	    		if(nextPoint[i] < times.length && nextPoint[i] >= 0) {
	    			int nextTime = times[now.point];
	    			if(i < 2) {
	    				nextTime = times[now.point] + 1; 
		    		}
	    			if(nextTime < times[nextPoint[i]]) {
	    				times[nextPoint[i]] = nextTime;
	    				q.add(new Info(nextPoint[i], nextTime));
	    			}
	    		}
	    	}
	    }
	    System.out.println(result);
	}
}