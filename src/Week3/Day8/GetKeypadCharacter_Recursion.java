package Week3.Day8;

import java.util.*;

public class GetKeypadCharacter_Recursion {
    static Map<String, String> map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        map = new HashMap<>();
        map.put("1", "abc");
        map.put("2", "def");
        map.put("3", "ghi");
        map.put("4", "jkl");
        map.put("5", "mno");
        map.put("6", "pqr");
        map.put("7", "stu");
        map.put("8", "vwx");
        map.put("9", "yz");

        System.out.println(solve(s));
    }

    private static ArrayList<String> solve(String s) {
        if(s.length() == 0) {
            ArrayList<String> br = new ArrayList<>();
            br.add("");
            return br;
        }
        char c = s.charAt(0);
        ArrayList<String> recursiveresult = solve(s.substring(1));
        ArrayList<String> finalresult = new ArrayList<>();
        String ch = map.get(c + "");
        for(String str : recursiveresult) {
            for(int i = 0 ; i < ch.length() ; i++) {
                finalresult.add(ch.charAt(i) + str);
            }
        }
        return finalresult;
    }

//    public static String choice(char key) {
//        if(key == '1') {
//            return "abc";
//        } else if(key == '2') {
//            return "def";
//        } else if(key == '3') {
//            return "ghi";
//        } else if(key == '4') {
//            return "jkl";
//        } else if(key == '5') {
//            return "mno";
//        } else if(key == '6') {
//            return "pqr";
//        } else if(key == '7') {
//            return "stu";
//        } else if(key == '8') {
//            return "vwx";
//        } else if(key == '9') {
//            return "yz";
//        } else {
//            return "";
//        }
//    }

}
