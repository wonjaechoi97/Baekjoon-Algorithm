package algo202211;

import java.io.*;
import java.util.*;

public class Main_bj_20056_마법사상어와파이어볼 {
    static class Shark{
        int i;
        int j;
        int m;
        int s;
        int d;


        public Shark(int i, int j, int m, int s, int d) {
            this.i = i;
            this.j = j;
            this.m = m;
            this.s = s;
            this.d = d;

        }
    }

    static class SharkSet extends Shark{
        int cnt; //상어 수
        int oddCnt; //홀수 방향 수
        int evenCnt; //짝수 방향 수

        int mSum; //질량의 합
        int sSum; //속도의 합

        public SharkSet(int i, int j, int m, int s, int d,  int cnt, int oddCnt, int evenCnt, int mSum, int sSum) {
            super(i, j, m, s, d );
            this.cnt = cnt;
            this.oddCnt = oddCnt;
            this.evenCnt = evenCnt;
            this.mSum = mSum;
            this.sSum = sSum;
        }
    }


    static int di[] = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int dj[] = {0, 1, 1, 1, 0, -1, -1, -1};
    static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");




        // N x N 격자
        N = Integer.parseInt(st.nextToken());
        //M개의 파이어볼
        int M = Integer.parseInt(st.nextToken());
        // K번의 이동
        int K = Integer.parseInt(st.nextToken());
        // 위치 r c, 질량 m, 방향 d, 속력 s

        //합쳐지는 파이어볼의 방향이 모두 짝수 or 홀수 이면 0 2 4 6
        //아니면 !!! 1 3 5 7

        //질량 합쳐진 파이어볼 질량 / 5

        //속력 합쳐진 파이어볼 / 합쳐진 파이어볼 개수


        // 질량 0인 파이어볼 소멸
        SharkSet[][] map = new SharkSet[N][N];
        List<Shark> sharks = new LinkedList<>();


        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");


            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            sharks.add(new Shark(r, c, m, s, d));



        }
       /* for(Shark shark : sharks){
            System.out.print("{ "+shark.i+" "+shark.j + " "+shark.m+" "+shark.s+" "+shark.d+ " }");
            System.out.println();
        }
        System.out.println("=====================================================================");*/
        for(int i=0; i<K; i++){
            Iterator<Shark> iterator = sharks.iterator();
            for(int ni=0; ni<N; ni++){
                for(int nj=0; nj<N; nj++){
                    map[ni][nj] = new SharkSet(0,0,0,0,0, 0,0,0,0,0);
                }
            }
            while(iterator.hasNext()){
                Shark shark = iterator.next();
                move(shark, map);
            }

            sharks = new LinkedList<>();
            for(int ni=0; ni<N; ni++){
                for(int nj=0; nj<N; nj++){
                    if(map[ni][nj].cnt>0){
                        split(map[ni][nj],sharks);
                    }
                }
            }
          /*  for(Shark shark : sharks){
                System.out.print("{ "+shark.i+" "+shark.j + " "+shark.m+" "+shark.s+" "+shark.d+ " }");
                System.out.println();
            }
            System.out.println("---------------------------------------------------------------------");*/
        }
        int sum = 0;
        for(int i=0; i<sharks.size(); i++){
            sum+=sharks.get(i).m;
        }

        System.out.println(sum);
        br.close();

    }


    //이동
    static void move(Shark shark, SharkSet[][] map){
        int ni = shark.i + di[shark.d] * shark.s % N;
        int nj = shark.j + dj[shark.d] * shark.s % N;
        if(ni<0)ni=N+ni;
        if(ni>=N)ni=ni-N;
        if(nj<0)nj=N+nj;
        if(nj>=N)nj=nj-N;
        if(map[ni][nj].cnt>0){
            SharkSet curShark = map[ni][nj];
            curShark.cnt++;
            curShark.mSum += shark.m;
            curShark.sSum += shark.s;
            if(shark.d%2==0){
                curShark.evenCnt++;
            }else{
                curShark.oddCnt++;
            }
        }else{
            SharkSet curShark = new SharkSet(ni, nj, shark.m,  shark.s,shark.d, 1, 0, 0, shark.m, shark.s );
            curShark.cnt=1;
            curShark.mSum = shark.m;
            curShark.sSum = shark.s;

            if(shark.d%2==0){
                curShark.evenCnt++;
            }else{
                curShark.oddCnt++;
            }
            map[ni][nj]=curShark;
        }
    }


    // 합쳐진 파이어볼 분리
    static void split(SharkSet set, List<Shark> sharks){
        if(set.cnt==1){
            sharks.add(new Shark(set.i,set.j,set.m,set.s, set.d));
        }else{
            if(set.mSum/5==0)return;
            if(set.oddCnt==0||set.evenCnt==0){
                sharks.add(new Shark(set.i, set.j, set.mSum / 5, set.sSum / set.cnt, 0));
                sharks.add(new Shark(set.i, set.j, set.mSum / 5, set.sSum / set.cnt, 2));
                sharks.add(new Shark(set.i, set.j, set.mSum / 5, set.sSum / set.cnt, 4));
                sharks.add(new Shark(set.i, set.j, set.mSum / 5, set.sSum / set.cnt, 6));
            }else{
                sharks.add(new Shark(set.i, set.j, set.mSum / 5, set.sSum / set.cnt, 1));
                sharks.add(new Shark(set.i, set.j, set.mSum / 5, set.sSum / set.cnt, 3));
                sharks.add(new Shark(set.i, set.j, set.mSum / 5, set.sSum / set.cnt, 5));
                sharks.add(new Shark(set.i, set.j, set.mSum / 5, set.sSum / set.cnt, 7));
            }
        }
    }
}
