package done;

public class BackJoon16985_2 {
	static int[][][] map;
	public static void main(String[] args) {

	}

	static void dfs(int idx) {
		if(idx == 5) {
			return;
		}		
		for(int i=0; i<4; i++) {
			rotate(idx);
			dfs(idx+1);
		}
	}
	static void rotate(int height) {
		int[][] tmp = new int[5][5];		
		for(int x=0; x<5; x++) {
			for(int y=0; y<5; y++) {
				tmp[y][4-x] = map[height][x][y];	
			}
		}
		map[height] = tmp;	
	}
	
	

}
