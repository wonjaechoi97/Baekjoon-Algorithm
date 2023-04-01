package algo202304;

import java.io.*;
import java.util.*;
public class SortPractice {
    public static void main(String[] args) throws Exception{
        List<SortClass> list = new LinkedList<>();
        list.add(new SortClass(1, 2));
        list.add(new SortClass(234, 3));
        list.add(new SortClass(2, 2));
        list.add(new SortClass(14, 27));
        list.add(new SortClass(122, 4));
        list.add(new SortClass(3, 9));
        list.add(new SortClass(798, 2));
        list.add(new SortClass(56, 75));
        list.add(new SortClass(18, 35));
        list.add(new SortClass(85, 1111));
        Collections.sort(list, new Comparator<SortClass>() {
            public int compare(SortClass o1, SortClass o2) {
              int r = o1.num-o2.num;
              if(r==0){
                  r = o1.num2 - o2.num2;
              }
              return r;
            };
        });
        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i).num + " " + list.get(i).num2);
        }
    }

    static class SortClass{
        int num;
        int num2;

        public SortClass(int num, int num2) {
            this.num = num;
            this.num2 = num2;
        }
    }
}
