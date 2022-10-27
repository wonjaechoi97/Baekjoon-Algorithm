package algo202210;

class Solution {
    static int ans;
    public int solution(int[] numbers, int target) {
        int answer = 0;
        int sum = 0;
        ans = 0;
        dfs(0, numbers, 0, target);
        answer=ans;
        return answer;
    }

    static void dfs(int cur, int[] numbers, int sum, int target){
        if(cur == numbers.length){
            if(sum==target){
                ans++;
            }
            return;
        }
        dfs(cur+1, numbers, sum+numbers[cur], target);
        dfs(cur+1, numbers, sum-numbers[cur], target);
    }
}
