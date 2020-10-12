package D3;

import java.util.Scanner;
import java.util.Stack;

public class D3_제로 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for(int tc=1; tc<=test; tc++) {
			int K = sc.nextInt();

			Stack<Integer> stk = new Stack<>();
			
			for(int i=0; i<K; i++) {
				int num = sc.nextInt();
				if(num != 0) {
					stk.push(num);
				} else {
					stk.pop();
				}
			}
			
			int total = 0;
			
			while(!stk.isEmpty())
				total += stk.pop();
						
			System.out.println("#"+tc+" " + total);
			
		}

	}
}
