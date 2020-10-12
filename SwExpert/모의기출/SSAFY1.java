package 모의기출;

public class SSAFY1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		/*
		for(int i=1; i<98; i++) {
			for(int j=1; j<98; j++) {
				for(int k=1; k<98; k++) {
					if(i+j+k == 100) {
						System.out.println(i+"+"+j+"+"+k+"=100");
					}
				}
			}
		}*/
		
		
		
		
	}
	public static int fibo_recursive(int a) {
		if(a == 1 || a ==2)
			return 1;
		
		return fibo_recursive(a-1)+fibo_recursive(a-2);
	}
	
	public static int fibo_dynamic(int n, int[] fibo_memo) {
		if(fibo_memo[n] != -1) {
			return fibo_memo[n];
		}
		fibo_memo[n] = fibo_dynamic(n-1, fibo_memo) + fibo_dynamic(n-2, fibo_memo);
		return fibo_memo[n];
	}
	
	public static int findMax(int[] a) {
		int max = 0;
		
		for(int i=0; i<a.length-2; i++) {
			if(max < a[i]+a[i+1]+a[i+2]) {
				max = a[i]+a[i+1]+a[i+2];
			}
		}
		
		
		return max;
	}
}
