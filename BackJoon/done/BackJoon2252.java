package done;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BackJoon2252 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] num = new int[N+1];
		ArrayList<Integer>[] list = new ArrayList[N+1];
		for(int i=0; i<N+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			list[A].add(B);
			num[B]++;
		}
			
		Queue<Integer> q = new LinkedList<>();
		for(int i=1; i<N+1; i++) {
			if(num[i] == 0)
				q.add(i);
		
		}
		
		while(!q.isEmpty()) {
			int n = q.poll();
			System.out.print(n + " ");
			for(int i=0; i<list[n].size(); i++) {
				int next = list[n].get(i);
				num[next]--;
				if(num[next]==0)
					q.add(next);
			}
		}

	}

}
