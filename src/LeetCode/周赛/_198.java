package LeetCode.周赛;

/**
 * @description: 198 周赛
 * @create: 2020-07-19-11:38
 * @finish:
 **/
public class _198 {
    public int numWaterBottles_AC(int numBottles, int numExchange) {
        int ans = numBottles;

        while (numBottles >= numExchange) {
            ans = ans + numBottles / numExchange;
            numBottles = numBottles / numExchange + numBottles % numExchange;
        }

        return ans;
    }

//    public int[] countSubTrees(int n, int[][] edges, String labels) { }
//

//    public int closestToTarget(int[] arr, int target) {
//
//    }

    public static void main(String[] args) {
//        int[] test ={1,2,4,8,16};
        int[] test ={9,12,3,7,15};
        for (int i = 0; i < test.length; i++) {
            for (int j = i ; j < test.length; j++) {
                if (i <= j){
                    System.out.println(function(test,i,j));
                }

            }
        }

    }
    static int function(int[] arr, int l, int r) {
        if (r < 1) {
            return -1000000000;
        }
        int ans = arr[l];
        for (int i = l + 1; i <= r ; i++) {
            ans = ans & arr[i];
        }
        return ans;
    }
}
