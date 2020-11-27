package newVersion;

import java.util.Scanner;

public class Backjoon20167 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		max = 0;
		num = new int[N];
		for(int i=0; i<N; i++) {
			num[i] = sc.nextInt();
		}
		dfs(0,0);
		
		System.out.println(max);
	}
	static int K,N, max;
	static int[] num;
	static void dfs(int idx, int sum) {
		if(idx>N) return;
		//System.out.println(idx + ", " + sum);
		max = Math.max(max, sum);
		
		int energy = 0;
		for(int i=idx; i<N; i++) {
			energy += num[i];
			if(energy>=K) {
				dfs(i+1, sum+energy-K);
				break;
			}
		}
		
		dfs(idx+1, sum);
	}

}
