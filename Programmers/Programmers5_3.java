import java.util.Stack;

public class Programmers5_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a = {{123,1,1}, {356,1,0}, {327,2,0}, {489,0,1}};
		
		solution(a);
	}

    public static int solution(int[][] baseball) {
    	Stack<String> stack = new Stack<>();
    	for(int i=1; i<10; i++) {
    		for(int j=1; j<10; j++) {
    			for(int k=1; k<10; k++) {
    				if(i != j && i != k && j != k) {
    					stack.add(String.valueOf(i*100 + j*10 + k));
    				}
    			}
    		}
    	}
    	
    	Stack<String> temp = new Stack<>();
    	boolean flag = true;
    	while(!stack.isEmpty()) {
    		String num = stack.pop();
    		for(int i=0; i<baseball.length && flag; i++) {
    			int strike = strike(num, String.valueOf(baseball[i][0]));
    			int ball = ball(num, String.valueOf(baseball[i][0])) - strike;
    			
    			if(strike != baseball[i][1] || ball != baseball[i][2]) {
    				flag = false;
    			}
    		}
			if(flag)
				temp.add(num);
			flag = true;
    	}
		return temp.size();
    }
    
    public static int strike(String num , String target) {
    	int cnt = 0;
    	for(int i=0; i<target.length(); i++) {
    		cnt = num.charAt(i) == target.charAt(i) ? cnt + 1 : cnt;
    	}
    	return cnt;
    }
    public static int ball(String num, String target) {
    	int cnt = 0;
    	for(int i=0; i<target.length(); i++) {
    		cnt = num.contains(String.valueOf(target.charAt(i))) ? cnt + 1 : cnt;
    	}
    	return cnt;
    }
}
