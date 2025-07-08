class Solution {
  
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        
        int answer = 0;
        
        for (int i = 0; i < schedules.length; i++) {
            
            int limitHour = schedules[i] / 100;
            int limitMinute = (schedules[i] % 100) + 10;
            
            if (limitMinute >= 60) {
                limitHour += 1;
                limitMinute -= 60;
            }
            
            int limitTime = limitHour * 100 + limitMinute;
            int cnt = 0;
            for (int j = 0; j < 7; j++) {
                
                int day = (startday + j) % 7;
                
                if (day == 6 || day == 0) {
                    cnt++;
                }
                else {
                     if (timelogs[i][j] <= limitTime) {
                        cnt++;
                    }
                }
            }
            
            if (cnt == 7) {
                answer++;
            }
        }
        
        return answer;
    }
}
