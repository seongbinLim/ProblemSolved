import java.util.Arrays;
import java.util.Stack;

public class Programmers6_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] a = {2,4};
		//int[] b= {1,3,5};
		//int[] a = {2,4};
		//int[] b = {3};
		int[] a = {2,3,4};
		int[] b = {1,2,3,6};
		solution(7, a, b);
	}
    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        Stack<Integer> stk = new Stack<>();

        for(int key : reserve) {
        	stk.add(key);
        }
        
        for(int i=0; i<lost.length; i++) {
        	for(int j=0; j<stk.size(); j++) {
        		if(stk.get(j) == lost[i]) {
        			lost[i] = -1;
        			stk.remove(j);
        			answer++;
        		}
        	}
        }
        
        for(int i=0; i<lost.length; i++) {
        	if(stk.isEmpty())
        		break;
        	for(int j=0; j<stk.size(); j++) {
        		if(stk.get(j) == lost[i]+1 || stk.get(j) == lost[i]-1) {
        			//System.out.println("lost[j] : " + lost[i] + " reserve[i] : " + stk.get(j) );
        			stk.remove(j);
        			answer++;
        			break;
        		}
        	}
        	//System.out.println(lost[i] + ", " +stk.get(0) );
        }
        //System.out.println(answer);
        return answer;
    }
}
