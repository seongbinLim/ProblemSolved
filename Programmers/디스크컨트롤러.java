import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class 디스크컨트롤러 {
	static class Job implements Comparable<Job>{
		int time, arrival;
		
		public Job(int time, int arrival) {
			this.time = time;
			this.arrival = arrival;
		}
		
		@Override
		public int compareTo(Job o) {
			return this.time - o.time;
		}		
	}
	public static void main(String[] args) {
		디스크컨트롤러 s = new 디스크컨트롤러();
		//int[][] jobs = {{0,3},{2,6},{1,9}};
		//int[][] jobs = {{0,4},{0,3},{0,2},{0,1}};
		//int[][] jobs = {{0, 9}, {1, 1}, {1, 1}, {1, 1}, {1, 1}};
		//int[][] jobs = {{0,1},{0,1},{1,0}};
		//int[][] j = {{0,10},{2,10},{25,10},{25,2}};
		//int[][] j = {{0,9},{0,4},{0,5},{0,7},{0,3}};
		//int[][] j = {{0,3},{4,3},{10,3}};
		//int[][] j = {{0,10},{2,3},{9,3}};
		//int[][] j = {{1,2},{3,2}};
		int[][] j = {{0,20},{3,4},{3,5},{17,2}};
		s.solution(j);

	}
    public int solution(int[][] jobs) {
        int answer = 0;
        //jobs의 들어온 순서대로 정렬한다.
        Arrays.sort(jobs, (o1,o2) -> {
        	if(o1[0]==o2[0])
        		return Integer.compare(o1[1], o2[1]);
        	return Integer.compare(o1[0], o2[0]);
        });
        
        Queue<Job> q = new LinkedList<>();
        for(int i=0; i<jobs.length; i++) {
        	q.add(new Job(jobs[i][1], jobs[i][0]));
        }

        int time = 0;
        PriorityQueue<Job> pq = new PriorityQueue<>();
        while(!(q.isEmpty() && pq.isEmpty())) {
        	while(!q.isEmpty() && q.peek().arrival<=time) { 
        		pq.add(q.poll());
        	}
        	System.out.println(pq.toString());
        	if(!pq.isEmpty()) {
        		Job current = pq.poll();
        		for(int i=time; i<time+current.time; i++) {
        			while(!q.isEmpty() && q.peek().arrival<=i) {
        				pq.add(q.poll());
        			}
        			answer = answer + pq.size() + 1;
        		}
        		time = time + current.time;
        	} else {
        		time++;
        	}  	
        } 

        return answer/jobs.length;
    }
}
