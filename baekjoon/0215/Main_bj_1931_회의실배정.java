import java.io.*;
import java.util.*;

public class Main_bj_1931_회의실배정 {
	static class Meeting implements Comparable<Meeting>{
		int start, end;

		public Meeting(int start, int end) {
			//ssuper();
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Meeting o) {
			return this.end !=o.end?this.end-o.end : this.start - o.start;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N =Integer.parseInt(br.readLine());
		Meeting[] meeting = new Meeting[N];
		for(int i=0; i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			meeting[i]= new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			
		}
		List<Meeting> result = getSchedule(meeting);
		//StringBuilder sb = new StringBuilder();
		//sb.append(result.size()).append("\n");
		/*
		for(Meeting meetings : result) {
			sb.append(meetings.start).append(" ").append(meetings.end).append("\n");
		}
		*/
		System.out.println(result.size());
		//for(int[] a: meeting)System.out.println(Arrays.toString(a));
		//Arrays.sort(meeting[0]);
		//for(int[] a: meeting)System.out.println(Arrays.toString(a));
		br.close();

	}
	public static List<Meeting> getSchedule(Meeting[] meetings){
		
		ArrayList<Meeting> result  = new ArrayList<Meeting>();
	
		Arrays.sort(meetings);
		result.add(meetings[0]);
		
		for(int i=1, size = meetings.length; i< size; i++) {
			// 직전회의의 종료시간과 현재회으의 종료 시간 비교
			if(result.get(result.size()-1).end <=meetings[i].start) {
				result.add(meetings[i]);
			}
		}
		return result;
	}
}
