package com.wdf.test.javabasic.algorithm.shuzu;

/**
 * @ClassName: GetMaxAverage
 * @Author WDF
 * @Description 求成绩的平均最大值
 * @Date 2021/3/14 12:14
 * @Copyright Dareway 2021/3/14
 * @Version 1.0
 **/
public class GetMaxAverage {

    public static void main(String[] args) {
        /* 整数相除有小数时，用double进行转化否则会小数的丢失 */
        System.out.println((double)10/3);
        GetMaxAverage maxAverage = new GetMaxAverage();
        int[][] classes = {{1,2},{3,5},{2,2}};
        maxAverage.maxAverageRatio(classes,2);
    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        double[] array = new double[classes.length];
        double portion = 0.0d;
        double max = 0.0d;
        for(int i = 0; i < classes.length;i++){
            int[] inArray = classes[i];
            //通过人数 / 总人数
            System.out.println(inArray[0] / inArray[1]);
            portion = portion + array[i];
        }
        double temp ;
        for(int i = 0; i < classes.length;i++){
            temp = portion;
            int[] inArray = classes[i];
            //通过人数 / 总人数
            double d2 =(double)  (inArray[0] + extraStudents) / (extraStudents + inArray[1]);
            double d1 =(double)  inArray[0] / inArray[1];
            temp = temp - d1 + d2;
            double result = temp / classes.length;
            System.out.println(result);
            if(max <  result){
                max = result;
            }
        }
        return max;
    }
}
