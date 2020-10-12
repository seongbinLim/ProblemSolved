package D3;

import java.util.Arrays;
import java.util.Scanner;

public class SwEx5948 {
	static boolean[] sum;
	static boolean[] visited;
	static int[] num;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int test=1; test<=tc; test++) {
			num = new int[7];
			visited = new boolean[7];

			for(int i=0; i<7; i++) {
				num[i] = sc.nextInt();
			}
			Arrays.sort(num);
			
			int maxTotal = num[6]+num[5]+num[4]+1;
			sum = new boolean[maxTotal];
			calculate(0,0,0);
			int cnt = 0;
			for(int i=maxTotal-1; i>=0; i--) {
				if(sum[i])
					cnt++;
				
				if(cnt == 5) {
					System.out.println("#"+test + " " + i);
					break;
				}
			}
		}
	}
	
	public static void calculate(int total, int idx, int prv) {
		if(idx == 3) {
			sum[total] = true;
			return;
		}
		
		for(int i=prv; i<7; i++) {
			if(!visited[i]) {
				visited[i] = true;
				calculate(total+num[i],idx+1, i+1);
				visited[i] = false;
			}
		}
	}

}