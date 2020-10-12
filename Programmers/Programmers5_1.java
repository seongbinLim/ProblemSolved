
public class Programmers5_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {4,4,4,5,1};
		solution(a);
	}
	
    public static int[] solution(int[] answers) {
        int[] answer = {};
        int[] a = {1,2,3,4,5};
        int[] b = {2,1,2,3,2,4,2,5};
        int[] c = {3,3,1,1,2,2,4,4,5,5};
        
        //int[] a = new int[5];
        //a[0] = 1; a[1] = 2; a[2] = 3; a[3] = 4; a[4] = 5;
        //int[] b = new int[8];
        //b[0] = 2; b[1] = 1; b[2] = 2; b[3] = 3; b[4] = 2; b[5] = 4;b[6] = 2; b[7] = 5;
        //int[] c = new int[10];
        //c[0] = 3; c[1] = 3; c[2] = 1; c[3] = 1; c[4] = 2; c[5] = 2; c[6] = 4; c[7] = 4; c[8] = 5; c[9] = 5;
        
        int length = answers.length;
        int aScore = 0;
        int bScore = 0;
        int cScore = 0;
        
        for(int i=0; i<length; i++) {
        	if(answers[i] == a[i%5])
        		aScore++;
        	if(answers[i] == b[i%8])
        		bScore++;
        	if(answers[i] == c[i%10])
        		cScore++;	
        }
        
        if(aScore > bScore) {
        	if(aScore > cScore) {
        		answer = new int[1];
        		answer[0] = 1;
        	} else if(aScore < cScore) {
        		answer = new int[1];
        		answer[0] = 3;
        	} else {
        		answer = new int[2];
        		answer[0] = 1; answer[1] = 3;
        	}
        } else if(aScore < bScore){
        	if(bScore > cScore) {
        		answer = new int[1];
        		answer[0] = 2;
        	} else if(bScore < cScore) {
        		answer = new int[1];
        		answer[0] = 3;
        	} else {
        		answer = new int[2];
        		answer[0] = 2; answer[1] = 3;
        	}
        } else {
        	if(aScore > cScore) {
        		answer = new int[1];
        		answer[0] = 1;
        	} else if(aScore < cScore) {
        		answer = new int[2];
        		answer[0] = 1; answer[1] = 2;
        	} else {
        		answer = new int[3];
        		answer[0] = 1; answer[1] = 2; answer[2] = 3;
        	}
        }
        System.out.println(answer.length);
        return answer;
    }
    
}
