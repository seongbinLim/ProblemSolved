package newVersion;

import java.util.Arrays;
import java.util.Scanner;

public class Backjoon20164 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		int s = Integer.parseInt(input);
		min = Integer.MAX_VALUE;
		max = 0;
		dfs(s, oddCnt(s));
		System.out.println(min+" "+max);
	}
	static int min;
	static int max;
	static int[] arr;
	private static void dfs(int x, int total_odd_cnt) {
		if(x < 10) {
			min = Math.min(min, total_odd_cnt);
			max = Math.max(max, total_odd_cnt);
			return;
		}
		
		if(x<100) {
			int next_x = (x/10) + (x%10);
			dfs(next_x, oddCnt(next_x) + total_odd_cnt);
			return;
		}
		
		String s = Integer.toString(x);
		for(int i=0; i<=s.length()-3; i++) {
			for(int j=i+1; j<=s.length()-2; j++) {
				String x1 = s.substring(0,i+1);
				String x2 = s.substring(i+1,j+1);			
				String x3 = s.substring(j+1,s.length());
				
				int next_x = Integer.parseInt(x1) + Integer.parseInt(x2) + Integer.parseInt(x3);
				dfs(next_x, oddCnt(next_x)+total_odd_cnt);
			}
		}
		
	}
	
	static int oddCnt(int x) {
		int res = 0;
		while(x>0) {
			int digit = x%10;
			if(digit%2==1) res++;
			x /= 10;
		}
		return res;
	}

}
