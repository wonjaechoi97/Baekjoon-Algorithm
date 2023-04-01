package algo202304;

import java.io.*;
import java.util.*;

public class Main_bj_20055_컨베이어벨트위의로봇 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] belt = new int[2 * N];
        int step = 1;
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 2 * N; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }
//        System.out.println(Arrays.toString(belt));
        boolean[] robots = new boolean[2*N];
        while (true) {
            // 1단계 + 로봇 빼기
            int[] nextBelt = new int[2 * N];
            boolean[] nextRobot = new boolean[2 * N];
            for(int i=0; i<2*N-1;i++){
                //벨트 + 로봇 이동
                nextBelt[i + 1] = belt[i];
                nextRobot[i + 1] = robots[i];
            }
            nextBelt[0] = belt[2 * N - 1];
            nextRobot[N - 1] = false;

            robots = nextRobot;
            belt = nextBelt;

            // 2단계먼저 올라간 로봇부터 이동
             //N-1부터
            for (int i = N - 2; i >= 0; i--) {
                if(robots[i]){
                    if (belt[i + 1] > 0 && !robots[i + 1]) { //다음 칸 내구도가 0보다 크고, 다음칸에 로봇이 없다면
                        robots[i + 1] = robots[i];
                        robots[i]=false;
                        belt[i + 1]--; //내구도 감소
                    }
                }
            }
            robots[N - 1] = false;


            //3. 올리는 위치에 내구도 0보다 크면 올리기
            if (belt[0] > 0) {
                robots[0]=true;
                belt[0]--; //내구도 감소
            }

            int cnt = 0;
            for (int i = 0; i < 2 * N; i++) {
                if(belt[i]==0)cnt++;
            }
            if(cnt>=K){
//                System.out.println(cnt);
                break;
            }

            step++;
        }
        System.out.println(step);
        br.close();
    }

}
