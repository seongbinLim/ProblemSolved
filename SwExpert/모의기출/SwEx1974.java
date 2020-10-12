package 모의기출;
import java.util.Arrays;
import java.util.Scanner;

public class SwEx1974 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int test=1; test<=tc; test++) {
			int[][] sudoku = new int[9][9];
			
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
					sudoku[i][j] = sc.nextInt();
				}
			}
			boolean flag = true;
			boolean sFlag = true;
			
			boolean[] checkX = new boolean[10];
			boolean[] checkY = new boolean[10];
			boolean[] checkS = new boolean[10];
					
			int[] dx = {0,-1,-1,0,1,1,1,0,-1};
			int[] dy = {0,0,1,1,1,0,-1,-1,-1};
			
			A:
			for(int m=1; m<8; m=m+3) {
				for(int n=1;n<8; n=n+3) {
					for(int k=0; k<9; k++) {
						checkS[sudoku[m+dx[k]][n+dy[k]]] = true;
					}
					
					for(int k=1; k<10; k++) {
						if(!checkS[k]) {
							sFlag = false;
							break A;
						}
					}			
					Arrays.fill(checkX, false);				
				}
			}
			
			
			B:
			for(int i=0; i<9; i++) {			
				for(int j=0; j<9; j++) {
					checkX[sudoku[j][i]] = true;
					checkY[sudoku[i][j]] = true;
				}

				//System.out.println("----------------------");
				//System.out.println(Arrays.toString(checkS));
				
				for(int k=1; k<10; k++) {
					if(!checkX[k] || !checkY[k]) {
						flag = false;
						break B;
					}
				}				
				Arrays.fill(checkX, false);
				Arrays.fill(checkY, false);				
			}
			if(flag && sFlag) {
				System.out.println("#" + test + " " + 1);
			} else {
				System.out.println("#" + test + " " + 0);
			}
		}

	}

}
