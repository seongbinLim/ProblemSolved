package D3;

public class SwEx3131 {

	public static void main(String[] args) {

		boolean[] prime = new boolean[10000];

		for (int i = 2; i < 10000; i++) {
		  if (prime[i] == false) {
		    for (int j = i*2; j < 10000; j += i) {
		      prime[j] = true;
		    }
		  }
		}

		for (int i = 2; i < 10000; i++) {
			if(!prime[i])
				System.out.print(i + " ");
		}
	}

}
