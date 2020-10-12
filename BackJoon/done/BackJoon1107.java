package done;

import java.util.Scanner;

public class BackJoon1107 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //원하는 채널
		int cnt = sc.nextInt();
		broken = new boolean[10]; //고장난 키패드 번호를 저장할 배열
		for(int i=0; i<cnt; i++)
			broken[sc.nextInt()] = true;
		min = Math.abs(N - 100);
		
		//숫자만 누르기
		//숫자len-1만큼 뽑기, 숫자len만큼 뽑기, 숫자len+1만큼 뽑기
		int length = Integer.toString(N).length();
		
		if(length>1)
			pick(0, 0, length-1);
		pick(0, 0, length);
		pick(0, 0, length+1);
		
		System.out.println(min);
			
	}
	static int N;
	static int min;
	static boolean[] broken;
	public static void pick(int cnt, int number, int len) {
		if(cnt == len) {
			int total = len + Math.abs(N-number);
			min = Math.min(min, total);
			return;
		}
		
		System.out.println(number);
		
		for(int i=0; i<10; i++) {
			if(!broken[i]) {
				pick(cnt+1, number + (int)Math.pow(10, cnt)*i, len);
			}
		}
		
	}
}
