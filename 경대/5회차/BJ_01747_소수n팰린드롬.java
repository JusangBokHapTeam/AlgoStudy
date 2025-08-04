import java.io.*;

/**
 * 백준 S1 ( https://www.acmicpc.net/problem/1747 )
 */
public class BJ_01747_소수n팰린드롬 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        while(true) {
            if(isPalindrome(N) && isPrime(N)) {
                bw.write(N + "\n");
                break;
            }
            N++;
        }

        bw.flush();

        br.close();
        bw.close();
    }

    // 팰린드롬 판단 메서드
    private static boolean isPalindrome(int n) {
        String str = Integer.toString(n);
        for(int i = 0; i<str.length() / 2; i++) {
            if(str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    // 소수 판단 메서드
    private static boolean isPrime(int n) {
        if(n < 2) return false;
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }

}
