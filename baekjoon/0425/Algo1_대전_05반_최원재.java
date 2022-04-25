import java.io.*;
import java.util.*;
public class Algo1_대전_05반_최원재 {
//소스코드는 라인별로 소스코드에 대한 주석을 작성한다.
	static class save implements Comparable<save>{ //원래 숫자 값과 문자열 변환 값을 저장하기 위한 클래스 우선순위 큐를 사용하기 위해서 comparable을 implements한다.
		int num;//원래의 숫자
		String str;//문자열로 변환된 값
		
	public save(int num, String str) { //생성자 함수 
			this.num = num;
			this.str = str;
		}

	@Override
	public int compareTo(save o) { // compareTo함수를 사용하여 사전순으로 더 빠르면 운선순위가 높도록 한다.
		return this.str.compareTo(o.str);
	}
		
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //입력을 읽어들이기 위한 BufferedReader
		StringBuilder sb = new StringBuilder(); // 정답 문자열을 담아두기 위한 stringbuilder
		StringTokenizer st = new StringTokenizer(br.readLine()," "); // 공백으로 구분된 값 읽어들이기 위한 StringTokenizer
		int M = Integer.parseInt(st.nextToken()); //M값 입력 받기
		int N = Integer.parseInt(st.nextToken()); //N값 입력 받기
		PriorityQueue<save> pq = new PriorityQueue<>(); // 우선순위가 높은 것이 가장 먼저 빠져 나오는 우선순위 큐 생성 save객체의 str을 통해 우선순위 결정 
		for(int i=M; i<=N; i++) {// i는 M부터 시작 N에서 종료
			if(i<10) { // 만약의 i가 한 자리 수라면?
				if(i==1) {// 1~9까지 숫자에 따라 문자열로 변환 후 우선순위 큐에 넣어준다.
					pq.offer(new save(i, "one"));
				}else if(i==2) {
					pq.offer(new save(i, "two"));
				}else if(i==3) {
					pq.offer(new save(i, "three"));
				}else if(i==4) {
					pq.offer(new save(i, "four"));
				}else if(i==5) {
					pq.offer(new save(i, "five"));
				}else if(i==6) {
					pq.offer(new save(i, "six"));
				}else if(i==7) {
					pq.offer(new save(i, "seven"));
				}else if(i==8) {
					pq.offer(new save(i, "eight"));
				}else if(i==9) {
					pq.offer(new save(i, "nine"));
				}
			}else {//만약에 두자리 수라면
				String res="";//빈 문자열 생성
				int ten = i/10; //10의 자리 수
				int one = i%10; // 1의 자리 수 
				if(ten==1) {//10의 자리수 (1~9)에 따라 문자열로 변환해준 후 빈 문자열에 더해준다.ex) "one "
					res+= "one ";
				}else if(ten==2) {
					res+= "two ";
				}else if(ten==3) {
					res+=  "three ";
				}else if(ten==4) {
					res+= "four ";
				}else if(ten==5) {
					res+= "five ";
				}else if(ten==6) {
					res+=  "six ";
				}else if(ten==7) {
					res+= "seven ";
				}else if(ten==8) {
					res+=  "eight ";
				}else if(ten==9) {
					res+= "nine ";
				}
				
				if(one==0) {//1의 자리수 (0~9)에 따라 문자열로 변환해준 후 앞 서 10의 자리 문자열을 더해준 res에 일의 자리 숫자를 문자열로 변환한 것을 더해준다. ex) "one two"
					res+= "zero";
				}else if(one==1) {
					res+= "one";
				}else if(one==2) {
					res+= "two";
				}else if(one==3) {
					res+=  "three";
				}else if(one==4) {
					res+= "four";
				}else if(one==5) {
					res+= "five";
				}else if(one==6) {
					res+=  "six";
				}else if(one==7) {
					res+= "seven";
				}else if(one==8) {
					res+=  "eight";
				}else if(one==9) {
					res+= "nine";
				}
				
				pq.offer(new save(i, res)); // 원래 숫자와 문자열로 변환한 것으로 객체를 만들어서 우선순위 큐에 넣어준다.
			}
			
		}
		int c=0; //10개 마다 줄바꿈을 해주기 위해 몇 번째 숫자인지 카운팅하는 변수
		while(!pq.isEmpty()) { //우선순위 큐가 빌 때 까지 반복
			c++;//숫자 카운트 
			sb.append(pq.poll().num).append(" ");//stringbuilder 객체에 정답을 담아둔다.
			if(c%10==0)sb.append("\n");//한 줄에 10개의 숫자가 있다면 줄바꿈
		}
		
		System.out.println(sb.toString());//stringbuilder에 모아둔 정답을 출력한다. 

	}

}
