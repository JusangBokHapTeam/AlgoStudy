package boj;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.StringTokenizer;

/**
 * 백준 S3 ( https://www.acmicpc.net/problem/1021 )
 */
public class BJ_01021_회전하는큐_2 {

    static int N, M, input[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 큐의 크기
        M = Integer.parseInt(st.nextToken()); // 뽑아내려고 하는 수의 개수
        input = new int[M]; // 지민이가 뽑아내려고 하는 수의 위치

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(solve());
        bw.flush();

        br.close();
        bw.close();
    }

    private static String solve() {
        int ans = 0; // 정답
        int now = 0; // 현재 뽑아내려는 수의 index

        Deque<Integer> dq = new ArrayDeque<>();
        for(int i = 1; i <= N; i++) {
            dq.addLast(i); // 초기 덱 만들기
        }

        while(now < M) {
            // 1. 첫 번째 원소를 뽑아낸다.
            if(dq.peekFirst() == input[now]) {
                dq.pollFirst();
                now++;
            } else {
                int fcnt = 0; // 앞에서 찾았을때의 크기
                Iterator<Integer> it = dq.iterator();
                while(it.hasNext()) {
                    if(it.next() == input[now]) break;
                    fcnt++;
                }

                int lcnt = 0; // 뒤에서 찾았을때의 크기
                Iterator<Integer> dit = dq.descendingIterator();
                while(dit.hasNext()) {
                    if(dit.next() == input[now]) break;
                    lcnt++;
                }

                // 2. 왼쪽으로 한 칸 이동시킨다.
                if(fcnt <= lcnt) {
                    for(int i = 0; i < fcnt; i++) {
                        dq.addLast(dq.removeFirst());
                    }
                    dq.removeFirst();
                    ans += fcnt;
                    now++;
                }
                // 3. 오른쪽으로 한 칸 이동시킨다.
                else {
                    for(int i = 0; i < lcnt; i++) {
                        dq.addFirst(dq.removeLast());
                    }
                    dq.removeLast();
                    ans += lcnt + 1; // 한번 더 움직여야 하므로(맨앞의 원소만 뽑을 수 있음)
                    now++;
                }
            }
        }

        return Integer.toString(ans);
    }
}
