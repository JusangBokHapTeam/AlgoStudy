import java.io.*;
import java.util.*;

/**
 * 백준 S3 ( https://www.acmicpc.net/problem/32196 )
 */
public class BJ_32196_급행열차 {

    static int N, M;
    static long K, X, Y, ans;
    static Queue<Station> pq = new PriorityQueue<Station>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 역 갯수
        M = Integer.parseInt(st.nextToken()); // 대피선 설치 역 갯수
        K = Long.parseLong(st.nextToken()); // 노선 운행 시간
        X = Long.parseLong(st.nextToken()); // 일반열차 갯수
        Y = Long.parseLong(st.nextToken()); // 급행열차 갯수

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            pq.add(new Station(i, a, b));
        }

        ans = (X + Y) * K; // 최초 운행시간
        for(int i = 0; i < M; i++) {
            Station now = pq.poll();
            ans += (now.x * X - now.y * Y); // 대피선 설치할때 운행시간 줄어드는 순으로 시간 합산
        }

        bw.write(ans + "\n");
        bw.flush();

        br.close();
        bw.close();
    }

    private static class Station implements Comparable<Station> {
        int n; // 역 번호
        long x; // 일반열차 운행시간
        long y; // 급행열차 운행시간

        Station(int n, long x, long y) {
            this.n = n;
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Station o) {
            return Long.compare(this.x * X - this.y * Y, o.x * X - o.y * Y); // [일반열차 시간 - 급행열차 운행시간] 기준 오름차순 (대피선 설치 시 열차운행 줄어드는 시간이 큰 순으로 정렬)
        }
    }
}
