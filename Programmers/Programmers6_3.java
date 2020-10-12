public class Programmers6_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution("4177252841",4);
	}
	
    public static String solution(String number, int k) {
        String answer = "";
        int[] data = new int[number.length()];
        
        for(int i=0; i<number.length(); i++) {
        	data[i] = number.charAt(i)-48;
        }
        
        int count = data.length-k;
    	int max = data[0];
    	int idx = 0, lastIdx = data.length-1, startIdx = 0;

    	StringBuilder sb = new StringBuilder();
    	
        while(count > 0) {
        	for(int i=startIdx; i<=lastIdx; i++) {
        		if(max < data[i]) {
        			max = data[i];
        			idx = i;
        			if(max == 9)
        				break;
        		}
        	} 
        
        	if(data.length-idx >= count) {
        		//answer += data[idx];
        		sb.append(data[idx]);
        		if(idx < data.length-1) {
        			startIdx = idx+1;
        			max = data[idx+1];
        			lastIdx = data.length-1;
        			idx++;
        		}
        		count--;
        	} else {
        		lastIdx = idx-1;
        		max = data[startIdx];
        		idx = startIdx;
        	}
        }
        
        //System.out.println(sb);
        answer = sb.toString();
        
        return answer;
    }

}
