package D4;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class D4_행렬찾기 {
	static class Pos implements Comparable<Pos> {
		int x;
		int y;
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	    @Override
	    public int compareTo(Pos s) {
	        if (this.x * this.y < s.x * s.y) {
	            return -1;
	        } else if (this.x * this.y > s.x * s.y) {
	            return 1;
	        } else {
	        	if(this.x < s.x) return -1;
	        	else {
	        		return 1;
	        	}
	        }
	    }
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int t=1; t<=tc; t++) {
			int N = sc.nextInt();
			
			int[][] map = new int[N][N];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			boolean[][] v = new boolean[N][N];
			ArrayList<Pos> list = new ArrayList<>();
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j] != 0 && !v[i][j]) {
						
						int newX = i;
						int newY = j;
						while(newY < N && map[newX][newY]!= 0) {
							newY++;
						}
						while(newX < N && map[newX][newY-1]!= 0) {
							newX++;
						}
						for(int m=i; m<newX; m++) {
							for(int n=j; n<newY; n++) {
								v[m][n] = true;
							}
						}
						list.add(new Pos(newX-i, newY-j));
					}
				}
			}
			
			Collections.sort(list);
			
			System.out.print("#"+t+" "+list.size());
			for(int i=0; i<list.size(); i++) {
				System.out.print(" " + list.get(i).x + " "+ list.get(i).y);
			}
			System.out.println();
		}

	}

}
