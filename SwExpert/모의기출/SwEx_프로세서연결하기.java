package 모의기출;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SwEx_프로세서연결하기 {
	static int N,M;
	static int[] max;
	static int[][] map;
	static ArrayList<Point> list;
	static class Point {
		int x,y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			
			list = new ArrayList<>();
			M = 0;
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 1) {
						if(i==0||i==(N-1)||j==0||j==(N-1))
							continue;
						list.add(new Point(i, j));
						M++;
					}
				}
			}
			max = new int[M+1];
			Arrays.fill(max, Integer.MAX_VALUE);
			dfs(0,0,map, 0);
			//System.out.println(Arrays.toString(max));
			for(int i=M; i>0; i--) {
				if(max[i]!=Integer.MAX_VALUE) {
					sb.append("#"+t+" "+max[i]+"\n");
					break;
				}
			}
		}
		System.out.println(sb.toString());
	}
	static void change(int dir, int[][] arr, int x, int y) {
		if(dir==0) { //up
			for(int i=x-1; i>=0; i--)
				arr[i][y] = -1;
		} else if(dir==1) { //left
			for(int i=y-1; i>=0; i--)
				arr[x][i] = -1;
		} else if(dir==2) { //down
			for(int i=x+1; i<N; i++)
				arr[i][y] = -1;
		} else { //right
			for(int i=y+1; i<N; i++)
				arr[x][i] = -1;
		}
	}
	static int check(int dir, int[][] arr, int x, int y) {
		int len=0;
		if(dir==0) { //up
			for(int i=x-1; i>=0; i--) {
				if(arr[i][y]!=0) return 0;
				len++;
			}
		} else if(dir==1) { //left
			for(int i=y-1; i>=0; i--) {
				if(arr[x][i]!=0) return 0;
				len++;
			}
		} else if(dir==2) { //down
			for(int i=x+1; i<N; i++) {
				if(arr[i][y]!=0) return 0;
				len++;
			}
		} else { //right
			for(int i=y+1; i<N; i++) {
				if(arr[x][i]!=0) return 0;
				len++;
			}
		}
		return len;
	}
	static void dfs(int idx, int length, int[][] copy, int cnt) {
		//System.out.println(cnt);
		if(idx==M) {
			max[cnt] = Math.min(max[cnt], length);
			return;
		}
		for(int i=0; i<4; i++) {
			int[][] copy2 = new int[N][N];
			for(int j=0; j<N; j++) {
				copy2[j] = copy[j].clone();
			}
			Point p = list.get(idx);
			int c = check(i, copy2, p.x, p.y);
			if(c>0) {
				change(i, copy2, p.x, p.y);
				dfs(idx+1, length+c, copy2, cnt+1);
			} else {
				if(max[M] == Integer.MAX_VALUE)
					dfs(idx+1, length+c, copy2, cnt);
			}
		}
	}

}
