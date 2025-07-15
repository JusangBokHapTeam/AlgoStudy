package programmers;

/**
 * 프로그래머스 ( https://school.programmers.co.kr/learn/courses/30/lessons/389479 )
 */
public class PG_389479_서버증설횟수 {

    private class Solution {
        public int solution(int[] players, int m, int k) {
            int answer = 0;

            // 서버 1대면 m명이상 2m명 미만
            // 서버 2대변 2m<= <3m

            int[] servers = new int[24]; // server[i] = i ~ i+1 시각의 서버 수
            for(int i = 0; i < 24; i++) {
                int needServers = players[i] / m; // 필요한 서버 수
                if(servers[i] >= needServers) continue;
                else {
                    int addServers = needServers - servers[i]; // 추가해야 할 서버 수
                    answer += addServers;
                    for(int j = i; j < i+k && j < 24; j++) { // j 시각의 서버 수 갱신
                        servers[j] += addServers;
                    }
                }
            }

            return answer;
        }
    }

}
