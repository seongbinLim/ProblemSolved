package D3;
import java.util.Scanner;

public class D3_농작물수확하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		for(int test=1; test<=tc; test++) {
			int N = sc.nextInt();
			int[][] map = new int[N][N];
			
			for(int i=0; i<N; i++) {
				String input = sc.next();
				for(int j=0; j<N; j++) {
					map[i][j] = Character.getNumericValue(input.charAt(j));
				}
			}
			
			int mid = N/2;
			int count = 0;
			for(int i=0; i<=mid; i++) {
				for(int j=mid-i; j<=mid+i; j++) {
					count += map[i][j];
				}
			}
			for(int i = 0; i<mid; i++) {
				for(int j=mid-i; j<=mid+i; j++) {
					count += map[N-i-1][j];
				}
			}
			
			System.out.println("#"+test+" " + count);
			
		}

	}

}
