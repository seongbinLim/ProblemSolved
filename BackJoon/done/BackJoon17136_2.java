package done;
import java.util.Scanner;

public class BackJoon17136_2 {
	static int[][] map;
	static int[] paper;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int count;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		map = new int[10][10];
		paper = new int[6];
		
		for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for(int k=5; k>0; k--) {
			for(int i=0; i<10; i++) {
				for(int j=0; j<10; j++) {
					if(map[i][j] == 1) {
						isFull(k, i, j);
					}
				}
			}
		}
		
		boolean find = false;
		for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++) {
				if(map[i][j]==1) {
					find = true;
					//System.out.println(i+ "," + j);
				}
			}
		}
		
		if(find)
			System.out.println(-1);
		else
			System.out.println(count);
	}
	
	//완전한 정사각형인지 아닌지 탐색
	static void isFull(int N, int x, int y) {
		boolean isFull = true;
		B:
		for(int i=x; i<x+N; i++) {
			for(int j=y; j<y+N; j++) {
				if((i < 10 && j < 10) && map[i][j] == 0) {
					isFull = false;
					break B;
				}
			}
		}
		
		if(isFull) {
			paper[N]++;
			for(int i=x; i<x+N; i++) {
				for(int j=y; j<y+N; j++) {
					if (i < 10 && j < 10) {
						map[i][j] = 0;
					}
				}
			}
		} 
	}

}
