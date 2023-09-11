import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static ArrayList<Info> list;
	static class Info implements Comparable<Info>{
		int age;
		String name;
		public Info(int age, String name) {
			this.age = age;
			this.name = name;
		}
		@Override
		public int compareTo(Info o) {
			return Integer.compare(this.age, o.age);
		}
	}
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
	    StringTokenizer st;

	    N = Integer.parseInt(br.readLine());
	    list = new ArrayList<>();
	    for(int i = 0; i < N; i++) {
	    	st = new StringTokenizer(br.readLine());
	    	int age = Integer.parseInt(st.nextToken());
	    	
	    	String str = st.nextToken();
	    	
	    	list.add(new Info(age, str));
	    }
	    
	    Collections.sort(list);
	    
	    for(int i = 0; i < list.size(); i++) {
	    	Info info = list.get(i);
	    	
	    	sb.append(info.age + " " + info.name + "\n");
	    }
	    System.out.println(sb);
	}
}