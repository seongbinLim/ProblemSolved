package done;

public class BackJoon16985 {
	
	public static void main(String[] args) {
		

	}
	
	//4 x 4 x 4 x 4 x 4 (�� ����� ���� ����)
	static void rotate(int[][] map) {
		int[][][] rotatedMap = new int[4][5][5];
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				rotatedMap[0][i][j] = map[i][j];
				rotatedMap[1][i][j] = map[j][5-i];
			}
		}
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				rotatedMap[2][i][j] = rotatedMap[1][j][5-i];
			}
		}
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				rotatedMap[3][i][j] = rotatedMap[2][j][5-i];
			}
		}
	}
	
	//������ 8���� ���������� ���鼭 ���� ���� ���� ã�´�.
	static void go(int start) {
		int[] dx = {1,-1,0,0,0,0};
		int[] dy = {0,0,1,-1,0,0};
		int[] dz = {0,0,0,0,1,-1};
		
		
	}

}
