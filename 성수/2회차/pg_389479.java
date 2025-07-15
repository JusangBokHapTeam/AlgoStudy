import java.util.ArrayList;
import java.util.List;

class Solution {
    
    static class Server{
        private int life;

        public Server(int life) {
            this.life = life;
        }

        public void minusOneHour() {
            this.life -= 1;
        }

        //0 보다 클때 > 서버가 살아있을 때
        public boolean isEnd() {
            return this.life <= 0;
        }
    }
    
    public int solution(int[] players, int m, int k) {
         int answer = 0;

        List<Server> list = new ArrayList<>();


        for (int player : players) {

            for (Server server : list) {
                server.minusOneHour();
            }
            list.removeIf(Server::isEnd);

            if(player >= m) {
                //필요한 서버 수
                int requiredSevers = player / m;

                int newServerCount = requiredSevers - list.size();
                if(newServerCount > 0) {
                    for (int i = 0; i < newServerCount; i++) {
                        list.add(new Server(k));
                        answer += 1;
                    }
                }

            }

        }

        return answer;
    }
}
