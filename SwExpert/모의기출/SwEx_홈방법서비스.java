package 모의기출;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SwEx_홈방법서비스 {
	static class Point {
		int x, y, k;
		public Point(int x, int y, int k) {
			this.x = x;
			this.y = y;
			this.k = k;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt(); //도시의 크기
			int M = sc.nextInt(); //비용지불
			
			int[][] map = new int[N][N];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			int K = N+1;
			
			
			int max = -1;
			
			for(int i=1; i<=K; i++) {
				for(int r=0; r<N; r++) {
					for(int c=0; c<N; c++) {
						
						int houseCnt = houseIn(i,r,c,N,map);
						int cost = i*i + (i-1)*(i-1);
						
						if((houseCnt*M)-cost>=0) {
							//System.out.println("i : "+i + " "+ cost + " " + houseCnt);
							max = Math.max(max, houseCnt);
						}
					}
				}
			}
			
			System.out.println("#" + t + " " + max);
		}

	}

	
    static int houseIn(int k, int x, int y, int N, int[][] map) {
    	int cnt = 0;
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if(Math.abs(x-i) + Math.abs(y-j) <= k -1 && map[i][j] == 1) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
