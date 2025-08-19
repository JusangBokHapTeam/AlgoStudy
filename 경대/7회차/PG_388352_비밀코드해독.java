package programmers;

import java.util.*;

/**
 * 프로그래머스 Lv2 ( https://school.programmers.co.kr/learn/courses/30/lessons/388352 )
 */
public class PG_388352_비밀코드해독 {

    static class Solution {

        static int answer, N, Q[][], A[];

        public int solution(int n, int[][] q, int[] ans) {
            N = n;
            Q = q;
            A = ans;

            for(int i = 1; i <= n - 4; i++) {
                solve(i, 0, new Integer[5]);
            }

            return answer;
        }

        private void solve(int now, int cnt, Integer[] list)  {

            list[cnt] = now;

            if(cnt == 4) {
                if(check(list)) answer++;
                return;
            }

            for(int i = now + 1; i <= N - (3 - cnt); i++) {
                solve(i, cnt + 1, list);
            }
        }

        private boolean check(Integer[] list) {

            for(int i = 0; i < Q.length; i++) {
                int cnt = 0;
                for(int j = 0; j < 5; j++) {
                    if(Arrays.asList(list).contains(Q[i][j])) {
                        cnt++;
                    }
                }
                if(cnt != A[i]) {
                    return false;
                }
            }

            return true;

        }
    }

}
