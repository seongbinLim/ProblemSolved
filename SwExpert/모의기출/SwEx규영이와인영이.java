package 모의기출;
import java.util.Arrays;
import java.util.Scanner;

public class SwEx규영이와인영이 {
	static int[] gyuyong; 
	static int[] inyong;
	static boolean[] visited;
	static int win;
	static int lose;
	static int totalWin;
	static int totalLose;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();

		for(int test=1; test<=tc; test++) {
			visited = new boolean[9];
			gyuyong = new int[9];
			inyong = new int[9];
			boolean[] in = new boolean[19];
			totalWin = 0;
			totalLose = 0;
			for(int i=0; i<9; i++) {
				int idx = sc.nextInt();
				gyuyong[i] = idx;
				in[idx] = true;
			}
			int idx = 0;
			for(int i=1; i<19; i++) {
				if(!in[i]) {
					inyong[idx++] = i;
				}
			}
			
			perm(0, new int[9]);
			System.out.println("#"+test+" " + totalWin + " " + totalLose);
			
		}

	}
	
	static void perm(int idx, int[] arr) {
		if(idx == 9) {
			for(int i=0; i<9; i++) {
				if(gyuyong[i] > arr[i])
					lose += gyuyong[i] + arr[i];
				else
					win += gyuyong[i] + arr[i];
			}
			
			if(win < lose) {
				totalWin++;
			} else {
				totalLose++;
			}
			
			win = 0;
			lose = 0;
			return;
		}
		
		for(int i=0; i<9; i++) {
			if(!visited[i]) {
				visited[i] = true;
				arr[idx] = inyong[i];
				perm(idx+1, arr);
				visited[i] = false;
			} 
		}
	}
}
