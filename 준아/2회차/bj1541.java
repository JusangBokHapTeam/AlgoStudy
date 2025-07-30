import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    // 1차 시도 : 자료구조 사용 - 너무 복잡하게 푼 듯
    public int solution(String str) {

        // 1. 숫자와 기호 분리
        Queue<Integer> nums = new LinkedList<>();
        Queue<Character> signs = new LinkedList<>();
        String tmp = "";
        for (char c : str.toCharArray()) {
            if (c == '-' || c == '+') {
                nums.offer(Integer.parseInt(tmp));
                signs.offer(c);
                tmp = "";
            } else {
                tmp += c;
            }
        }
        nums.offer(Integer.parseInt(tmp));

        // 2. '+' 먼저 계산
        Deque<Integer> results = new LinkedList<>();
        results.addLast(nums.poll());
        while (!signs.isEmpty()) {
            int sign = signs.poll();
            if (sign == '-') {
                results.addLast(nums.poll());
            } else {
                results.addLast(results.pollLast() + nums.poll());
            }
        }

        int answer = results.pollFirst();
        while (!results.isEmpty()) {
            answer -= results.pollFirst();
        }

        return answer;
    }

    // 2차 시도 : 다른 사람 풀이 참고. StringTokenizer
    public int solution2(String str) {

        StringTokenizer minusToken = new StringTokenizer(str, "-");

        boolean isFirst = true;
        int answer = 0;
        while (minusToken.hasMoreTokens()) {
            StringTokenizer plusToken = new StringTokenizer(minusToken.nextToken(), "+");

            int sum = 0;
            while (plusToken.hasMoreTokens()) {
                sum += Integer.parseInt(plusToken.nextToken());
            }

            if (isFirst) {
                answer = sum;
                isFirst = false;
            } else {
                answer -= sum;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Main main = new Main();

        String str = br.readLine();

        bw.write(String.valueOf(main.solution2(str)));
        bw.flush();

        br.close();
        bw.close();
    }
}
