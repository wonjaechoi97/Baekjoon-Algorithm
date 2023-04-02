package algo202304;

import java.io.*;
import java.util.*;
public class Main_bj_21609_상어중학교 {
    static int N;
    static int M;

    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, - 1};

    static class Block implements Comparable<Block>{
        int standardI;
        int standardJ;
        int size;
        int rainbowCnt;

        public Block(int standardI, int standardJ, int size, int rainbowCnt) {
            this.standardI = standardI;
            this.standardJ = standardJ;
            this.size = size;
            this.rainbowCnt = rainbowCnt;
        }

        @Override
        public int compareTo(Block o) {
            int r = this.size - o.size;
            if(r==0){
                r= this.rainbowCnt-o.rainbowCnt;
                if(r==0){
                    r = this.standardI - o.standardI;
                    if(r==0){
                        r = this.standardJ - o.standardJ;
                    }
                }


            }
            return r;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());//격자 크기
        M = Integer.parseInt(st.nextToken());//색상 수

        int[][] map = new int[N][N];
        int point = 0; //최종 획득 점수

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true){
            //크기가 가장 큰 블록을 찾는 과정 BFS,
            int[] maxLoc = findBiggestBlock(map);
            if(maxLoc[0]==-1)break; //블록 없음 BREAK!!!!!!!!!
            //2-1블록 제거, 빈칸은 -2
            eraseBlock(map, maxLoc[0], maxLoc[1]);

            //2-2점수 추가
            point += maxLoc[2] * maxLoc[2];


            // 3. 중력
            gravity(map);
//

            //4. 격자가 90도 반시계 방향 회전
            map = rotate(map);


            //5. 다시 격자에 중력
            gravity(map);



        }


        System.out.println(point);

        br.close();

    }


    static int[] findBiggestBlock(int[][] map){
        boolean[][] numVisited = new boolean[N][N];
        int maxSize = -1;
        int maxI = -1;
        int maxJ = -1;
        int rainbowCnt=-1;
        //기준 블록은 좌측 상단에 {있을 수록 기준 블록이므로 좌측 상단부터 탐색
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                //일반 블록이 적어도 하나는 있어야 한다. 그러므로 블록이 일반 블록일 경우 + 방문하지 않은 경우 탐색
                if(map[i][j]>0&&!numVisited[i][j]){

                    Block block = bfs(map, numVisited, i, j);
                    //기존의 것보다 큰 사이즈의 블록이라면 maxI, maxJ, maxSize 갱신
                    if(block.size==maxSize){

                        if(block.compareTo(new Block(maxI, maxJ, maxSize, rainbowCnt))>0){
                           maxI = block.standardI;
                           maxJ = block.standardJ;
                           maxSize = block.size;
                           rainbowCnt = block.rainbowCnt;
                        }

                    }else if(block.size>maxSize){
                        maxI = block.standardI;
                        maxJ = block.standardJ;
                        maxSize = block.size;
                        rainbowCnt = block.rainbowCnt;
                    }

                }

            }
        }

        return new int[]{maxI, maxJ, maxSize};
    }

    static Block bfs(int[][] map, boolean[][] numVisited, int si, int sj /*일반 블록 방문했는지 체크용*/) {
        boolean[][] visited = new boolean[N][N];
        int size = 0;
        int colorNum = map[si][sj];
        int rainbowCnt = 0;
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{si, sj});
        size++;
        numVisited[si][sj] = visited[si][sj] = true; //일반 블록 방문이므로 숫자방문, 걍방문 다 체크
        while(!que.isEmpty()){
            int[] cur = que.poll();

            for (int d = 0; d < 4; d++) {
                int ni = cur[0] + di[d];
                int nj = cur[1] + dj[d];
                if(0<=ni&&ni<N&&0<=nj&&nj<N && !visited[ni][nj]){ //격자 내부 + 방문 안함
                    if(map[ni][nj]==0){ //무지개라면
                        rainbowCnt++;
                        que.add(new int[]{ni, nj});
                        visited[ni][nj] = true;
                        size ++;
                    } else if (map[ni][nj] == colorNum) {//일반 숫자 블록 방문이라면
                        que.add(new int[]{ni, nj});
                        visited[ni][nj] = true;
                        numVisited[ni][nj] =true;
                        size++;
                    }
                }
            }

        }
        if(size<2)return new Block(-2,-2, -2, -2);
        else return new Block(si, sj, size, rainbowCnt);
    }

    static void eraseBlock(int[][] map, int si, int sj) {
        boolean[][] visited = new boolean[N][N];
        int colorNum = map[si][sj];
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{si, sj});
        visited[si][sj] = true;
        map[si][sj] =-2; //지우기
        while(!que.isEmpty()){
            int[] cur = que.poll();

            for (int d = 0; d < 4; d++) {
                int ni = cur[0] + di[d];
                int nj = cur[1] + dj[d];
                if(0<=ni&&ni<N&&0<=nj&&nj<N && !visited[ni][nj]){ //격자 내부 + 방문 안함
                    if(map[ni][nj]==0 || map[ni][nj]==colorNum) { //무지개라면
                        que.add(new int[]{ni, nj});
                        visited[ni][nj] = true;
                        map[ni][nj]=-2;
                    }
                }
            }

        }
    }

    static void gravity(int[][] map){

        for(int i=N-2; i>=0; i--){
            for(int j=0; j<N; j++){
                //빈칸이 아닌 블록은 아래로 옮길 수 있는지 확인
                if(map[i][j]>-1){
                    //막히는 것이 있을 때까지 아래로 전진
                    int ni = i;
                    int nj = j;
                    while(true){
                        ni += di[2]; //아래 확인
                        if(ni>=N || map[ni][nj]>-2){ //격자  밖이거나 혹은 더이상 나아갈 수 없다면?
                            ni -= di[2];
                            break;
                        }


                    }
                    //옮기기
                    int tmp = map[i][j];
                    map[i][j]=-2;
                    map[ni][j] = tmp;

                }
            }
        }
    }

    static int[][] rotate(int[][] map){
        int[][] copy = new int[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                copy[N-1-j][i] = map[i][j];
            }
        }
        return copy;
    }
}
