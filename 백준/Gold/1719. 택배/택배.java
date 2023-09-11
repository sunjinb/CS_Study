import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static final int INF = 10000001;
	static int[][] map;  // 가는데 걸리는 시간
	static int[][] memo; // 최소 시간을 위해 거쳐서 가야하는 경유지
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
	    StringTokenizer st;

	    st = new StringTokenizer(br.readLine());
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    
	    map = new int[N + 1][N + 1];
	    memo = new int[N + 1][N + 1];
	    
	    for(int i = 1; i <= N; i++) {
	    	for(int j = 1; j <= N; j++) {
	    		memo[i][j] = j;
	    		map[i][j] = INF;
	    		if(i == j) {
	    			memo[i][j] = INF;
	    			map[i][j] = 0;
	    		}
	    	}
	    }
	    
	    for(int i = 0; i < M; i++) {
	    	st = new StringTokenizer(br.readLine());
	    	int from = Integer.parseInt(st.nextToken());
	    	int to = Integer.parseInt(st.nextToken());
	    	int cost = Integer.parseInt(st.nextToken());
	    	map[from][to] = cost; 
	    	map[to][from] = cost;
	    }
	    
	    for(int k = 1; k <= N; k++) {
	    	for(int i = 1; i <= N; i++) {
	    		// 시작점과 경유지가 같다면 굳이 안 해봐도됨
	    		if(i == k) continue;
	    		for(int j = 1; j <= N; j++) {
	    			if(i == j) continue;
	    			if(k == j) continue;
	    			// 경유지를 통해 목적지를 가는 방법이 있다면
	    			if(map[i][k] != INF && map[k][j] != INF) {
	    				if(map[i][k] + map[k][j] < map[i][j]) {
	    					map[i][j] = map[i][k] + map[k][j];
	    					memo[i][j] = memo[i][k];
	    				}
	    				
	    			}
	    		}
	    	}
	    }
	    
	    for(int i = 1; i <= N; i++) {
	    	for(int j = 1; j <= N; j++) {
	    		if(memo[i][j] == INF) sb.append("-" + " ");
	    		else sb.append(memo[i][j] + " ");
	    	}
	    	sb.append("\n");
	    }
	    
	    System.out.println(sb);
	}
}