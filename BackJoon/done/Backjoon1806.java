package newVersion;

import java.util.Scanner;

public class Backjoon1806 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] input = new int[N];
		
		for(int i=0; i<N; i++)
			input[i] = sc.nextInt();
		
		int front = 0;
		int end = 0;
		int sum = input[0];
		int min = N+1;
		while(front<N && end<N) {
			if(sum>=K) {
				min = Math.min(min, end-front+1);
			}
			
			if(sum<K) {
				if(end>=N-1)
					break;
				
				sum += input[++end];
			} else {
				sum -= input[front++];
			}
		}
		
		if(min == N+1)
			min = 0;
		
		System.out.println(min);

	}

}
