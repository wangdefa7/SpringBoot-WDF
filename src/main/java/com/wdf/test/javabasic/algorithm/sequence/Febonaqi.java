package com.wdf.test.javabasic.algorithm.sequence;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Febonaci
 * @Author WDF
 * @Description 斐波那契数列  + 青蛙跳台阶
 * @Date 2021/3/12 13:20
 * @Copyright Dareway 2021/3/12
 * @Version 1.0
 **/
public class Febonaqi {

    /**
     * 超过n=44后，需要考虑使用  【最小的十位质数1000000007】 进行 取于
     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     **/
    private static Map<Integer,Integer> map;
    private static int[] array;
    public static void main(String[] args) {
        int n = 45;
        Febonaqi f = new Febonaqi();
        map = new HashMap<>();
        Long time = System.currentTimeMillis();
        System.out.println(f.fib_rember_search(n));
        System.out.println( System.currentTimeMillis() - time);
        //满足记忆的下标，0弃用
        array = new int[n + 1];
        //初始化数组为一个数
        Arrays.fill(array,-1);
        time = System.currentTimeMillis();
        System.out.println(f.fib_rember_search_byArray(n));
        System.out.println( System.currentTimeMillis() - time);
        Arrays.fill(array,-1);
        System.out.println(f.dfs(n,array));


    }

    /**
     * @Author WDF
     * @Description 使用Map进行记忆化搜索。
     * @Date 2021/3/12 13:27
     * @Param [n]
     * @return int
     **/
    public int fib_rember_search(int n){
        if (n <= 1){
            return n;
        }
        if (map.containsKey(n)){
            return map.get(n);
        }
        int left = fib_rember_search(n-1) % 1000000007;
        map.put(n -1,left);
        int right = fib_rember_search(n-2) % 1000000007;
        map.put(n - 2,right);
        map.put(n,((left + right) % 1000000007));
        return map.get(n);
    }

    /**
     * @Author WDF
     * @Description 使用int数组进行记忆化搜索。
     * @Date 2021/3/12 13:27
     * @Param [n]
     * @return int
     **/
    public int fib_rember_search_byArray(int n){
        if (n <= 1){
            return n;
        }
        if (array[n] != -1){
            return map.get(n);
        }
        int left = fib_rember_search(n-1);
        int right = fib_rember_search(n-2);
        array[n] = left + right;
        return left + right;
    }


    /**
     * @Author WDF
     * @Description leetcode上例子
     * @Date 2021/3/12 14:18
     * @Param [n, memo]
     * @return int
     **/
    private int dfs(int n, int[] memo) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        if (memo[n] != -1) {
            return memo[n];
        }
        int leftFib = dfs(n - 1, memo);
        int rightFib = dfs(n - 2, memo);

        memo[n] = leftFib + rightFib;

        return leftFib + rightFib;
    }


    /**
     * @Author WDF
     * @Description 青蛙跳台阶
     * @Date 2021/3/16 11:03
     * @Param [n]
     * @return int
     **/
    public int numWays(int n) {
        if(n == 0) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i < n + 1; i++){
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[n];
    }

}
