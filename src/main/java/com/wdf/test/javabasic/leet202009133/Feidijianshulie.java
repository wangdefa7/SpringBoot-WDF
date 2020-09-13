package com.wdf.test.javabasic.leet202009133;

/**
 * 非递减数列
 */
public class Feidijianshulie {

    public static void main(String[] args) {
        Feidijianshulie a = new Feidijianshulie();
        int[] s = {4,2,3};
        System.out.println(a.checkPossibility(s));;
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
