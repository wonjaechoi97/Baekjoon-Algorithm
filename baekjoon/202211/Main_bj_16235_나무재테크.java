package algo202211;

import java.io.*;
import java.util.*;

public class Main_bj_16235_나무재테크 {
    static class Tree implements Comparable<Tree>{
        int r;
        int c;
        int age;

        public Tree(int r, int c, int age){
            this.r=r;
            this.c=c;
            this.age=age;
        }

        public int compareTo(Tree o){
            return -o.age + this.age;
        }

    }
    static int[] di = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dj = {0, 1, 1, 1, 0, -1, -1, -1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /*
        봄
            - 나무 자신의 나이만큼 양분 섭취 후 나이 +1
            - 나이가 어린 나무부터
            - 나이만큼 못먹으면 죽음
        여름
            - 죽은 나무 나이/2만큼 양분 + 소수점 아래는 버린다.

        가을
            - 나이가 5배수 나무 주변 8칸에 나이가 1인 나무 생성 8방 탐색
        겨울
            - 칸마다  A[r][c]만큼 양분 추가


         */
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][N]; //양분정보
        int[][] A = new int[N][N]; //양분 더하는 정보

        //모든 칸에는 5만큼의 양분이 있다.
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                map[i][j]=5;
            }
        }
        // A 배열 정보
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        PriorityQueue<Tree> [][] trees = new PriorityQueue[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                trees[i][j] = new PriorityQueue<Tree>();
            }
        }

        //나무 심은 정보 저장 나이 순으로 빼서 사용하기 위해 priorityqueue 사용
        for(int m =0; m<M; m++){
            st = new StringTokenizer(br.readLine()," ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int age = Integer.parseInt(st.nextToken());
            trees[x-1][y-1].add(new Tree(x-1,y-1,age));
        }

        for(int k=0; k<K;k++){
            /*봄
                - 나무 자신의 나이만큼 양분 섭취 후 나이 +1
                - 나이가 어린 나무부터
                - 나이만큼 못먹으면 죽음*/
            int[][] nextMap = new int[N][N]; //다 죽고 나서 추가될 양분 저장소
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    int size  =trees[i][j].size();

                    PriorityQueue<Tree> nextTree = new PriorityQueue<>();
                    for(int q=0; q<size;q++){
                        Tree cur = trees[i][j].poll();
                        if(cur.age>map[i][j]){
                            nextMap[i][j]+=cur.age/2; //먹지 못하면 죽고 양분을 남긴다.
                        }else{
                            map[i][j]-=cur.age; //먹는다면 양분을 먹고
                            cur.age++; //나이가 증가
                            nextTree.add(cur); //다시 살아남아 새로운 큐에 담긴다.
                        }
                    }
                    trees[i][j] = nextTree;//새로운 큐 할당
                }
            }
            //봄이 모두 지남 여름 죽은 나무로부터 양분 추가
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    map[i][j]+=nextMap[i][j]; //양분 추가!
                }
            }

            //여름이 지나고 5의 배수만큼 나이를 먹은 나무들 8방에 나이가 1인 나무가 생긴다
            PriorityQueue<Tree>[][] nextTrees = new PriorityQueue[N][N];
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    nextTrees[i][j] = new PriorityQueue<Tree>();
                }
            }
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    int size = trees[i][j].size();
                    for(int q=0; q<size; q++){
                        Tree cur = trees[i][j].poll();
                        if(cur.age%5==0){
                            for(int d=0;d<8;d++){
                                int ni = i + di[d];
                                int nj = j + dj[d];
                                if(0<=ni&&ni<N&&0<=nj&&nj<N){
                                    nextTrees[ni][nj].add(new Tree(ni,nj,1));
                                }
                            }
                        }
                        nextTrees[i][j].add(cur);
                    }
                }
            }
            trees = nextTrees;

            //가을이 모두 지나고 겨울 새롭게 양분추가
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    map[i][j]+=A[i][j]; //양분 추가!
                }
            }

        }

        //최종 나무 세기

        int sum = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                sum+=trees[i][j].size();
            }
        }

        System.out.println(sum);

    }
}
