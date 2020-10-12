package 모의기출;

import java.util.Scanner;

public class D2_1859_백만장자프로젝트 {
   static int T;
   static int N;
   static int[] arr;
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      T = sc.nextInt();
      
      for (int tc = 1; tc <= T; tc++) {
         N = sc.nextInt();
         arr = new int[N];
         for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
         }
         long Sum = 0;
         for (int i = 0; i < N-1; i++) {
            int Max = arr[i];
            for (int j = i+1; j < N; j++) {
               if(Max<arr[j]) {
                  Max=arr[j];
               }
            }
            Sum += Max-arr[i];
            
         }
         System.out.println("#"+tc+" "+Sum);
      }
   }
}


