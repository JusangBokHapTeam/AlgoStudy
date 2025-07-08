/**
 * 프로그래머스 ( https://school.programmers.co.kr/learn/courses/30/lessons/388351 )
 */
public class PG388351_유연근무제 {

    private class Solution {
        public int solution(int[] schedules, int[][] timelogs, int startday) {
            int answer = 0;

            int N = schedules.length;
            for(int i = 0; i < N; i++) {
                boolean flag = true;
                for(int j = 0; j < 7; j++) {
                    int nowDay = (j + startday) % 7;
                    if(nowDay == 6 /*토요일*/ || nowDay == 0 /*일요일*/) continue;
                    if(!isInTime(schedules[i], timelogs[i][j])) flag = false;
                }
                if(flag) answer++;
            }

            return answer;
        }

        private boolean isInTime(int plan, int real) {
            // 실제출근시간 <= 출근희망시각 + 10분이면 이벤트 통과
            return (real/100)*60 + real%100 <= (plan/100)*60 + plan%100 + 10;
        }
    }

}
