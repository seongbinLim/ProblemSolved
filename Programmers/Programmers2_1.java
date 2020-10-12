
public class Programmers2_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] a = {6,9,5,7,4};
		//int[] a= {3,9,9,3,5,7,2};
		int[] a = {1,5,3,6,7,6,5};
		solution(a);
	}
	
    public static int[] solution(int[] heights) {
        int[] answer = new int[heights.length];
        int[] answer2 = new int[heights.length];
        int index = 0;
        
        int lastIdx = heights.length-1;
        
        for(int i=0; i<heights.length; i++) {
            int idx = lastIdx-1;
        	int sendLength = heights[lastIdx];
        	
        	while(idx > -1) {
        		if(sendLength < heights[idx]) {
        			//System.out.println("check " + heights[idx] + " idx " + idx);
        			break;
        		}
        		idx--;
        	}
        	if(idx != -1) {
        		answer2[index] = idx+1;
        	}
    		lastIdx--;
    		index++;
        }

        //for(int i=0; i<answer2.length; i++) {
        //	System.out.print(answer2[i] + " ");
        //}
        //System.out.println();
        for(int i=answer2.length-1; i>=0; i--) {
        	answer[i] = answer2[answer2.length-i-1];
        	//System.out.print(answer[i] + " ");
        }
        return answer;
    }
}
