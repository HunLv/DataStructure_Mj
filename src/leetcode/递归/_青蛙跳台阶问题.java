package leetcode.递归;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @description: 递归写法  + 用 map 存储计算过的结果，解决重复计算问题
 * @create: 2020-08-19-18:56
 **/
public class _青蛙跳台阶问题 {
    Map<Integer,Integer> map = new HashMap<>();

    public int numWays(int n) {
        if(n == 0 || n== 1) return 1;
        if(n == 2) return 2;

        // 如果计算过，就直接取出，反之计算
        if (map.containsKey(n)){
            return map.get(n);
        }else {
            int temp = (numWays(n-1)+numWays(n-2)) % 1000000007;
            map.put(n,temp);
            return temp;
        }
    }
}
