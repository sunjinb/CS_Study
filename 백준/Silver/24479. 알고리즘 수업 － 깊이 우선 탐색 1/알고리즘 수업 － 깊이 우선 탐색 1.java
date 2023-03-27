import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
	static int N, M, R;
	static int count;
	static int[] result;
	static boolean[] visited;
	static ArrayList<Integer>[] list;
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        
        list = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) {
        	list[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	int u = Integer.parseInt(st.nextToken());
        	int v = Integer.parseInt(st.nextToken());
        	list[u].add(v);
        	list[v].add(u);
        }
        
        for(int i = 1; i <= N; i++) {
        	Collections.sort(list[i]);
        }
        
        count = 1;
        result = new int[N + 1];
        visited = new boolean[N + 1];
        dfs(R);
        
        for(int i = 1; i <= N; i++) {
        	System.out.println(result[i]);
        }
    }
	private static void dfs(int point) {
		visited[point] = true;
		result[point] = count++;
		
		for(int next : list[point]) {
			if(!visited[next]) {
				dfs(next);
			}
		}
		
	}
}