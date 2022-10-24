package algo202210;

import java.util.Arrays;
import java.util.Stack;

public class Solution_pro_스택큐_같은숫자는싫어 {
    public static void main(String[] args) throws Exception{
        int[] arr = {1,1,3,3,0,1,1,};
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if(stack.size()==0){
                stack.add(arr[i]);
                continue;
            }
            int n = stack.peek();
            if(n!=arr[i]) stack.add(arr[i]);
        }
        int[] answer = new int[stack.size()];
        for(int i=stack.size()-1; i>=0; i--){
            answer[i] = stack.pop();
        }
        System.out.println(Arrays.toString(answer));
    }
}
