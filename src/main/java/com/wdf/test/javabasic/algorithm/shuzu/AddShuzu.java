package com.wdf.test.javabasic.algorithm.shuzu;

/**
 * @ClassName: AddShuzu
 * @Author WDF
 * @Description 数组求和累加
 * @Date 2020/9/30 8:08
 * @Copyright Dareway 2020/9/30
 * @Version 1.0
 **/
public class AddShuzu {

    public static void main(String[] args) {
        AddShuzu addShuzu = new AddShuzu();
        System.out.println(6/4);
//        int[] nums = new int[]{1, 2, 3, 4};
//        addShuzu.runningSum(new int[]{1, 2, 3, 4});
        int[] nums2 = new int[]{10,20,30,5,10,50};
        System.out.println(maxAscendingSum(nums2));
    }

    /**
     * @Author WDF
     * @Description 给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
     * 请返回 nums 的动态和。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/running-sum-of-1d-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @Date 2020/9/30 8:09
     * @Param
     * @return
     **/

    public int[] runningSum(int[] nums) {
        if(nums.length <1) return new int[]{};
        int[] result = new int[nums.length];
        result[0] = nums[0];
        for(int i=1; i<nums.length; i++){
            result[i] = result[i-1]  + nums[i];
        }
        for(int i=0; i<nums.length; i++) {
            System.out.println(result[i]);
        }
        return result;
    }
    /**
     * @Author WDF
     * @Description 网上解法，在求和这一步，用了同一个数组而且更简单
     * @Date 2020/9/30 8:18
     * @Param [nums]
     * @return int[]
     **/
    public int[] runningSum2(int[] nums) {
        int len = nums.length;
        if(len == 0){
            return nums;
        }
        for(int i=1;i < len;i++){
            nums[i]+=nums[i-1];
        }
        return nums;
    }

    /**
     * 给你一个正整数组成的数组 nums ，返回 nums 中一个 升序 子数组的最大可能元素和。
     *
     * 子数组是数组中的一个连续数字序列。
     *
     * 已知子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，若对所有 i（l <= i < r），numsi < numsi+1 都成立，则称这一子数组为 升序 子数组。注意，大小为 1 的子数组也视作 升序 子数组。
     *
      * 考虑到 1223 这种情况也不属于升序，因为2重复了
      **/
    public static int maxAscendingSum(int[] nums) {
        //int[] sum = new int[nums.length];
        int start = 0;
        int end = 0;
        int max = nums[0];
        int temp = 0;
        for(int i = 0; i < nums.length ; i++){
            if(i == nums.length - 1 || nums[i] >= nums[i+1]){
                end = i;
                while(start <= end){
                    temp = temp + nums[start++];
                }
                if(max < temp){
                    max = temp;
                }
                start = end +1;
                //end = 0;
                temp = 0;
            }
        }
        return max;
    }


}
