import java.io.*;
import java.util.*;


public class OddOccurrencesInArray {
    public static void main(String[] args) throws Exception{
        int[] A = {9, 3, 9, 3, 9, 7, 9};
        HashSet<Integer> set = new HashSet<>();

        for(int a : A){
            if(set.contains(a)){
                set.remove(a);
            }else{
                set.add(a);
            }
        }
        System.out.println(set.iterator().next());

    }
}
