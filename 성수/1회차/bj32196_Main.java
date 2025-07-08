import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//bj32196 문제에 나오는 정수 범위를 잘 확인하자
public class Main {



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //1번역 부터 N 번역
        //초기 : 일반, 급행 K분
        //(1 <= i <= N) i 번째 역에 대피선을 설치하면,
        // 일반 열차의 운행시간 Ai 분 증가
        // 급행 열차의 운행시간은 Bi 분 감소
        // X개의 일반열차 Y개의 급행열차
        // M 개의 역을 골라 대피선을 설치하려 한다

        //N,M,K,X,Y

        int station = Integer.parseInt(st.nextToken()); //전체역
        int destRailCount = Integer.parseInt(st.nextToken()); //골라서 설치할 역 개수
        long initMinute = Long.parseLong(st.nextToken()); //초기
        long normalTrainCount = Long.parseLong(st.nextToken()); //일반
        long speedTrainCount = Long.parseLong(st.nextToken()); //급행

        long[] time = new long[station]; // 각 케이스당 걸리는 시간 , 최소값 부터 더한다

        for (int i = 0; i < station; i++) {
            st = new StringTokenizer(br.readLine());
            long normalPlus =  Long.parseLong(st.nextToken());
            long speedMinus =  Long.parseLong(st.nextToken());

            //1. 시간 변동량의 총합
            time[i] = ((normalPlus * normalTrainCount) - (speedMinus * speedTrainCount));

        }

        //2. 가장 낮은 순으로 정렬
        Arrays.sort(time);

        long result = 0;
        for (int i = 0; i < destRailCount; i++) {
            result += time[i];
        }

        System.out.print(result + (normalTrainCount+speedTrainCount) * initMinute);

    }
}
