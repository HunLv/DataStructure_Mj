package leetcode.周赛;

import java.util.TreeMap;

/**
 * @description: 199 周赛
 * @create: 2020-07-26-10:32
 * @finish:
 **/
public class _199 {
    public String restoreString(String s, int[] indices) {
        TreeMap<Integer,Character> map = new TreeMap<>();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < indices.length ; i++) {
            map.put(indices[i],s.charAt(i));
        }

        for (Integer key:map.keySet()){
            buffer.append(map.get(key));
        }

        return buffer.toString();
    }

//    public int minFlips(String target) {
//    }

}
