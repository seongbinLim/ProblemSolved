package D4;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class D4_방향전환 {
	static class Pos {
		int x, y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			Pos start = new Pos(x, y);

			x = sc.nextInt();
			y = sc.nextInt();

			Pos end = new Pos(x, y);
			
			Queue<Pos> q = new LinkedList<>();
			q.add(start);
			while(!q.isEmpty()) {
				
			}
			
		}
	}
	
	

}
