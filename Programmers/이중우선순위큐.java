import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

public class 이중우선순위큐 {

	public static void main(String[] args) {
		//String[] s = {"I 16","D 1"};
		String[] s = {"I 7", "I -5", "I 5", "D -1"};
		solution(s);

	}
	
    public static int[] solution(String[] operations) {
        int[] answer = new int[2];
        Deque<Integer> pq = new LinkedList<Integer>();
        
        for(int i=0; i<operations.length; i++) {
        	Deque<Integer> newDq = new LinkedList<Integer>();
        	//System.out.println(pq.toString());
        	char oper = operations[i].charAt(0);
        	int value = Integer.parseInt(operations[i].substring(2));
        	if(oper == 'I') {
        		while(!pq.isEmpty() && pq.peek()>value) {
        			newDq.add(pq.poll());
        		}
        		newDq.add(value);
        		while(!pq.isEmpty()) {
        			newDq.add(pq.poll());
        		}
        		pq = newDq;
        		
        	} else if(oper == 'D'){
        		if(value == 1) {
        			pq.pollFirst();
        		} else {
        			pq.pollLast();
        		}
        	}
        	
        }
        
        if(pq.size()>0) {
        	answer[0] = pq.getFirst();
        	answer[1] = pq.getLast();
        }
        
        //System.out.println(Arrays.toString(answer));
        return answer;
    }
}
