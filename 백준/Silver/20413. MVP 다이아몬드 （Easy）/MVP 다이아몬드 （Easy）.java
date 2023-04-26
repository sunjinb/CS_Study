import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] cost;
	static int[] result;
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
	    StringTokenizer st;

	    N = Integer.parseInt(br.readLine());
	    cost = new int[4];
	    
	    st = new StringTokenizer(br.readLine());
	    for(int i = 0; i < 4; i++) {
	    	cost[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    String str = br.readLine();
	    result = new int[str.length()];
	    
	    char startRank = str.charAt(0);
	    if(startRank == 'B') {
	    	result[0] = cost[0] - 1;
	    }
	    else if(startRank == 'S') {
	    	result[0] = cost[1] - 1;
	    }
	    else if(startRank == 'G') {
	    	result[0] = cost[2] - 1;
	    }
	    else if(startRank == 'P') {
	    	result[0] = cost[3] - 1;
	    }
	    else if(startRank == 'D') {
	    	result[0] = cost[3];
	    }
	    
	    
	    for(int i = 1; i < N; i++) {
	    	char rank = str.charAt(i);
	    	
	    	int beforeResult = result[i - 1];
	    	
	    	if(rank == 'B') {
	    		result[i] = cost[0] - beforeResult - 1;
	    	}
	    	else if(rank == 'S') {
	    		result[i] = cost[1] - beforeResult - 1;
	    	}
	    	else if(rank == 'G') {
	    		result[i] = cost[2] - beforeResult - 1;
	    	}
	    	else if(rank == 'P') {
	    		result[i] = cost[3] - beforeResult - 1;	
	    	}
	    	else if(rank == 'D') {
	    		result[i] = cost[3];
	    	}
	    }
	    
	    int sum = 0;
	    for(int i = 0; i < N; i++) {
	    	sum += result[i];
	    }
	    
	    System.out.println(sum);
	}
}