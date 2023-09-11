import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int result;
	static boolean[] visited;
	static Queue<Info> q;
	static ArrayList<Point> ladderList;
	static ArrayList<Point> snakeList;
	static class Point{
		int start, to;
		public Point(int start, int to){
			this.start = start;
			this.to = to;
		}
	}
	static class Info{
		int point, depth;
		public Info(int point, int depth) {
			this.point = point;
			this.depth = depth;
		}
	}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        ladderList = new ArrayList<>();
        for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	int start = Integer.parseInt(st.nextToken());
        	int to = Integer.parseInt(st.nextToken());
        	ladderList.add(new Point(start, to));
        }
        
        snakeList = new ArrayList<>();
        for(int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	int start = Integer.parseInt(st.nextToken());
        	int to = Integer.parseInt(st.nextToken());
        	snakeList.add(new Point(start, to));
        } 
        
        result = Integer.MAX_VALUE;
        
        visited = new boolean[101];
        q = new LinkedList<>();
        visited[1] = true;
        q.add(new Info(1, 0));
        
        
        while(!q.isEmpty()) {
        	Info now = q.poll();
        	
        	L:for(int dice = 1; dice <= 6; dice++) {
        		int nextPoint = now.point + dice;
        		
        		if(nextPoint == 100) {
        			System.out.println(now.depth + 1);
        			return;
        		}
        		
        		if(nextPoint < 0 || nextPoint > 100 || visited[nextPoint]) continue;
        		
        		for(int i = 0; i < ladderList.size(); i++) {
        			if(nextPoint == ladderList.get(i).start) {
        				visited[nextPoint] = true;
        				q.add(new Info(ladderList.get(i).to, now.depth + 1));
        				continue L;
        			}
        		}
        		
        		for(int i = 0; i < snakeList.size(); i++) {
        			if(nextPoint == snakeList.get(i).start) {
        				visited[nextPoint] = true;
        				q.add(new Info(snakeList.get(i).to, now.depth + 1));
        				continue L;
        			}
        		}
        		
        		visited[nextPoint] = true;
        		q.add(new Info(nextPoint, now.depth + 1));
        	}
        }
        
        System.out.println(result);

    }
}