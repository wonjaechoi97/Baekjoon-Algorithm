package algo202301;

import java.io.*;
import java.util.*;

public class Main_bj_17281_야구 {
    static int max;
    static int N;
    static int[][] play;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); //이닝 수

        play = new int[N][9]; //이닝별 타자 예상 결과

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<9; j++){
                play[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solve(new boolean[9], new int[8], 0);

        System.out.println(max);
        br.close();
    }

    //순열
    static void solve(boolean[] visited, int[] result, int cnt){
        if(cnt ==8){
//
            int[] order = new int[9];
            order[3] = 0;
            order[0] = result[0];
            order[1] = result[1];
            order[2] = result[2];
            order[4] = result[3];
            order[5] = result[4];
            order[6] = result[5];
            order[7] = result[6];
            order[8] = result[7];
            play(order);
            return;
        }

        for (int i = 1; i < 9; i++) {
            if(visited[i])continue;
            //추가
            result[cnt] = i;
            visited[i] = true;
            solve(visited, result, cnt + 1);
            visited[i] = false;
        }
    }

    static void play(int[] order){

        int hitter = 0; //현재 타자
        int point = 0;
        for(int i=0; i<N; i++){
            int[] base = new int[4];
            int outCnt = 0;
            int[] inning = play[i]; //각 타자별 성적
            while(outCnt!=3){
                int hit = inning[order[hitter]];//몇 타 ? 1루타 2루타 3루타 홈런

                if(hit==0){
                    hitter++;
                    if(hitter>8){
                        hitter = 0;
                    }
                    outCnt++;
                } else if (hit == 1) {
                    if(base[3]==1){ //3루에 있다면?
                        point++;
                    }

                    for (int b = 3; b > 0; b--) {
                        base[b] = base[b - 1]; //2-->3, 1-->2, 0-->1
                        base[b - 1] = 0;
                    }

                    //1루 진출
                    base[1] = 1;

                    hitter++;
                    if(hitter>8){
                        hitter = 0;
                    }

                }else if (hit == 2) { //2루타
                    if(base[3]==1){ //3루에 있다면?
                        base[3]=0;
                        point++;
                    }
                    if(base[2]==1){ //2루에 있다면?
                        base[2]=0;
                        point++;
                    }
                    base[3] = base[1]; // 1-->3
                    base[1] = 0; //1루 비우고
                    base[2] = 1; // 0 --> 2
                    hitter++;
                    if(hitter>8){
                        hitter = 0;
                    }
                }else if (hit == 3) { //3루타
                    if(base[3]==1){ //3루에 있다면?
                        base[3]=0;
                        point++;
                    }
                    if(base[2]==1){ //2루에 있다면?
                        base[2]=0;
                        point++;
                    }
                    if(base[1]==1){ //1루에 있다면?
                        base[1]=0;
                        point++;
                    }
                    hitter++;
                    if(hitter>8){
                        hitter = 0;
                    }
                    base[3] = 1; //진루

                }else if (hit == 4) { //홈런
                    point++;
                    if(base[3]==1){ //3루에 있다면?
                        base[3]=0;
                        point++;
                    }
                    if(base[2]==1){ //2루에 있다면?
                        base[2]=0;
                        point++;
                    }
                    if(base[1]==1){ //1루에 있다면?
                        base[1]=0;
                        point++;
                    }
                    hitter++;
                    if(hitter>8){
                        hitter = 0;
                    }

                }
            }
        }

        if(point>max) max = point;

    }
}
