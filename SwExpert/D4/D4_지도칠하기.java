package D4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class D4_지도칠하기 {
	static int N, min;
	static int[] country;
	static boolean[] change;
	static int[][] adj;
	static class Color {
		int x,y;
		public Color(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			N = sc.nextInt();
			country = new int[N];
			for(int i=0; i<N; i++) {
				country[i] = sc.nextInt();
			}
			
			adj = new int[N][N];
			change = new boolean[N];

			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					adj[i][j] = sc.nextInt();
					if(adj[i][j]==1 && country[i] == country[j]) {
						change[i] = true;
						change[j] = true;
					}
				}
			}
			min = Integer.MAX_VALUE;
			for(int i=0; i<N; i++) {
				if(change[i])
					dfs(0);
			}
			if(min == Integer.MAX_VALUE) min = 0;
			System.out.println("#"+t+" "+min);
		}

	}
	
	static void dfs( int cnt) {
		if(cnt>= min) return;
		if(allDiff()) {
			min = Math.min(min, cnt);
			return;
		}
		for(int j=0; j<N; j++) {
			if(change[j]) {
				for(int i=1; i<=4; i++) {
					if(i != country[j]) {
						int origin = country[j];
						country[j] = i;
						change[j] = false;
						dfs(cnt+1);
						country[j] = origin;
						change[j] = true;
					}
				}
			}
		}
	}
	
	static boolean allDiff() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(adj[i][j]==1 && country[i] == country[j]) {
					return false;
				}
			}
		}
		
		return true;
	}
}
