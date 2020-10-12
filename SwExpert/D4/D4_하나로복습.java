package D4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class D4_하나로복습 {
	static int N;
	static double E;
	
	static class Point implements Comparable<Point>{
		int x,y;
		long length;
		public Point() {}
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		public Point(int x, int y, long length) {
			this.x = x;
			this.y = y;
			this.length = length;
		}
		
        @Override
        public int compareTo(Point o) {
            return Long.compare(length, o.length);
        }
	}
	
	static Point[] arr;
	static int[] parents, rank;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			N = sc.nextInt();
			arr = new Point[N];
			parents = new int[N];
            rank = new int[N];
            
			for(int i=0; i<N; i++) {
				arr[i] = new Point();
				arr[i].x = sc.nextInt();
			}
			for(int i=0; i<N; i++) {
				arr[i].y = sc.nextInt();
			}
			
			E = sc.nextDouble();
			
			List<Point> list = new ArrayList<Point>();
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					list.add(new Point(i, j, distance(arr[i].x, arr[i].y, arr[j].x, arr[j].y)));
				}
			}
			
			Collections.sort(list);

            for (int i = 0; i < N; i++) {
                makeSet(i);
            }
 
            long dist = 0;
            for (Point p : list) {
                if (findSet(p.x) == findSet(p.y)) {
                    continue;
                } else {
                    union(p.x, p.y);
                    dist += p.length;
                }
            }
 
            System.out.println("#" + t + " " + Math.round(dist * E));
			
		}
	}
	
	static long distance(int x1, int y1, int x2, int y2) {
		return (long) (Math.pow(Math.abs(x1-x2), 2) + Math.pow(Math.abs(y1-y2), 2));
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

}
