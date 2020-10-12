package D3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class D3_암호생성기 {

	public static void main(String[] args) {
		int tc = 10;
		Scanner sc = new Scanner(System.in);
		for(int test=1; test<=tc; test++) {
			sc.nextInt();
			Queue<Integer> q = new LinkedList<>();
			for(int i=0; i<8; i++) {
				q.add(sc.nextInt());
			}
			boolean find = false;
			do {
				for(int i=1; i<=5; i++) {
					int num = q.peek()-i;
					q.poll();
					if(num<=0) {
						q.add(0);
						find = true;
						break;
					}else {
						q.add(num);
					}
				}
			} while(!find);
			
			System.out.print("#"+test+" ");
			while(!q.isEmpty()) {
				System.out.print(q.poll()+" ");
			}
			System.out.println();
		}

	}

}
