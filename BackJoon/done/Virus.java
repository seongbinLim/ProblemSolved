package done;
import java.util.Arrays;
import java.util.Scanner;

public class Virus {
	static int[] dx = { 1, -1, 0, 0, 0, 0 };
	static int[] dy = { 0, 0, -1, 1, 0, 0 };
	static int[] dz = { 0, 0, 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int H = sc.nextInt();

		int[][][] map = new int[M][N][H];
		boolean[][][] check = new boolean[M][N][H];
		for (int k = 0; k < H; k++) {
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j][k] = sc.nextInt();
				}
			}
		}

		
		int total = M + N + H - 3;
		int count = 0;
		int count2 = 0;
		for (int start = 0; start < total; start++) {
			boolean find = false;

			for (int k = 0; k < H; k++) {
				for (int i = 0; i < M; i++) {
					for (int j = 0; j < N; j++) {
						check[i][j][k] = false;
						if(map[i][j][k] == 0) {
							find = true;
							//System.out.println("start : " + start +"/ " + i + " " + j + " " + k);
						}		
					}
				}
			}
			
			if(!find) {
				count2 = start;
				break;
			}
			for (int k = 0; k < H; k++) {
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
						if (map[i][j][k] == 1 && !check[i][j][k]) {
							//System.out.println("inject : " + i + ", " +j + ", " + k);
							int newX = i;
							int newY = j;
							int newZ = k;

							for (int l = 0; l < 6; l++) {
								newX = i+dx[l];
								newY = j + dy[l];
								newZ = k + dz[l];

								if (newX > -1 && newY > -1 && newZ > -1 && newX < M && newY < N && newZ < H
										&& map[newX][newY][newZ] == 0) {
									map[newX][newY][newZ] = 1;
									check[newX][newY][newZ] = true;
									//System.out.println(newX + ", " +newY + ", " + newZ);
								} else {
									//System.out.println("N : " + newX + ", " +newY + ", " + newZ);
								}
							}
						}
					}
				}
			}
		}

		boolean has = false;
		B: for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < H; k++) {
					if (map[i][j][k] == 0) {
						System.out.println("-1");
						//System.out.println(i+ "," + j + "," + k);
						has = true;
						break B;
					}
				}
			}
		}

		if (!has)
			System.out.println(count2);
			
	}

}
