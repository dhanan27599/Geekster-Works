package HashMap_Questions;

import java.util.*;
public class Group_Anagram {
    public static void main(String[] args) {
        String[] words = {"cat", "act", "tac", "dog", "god"};
        System.out.println(solve(words));
    }

    public static List<List<String>> solve(String[] words) {
        Map<Map<Character, Integer>, List<String>> res = new HashMap<>();

        for(String s : words) {
            Map<Character, Integer> map = new HashMap<>();
            for(char c : s.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            if(res.containsKey(map)) {
                res.get(map).add(s);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                res.put(map, list);
            }
        }

        return new ArrayList<>(res.values());
    }

}
