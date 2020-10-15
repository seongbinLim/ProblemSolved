import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Programmers_더맵게 {

	public static void main(String[] args) {
		int[] s = {1,2,3,9,10,12};
		solution(s, 7);

	}
    public static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<scoville.length; i++) {
            pq.add(scoville[i]);
        }
        
        while(pq.peek() < K && pq.size()>1) {
        	answer++;
        	int first = pq.poll();
        	int second = pq.poll();
        	
        	pq.add(first + second*2);
        }
        
        if(pq.size()==1 && pq.poll()<K)
        	return -1;
        
        return answer;
    }
}
