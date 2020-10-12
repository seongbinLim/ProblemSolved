package done;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BackJoon1753 {
	static class Edge implements Comparable<Edge>{
		int v, weight;
		public Edge(int v, int weight) {
			this.v = v;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
		@Override
		public String toString() {
			return weight + "";
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt()+1;
		int E = sc.nextInt();
		int S = sc.nextInt();
		List<Edge>[] adj = new ArrayList[V];
		for(int i = 0; i < V; i++)
			adj[i] = new ArrayList<>();
		
		for(int i = 0; i < E; i++)
			adj[sc.nextInt()].add(new Edge(sc.nextInt(), sc.nextInt()));
		
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		boolean[] check = new boolean[V];
		Edge[] D = new Edge[V];
		for(int i = 1; i < V; i++) {
			if( i == S ) {
				D[i] = new Edge(i,0);
			} else {
				D[i] = new Edge(i, Integer.MAX_VALUE);
			}
			pq.add(D[i]);
		}
		while( !pq.isEmpty() ) {
			Edge edge = pq.poll();
			
			if(edge.weight == Integer.MAX_VALUE) break;
			
			for( Edge next : adj[edge.v]) {
				if( !check[next.v]&& D[next.v].weight > D[edge.v].weight + next.weight ) {
					D[next.v].weight = D[edge.v].weight + next.weight;
					//decrease key
					pq.remove(D[next.v]);
					pq.add(D[next.v]);
				}
			}
			check[edge.v] = true;
		}
		
		for(int i = 1; i < V; i++) {
			if(D[i].weight == Integer.MAX_VALUE)
				System.out.println("INF");
			else System.out.println(D[i].weight);
		}
	}

}
