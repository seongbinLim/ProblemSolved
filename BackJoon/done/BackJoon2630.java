package done;
import java.util.Arrays;
import java.util.Scanner;

public class BackJoon2630 {
	static int white;
	static int blue;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[][] map = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		recursive(map);
		
		System.out.println(white);
		System.out.println(blue);

	}
	
	static void recursive(int [][] arr) {
		if(arr.length == 1) {
			if(arr[0][0] == 0) white++;
			else blue++;
			return;
		}
		
		int color = arr[0][0];
		boolean isPossible = true;
		B:for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
				if(color != arr[i][j]) {
					isPossible = false;
					break B;
				}
			}
		}
		
		if(!isPossible) {
			int size = arr.length/2;
			int[][] arr1 = new int[size][size];
			int[][] arr2 = new int[size][size];
			int[][] arr3 = new int[size][size];
			int[][] arr4 = new int[size][size];
			
			for(int i=0; i<size; i++) {
				for(int j=0; j<size; j++) {
					arr1[i][j] = arr[i][j];
				}
			}
			
			for(int i=size; i<arr.length; i++) {
				for(int j=0; j<size; j++) {
					arr2[i-size][j] = arr[i][j];
				}
			}
			
			for(int i=0; i<size; i++) {
				for(int j=size; j<arr.length; j++) {
					arr3[i][j-size] = arr[i][j];
				}
			}
			
			for(int i=size; i<arr.length; i++) {
				for(int j=size; j<arr.length; j++) {
					arr4[i-size][j-size] = arr[i][j];
				}
			}

			recursive(arr1);
			recursive(arr2);
			recursive(arr3);
			recursive(arr4);
		}
		
		else {
			if(color == 1) blue++;
			else white++;
		}
	}

}
