package done;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class BackJoon1941 {
	static class Point {
		int x, y, c;
		int yNum;
		String alph;
		public Point(int x, int y, int c, int yNum, String alph) {
			this.x = x;
			this.y = y;
			this.c = c;
			this.yNum = yNum;
			this.alph = alph;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[][] map = new char[5][5];
		char[][] number = new char[5][5];
		char idx = 'A';
		for (int i = 0; i < 5; i++) {
			map[i] = sc.nextLine().toCharArray();
			for(int j=0; j<5; j++) {
				number[i][j] = idx++;
			}
		}
		for(int i=0; i<5; i++)
			System.out.println(Arrays.toString(number[i]));
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, 1, 0, -1 };
		
		
		Set<String> set = new HashSet<>();
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (map[i][j] == 'S') {
					boolean[][] v = new boolean[5][5];
					Queue<Point> q = new LinkedList<>();
					q.add(new Point(i, j, 1, 0, number[i][j]+""));
					v[i][j] = true;
					while (!q.isEmpty()) {
						Point p = q.poll();
						if(p.c==7) {
							char[] sort = p.alph.toCharArray();
							Arrays.sort(sort);
							System.out.println(Arrays.toString(sort));
							set.add(Arrays.toString(sort));
							break;
						}
						for (int k = 0; k < 4; k++) {
							int nx = p.x + dx[k];
							int ny = p.y + dy[k];
							if (nx > -1 && ny > -1 && nx < 5 && ny < 5 && !v[nx][ny] && p.c<7) {
								if(map[nx][ny]=='Y' && p.yNum<3) {
									v[nx][ny] = true;
									q.add(new Point(nx, ny, p.c+1, p.yNum+1, p.alph+number[nx][ny]));
								} else if(map[nx][ny]=='S'){
									v[nx][ny] = true;
									q.add(new Point(nx, ny, p.c+1, p.yNum, p.alph+number[nx][ny]));
								}
							}
						}
					}
					
				}
			}
		}
		System.out.println(set.size());

	}

}
