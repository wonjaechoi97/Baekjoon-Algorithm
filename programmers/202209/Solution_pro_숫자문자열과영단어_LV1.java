package algo202209;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_pro_숫자문자열과영단어_LV1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s  = br.readLine();


        String[] numbers = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        int answer = 0;
        int head = 0;
        String answerString = "";
        char[] charArr = s.toCharArray();
        while(true){
            if('0'<=charArr[head]&& charArr[head]<='9'){ //만약 숫자면?
//                list.add(Character.toString(charArr[head])); // 숫자 문자로 변화해서 리스트에 저장
                answerString+=Character.toString(charArr[head]);
                head++;

            }else{
                //한 글자씩 넣어가면서 비교
                String checkString = "";
                point : while(true){
                    checkString+=Character.toString(charArr[head]);
                    head++;
                    if(checkString.length()>=3) {
                        for (int i = 0; i <= 9; i++) {
                            if (checkString.equals(numbers[i])) {
                                answerString += Integer.toString(i);
                                break point;
                            }
                        }
                    }
                }
            }
            if(head == s.length()){
                break;
            }
        }
        System.out.println(answerString);
        br.close();

    }


}
