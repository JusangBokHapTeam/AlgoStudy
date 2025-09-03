import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        
        Set<String> gemSet = new HashSet<>();
        for (String gem : gems) {
            gemSet.add(gem);
        }
        
        int gemCount = gemSet.size();
        int len = Integer.MAX_VALUE;
        int l = 0;
        Map<String, Integer> gemMap = new HashMap<>();
        for (int r = 0; r < gems.length; r++) {
            gemMap.put(gems[r], gemMap.getOrDefault(gems[r], 0) + 1);
            
            while (gemMap.get(gems[l]) - 1 > 0) {
                gemMap.put(gems[l], gemMap.get(gems[l]) - 1);
                l++;
            }
            
            if (gemMap.size() == gemCount && len > r - l) {
                len = r - l;
                answer[0] = l + 1;
                answer[1] = r + 1;
            }
        }
        
        return answer;
    }
}
