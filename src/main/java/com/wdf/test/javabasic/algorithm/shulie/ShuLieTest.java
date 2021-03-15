package com.wdf.test.javabasic.algorithm.shulie;


public class ShuLieTest {

 public static void main(String[] args) {
  ShuLieTest a = new ShuLieTest();
  int[] s = {3,4,2,3};//{4,2,3};
  int[] s2 = {4,2,3};
  int[] s3 = {1,1,1};
  System.out.println(a.checkPossibility2(s3));
 }

 /**
  * @Author WDF
  * @Description 替换一个数变为递增数列
  * @Date 2020/9/12 16:38
  * @Param [nums]
  * @return boolean
  **/
 public boolean checkPossibility(int[] nums) {
  if(nums.length < 1) return false;
  if(nums.length <= 2) return true;
  int sum = 0,val=nums[0];
  boolean flag = true;
  for(int i=0;i<nums.length;i++){
   if(i+1 == nums.length) return true;
   if(nums[i] < nums[i+1] || val < nums[i+1]) {
    continue;
   }else{
    if(flag) val = nums[i]; flag =false;
    sum++;
    if(sum > 1) return false;
   }
  }
  return true;
 }

 public boolean checkPossibility2(int[] nums) {
  if(nums.length < 1) return false;
  if(nums.length <= 2) return true;
  int sum = 0,val=nums[0];
  for(int i=0;i<nums.length;i++){
   if(i+1 == nums.length) return true;
   if(nums[i] <= nums[i+1] ) {
    continue;
   }else{
    sum++;
    if(sum > 1) return false;
    if(i-1 >= 0){
     if (nums[i-1] > nums[i+1]) return  false;
    }
   }
  }
  return true;
 }
}
