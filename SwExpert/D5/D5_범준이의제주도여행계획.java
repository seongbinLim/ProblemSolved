package D5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D5_범준이의제주도여행계획 {
	static class Point {
		char ch;
		int score;
		int time;
		
		public Point(char ch) {
			this.ch = ch;
		}
		
		public Point(char ch, int score, int time) {
			this.ch = ch;
			this.score = score;
			this.time = time;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken()); //지점포인트
			int M = Integer.parseInt(st.nextToken()); //휴가기간
			int[][] adj = new int[N][N];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=i+1; j<N; j++) {
					if(i!=j) {
						adj[i][j] = Integer.parseInt(st.nextToken());
						adj[j][i] = adj[i][j];
					}
				}
			}
			
			Point[] arr = new Point[N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				char c = st.nextToken().charAt(0);
				if(c == 'A' || c == 'H') {
					arr[i] = new Point(c);
				} else {
					int s = Integer.parseInt(st.nextToken());
					int time = Integer.parseInt(st.nextToken());
					arr[i] = new Point(c, s, time);
				}
			}
			
			int[] v = new int[N];
			
			for(int i=0; i<M; i++) {
				int remainT = 60 * 9;
				char last = 'H';
				if(i==M-1) last = 'A';
				
				while(remainT>0) {
					//선택해야함 현재지점에서 
					
				}
			}
		}
		

	}

}
