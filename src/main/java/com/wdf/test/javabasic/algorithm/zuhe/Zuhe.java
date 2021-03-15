package com.wdf.test.javabasic.algorithm.zuhe;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author WDF
 * @Description 组合
 * @Date 2020/9/8 15:16
 * @Param
 * @return
 **/

public class Zuhe {

  public static void main(String[] args) {
        Zuhe zuhe = new Zuhe();
        zuhe.combine(4,2);
  }

 public List<List<Integer>> combine(int n, int k) {
       List<Integer> list1 = new ArrayList<Integer>();
       List<List<Integer>> list2 = new ArrayList<List<Integer>>();
       for(int i = 1;i <= n; i++){
        for(int j = i+1; j<=n; j++){
            for (int m = 1;m <= 2;m++){
                list1.add(j);
            }
            list1 = new ArrayList<Integer>();
            list2.add(list1);
        }
       }
     System.out.println(list2.toString());
       return list2;
  }
}
