import java.util.Arrays;


public class 섬연결하기 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] c = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};

		solution(4, c);
	}

    public static int solution(int n, int[][] costs) {
        int answer = 0;
        //크루스칼 알고리즘
        //비용이 적은 것부터 정렬한다.
        Arrays.sort(costs, (o1, o2) -> {
        	return o1[2]-o2[2];
        });
        
        int[] parent = new int[n]; //사이클 체크용
        for(int i=0; i<n; i++)
        	parent[i] = i;
        
        for(int[] cost : costs) {
        	int from = cost[0];
        	int to = cost[1];
        	int value = cost[2];
        	
        	//두 정점의 부모노드가 같으면 연결되어있음
        	if(connected(parent, from, to)) continue;
        	else {
        		//연결되어있지 않으면, 비용 계산해주고 부모 node update
        		answer += value;
        		union(parent, from, to);
        	}
        }
        
        return answer;
    }
    
    public static void union(int[] parent, int from , int to) {
    	from = getParent(parent, from);
    	to = getParent(parent, to);
    	
    	if(from < to)
    		parent[to] = from;
    	else
    		parent[from] = to;
    }
    
    public static int getParent(int[] parent, int idx) {
    	if(parent[idx] == idx) return idx;
    	else return getParent(parent, parent[idx]);
    }
    
    public static boolean connected(int[] parent, int from, int to) {
    	from = getParent(parent, from);
    	to = getParent(parent, to);
    	
    	return from == to;
    }


}
