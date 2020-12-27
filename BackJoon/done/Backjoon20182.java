package newVersion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Backjoon20182 {
	static class Vertax {
		int v;
		int m;
		public Vertax(int v, int m) {
			this.v = v;
			this.m = m;
		}
	}

	static class Vertax2 {
		int v;
		int m;
		int max;
		public Vertax2(int v, int m, int max) {
			this.v = v;
			this.m = m;
			this.max = max;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //교체로 개수
		int M = sc.nextInt(); //골목 개수
		int A = sc.nextInt()-1; //시작점
		int B = sc.nextInt()-1; //도착점
		int C = sc.nextInt(); //가진 돈
		
		ArrayList<Vertax>[] list = new ArrayList[N];
		
		for(int i=0; i<N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			int s = sc.nextInt()-1;
			int e = sc.nextInt()-1;
			int m = sc.nextInt();
			
			list[s].add(new Vertax(e,m));
			list[e].add(new Vertax(s,m));
		}
		
		int answer = Integer.MAX_VALUE;
		boolean[] v = new boolean[N];
		Queue<Vertax2> q = new LinkedList<>();
		q.add(new Vertax2(A, 0, 0));
		v[A] = true;
		while(!q.isEmpty()) {
			Vertax2 cur = q.poll();
			if(cur.v == B) {
				answer = Math.min(answer, cur.max);
			}
			
			for(int i=0; i<list[cur.v].size(); i++) {
				Vertax next = list[cur.v].get(i);
				if(!v[next.v] && cur.m+next.m<=C) {
					v[next.v] = true;
					int max = Math.max(cur.max, next.m);
					q.add(new Vertax2(next.v, cur.m+next.m, max));
				}
			}
		}
		
		if(answer == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(answer);
		
		
	}

}
