package 모의기출;
import java.util.Scanner;

public class SSAFY_lader {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] result = new int[10];
		
		for(int testcase = 1; testcase<=10; testcase++) {
			sc.nextInt();

			int row = 100, col = 100;
			int[][] arr = new int[row][col];
			
			int curX = -1;
			int curY = -1;
			
			for(int i=0; i<row; i++) {
				for(int j=0; j<col; j++) {
					arr[i][j] = sc.nextInt();
					if(i==(row-1) && arr[i][j] == 2) {
						curX = i;
						curY = j;
					}
				}
			}

			int prvX = -1;
			int prvY = -1;
			
			// x�� --�� ����, y�� �޿� �Ѵ� ����
			int[] dx = { 0, 0, -1 };
			int[] dy = { 1, -1, 0 };
			while (curX != 0) {
				for (int i = 0; i < dx.length; i++) {
					int newX = curX + dx[i];
					int newY = curY + dy[i];
					if (newY < col && newY > -1 && (newY != prvY || newX != prvX) && arr[newX][newY] == 1) {
						//System.out.println(newX + ", " + newY + " cur : " + curX + ", " + curY + " prv : " + prvX + ", " + prvY);
						prvX = curX;
						prvY = curY;
						curX = newX;
						curY = newY;
						break;
					}
				}
			}
			result[testcase-1] = curY;

		}
		
		for(int i=0; i<result.length; i++)
			System.out.println("#"+(i+1) + " " + result[i]);
	}
 
}
