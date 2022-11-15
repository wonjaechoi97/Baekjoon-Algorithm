package algo202211;
import java.io.*;
import java.util.*;
public class Main_bj_12100_2048Easy {
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};
    static int N;
    static int max;
    public static void main(String[] args) throws Exception{
        //상하좌우 한 방향으로 이동
        //4방으로 이동해서 한쪽으로 밀려내려가서 같은 숫자끼리 만나면 합쳐짐 한번 합쳐지면

        //!!!!!한번 합쳐지면 또 합쳐질 수 없음!!!!!!!!!!!

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        max = 0;
        int[][][] map = new int[N][N][2]; //이미 합쳐진 것인지 확인하기 위해 3차원 마지막 배열을 2칸으로 만듦
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++){
                int n = Integer.parseInt(st.nextToken());
                map[i][j][0]=n;
            }
        }
        //중복 조합 !

        solve(0, new int[5], map);
        System.out.println(max);
        br.close();

        

    }
    static void solve(int cnt, int[] selected, int[][][] map){
        if(cnt==5){
//            System.out.println(Arrays.toString(selected));
            int[][][] copy = new int[N][N][2];
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    copy[i][j][0]=map[i][j][0];
                }
            }
            for(int t=0; t<5; t++){
                if(selected[t]==0){
                    up(copy);
                } else if (selected[t]==1) {
                    down(copy);
                }else if (selected[t]==2) {
                    right(copy);
                }else {
                    left(copy);
                }
                for(int i=0; i<N; i++){
                    for(int j=0; j<N; j++){
                        copy[i][j][1]=0;
                    }
                }
                /*for(int i=0; i<N; i++){

                    for(int j=0; j<N; j++){
                        System.out.print(Arrays.toString(copy[i][j]));

                    }
                    System.out.println();
                }
                System.out.println("=------------------------------------");*/
            }
            int sum = 0;
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(copy[i][j][0]>max)max = copy[i][j][0];
                }
            }
            return;
        }
        for(int t=0; t<4; t++){
            selected[cnt]=t;
            solve(cnt+1, selected, map);
        }
    }
    
    static void up(int[][][] map){
        //위에서 부터 이동
        //d==0
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j][0]==0)continue;
                move(map, 0, i, j, map[i][j][0]);
            }
        }
    }
    static void right(int[][][] map){
        //우측 부터 이동 d=1
        for(int i=0; i<N; i++){
            for(int j=N-1; j>=0; j--){
                if(map[i][j][0]==0)continue;
                move(map, 1, i, j, map[i][j][0]);
            }
        }
    }
    
    static void down(int[][][] map){
        //위에서 부터 이동 d=2
        for(int i=N-1; i>=0; i--){
            for(int j=N-1; j>=0; j--){
                if(map[i][j][0]==0)continue;
                move(map, 2, i, j, map[i][j][0]);
            }
        }
    }
    
    static void left(int[][][] map){
        //좌측 부터 이동 d=3
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j][0]==0)continue;
                move(map, 3, i, j, map[i][j][0]);
            }
        }


    }
    
    static void move(int[][][] map, int d, int i, int j, int num){
        
        while(true){
            i+=di[d];
            j+=dj[d];
            if(0<=i&&i<N&&0<=j&&j<N){
                if(map[i][j][0]>0){
                    if(map[i][j][0]==num){ //합쳐질 수 있음
                        if(map[i][j][1]==0){//아직 합쳐진 적 없음
                            map[i][j][0]=2*num; //더 해줌
                            map[i][j][1]=1; // 방문 표시
                            map[i-di[d]][j-dj[d]][0]=0;
                        }
                    }
                    //합쳐질 수 없음
                    //이미 합쳐진 적이 있음
                    break;
                }else{//이동 가능
                    map[i-di[d]][j-dj[d]][0]=0;
                    map[i][j][0]=num;
                }
            }else{
                break;
            }
        }
    }
    
    
}
