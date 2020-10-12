package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D4_정식이의은행업무 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			String num1 = br.readLine();
			String num2 = br.readLine();
			
	       B: for (int i = 0; i < num1.length(); i++) {
	            for (int j = 0; j < num2.length(); j++) {
	                int startB = num1.charAt(i)-'0' + 1;
	                int startT = num2.charAt(j)-'0' + 1;
	                for (int m = startB; m < startB + 1; m++) {
	                    for (int n = startT; n < startT + 2; n++) {
	                    	int idx1 = m%2;
	                    	int idx2 = n%3;
		                    String new1 = num1.substring(0,i)+idx1+num1.substring(i+1);
		                    String new2 = num2.substring(0,j)+idx2+num2.substring(j+1);
	                        int bin  = Integer.parseInt(new1.toString(), 2);
	                        int ten = Integer.parseInt(new2.toString(), 3);
	                        if (bin == ten) {
	                        	System.out.println("#"+t+" "+bin);
	                        	break B;
	                        }
	                    }
	                }
	            }
	        }
		}
	}

}
