import java.util.Scanner;

import static java.lang.Math.pow;

public class 수이어쓰기_1748 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int size = Integer.toString(N).length();
        int ans = 0;
        for(int i=0; i<size; i++) {
            if(i == size-1) {
                int start = (int) Math.pow(10,i);
                ans += (N-start+1) * (i+1);
                continue;
            }
            double cnt = (9 * Math.pow(10,i)) * (i+1);
            ans += cnt;
        }

        System.out.println(ans);
    }
}
