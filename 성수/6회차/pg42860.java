import java.util.*;

class Solution42860 {
    public int solution(String name) {
        int answer = 0;

        Map<Character,Integer> map = new HashMap<>();

        for(int i = 0; i < 14; i++) {
            map.put((char)('A'+i),i);
        }
        for(int i = 0; i <= 11; i++) {
            map.put((char)('O'+i), (12-i));
        }

        //상하이동
        for(int i = 0; i < name.length(); i++) {
            answer += map.get(name.charAt(i));
        }

        int minMove = name.length() - 1;

        for(int i = 0; i < name.length(); i++) {
            int next = i + 1;

            //A는 상하이동이 필요없어서 계속 건너뜀
            while(next < name.length() && name.charAt(next) == 'A') {
                next++;
            }
            //          5
            //0 1 2 3 4 5 6 7 8 9 10
            //B B B A A B A A A A B


            // 1. 앞 -> 뒤
            minMove = Math.min(minMove, i * 2 + (name.length() - next));
            // 2. 뒤 -> 앞
            minMove = Math.min(minMove, (name.length() - next) * 2 + i);
        }

        answer += minMove;

        return answer;
    }
}
