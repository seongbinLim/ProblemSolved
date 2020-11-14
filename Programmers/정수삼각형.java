import java.util.Arrays;

public class 정수삼각형 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] t = {{7},{3,8},{8,1,0},{2,7,4,4},{4,5,2,6,5}};
		solution(t);
	}
    public static int solution(int[][] triangle) {
        for(int i=1; i<triangle.length; i++) {
            triangle[i][0] += triangle[i-1][0];
            for(int j=1; j<triangle[i].length-1; j++) {
                int A = triangle[i-1][j-1] + triangle[i][j];
                int B = triangle[i-1][j] + triangle[i][j];
                triangle[i][j] = Math.max(A, B);
            }
            triangle[i][triangle[i].length-1] += triangle[i-1][triangle[i-1].length-1];
            
            System.out.println(Arrays.toString(triangle[i]));
        }
        
        int max = 0;
        int lastIdx = triangle.length-1;
        for(int i=0; i<triangle[lastIdx].length; i++)
            max = Math.max(max, triangle[lastIdx][i]);
        return max;
    }
}
