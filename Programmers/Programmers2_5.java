import java.util.Stack;

public class Programmers2_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "()(((()())(())()))(())";
		solution(s);
	}
	
    public static int solution(String arrangement) {
        int answer = 0;
        
        Stack<String> stk = new Stack<>();
        
        for(int i=0; i<arrangement.length(); i++) {
        	if(arrangement.charAt(i) == '(') {
        		if(arrangement.charAt(i+1) == ')') {
        			answer += stk.size();
        			i++;
        		} else {
        			stk.push(arrangement).charAt(i);
        		}
        	} else {
        		stk.pop();
        		answer++;
        	}
        }
        
        //System.out.println(answer);
        return answer;
    }
}
