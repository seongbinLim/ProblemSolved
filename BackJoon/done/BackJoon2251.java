package done;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BackJoon2251 {
	static class Water {
		int A, B, C;
		public Water(int a, int b, int c) {
			A = a;
			B = b;
			C = c;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		boolean[][][] v = new boolean[201][201][201];
		boolean[] num = new boolean[201];
		Queue<Water> q = new LinkedList<>();
		q.add(new Water(0,0,C));
		
		while(!q.isEmpty()) {
			Water cur = q.poll();
			
			if(!v[cur.A][cur.B][cur.C]) {
				
				v[cur.A][cur.B][cur.C] = true;
				
				if(cur.A == 0) num[cur.C] = true;
				
				//a->b
				if(cur.A+cur.B > B) q.add(new Water(cur.A+cur.B-B, B, cur.C));
				else q.add(new Water(0, cur.A+cur.B, cur.C));
				//a->c
				if(cur.A+cur.C > C) q.add(new Water(cur.A+cur.C-C, cur.B, C));
				else q.add(new Water(0, cur.B, cur.A + cur.C));				
				
				
				//b->a
				if(cur.A+cur.B > A) q.add(new Water(A, cur.A+cur.B-A, cur.C));
				else q.add(new Water(cur.A+cur.B, 0, cur.C));
				//b->c
				if(cur.B+cur.C > C) q.add(new Water(cur.A, cur.B+cur.C-C, C));
				else q.add(new Water(cur.A, 0, cur.B+cur.C));
				
				//c->a
				if(cur.A+cur.C > A) q.add(new Water(A, cur.B, cur.A+cur.C-A));
				else q.add(new Water(cur.A+cur.C, cur.B, 0));
				//c->b
				if(cur.B+cur.C > B) q.add(new Water(cur.A, B, cur.B+cur.C-B));
				else q.add(new Water(cur.A, cur.B+cur.C , 0));
			}
		}
		
		for(int i=1; i<201; i++) {
			if(num[i]) System.out.print(i + " ");
		}
	}
}
