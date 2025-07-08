public int solution(int[] schedules, int[][] timelogs, int startday) {
        
  int answer = 0;
        int employeeCount = schedules.length;
        boolean[] visited = new boolean[employeeCount];

        //5,6,7,8,9,10,11,12
        //1100
        //1008 958


        //6은 토요일 7은 일요일
        for (int j = 0; j < employeeCount; j++) {
            for (int i = startday, dayCount = 0; i < startday + 7 ; i++, dayCount++) {
                int day = (i + 7) % 7;  // 단 0 일 경우는 7과 같음,
                if(day != 0 && day != 6) {

                    int hour = timelogs[j][dayCount] / 100;
                    int minute = timelogs[j][dayCount] % 100;
                    int scheduleHour = schedules[j] / 100;
                    int scheduleMinute = schedules[j] % 100;
                    //timelogs[j][dayCount] - schedules[j] 
                    //1000  959   >> 10시 , 9시59분 실제로는 1분 차이지만 61분늦은것으로 계산됨.
                    //문제에 나오는 문자 그대로 구현하자! 
                    if((hour*60 + minute) - (scheduleHour*60 + scheduleMinute)  > 10) {
                        visited[j] = true;
                        break;
                    }
                }
            }
        }

        for (boolean check : visited) {
            if(!check) {
                answer += 1;
            }
        }

        System.out.print(answer);

        return answer;
}
