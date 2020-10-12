
public class Programmers2_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int b = 2;
		//int w = 10;
		//int[] t = {7,4,5,6};

		//int b = 100;
		//int w = 100;
		//int[] t = {10};
		
		int b = 100;
		int w = 100;
		int[] t = {10,10,10,10,10,10,10,10,10,10};
		solution(b,w,t);
	}
	
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 2;
        int lastTruck = truck_weights.length-1;
        
        int[] length = new int[truck_weights.length];  
        int curW = truck_weights[0];
        int inIdx = 0;
        int lastIdx = 1;
        length[inIdx]++;
        
        while(length[lastTruck] != bridge_length) {
        	if(lastIdx <= lastTruck) {
        		if(weight >= curW + truck_weights[lastIdx]) {
        			//System.out.println("다리 무게 넉넉스, in : " + truck_weights[lastIdx]);
        			curW = curW + truck_weights[lastIdx]; 
        			lastIdx++;
        		}
        	}
        	for(int i=inIdx; i<lastIdx; i++) {
        		length[i]++;
        	}
        	
        	if(length[inIdx] == bridge_length) {
        		//System.out.println("다리 통과 : " + truck_weights[inIdx]);
        		curW = curW - truck_weights[inIdx];
        		inIdx++;
        	}
        	answer++;       	
        }
        //System.out.println("Ans : " + answer);
        return answer;
    }
}
