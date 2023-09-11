import java.io.*;
import java.util.*;

public class Main {
	static int K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			K = Integer.parseInt(br.readLine());
			
			// 작은거 먼저
			PriorityQueue<Integer> minQ = new PriorityQueue<>();
			
			// 큰거 먼저
			PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
			
			Map<Integer, Integer> map = new HashMap<>();
			
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				char ch = st.nextToken().charAt(0);
				int value = Integer.parseInt(st.nextToken());
				
				// 삽입 연산
				if(ch == 'I') {
					minQ.add(value);
					maxQ.add(value);
					map.put(value, map.getOrDefault(value, 0) + 1);
				}
				// 삭제 연산
				else {
					if(map.size() == 0) continue;
					
					else {
						if(value == 1) {
							remove(maxQ, map);
						}
						else if(value == -1) {
							remove(minQ, map);
						}
					}
				}
			}
			
			if (map.size() == 0)
                sb.append("EMPTY\n");
            else {
                int max = remove(maxQ, map);
                sb.append(max + " " + (map.size() > 0 ? remove(minQ, map) : max) + "\n");
            }
		}
		System.out.println(sb);
	}
	private static int remove(PriorityQueue<Integer> q, Map<Integer, Integer> map) {
		int num;
		while(true) {
			num = q.poll();
			
			int val = map.getOrDefault(num, 0);
			
			if(val == 0) continue;
			
			if(val == 1) map.remove(num);
			else map.put(num, val - 1);
			break;
		}
		return num;
	}
}
