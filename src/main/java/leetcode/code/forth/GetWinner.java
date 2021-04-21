package leetcode.code.forth;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: GetWinner
 * @Author WDF
 * @Description 找到游戏的获胜者
 * @Date 2021/4/11 11:28
 * @Copyright Dareway 2021/4/11
 * @Version 1.0
 **/
public class GetWinner {

    public static void main(String[] args) {
        System.out.println(new GetWinner().findTheWinner(5,2));
    }

    public int findTheWinner(int n, int k) {
        //用一个Map存放淘汰的小伙伴
        Map map = new HashMap<Integer,Object>(n);
        int p = 0;
        while (map.size() <= n-1){
            //标记淘汰的一个小伙伴的下一个
            int num =  1;
            while(num <= k){
                int temp = (p + 1) % (n+1) ;
                temp = temp == 0 ? 1 : temp;
                //已经淘汰
                if(map.containsKey(temp)){
                    p = temp;
                    continue;
                }
                num++;
                //后移一位小伙伴
                p = temp;
            }
            //map的长度等于n-1
            if(map.size() == n-1){
                return p;
            }
            map.put(new Integer(p),null);
        }
        return p;
    }
}
