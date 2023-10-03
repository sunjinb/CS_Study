import java.util.ArrayList;

public class Levenshtein_distance_algorithm {
    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        list.add("초밥을 먹었어. 근데 엄청나게 맛있었어. 집에 오는 길에 넘어졌어.");
        list.add("초밥을 먹습니다");
        list.add("초밥을 버립니다. 치킨을 시켰습니다.");
        list.add("치킨은 맛있습니다");
        list.add("집에 파도가 칩니다");
        list.add("오다작가의 만화 원피스");
        list.add("이 길에 끝에 서서 하늘을 바라보다");
        list.add("초밥이 넘어집니다.");
        list.add("범선이는 밥을 먹는다.");
        list.add("그리고 선진이는 치킨을 먹는다.");
        list.add("선진이는 밥을 먹는다. 그리고 범선이는 초밥을 먹는다");
        list.add("초밥을 먹었어 범선이가. 선진이는 밥을 먹는데.");
        list.add("먹다 밥 선진 먹다 초밥 먹다 범선");
        list.add("먹다");
        list.add("범선");
        list.add("선진");
        list.add("초밥");
        list.add("먹었다");
        list.add("먹을거다");
        list.add("먹의싶다");
        list.add("범선 범선 범선");
        list.add("선");
        list.add("먹");
        list.add("다");

        String dream = "범선이는 초밥을 먹었다. 그리고 선진이는 밥을 먹을거다. 범선이는 배고프다.";


        System.out.println(dream);
        for(int i = 0; i < list.size(); i++){
            System.out.printf("%.0f 퍼센트의 정확도 ", similarity(dream, list.get(i)) * 100);
            System.out.println(list.get(i));
        }
    }
    private static double similarity(String s1, String s2) {
        String longer = s1, shorter = s2;

        if (s1.length() < s2.length()) {
            longer = s2;
            shorter = s1;
        }

        int longerLength = longer.length();
        if (longerLength == 0) return 1.0;
        return (longerLength - editDistance(longer, shorter)) / (double) longerLength;
    }

    private static int editDistance(String s1, String s2) {
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();
        int[] costs = new int[s2.length() + 1];

        for (int i = 0; i <= s1.length(); i++) {
            int lastValue = i;
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0) {
                    costs[j] = j;
                } else {
                    if (j > 0) {
                        int newValue = costs[j - 1];

                        if (s1.charAt(i - 1) != s2.charAt(j - 1)) {
                            newValue = Math.min(Math.min(newValue, lastValue), costs[j]) + 1;
                        }

                        costs[j - 1] = lastValue;
                        lastValue = newValue;
                    }
                }
            }

            if (i > 0) costs[s2.length()] = lastValue;
        }

        return costs[s2.length()];
    }
}
