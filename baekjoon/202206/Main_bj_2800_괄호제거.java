package p06;

import java.io.*;
import java.util.*;

public class Main_bj_2800_괄호제거 {
	static class term {
		char ch;
		int idx;

		public term(char ch, int idx) {
			this.ch = ch;
			this.idx = idx;
		}
	}    //   (

	static Set<String> set = new TreeSet<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();

		Stack<term> sta = new Stack<>();
		List<int[]> list = new ArrayList<int[]>();  

		for (int i = 0; i < input.length; i++) {
			if (input[i] == '(') {
				sta.add(new term('(', i));
			} else if (input[i] == ')') {
				int left = sta.pop().idx;
				list.add(new int[] { left, i });
			}
		}
		int[] check = new int[list.size()];
		
		solve(input, list, check, 0);
		for(String s : set) {
			System.out.println(s);
		}

	}

	static void solve(char[] input, List<int[]> list, int[] check, int cur) {
		if (cur > list.size() - 1) {
			StringBuilder sb = new StringBuilder();
			int cntone = 0;

			for (int i = 0; i < list.size(); i++) {
				if (check[i] == 1)
					cntone++;
			}
			if(cntone!=0) {
				char[] copy = new char[input.length];
				for(int i=0; i<input.length; i++) {
					copy[i]=input[i];
				}
				for(int i=0; i<list.size(); i++) {
					if(check[i]==1) {
						copy[list.get(i)[0]]='X';
						copy[list.get(i)[1]]='X';
					}
				}
				for(int i=0; i<input.length; i++) {
					if(copy[i]=='X')continue;
					sb.append(copy[i]);
				}
				set.add(sb.toString());
			}
			return;
		}

		solve(input, list, check, cur + 1);
		check[cur] = 1;
		solve(input, list, check, cur + 1);
		check[cur] = 0;
	}

}
