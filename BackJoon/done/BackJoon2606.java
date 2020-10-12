package done;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BackJoon2606 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt()+1;
		int M = sc.nextInt();
		
		ArrayList<Integer>[] list = new ArrayList[N];
		boolean[] v = new boolean[N];
		for(int i=1; i<N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			list[a].add(b);
			list[b].add(a);
		}
		
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		v[1] = true;
		int count = 0;
		while(!q.isEmpty()) {
			int p = q.poll();
			count++;
			for(int i=0; i<list[p].size(); i++) {
				if(!v[list[p].get(i)]) {
					q.add(list[p].get(i));
					v[list[p].get(i)] = true;
				}
			}
		}

		System.out.println(count-1);
	}

}
