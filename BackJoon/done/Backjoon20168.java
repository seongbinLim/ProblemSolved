package newVersion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Backjoon20168 {
	public static class Position {
		int index, money, sMoney;
		public Position(int index, int money, int sMoney) {
			this.index = index;
			this.money = money;
			this.sMoney = sMoney;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //교차로의 개수
		int M = sc.nextInt(); //골목의 개수
		int A = sc.nextInt()-1; //시작 교차로 번호
		int B = sc.nextInt()-1; //도착 교차로 번호
		int C = sc.nextInt(); //가진 돈
		
		boolean[] v = new boolean[N];
		ArrayList<Position>[] list = new ArrayList[N];
		for(int i=0; i<N; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i=0; i<M; i++) {
			int s = sc.nextInt()-1;
			int e = sc.nextInt()-1;
			int m = sc.nextInt();
			list[s].add(new Position(e, m, 0));
			list[e].add(new Position(s, m, 0));
		}
		int suchisim = Integer.MAX_VALUE;
		
		Queue<Position> q = new LinkedList<>();
		q.add(new Position(A, C, 0));
		v[A] = true;
		while(!q.isEmpty()) {
			Position current = q.poll();
			for(int i=0; i<list[current.index].size(); i++) {
				Position next = list[current.index].get(i);
				if(current.money-next.money>=0 && !v[next.index]) {
					if(next.index==B) {
						if(current.index==A) suchisim = next.money;
						else suchisim = Math.min(suchisim, current.sMoney);
						continue;
					}
					int sm = Math.max(current.sMoney, next.money);
					q.add(new Position(next.index, current.money-next.money, sm));
					v[next.index] = true;
				}
			}
		}
		
		if(suchisim==Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(suchisim);
	}

}
