
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {

        String str = "[](){}"; // 3
        String str1 = "}]()[{"; //2
        String str2 = "[)(]"; //0
        String str3 = "}}}"; //0

        int answer = solution("{{{");
        System.out.print(answer);

    }


    public static int solution(String s) {

        int initStringSize = s.length();
        String rotateString = s + s; // String 2 개를 이어붙이면 회전연산을 할 필요가 없음
        char[] arr = rotateString.toCharArray();

        int answer = 0;


        for (int i = 0; i < initStringSize; i++) { // 0 ~ 1000
            boolean flag = true;
            //디버깅용 소스
            //String temp = rotateString.substring(i, initStringSize + i);
            //System.out.println(temp);
            //디버깅용 소스

            Stack<Character> stack = new Stack<>();

            for (int j = i; j < initStringSize + i ; j++) {

                if(arr[j] == '(' || arr[j] == '[' || arr[j] == '{') {
                    stack.push(arr[j]);
                } else if(arr[j] == ')' && !stack.isEmpty() &&stack.peek() == '(') {
                    stack.pop();
                } else if(arr[j] == ']' && !stack.isEmpty() &&stack.peek() == '[') {
                    stack.pop();
                } else if(arr[j] == '}' && !stack.isEmpty() &&stack.peek() == '{') {
                    stack.pop();
                } else {
                    flag = false;
                    break;
                }

            }
            // 반례 {{{ , stack 이 비어있어야함
            if(flag && stack.isEmpty()) {
                answer += 1;
            }
        }

        return answer;
    }
}
