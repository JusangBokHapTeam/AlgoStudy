import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    private static Deque<Integer> nums;

    public int solution(int n, int[] arr) {

        int answer = 0;

        nums = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            nums.addLast(i);
        }

        for (int i = 0; i < arr.length; i++) {

            int idx = findIdxInQueue(arr[i]);
            if (idx == 0) {
                nums.pollFirst();
                continue;
            }

            int length = nums.size();
            if (idx < length - idx) {
                moveLeft(arr[i]);
                answer += idx;

            } else {
                moveRight(arr[i]);
                answer += length - idx;
            }
        }

        return answer;
    }

    private int findIdxInQueue(int num) {
        int idx = 0;
        for (int x : nums) {
            if (x == num) {
                break;
            }
            idx++;
        }
        return idx;
    }

    private void moveLeft(int num) {
        int tmp = nums.pollFirst();
        while (num != tmp) {
            nums.addLast(tmp);
            tmp = nums.pollFirst();
        }
    }

    private void moveRight(int num) {
        int tmp = nums.pollLast();
        while (num != tmp) {
            nums.addFirst(tmp);
            tmp = nums.pollLast();
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Main main = new Main();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[m];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(String.valueOf(main.solution(n, arr)));
        bw.flush();

        br.close();
        bw.close();
    }
}
