package D4;
import java.util.Scanner;
import java.util.Stack;

public class D4_계산기2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1; tc<=10; tc++) {
			sc.nextInt();
			String str = sc.next();
			
			Stack<Character> stk = new Stack<>();
			StringBuilder sb = new StringBuilder();
			
			for(int i=0; i<str.length(); i++) {
				char c = str.charAt(i);
				if(Character.isDigit(c))
					sb.append(c);
					//System.out.print(c);
				else {
					if(c == '+' || c == '-') {
						while(!stk.isEmpty() && stk.peek() != '('  ) {
							sb.append(stk.pop());
							//System.out.print(stk.pop());
						}
						stk.push(c);
					}
					else if(c == '*' || c == '/') {
						while(!stk.isEmpty() && stk.peek() != '+' && stk.peek() != '-' && stk.peek() != '('  )
							sb.append(stk.pop());
							//System.out.print(stk.pop());
						stk.push(c);
					}
					else if(c == '(') {
						stk.push(c);
					}
	                else if( c == ')' ) {
	                    //�떕�옒愿꾪샇�뒗 �뿴由쇨큵�샇瑜� 留뚮궇�븣源뚯� �떎 爰쇰궡�꽌 異쒕젰�븯怨�, �뿴由쇨큵�샇 踰꾨┛�떎.
	                    while( true ) {
	                        char top = stk.pop();
	                        if( top != '(' )
	                            sb.append(top);
	                        else
	                            break;
	                    }
	                }
				}
			}
			
			while(!stk.isEmpty())
				sb.append(stk.pop());
			
			str = sb.toString();
			
	        Stack<Integer> stack = new Stack<>();
	        //�떇�쓣 �닚�쉶�븯硫댁꽌(臾몄옄�뿴�뿉�꽌 臾몄옄 �븳湲��옄�뵫 寃��궗�븯硫댁꽌)
	        for(int i = 0; i < str.length(); i++) {
	            char c = str.charAt(i);
	            //�뵾�뿰�궛�옄硫� �뒪�깮�뿉 �떞�뒗�떎.
	            if( Character.isDigit(c) )
	                stack.push(c - '0');
	            //�뿰�궛�옄硫� �몢媛쒖쓽 �뵾�뿰�궛�옄瑜� �뒪�깮�뿉�꽌 爰쇰궡�꽌 �빐�떦 �뿰�궛�옄濡� �뿰�궛�븳 �썑 寃곌낵瑜� �뒪�깮�뿉 �떞�뒗�떎.
	            else {
	                int num2 = stack.pop();
	                int num1 = stack.pop();
	                switch (c) {
	                case '+':
	                    stack.push(num1 + num2);
	                    break;
	                case '-':
	                    stack.push(num1 - num2);
	                    break;
	                case '*':
	                    stack.push(num1 * num2);
	                    break;
	                case '/':
	                    stack.push(num1 / num2);
	                    break;
	                }
	            }
	        }
	        //�떇�씠 �걹�굹硫� �뒪�깮�뿉 �엳�뒗 �븯�굹�쓽 媛믪씠 寃곌낵.
	        //System.out.println(stack.pop());
			
			System.out.println("#"+tc+" " + stack.pop());
			
		}
	}

}
