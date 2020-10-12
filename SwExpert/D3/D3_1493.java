package D3;
import java.util.Arrays;
import java.util.Scanner;

public class D3_1493 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();
		for (int test = 1; test <= tc; test++) {
			int p = sc.nextInt();
			int q = sc.nextInt();

			int[][] map = new int[320][320];
			int num = 1;
			int count = 1;

			map[1][1] = 1;

			while (num <= 50000) {
				//System.out.println(count);
				for (int i = 1; i <= count; i++) {
					map[i][count - i + 1] = num++;
				}
				count++;
			}
			
			
			int pX = 0, pY =0, qX = 0, qY = 0;
			
			for(int i=1; i<300; i++) {
				for(int j=1; j<300; j++) {
					if(map[i][j] == p) {
						pX = i;
						pY = j;
					}
					if(map[i][j] == q) {
						qX = i;
						qY = j;						
					}
				}
			}
			
			
			int newX = pX + qX;
			int newY = pY + qY;
			
			int ans = map[newX][newY];
			 
			System.out.println("#"+test+" " + ans);
		}
	}
}
