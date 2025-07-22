import java.io.*;
import java.util.*;

/**
 * 백준 G5 ( https://www.acmicpc.net/problem/1931 )
 */
public class BJ_01931_회의실배정 {

    static int N, ans;
    static PriorityQueue<Meeting> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pq.offer(new Meeting(start, end));
        }

        bw.write(String.valueOf(solve()));
        bw.flush();

        br.close();
        bw.close();
    }

    private static int solve() {
        ans = 1;
        Meeting prev = pq.poll();
        while(!pq.isEmpty()) {
            Meeting now = pq.poll();
            if(prev.end <= now.start) {
                ans++;
                prev = now;
            }
        }
        return ans;
    }

    static class Meeting implements Comparable<Meeting> {

        int start;
        int end;

        Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting o) {
            // 끝나는 시간 기준으로 오름차순(같으면 시작하는 시간 기준)
            return end == o.end ? start - o.start : end - o.end;
        }
    }
}
