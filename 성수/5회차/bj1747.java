import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if(n == 1 || n == 2) {
            System.out.println(2);
        } else {

            //isPell(n);
           long i = n;
            //n 보다 크거나 같고이기떄문에 안되는것 
           while(true) {
                if(isPrime(i) && isPell(i)) {
                    System.out.println(i);
                    break;
                }
                i += 1;
           }

        }

    }

    static boolean isPrime(long n) {
        
        if(n % 2 == 0) {
            return false;
        }

        for (int i = 3; i <= Math.sqrt(n); i+= 2) {
            if(n % i == 0) {
                return false;
            }
        }

        return true;

    }

  static boolean isPell(long n) {

        String str = String.valueOf(n);
        char[] arr = str.toCharArray();

        for (int i = 0; i < arr.length / 2; i++) {
            if(arr[i] != arr[arr.length-1-i]) return false;
        }


        return true;

    }


}
