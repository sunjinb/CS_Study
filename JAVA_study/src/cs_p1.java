import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class cs_p1 {
    public static void main(String[] args) {
        String[] first_input = new String[]{"muzi", "frodo", "apeach", "neo"};
        String[] second_input = new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int third_input = 2;
        int[] my_result = solution(first_input, second_input, third_input);
        for (int result : my_result) {
            System.out.println(result);
        }
    }

    public static int[] solution(String[] id_list, String[] report, int k){
        int[] answer = new int[id_list.length];
        HashMap<String, HashSet<String>> reportMap = new HashMap<>();
        HashMap<String, Integer> countMap = new HashMap<>();

        for(int i = 0; i < id_list.length; i++){
            String name = id_list[i];
            reportMap.put(name, new HashSet<>());
            countMap.put(name, i);
        }

        for (String s : report) {
            String[] str = s.split(" ");
            String from = str[0];
            String to = str[1];
            reportMap.get(to).add(from);
        }

        for (int i = 0; i < id_list.length; i++){
            HashSet<String> send = reportMap.get(id_list[i]);
            if(send.size() >= k){
                for(String name : send){
                    answer[countMap.get(name)]++;
                }
            }
        }
        return answer;
    }
}
