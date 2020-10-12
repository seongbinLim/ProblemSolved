package done;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BackJoon1197 {
	public static void main(String[] args) {
		byKruskal();
		//byPrim();
	}
	
	static class Edge implements Comparable<Edge>{
		int x,y;
		int w;
		public Edge(int x, int y, int w) {
			this.x = x;
			this.y = y;
			this.w = w;
		}
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(w, o.w);
		}
	}
	static int[] parents, rank;
	static void byKruskal() {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt()+1;
		int E = sc.nextInt();
		
		List<Edge> list = new ArrayList<>();
		parents = new int[V];
        rank = new int[V];
        
		for(int i=0; i<E; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			list.add(new Edge(a, b, c));
		}
		
		Collections.sort(list);
		
        for (int i = 1; i < V; i++) {
            makeSet(i);
        }

        long dist = 0;
        for (Edge e : list) {
            if (findSet(e.x) == findSet(e.y)) {
                continue;
            } else {
                union(e.x, e.y);
                dist += e.w;
            }
        }
        System.out.println(dist);
	}
    static void makeSet(int x) {
        parents[x] = x;
    }
 
    static int findSet(int x) {
        if (parents[x] == x)
            return x;
        else {
            parents[x] = findSet(parents[x]);
            return parents[x];
        }
    }
 
    static void union(int x, int y) {
        int px = findSet(x);
        int py = findSet(y);
 
        if (rank[px] > rank[py]) {
            parents[py] = px;
        } else {
            parents[px] = py;
            if (rank[px] == rank[py])
                rank[py]++;
        }
    }
	
	/*프림용 간선정보*/
	
	static class EdgePrim implements Comparable<Edge>{
		int adj;
		int w;
		public EdgePrim(int adj, int w) {
			this.adj = adj;
			this.w = w;
		}
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(w, o.w);
		}
	}
	
	static void byPrim() {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt()+1;
		int E = sc.nextInt();
		
		List<EdgePrim>[] list = new ArrayList[V];
		for(int i=1; i<V; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<E; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			list[a].add(new EdgePrim(b, c));
			list[b].add(new EdgePrim(a, c));
			
		}
		
		boolean[] check = new boolean[V];
		int[] key = new int[V];
		
		Arrays.fill(key, Integer.MAX_VALUE);
		
		key[1] = 0;
		
		for(int i=1; i<V-1; i++) {
			int min = Integer.MAX_VALUE;

			int index = -1;
			for(int j=1; j<V; j++) {
				if( !check[j] && key[j] < min ) {
					index = j;
					min = key[j];
				}
			}
			//System.out.println(index);
			check[index] = true;
			for(int j=0; j<list[index].size(); j++) {
				int curAdj = list[index].get(j).adj;
				if( !check[curAdj] && key[curAdj] > list[index].get(j).w) {
					key[curAdj] = list[index].get(j).w;
				}
			}
			//System.out.println(Arrays.toString(key));
		}
		
		int result = 0;
		for(int i=1; i<V; i++) {
			result += key[i];
		}
		System.out.println(result);		
	}
}
