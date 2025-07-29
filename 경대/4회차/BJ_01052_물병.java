import java.io.*;
import java.util.*;

/**
 * 백준 G5 ( https://www.acmicpc.net/problem/1052 )
 */
public class BJ_01052_물병 {

    static long N, ans;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bw.write(solve());
        bw.flush();

        br.close();
        bw.close();
    }

    private static String solve() {
        // 1. 일단 가지고 있는 물병으로 만들 수 있는 만큼 만들기 ( ex) 13 > 8 + 4 + 1 : 물병 3개로 만들 수 있음 => 이것을 비트마스킹으로 표현 )
        String bitNumber = Long.toBinaryString(N); // 2진수로 표현된 N 값
        int oneCnt = 0; // 현재 가지고 있는 물병 수
        for(int i = 0; i < bitNumber.length(); i++) {
            if(bitNumber.charAt(i) == '1') {
                oneCnt++;
            }
        }

        // 2. 물병을 사지 않아도 되는 상황이면 0 리턴
        if(oneCnt == 1 || oneCnt <= K) {
            return "0";
        }

        // 3. 물병 2진법 자리수 만큼 추가해보면서 진행
        ans = 0;
        char prev = '0'; // 이전 자리수에서 올린 값
        boolean flag = false;
        for(int i = 0; i < bitNumber.length(); i++) {
            char now = bitNumber.charAt(bitNumber.length() - i - 1);
            if(now == '1' && prev == '0') {         // (2^i)리터 물병이 있고 전에 합쳐진게 없다면
                ans += (long) Math.pow(2, i);       // 1리터 물병 (2^i)개 만큼 사고
                oneCnt--;                           // 남은 물병 개수 감소
                prev = '1';
            } else if (now == '0' && prev == '1') { // (2^i)리터 물병이 없는데 전에 합쳐진게 있다면
                ans += (long) Math.pow(2, i);       // 1리터 물병 (2^i)개 만큼 사기 만 하기
                prev = '1';
            } else if (now == '1' && prev == '1') { // (2^i)리터 물병이 있고 전에 합쳐진게 있다면
                oneCnt--;                           // 남은 물병 개수 감소만 하기
                prev = '1';
            } else {                                // 둘다 아니면 다음 진행
                prev = '0';
            }

            // 4. 문제에 적합해지면 break
            if(oneCnt < K) {
                flag = true;
                break;
            }
        }

        // 5. 여기까지 왔는데 k보다 크거나 같다면 정답이 없으므로 -1 리턴
        return flag ? String.valueOf(ans) : "-1";
    }

}
