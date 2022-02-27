package practice0227;
import java.io.*;
import java.util.*;
public class Main_bj_4153_직각삼각형 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[] nums = new int[3];
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			nums[0]= Integer.parseInt(st.nextToken());
			nums[1]= Integer.parseInt(st.nextToken());
			nums[2]= Integer.parseInt(st.nextToken());
			if(nums[0]==0)break;
			Arrays.sort(nums);
			if(nums[0]*nums[0]+nums[1]*nums[1]==nums[2]*nums[2])sb.append("right").append("\n");
			else sb.append("wrong").append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
