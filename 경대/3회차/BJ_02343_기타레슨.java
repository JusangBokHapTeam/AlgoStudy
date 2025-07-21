import java.io.*;
import java.util.StringTokenizer;

/**
 * 백준 S1 ( https://www.acmicpc.net/problem/2343 )
 */
public class BJ_02343_기타레슨 {

    static int N, M, input[], ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 강의의 수
        M = Integer.parseInt(st.nextToken()); // 블루레이 수

        input = new int[N];
        int start = -1;
        int end = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
            start = Math.max(start, input[i]); // 강의의 길이 중 가장 큰 것
            end += input[i]; // 강의의 길이 총 합
        }

        // 이분탐색
        ans = Integer.MAX_VALUE;
        while(start <= end) {
            int mid = (start + end) / 2; // 임시 블루레이 크기
            int cnt = 1;
            int tempSum = 0;
            for(int i = 0; i < N; i++) {
                tempSum += input[i];
                if(tempSum > mid) { // 그룹으로 안묶어질 경우 그룹 하나 추가 생성
                    cnt++;
                    tempSum = input[i];
                }
            }

            if(cnt > M) {   // 그룹이 블루레이 수보다 많다면 > 크기 늘려서 재시도
                start = mid + 1;
            } else {        // 그룹이 블루레이 수보다 같거나 작다면 > 크기 작게해서 재시도
                end = mid - 1;
                ans = mid;
            }
        }

        bw.write(ans + "\n");
        bw.flush();

        br.close();
        bw.close();
    }
}
