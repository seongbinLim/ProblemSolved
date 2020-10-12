
public class Programmers5_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution(10,2);
		solution(8,1);
		//solution(24,24);
	}
	
    public static int[] solution(int brown, int red) {
        int[] answer = new int[2];
        
        int total = brown + red;
        
        for(int i=1; i<=total; i++) {
        	if(total%i==0) {
        		int height = i;
        		int width = total/i;
        		
        		if(height <= width && red == (width-2) * (height-2)) {
        			answer[0] = width;
        			answer[1] = height;
        			break;
        		}
        		
        	}
        }
        
        return answer;
    }
}
