package leetcode.字符串;

import java.util.HashSet;

/**
 * @description: 练习滑动窗口
 * @create: 2020-10-01-16:48
 * @finish:
 **/
public class _3_无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<Character>();
        int n = s.length();

        int rk = -1;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            // 模拟左指针
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }
            // 模拟右指针
            while (rk + 1 < n && !set.contains(s.charAt(rk + 1))) {
                set.add(s.charAt(rk + 1));
                rk++;
            }
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }
}
