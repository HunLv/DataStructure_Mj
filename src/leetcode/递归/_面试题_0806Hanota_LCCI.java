package leetcode.递归;

import java.util.List;

/**
 * https://leetcode-cn.com/problems/hanota-lcci/
 * @create: 2020-08-19-21:06
 **/
public class _面试题_0806Hanota_LCCI {
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        hanota(A.size(),A,B,C);
    }

    /**
     *
     * @param problemScale 问题规模
     * @param A 盘子原位置
     * @param B 辅助盘
     * @param C 盘子目标位置
     */
    private void hanota(int problemScale,List<Integer> A, List<Integer> B, List<Integer> C) {
        if (problemScale == 1){
            // 直接 A->C
            C.add(A.remove(0));
            return;
        }
        // 将 A 划分为 两部分，最下面的那个为 一部分，上面其余的为一部分, B 作为 辅助盘， C 为目标盘,整体思考问题
        // (划分很重要,经过一次移动，最大的盘到达目的地，且新的局面与原来相似 —— 即划分后的问题性质不改变，如果划分不恰当，后序无法移动)
        // 1~N-1个盘 A->B  C 为辅助
        hanota(problemScale - 1,A,C,B);
        // 第 N 个盘 ，A->C
        C.add(A.remove(0));
        // 1-N-1 个盘，B->C  A 为辅助
        hanota(problemScale - 1,B,A,C);
    }
}
