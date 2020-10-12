import java.util.Stack;

public class Programmers2_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] p = {1,2,3,2,3};
		//int[] p = {2,3,4,5,6};
		//int[] p ={2,3,4,5,4};
		//int[] p = {2,3,4,5,1};
		//int[] p = {5,4,3,5,6,5};
		solution(p);
	}
	
    public static int[] solution(int[] prices) {
        int[] answer = {};
        int endIdx = prices.length;
        
        answer = new int[endIdx];
        
        for(int i=0; i<endIdx; i++) {
        	for(int j=i+1; j<endIdx; j++) {
        		answer[i]++;
        		if(prices[i] > prices[j]) {
        			break;
        		}
        	}
        }
        
        answer[endIdx-1] = 0;

        return answer;
    }
    
    
    

}
