import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] arr;
	static int[] sortValue;
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
	    StringTokenizer st;

	    N = Integer.parseInt(br.readLine());
	    arr = new int[N];
	    sortValue = new int[N];
	    st = new StringTokenizer(br.readLine());
	    for(int i = 0; i < N; i++) {
	    	arr[i] = Integer.parseInt(st.nextToken());
	    	sortValue[i] = arr[i];
	    }
	    
	    Arrays.sort(sortValue);
	    
	    HashMap<Integer, Integer> hashMap = new HashMap<>();
	    
	    int rank = 0;
	    for(int i = 0; i < sortValue.length; i++) {
	    	if(!hashMap.containsKey(sortValue[i])) {
	    		hashMap.put(sortValue[i], rank);
	    		rank++;
	    	}
	    }
	    
	    for(int i = 0; i < arr.length; i++) {
	    	sb.append(hashMap.get(arr[i]) + " ");
	    }
	    
	    System.out.println(sb);
	}
}