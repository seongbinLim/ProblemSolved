package done;
import java.util.Scanner;

public class BackJoon2669 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] map = new int[101][101];
		for(int i=0; i<4; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			
			for(int r=y1; r<y2; r++) {
				for(int c=x1; c<x2; c++) {
					map[r][c]++;
				}
			}
		}
		
		int size = 0;
		for(int i=0; i<101; i++) {
			for(int j=0; j<101; j++) {
				if(map[i][j] > 0) size++;
			}
		}
		
		System.out.println(size);

	}

}
