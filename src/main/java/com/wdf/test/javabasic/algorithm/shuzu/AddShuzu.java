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
        int[] nums = new int[]{1, 2, 3, 4};
        addShuzu.runningSum(new int[]{1, 2, 3, 4});
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



}
