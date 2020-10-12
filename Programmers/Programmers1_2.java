import java.util.Arrays;

public class Programmers1_2 {
	public static void main(String args []) {
		//String[] a = {"119", "97674223", "1195524421"};
		//String[] a = {"123", "456", "789"};
		String[] a = {"12", "123", "1235", "567", "88"};
		solution(a);
	}
	
    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Arrays.sort(phone_book);
        
        //for(String a : phone_book)
        //	System.out.println(a);
        
        for(int i=1; i<phone_book.length; i++) {
        	String tmp = phone_book[i-1];
        	if(phone_book[i].contains(tmp))
        		answer = false;
        }
        
        System.out.println(answer);
        return answer;
    }
}
