package done;
import java.util.Scanner;

public class BackJoon9663 {
	static int[][] map;
	static int count;
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		count = 0;
		backtrack(0);
		System.out.println(count);
	}
	
	static void backtrack(int idx) {
		if(idx == N) {
			count++;
			return;
		}
		
		for(int i=0; i<N; i++) {
			map[idx][i] = 1;
			if(isPossible(idx, i)) {
				backtrack(idx+1);
			}
			map[idx][i] = 0;
			
		}
	}
	
	static boolean isPossible(int x, int y) {
		//up
		for(int i=0; i<x; i++) {
			if(map[i][y]==1) return false;
		}
		//leftsideup
		for(int i=x-1, j=y-1; i>=0 && j>=0; i--, j--) {
			if(map[i][j]==1) return false;
		}
		//rightsideup
		for(int i=x-1, j=y+1; i>=0 && j<N; i--,j++) {
			if(map[i][j]==1) return false;
		}
		return true;
	}

}
