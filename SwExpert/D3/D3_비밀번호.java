package D3;
import java.util.Scanner;
import java.util.Stack;

public class D3_비밀번호 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int test=1; test<=10; test++) {
			int N = sc.nextInt();
			Stack<Integer> stk = new Stack<>();
			String input = sc.next();
			for(int i=0; i<input.length(); i++) {
				int num = Character.getNumericValue(input.charAt(i));
				if(!stk.isEmpty() && stk.peek() == num) {
					stk.pop();
				} else {
					stk.push(num);
				}
			}
			String passwd = "";
			for(int i=0; i<stk.size(); i++) {
				passwd += stk.get(i);
			}
			
			System.out.println("#"+test+" " + passwd);
			
		}
	}
}
