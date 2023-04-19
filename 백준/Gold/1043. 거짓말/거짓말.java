import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[] parents;
	static boolean[] cannotGoParty;
	static boolean[] visited;
	static boolean[] knowTruthPersonNum;
	static ArrayList<Integer>[] partyList;
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

	    st = new StringTokenizer(br.readLine());
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    
	    knowTruthPersonNum = new boolean[N + 1];
	    st = new StringTokenizer(br.readLine());
	    int knowNum = Integer.parseInt(st.nextToken());
	    for(int i = 0; i < knowNum; i++) {
	    	int tmp = Integer.parseInt(st.nextToken());
	    	knowTruthPersonNum[tmp] = true;
	    }
	    
	    partyList = new ArrayList[M];
	    for(int i = 0; i < M; i++) {
	    	partyList[i] = new ArrayList<>();
	    }
	    
	    makeSet();
	    
	    // 파티에 참여하는 사람들 입력
	    for(int i = 0; i < M; i++) {
	    	st = new StringTokenizer(br.readLine());
	    	int partyPeopleNum = Integer.parseInt(st.nextToken());
	    	for(int j = 0; j < partyPeopleNum; j++) {
	    		partyList[i].add(Integer.parseInt(st.nextToken()));
	    	}
	    }
	    
	    // 파티별로 루트녀석들 바꾸기
	    for(int i = 0; i < M; i++) {
	    	for(int j = 0; j < partyList[i].size(); j++) {
	    		if(j == 0) continue;
	    		union(partyList[i].get(j - 1), partyList[i].get(j));
	    	}
	    }
	    
	    visited = new boolean[N + 1];
	    // 사람 돌면서 루트 녀석들 바꾸기
	    for(int i = 1; i <= N; i++) {
	    	// 이 녀석이 알고 있다면
	    	if(knowTruthPersonNum[i] && !visited[i]) {
	    		// 알고 있는 녀석의 루트 찾기
	    		int knowRoot = findRoot(i);
	    		for(int j = 1; j <= N; j++) {
	    			if(i == j) continue;
	    			if(findRoot(j) == knowRoot) {
	    				knowTruthPersonNum[j] = true;
	    				visited[j] = true;
	    			}
	    		}
	    	}
	    }
	    
	    cannotGoParty = new boolean[M];
	    
	    for(int i = 1; i <= N; i++) {
	    	if(knowTruthPersonNum[i]) {
	    		for(int j = 0; j < M; j++) {
	    			if(partyList[j].contains(i)) {
	    				cannotGoParty[j] = true;
	    			}
	    		}
	    	}
	    }
	    
	    int result = M;
	    for(int i = 0; i < cannotGoParty.length; i++) {
	    	if(cannotGoParty[i]) {
	    		result--;
	    	}
	    }
	    
	    System.out.println(result);
	    
	}
	
	private static void union(int from, int to) {
		int rootFrom = findRoot(from);
		int rootTo = findRoot(to);
		
		if(rootFrom != rootTo) {
			parents[rootFrom] = rootTo;
		}
	}
	
	private static int findRoot(int val) {
		if(parents[val] == val) return val;
		else return parents[val] = findRoot(parents[val]);
	}
	
	private static void makeSet() {
		parents = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			parents[i] = i;
		}
		
	}
}