import java.util.Scanner;

public class 카잉달력_6064 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        for(int t=0; t<tc; t++) {
            int M = sc.nextInt();
            int N = sc.nextInt();

            int x = sc.nextInt();
            int y = sc.nextInt()%N;

            int year = -1;

            int max = N*M;
            for(int i=0; i*M+x<=max; i++) {
                int tmp = i*M + x;

                if(tmp%N==y) {
                    year = tmp;
                    break;
                }
            }

            System.out.println(year);
        }
    }
}
