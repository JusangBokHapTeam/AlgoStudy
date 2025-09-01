class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        int s = 1, e = 0;
        for (int i = 0; i < stations.length; i++) {
            e = stations[i] - w;
            
            answer += (e - s) / (2 * w + 1);
            if (((e - s) % (2 * w + 1)) > 0) {
                answer++;
            }
            
            s = stations[i] + w + 1;
        }
        
        if (s <= n && e <= n) {
            e = n + 1;
            
            answer += (e - s) / (2 * w + 1);
            if (((e - s) % (2 * w + 1)) > 0) {
                answer++;
            }
        }

        return answer;
    }
}
