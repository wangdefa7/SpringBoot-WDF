package com.wdf.test.javabasic.algorithm.shulie;

/**
 * 非递减数列
 */
public class Feidijianshulie {

    public static void main(String[] args) {
        Feidijianshulie a = new Feidijianshulie();
        int[] s = {4,2,3};
        System.out.println(a.checkPossibility2(s));
    }

    public boolean checkPossibility(int[] nums) {
        if(nums.length < 3) return true;
        int val = nums[0],sum = 0,p = 0;
            for (int i=0; i< nums.length-1;i++){
                if (nums[i] <= nums[i+1]){
                    continue;
                }else{
                    if (i-1 >0 && nums[i] < nums[i-2]){
                        nums[i] =nums[i-1];
                    }else {
                        nums[i+1] = nums[i];
                    }
                    sum++;
                    if (sum>1 ) return false;
                }
        }
        return true;
    }
    /**
     * @Author WDF
     * @Description 非递减数列，思路：将第一次排序中的数修改成合适的，如果二次还有还有说明超过了一个
     * @Date 2020/9/30 8:24
     * @Param [nums]
     * @return boolean
     **/
    public boolean checkPossibility2(int[] nums) {
        if(nums.length < 3) return true;
       // int val = nums[0],sum = 0,p = 0;
        for (int i=1; i< nums.length;i++){
            if (nums[i-1] <= nums[i]){
                continue;
            }else if (nums.length == i+1){
                return true;//一次到头
            }else{
                nums[i] = nums[i-1];//将违反的值修改
                break;
            }
        }
        for (int i=1; i< nums.length;i++){
            if (nums[i-1] <= nums[i]){
                continue;
            }else{
                return false;
            }
        }
        return true;
    }

    public boolean OneExzample(int[] nums){
        int cnt = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] > nums[i + 1]) {
                int tmp = nums[i];
                if(i >= 1) {
                    nums[i] = nums[i - 1];
                } else {
                    nums[i] = nums[i + 1];
                }
                if(nums[i] > nums[i + 1]) {
                    nums[i] = tmp;
                    nums[i + 1] = nums[i];
                }
                cnt++;
                if(cnt == 2) {
                    return false;
                }
            }
        }
        return true;
    }
}
