package leetcode.code;

public class Compete20210117 {

    public static void main(String[] args) {
        Compete20210117 main = new Compete20210117();
        //int[][] rectangles = {{3,2},{2,3},{2,1},{3,2},{2,3},{3,2},{1,3},{2,1},{1,2},{3,2},{2,1},{1,2},{2,3},{3,1},{3,1},{3,1},{2,3},{3,1},{2,1},{2,1}};
        int[][] rectangles = {{5,8},{3,9},{5,12},{16,5}};
        System.out.println(main.countGoodRectangles(rectangles));;
    }

    public int countGoodRectangles(int[][] rectangles) {
        int count = 0;
        int max[] = new int[rectangles.length];
        for (int i = 0; i < rectangles.length; i++) {
            int[] rectangle = rectangles[i];
            if (rectangle[0]<rectangle[1]){
                max[i] = rectangle[0];
            }else {
                max[i] = rectangle[1];
            }
        }
        for (int i = 0; i < max.length; i++) {
            for (int j = i; j < max.length; j++ ){
                if (max[i] > max[j]){
                    int t = max[i];
                    max[i] = max[j];
                    max[j] = t;
                }
            }
        }

        int maxNum = max[max.length-1];
        for (int i = max.length-1; i>=0;i--){
            System.out.println(max[i]);
            if (maxNum != max[i]){
                break;
            }
            count++;
        }

        return count;
    }

}
