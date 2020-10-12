package D4;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class D4_지희의고장난계산기 {
	static int X;
	static int min;
	static boolean[] btn;
	static int size;
	static int[] memo;
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine().trim());
		for(int t=1; t<=T; t++) {
			min = Integer.MAX_VALUE;
			btn = new boolean[10];
			StringTokenizer st = new StringTokenizer(in.readLine().trim(), " ");
			int num;
			for(int i=0; i<10; i++) {
				num = Integer.parseInt(st.nextToken());
				if(num==1) btn[i] = true;
			}
			//x�� ����� ���Ѵ�.
			X = Integer.parseInt(in.readLine().trim());
			
			find(X, 0);
			//x�� ����� �־��� ���ڷ� ������ �� �ִ��� Ȯ���Ѵ�.
			size = (int)Math.sqrt(X);
			memo = new int[size];
			min = min == Integer.MAX_VALUE ? -1 : min;
			System.out.println("#"+t+" " + min);
		}
	}

	static int find(int x, int cnt) {
		if(isMake(x+"")) {
			if(cnt == 0) {
				min = len(x)+1;
			}
			return len(x)+1;
		}
		
		int result = -1;
		for(int i=2, end = (int)Math.sqrt(x); i < end; i++) {
			if( x % i == 0 && isMake(i+"") ) {
				int len1 = len(i)+1; // x ���ϱ��ư
				int len2 = find(x/i, cnt+1);
				
				if(len2 > -1) {
					result = len1 + len2;
					if(result < min && x == X) {
						min = result;
					}
				}
			}
		}
		
		return result;
	}
	static int len(int x) {
		return (int)Math.log10(x)+1;
	}
	static boolean isMake(String x) {
		for(char c : x.toCharArray()) {
			if(!btn[c-'0']) return false;
		}
		return true;
	}
}
