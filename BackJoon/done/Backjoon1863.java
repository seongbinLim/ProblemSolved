package newVersion;

import java.util.Scanner;
import java.util.Stack;

public class Backjoon1863 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> stk = new Stack<>();
		int N = sc.nextInt();
		int answer = 0;
		for(int i=0; i<N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			while(!stk.isEmpty() && stk.peek()>y) {
				stk.pop();
				answer++;
			}
			if(!stk.isEmpty() && stk.peek()==y) continue;
			stk.push(y);
			
		}
		
		while(!stk.isEmpty()) {
			stk.pop();
			answer++;
		}
		
		System.out.println(answer);

	}

}
