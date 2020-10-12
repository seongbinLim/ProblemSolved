package 모의기출;
import java.util.Scanner;

public class SwEx_보호필름 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			D = sc.nextInt(); //보호필름 두께
			W = sc.nextInt(); //가로크기
			K = sc.nextInt(); //합격기준
			
			map = new int[D][W];
			
			for(int i=0; i<D; i++) {
				for(int j=0; j<W; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			min = Integer.MAX_VALUE;
			for(int i=0; i<=K; i++)
				pick(0,i);
			System.out.println("#"+t + " " + min);
			
		}
		
	}
	static int min;
	static int K;
	static int D;
	static int W;
	static int[][] map;
	public static void pick(int idx, int N) {
		if(min != Integer.MAX_VALUE)
			return;
		if(idx == N) {
			if(check())
				min = Math.min(min, N);
			return;
		}
		
		int[] copy = new int[W];
		for(int i=0; i<W; i++) {
			copy[i] = map[idx][i];
		}
		
		for(int i=0; i<W; i++) {
			map[idx][i] = 0;
		}
		
		pick(idx+1, N);
		for(int i=0; i<W; i++) {
			map[idx][i] = 1;
		}
		pick(idx+1, N);
		for(int i=0; i<W; i++) {
			map[idx][i] = copy[i];
		}
		
	}
	
	public static boolean check() {
		for(int i=0; i<W; i++) {
			boolean find = false;
			int temp = map[0][i];
			int cnt=1;
			
			for(int j=0; j<D; j++) {
				if(temp == map[i][j])
					cnt++;
				else {
					temp = map[i][j];
					cnt=1;
				}
				
				if(cnt == K) {
					find = true;
				}	
			}
			
			if(!find) return false;
		}
		return true;
	}

}
