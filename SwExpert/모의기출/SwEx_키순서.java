package 모의기출;
import java.util.Scanner;

public class SwEx_키순서 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[][] arr = new int[N][N];
			for(int i=0; i<M; i++) {
				int a = sc.nextInt()-1;
				int b = sc.nextInt()-1;
				
				arr[a][b] = 1;
			}
			
			for(int k=0; k<N; k++) {
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
						if(i==j) continue;
						if(i==k || j==k) continue;
						if(arr[i][k]==0 || arr[k][j]==0) continue;
						if(arr[i][j]==0 || (arr[i][j] > arr[i][k]+arr[k][j])) {
							arr[i][j] = arr[i][k] + arr[k][j];
						}
					}
				}
			}
			int answer = 0;
			for(int i=0; i<N; i++) {
				boolean flag = true;
				for(int j=0; j<N; j++) {
					if(i!=j && (arr[i][j]==0 && arr[j][i]==0)) {
						flag = false;
						break;
					}
				}
				if(flag) answer++;
			}
			
			System.out.println("#"+t+" "+answer);
		}

	}

}
