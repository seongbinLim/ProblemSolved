package 모의기출;
import java.util.Scanner;

public class SwEx2005 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int test=1; test<=tc; test++) {
			int N = sc.nextInt();
			int[][] pascal = new int[N][N];
			
			pascal[0][0] = 1;
			for(int i=1; i<N; i++) {
				pascal[i][0] = 1;
				for(int j=1; j<i+1; j++) {
					if(pascal[i-1][j] == 0) {
						pascal[i][j] = 1;
					} else {
						pascal[i][j] = pascal[i-1][j-1] + pascal[i-1][j];
					}
				}
			}
			
			System.out.println("#" + test);
			for(int i=0; i<N; i++) {
				for(int j=0; j<=i; j++) {
					System.out.print(pascal[i][j] + " ");
				}
				System.out.println();
			}
		}

	}

}
