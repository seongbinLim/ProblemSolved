package done;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BackJoon14503 {
	static class Robot {
		int x;
		int y;
		int dir;

		public Robot(int x, int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] map = new int[N][M];

		int x = sc.nextInt();
		int y = sc.nextInt();
		int d = sc.nextInt();
		Robot robot = new Robot(x, y, d);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		int count = 1;
		// d : 0 �� , 1��, 2 ��, 3 ��
		Queue<Robot> q = new LinkedList<>();
		q.add(robot);
		map[robot.x][robot.y] = 2;
		
		while (!q.isEmpty()) {
			Robot r = q.poll();
			//count++;
			for (int i = 1; i <= 4; i++) {
				int newD = r.dir - i;
				if(newD < 0) newD += 4;
				int newX = r.x;
				int newY = r.y;
				
				if (newD == 0) {
					newX = r.x - 1;
				} else if (newD == 1) {
					newY = r.y + 1;
				} else if (newD == 2) {
					newX = r.x + 1;
				} else {
					newY = r.y - 1;
				}
				
				if (newX > -1 && newY > -1 && newX < N && newY < M && map[newX][newY] == 0) {
					q.add(new Robot(newX, newY, newD));
					map[newX][newY] = 2;
					count++;
					break;
				}
				if(i==4) {
					if (newD == 0) {
						newX = r.x + 1;
					} else if (newD == 1) {
						newY = r.y - 1;
					} else if (newD == 2) {
						newX = r.x - 1;
					} else {
						newY = r.y + 1;
					}
					if (newX > -1 && newY > -1 && newX < N && newY < M && map[newX][newY] == 2) {
						q.add(new Robot(newX, newY, newD));
					}
				}
			}
			
		}
		System.out.println(count);
	}

}
