package practice0226;
import java.io.*;
import java.util.*;
public class Main_bj_20055_컨베이어벨트위의로봇 {
	/*
	 * 올리는 위치 0
	 * 내리는 위치 N-1
	 * 올리는 위치에 로봇 올리거나 로봇 한칸 이동하면 이동하는 곳 내구도 -1
	 * 1. 벨트가 로봇과 함께 회전
	 * 2. 앞 칸에 로봇이 없거나 내구도가 1이상이면 로봇은 한 칸 앞으로;
	 * 3.올리는 위치에 내구도 0 아니라면 올린다.
	 * 4. 
	 */
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());//컨베이어 칸수
		int K = Integer.parseInt(st.nextToken());//내구 도 0인 칸 수가 K개 이상이면 종료 
		int[] belt = new int[2*N+1];//내구도 
		boolean[] robot = new boolean[N+1];//로봇 있는지 확인
		st =new StringTokenizer(br.readLine()," ");
		for(int i=0;i<2*N;i++) {
			belt[i]=Integer.parseInt(st.nextToken());
		}
		int step = 1;
		while(true) {
			//1.한 칸 회전
			for(int i=2*N-1; i>=0; i--) {
				belt[i+1]=belt[i];
			
			}
			belt[0]=belt[2*N]; //마지막 칸 맨 앞으로 
			for(int i=N-1; i>=0;i--) {
				robot[i+1]=robot[i];
			}
			robot[0]=false;
			robot[N-1]=false;//로봇 있다면 내리기
//			System.out.println(1);
//			for(int i=0; i<2*N;i++)System.out.print(belt[i]+" ");
//			System.out.println();
//			for(int i=0; i<N;i++)System.out.print(robot[i]+" ");
//			System.out.println();
			//2.로봇 한 칸 씩 이동 먼저 올라간 것 부터 
			for(int i=N-2; i>=0;i--) {
				if(robot[i]==true&&robot[i+1]==false&&belt[i+1]>0) {
					robot[i+1]=true;//이동
					robot[i]=false;//이전 위치 다시 0으로
					belt[i+1]-=1;//이동 위치 내구도 감소						
				}
			}
			robot[N-1]=false;//로봇 있다면 내리기
//			System.out.println(2);
//			for(int i=0; i<2*N;i++)System.out.print(belt[i]+" ");
//			System.out.println();
//			for(int i=0; i<N;i++)System.out.print(robot[i]+" ");
//			System.out.println();
			
			//로봇 올리기
			if(belt[0]>0) {
				robot[0]=true;
				belt[0]--;
			}
//			System.out.println(3);
//			for(int i=0; i<2*N;i++)System.out.print(belt[i]+" ");
//			System.out.println();
//			for(int i=0; i<N;i++)System.out.print(robot[i]+" ");
//			System.out.println();
//			System.out.println("----------------------");
			int count = 0;
			for(int i=0; i<2*N;i++) {
				if(belt[i]==0)count++;
			}									
			if(count>=K)break;
			step++;			
		}
		System.out.println(step);		
	}
}
