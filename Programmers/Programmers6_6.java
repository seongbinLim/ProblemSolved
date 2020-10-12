import java.util.ArrayList;
import java.util.Collections;


public class Programmers6_6 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] r = {{-20,15},{-14,-5},{-18,-13},{-5,-3}};
		int[][] r2 = {{-2,-1}, {1,2}, {-3,0}};
		int[][] r3 = {{0,1},{0,1},{1,2}};
		int[][] r4 = {{0,0}};
		solution(r2);
	}
    public static int solution(int[][] routes) {
        int answer = 0;
        
        ArrayList<Point> p = new ArrayList<>();
        
        for(int i=0; i<routes.length; i++) {
        	p.add(new Point(routes[i][0], routes[i][1]));
        }
        
        Collections.sort(p);
        
        Point tmp = p.get(0);
        
        for(int i=0; i<p.size(); i++) {
        	Point current = p.get(i);
        	if(tmp.out > current.out) {
        		tmp = current;
        	} else if(tmp.out < current.in) {
        		answer++;
        		tmp = current;
        	}
        }
                
        return answer;
    }
    
	public static class Point implements Comparable<Point>{
		public int in;
		public int out;
		
		public Point(int in, int out) {
			this.in = in;
			this.out = out;
		}
		
        @Override
        public int compareTo(Point r) {
            if (this.in > r.in) return 1;
            else if (r.in == this.in) return 0;
            else return -1;
        }
	}

}