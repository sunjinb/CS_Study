import java.io.*;
import java.util.*;

public class Main {
	static int N;
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
	    StringTokenizer st;
	    
	    PriorityQueue<Integer> minq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
	    
	    PriorityQueue<Integer> maxq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		});
	    
	    
	    N = Integer.parseInt(br.readLine());
	    for(int i = 0; i < N; i++) {
	    	int num = Integer.parseInt(br.readLine());
	    	
	    	// 만약 둘 다 비어있으면 그냥 minq에 넣으면 됨
	    	if(minq.size() == 0 && maxq.size() == 0) {
	    		minq.add(num);
	    	}
	    	
	    	else if(minq.size() == 1 && maxq.size() == 0) {
	    		if(minq.peek() <= num) {
	    			maxq.add(num);
	    		}
	    		else {
	    			int tmp = minq.poll();
	    			minq.add(num);
	    			maxq.add(tmp);
	    		}
	    	}
	    	
	    	
	    	// 둘의 사이즈가 같아? 그럼 minq에 넣어야겠지
	    	else if(minq.size() == maxq.size()) {
	    		if(maxq.peek() < num) {
	    			int tmp = maxq.poll();
	    			minq.add(tmp);
	    			maxq.add(num);
	    		}
	    		else {
	    			minq.add(num);
	    		}
	    	}
	    	
	    	// minq에 들어있는 녀석이 더 많아? 그럼 maxq에 넣어야겠지
	    	// 근데 maxq에 있는 놈 중에 젤 작은 놈이 num보다 작아?
	    	// 그럼 minq에 전자놈 넣고 maxq에 num을 넣어야겠지
	    	else if(minq.size() > maxq.size()) {
	    		if(minq.peek() <= num) {
	    			maxq.add(num);
	    		}
	    		else {
	    			int tmp = minq.poll();
	    			minq.add(num);
	    			maxq.add(tmp);
	    		}
	    	}
	    	
//	    	System.out.println("minq : ");
//	    	for(int val : minq) {
//	    		System.out.print(val + " ");
//	    	}
//	    	System.out.println();
//	    	
//	    	System.out.println("maxq : ");
//	    	for(int val : maxq) {
//	    		System.out.print(val + " ");
//	    	}
//	    	System.out.println();
//	    	System.out.println();
	    	
	    	
	    	// minq에 있는 애들 중에 제일 큰 녀석
	    	sb.append(minq.peek() + "\n");
	    }
	    
	    System.out.println(sb);
	}
}