class Solution {
    public int solution(String name) {
        int answer = 0;
        
        int move = name.length() - 1;
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            answer += Math.min(c - 'A', 'Z' + 1 - c);
            int idx = i + 1;
            while (idx < name.length() && name.charAt(idx) == 'A') {
                idx++;
            } 
            move = Math.min(move, i * 2 + name.length() - idx);
            move = Math.min(move, (name.length() - idx) * 2 + i);
        }
        
        answer += move;
        
        return answer;
    }
}
