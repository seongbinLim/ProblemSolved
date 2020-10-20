package newVersion;

import java.util.Scanner;

public class Backjoon2003 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int K = sc.nextInt();
		
		int[] input = new int[T];
		for(int i=0; i<T; i++)
			input[i] = sc.nextInt();
		
		int front = 0;
		int end = 0;
		int answer = 0;
		int sum = input[0];
		while(!(front >= T || end >= T)) {
			if(sum==K) answer++;
			
			int frontD = input[front];
			
			if(sum<K) {
				if(end == T-1) break;
				sum += input[++end];
			} else {
				sum -= frontD;
				front++;
			}
		}
		
		System.out.println(answer);

	}

}
