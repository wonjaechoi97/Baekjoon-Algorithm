package practice0226;
import java.util.*;
import java.io.*;
public class Main_bj_17478_재귀함수가뭔가요 {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N =Integer.parseInt(br.readLine());
		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		
		recur("", 0, N);
		System.out.println(sb.toString());
		br.close();

	}
	static void recur(String under, int n, int N) {
		sb.append(under+"\"재귀함수가 뭔가요?\"\n");
		if(n==N) {
			sb.append(under+"\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
			sb.append(under+"라고 답변하였지.\n");
			return;
		}
		String[] str = {
				"\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n",
				"마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n",
				"그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n"};
		for(int i=0; i<3; i++) {
			sb.append(under+str[i]);
		}
		recur(under+"____",n+1,N);
		sb.append(under+"라고 답변하였지.\n");		
	}
}
