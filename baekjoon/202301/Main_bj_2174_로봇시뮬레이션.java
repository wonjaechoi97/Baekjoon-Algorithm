package algo202301;

import java.io.*;
import java.util.*;
public class Main_bj_2174_로봇시뮬레이션 {
    static class Robot {
        int i;
        int j;
        String dir;

        public Robot(int i, int j, String dir) {
            this.i = i;
            this.j = j;
            this.dir = dir;
        }
    }

    static int[] di = {-1, 0, 1, 0}; // W N E S
    static int[] dj = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken()); //가로
        int B = Integer.parseInt(st.nextToken()); //세로
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); //로봇 수
        int M = Integer.parseInt(st.nextToken()); // 명령 수

        Robot[] robots = new Robot[N + 1];
        int[][] map = new int[A][B];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int ci = Integer.parseInt(st.nextToken()) - 1;
            int cj = Integer.parseInt(st.nextToken()) - 1;
            String dir = st.nextToken();

            robots[i] = new Robot(ci, cj, dir);
            map[ci][cj] = i;
        }

        /*for (int i = 1; i <= N; i++) {
            System.out.println(robots[i].i + " " + robots[i].j + " " + robots[i].dir);
        }*/

//        for (int[] a : map) System.out.println(Arrays.toString(a));
        boolean success = true;
        here : for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine(), " ");

            //로봇 번호
            int robotNum = Integer.parseInt(st.nextToken());
            String order = st.nextToken();

            //몇 회 반복
            int times = Integer.parseInt(st.nextToken());
            Robot cur = robots[robotNum];

            if(order.equals("F")){ //전진
                int d = -1;
                if(cur.dir.equals("W")){
                    d = 0;
                } else if (cur.dir.equals("N")) { //우
                    d = 1;
                } else if (cur.dir.equals("E")) { //하
                    d = 2;
                }else{
                    d = 3;
                }
                for(int n=0; n<times; n++){
                    int ni = cur.i + di[d];
                    int nj = cur.j + dj[d];
                    //범위 내냐?
                    if(0<=ni&&ni<A&&0<=nj&&nj<B){
                        if(map[ni][nj]>0) {//충돌
                            System.out.println("Robot "+robotNum + " crashes into robot "+map[ni][nj]);
                            success =false;
                            break here;
                        }else { //정상적 진행 가능
                            map[cur.i][cur.j]=0;//지우기
                            cur.i = ni;
                            cur.j = nj;
                            map[cur.i][cur.j] = robotNum;//맵에도 표시
                            /*System.out.println("*** : "+n + " "+cur.i+" "+cur.j+" "+cur.dir );
                            for (int[] a : map) System.out.println(Arrays.toString(a));
                            System.out.println();*/
                        }
                    }else{ //벽 충돌
                        System.out.println("Robot "+robotNum + " crashes into the wall");
                        success = false;
                        break here;
                    }
                }
            } else if (order.equals("L")) {
                for(int n=0; n<times; n++) {
                    if (cur.dir.equals("W")) {
                        cur.dir = "S";
                    } else if (cur.dir.equals("N")) { //우
                        cur.dir = "W";
                    } else if (cur.dir.equals("E")) { //하

                        cur.dir = "N";
                    } else {
                        cur.dir = "E";
                    }
                }
            }else{
                for(int n=0; n<times; n++) {
                    if (cur.dir.equals("W")) {
                        cur.dir = "N";
                    } else if (cur.dir.equals("N")) { //우
                        cur.dir = "E";
                    } else if (cur.dir.equals("E")) { //하

                        cur.dir = "S";
                    } else {
                        cur.dir = "W";
                    }
                }

            }
        }
        if(success) System.out.println("OK");
        br.close();

    }
}
