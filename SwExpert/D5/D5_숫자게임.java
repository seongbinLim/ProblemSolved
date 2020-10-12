package D5;

import java.util.Scanner;
//복습필!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
public class D5_숫자게임 {
	static int max;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int input = sc.nextInt();
			max = 0;
			if (input / 10 > 0) {
				String number = input + "";
				for (int i = 0; i < number.length() - 1; i++) {
					int a = Integer.parseInt(number.substring(0, i + 1));
					int b = Integer.parseInt(number.substring(i + 1));
					System.out.println(a + "," + b);
					recur(a, b, 1);
				}
			}

			System.out.println("#" + t + " " + max);
		}
	}

	static void recur(int A, int B, int turn) {
		System.out.println("in recur" + turn + " / " + A*B);
		if (A * B < 10) {
			max = Math.max(max, turn);
			//System.out.println("in..........");
			return;
		} else {
			int newNum = A * B;
			String newStr = newNum + "";
			for (int i = 0; i < newStr.length() - 1; i++) {
				A = Integer.parseInt(newStr.substring(0, i + 1));
				B = Integer.parseInt(newStr.substring(i + 1));
				System.out.println("here" + A + "," + B);
				recur(A, B, turn + 1);
			}
		}
	}
    static void dfs(int num ,int cnt) {
        if(num < 10 ) {
            max = Math.max(max, cnt);
            return;
        }
        String str = Integer.toString(num);
        int len = str.length()-1;
        int sum = str.charAt(0)-'0';
        int tmpSum = 1;
        for(int i = 1 ; i < (1 << len) ; i++) {
            for(int j = 0 ; j < len ; j++) {
                if((i & (1 << j)) != 0) {
                    tmpSum = tmpSum * sum;
                    sum = (str.charAt(j+1)-'0');
                }else {
                    sum = sum*10+(str.charAt(j+1)-'0');
                }
            }
            int res = tmpSum * sum;
 
            dfs(res, cnt+1);
            sum = str.charAt(0)-'0';
            tmpSum = 1;
        }
    }
}
