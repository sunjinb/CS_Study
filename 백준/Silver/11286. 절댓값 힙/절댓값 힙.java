import java.io.*;
import java.util.*;

public class Main {
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if(Math.abs(o1) == Math.abs(o2)){
					return o1 - o2;
				}
				else {
					return Math.abs(o1) - Math.abs(o2);	
				}
			}
		});
		
		N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			int op = Integer.parseInt(br.readLine());
			
			// 배열에서 절댓값이 가장 작은 값을 출력, 그 값을 제거
			if(op == 0) {
				if(q.size() == 0) {
					sb.append(0 + "\n");
				}
				else {
					sb.append(q.poll() + "\n");
				}
			}
			else {
				q.add(op);
			}
		}
		
		System.out.println(sb);
		
	}
}
