package 모의기출;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class SwEx5653 {
	static class Cell implements Comparable<Cell> {
		int x, y;
		int life;
		int time;

		public Cell(int x, int y, int life, int time) {
			this.x = x;
			this.y = y;
			this.life = life;
			this.time = time;
		}

		
		@Override
		public String toString() {
			return "time : " + this.time + " life : " + this.life;
		}


		@Override
		public int compareTo(Cell cell) {
			if(this.time == cell.time) {
				return cell.life - this.life;
			}
			return this.time - cell.time;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();

		for (int t = 1; t <= tc; t++) {
			int N = sc.nextInt(); // 세로
			int M = sc.nextInt(); // 가로
			int K = sc.nextInt(); // 배양시간
			int[][] map = new int[702][702];
			int cX = 350;
			int cY = 350;
			PriorityQueue<Cell> pq = new PriorityQueue<>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					int life = sc.nextInt();
					map[cX + i][cY + j] = life;
					if (life != 0)
						pq.add(new Cell(cX + i, cY + j, life, life));
				}
			}
			
			for (int i = 0; i < K; i++) {

				PriorityQueue<Cell> list = new PriorityQueue<>();
				while(!pq.isEmpty()) {
					Cell c = pq.poll();
					if(c.time <= 0) {
						int[] dx = {1,0,-1,0};
						int[] dy = {0,-1,0,1};

						for(int dir=0; dir<4; dir++) {
							int nx = c.x + dx[dir];
							int ny = c.y + dy[dir];
							int life = c.life;
							
							if(map[nx][ny] == 0) {
								map[nx][ny] = life;
								list.add(new Cell(nx, ny, life, life));
							}
						}
						
						if( Math.abs(c.time-1) < c.life )
							list.add(new Cell(c.x, c.y, c.life, c.time-1));
						else
							map[c.x][c.y] = -1; 
						
						
					} else {
						list.add(new Cell(c.x, c.y, c.life, c.time-1));
					}
				}
				
				pq = list;
			}
			
			System.out.println("#" + t+ " " + pq.size());
		}

	}

}
