import java.util.ArrayList;

public class Programmers6_5 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a = {{0,1,1}, {0,2,2}, {1,2,5}, {1,3,1}, {2,3,8}};
		int[][] b = {{0,1,5}, {1,2,3}, {2,3,3}, {3,1,2},{3,0,4}}; //return 9
		int[][] c = {{0,1,1}, {0,2,2}, {2,3,1}};
		solution(4, c);
	}
    public static int solution(int n, int[][] costs) {
        int answer = 0;
        int[][] adj = new int[n][n];
        
        for(int i=0; i<costs.length; i++) {
        	adj[costs[i][0]][costs[i][1]] = adj[costs[i][1]][costs[i][0]] = costs[i][2];
        }
        
        boolean[] visit = new boolean[n];
        
        ArrayList<Integer> connect = new ArrayList<>();
        
        connect.add(0);
        
        while(connect.size() < n) {
        	int min = Integer.MAX_VALUE;
        	int minIdx = -1;
        	
        	for(int i=0; i<connect.size(); i++) {
        		int idx = connect.get(i);
        		for(int j=0; j<n; j++) {
        			if(!visit[j] && idx != j && adj[idx][j] > 0 && adj[idx][j] < min ) {
        				min = adj[idx][j];
        				minIdx = j;
        			}
        		}
        	}
        	visit[minIdx] = true;
        	connect.add(minIdx);
        	answer += min;
        }
        
        return answer;
    }
    

}
