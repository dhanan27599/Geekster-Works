package Week3.Day9;

import java.util.*;

public class GetKeypadCharacter_QAApproach {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        solve(sc.next());
    }

    public static void solve(String s) {
        solve(s, "");
    }

    public static void solve(String question, String answer) {
        if(question.length() == 0) {
            System.out.println(answer);
            return;
        }

        char c = question.charAt(0);
        String choice = choice(c);
        String rem = question.substring(1);
        for(int i = 0 ; i < choice.length() ; i++) {
            solve(rem, answer + choice.charAt(i));
        }
    }


    public static String choice(char key) {
        if(key == '1') {
            return "abc";
        } else if(key == '2') {
            return "def";
        } else if(key == '3') {
            return "ghi";
        } else if(key == '4') {
            return "jkl";
        } else if(key == '5') {
            return "mno";
        } else if(key == '6') {
            return "pqr";
        } else if(key == '7') {
            return "stu";
        } else if(key == '8') {
            return "vwx";
        } else if(key == '9') {
            return "yz";
        } else {
            return "";
        }
    }
}
