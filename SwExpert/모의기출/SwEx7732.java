package 모의기출;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class SwEx7732 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();
		for (int test = 1; test <= tc; test++) {
			String input = sc.next();
			String[] current = input.split(":");
			
			input = sc.next();
			String[] promise = input.split(":");
			
			int hour = Integer.parseInt(current[0]);
			int min = Integer.parseInt(current[1]);
			int sec = Integer.parseInt(current[2]);
			
			int hourP = Integer.parseInt(promise[0]);
			int minP = Integer.parseInt(promise[1]);
			int secP = Integer.parseInt(promise[2]);
			
			int hourR = hourP - hour;
			int minR =  minP - min;
			int secR = secP - sec;
			
			if(hourR < 0)
				hourR += 24;
			if(minR < 0) {
				if(hourR == 0) {
					hourR = 24;
				}
				hourR--;
				minR += 60;
			}
			if(secR < 0) {
				if(minR == 0) {
					if(hourR == 0) {
						hourR = 23;
						minR = 60;
					} else {
						hourR--;
						minR = 60;
					}
				}
				minR--;
				secR += 60;
			}

			String h = String.format("%02d", hourR);
			String m = String.format("%02d", minR);
			String s = String.format("%02d", secR);
			String ans = " " + h + ":" + m + ":" + s;
			

			System.out.println("#"+test+ans);
			
			
		}
		

	}

}
