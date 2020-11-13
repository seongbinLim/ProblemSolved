class 타겟넘버 {
    public int solution(int[] numbers, int target) {
        count = 0;
        N = numbers.length;
        dfs(0, 0, target, numbers);
        return count;
    }
    public static int count;
    public static int N;
    public static void dfs(int idx, int value, int target, int[] numbers) {
         if(idx == N) {
             if(value==target) count++;
             return;
         }
        
        dfs(idx+1, value+numbers[idx], target, numbers);
        dfs(idx+1, value-numbers[idx], target, numbers);
        
    }
}