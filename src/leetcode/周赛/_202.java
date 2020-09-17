package leetcode.周赛;

/**
 * @description:
 * @create: 2020-08-16-10:48
 * @finish:
 **/
public class _202 {
    public boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;
        boolean ans = false;

        for (int i = 0; i < arr.length; i++) {

            if ((arr[i] & 1) != 1) {
                count = 0;
                continue;
            } else {
                count++;
            }
            if (count == 3) {
                ans = true;
                break;
            }
        }
        return ans;
    }

    public int minOperations(int n) {
        int ans = 0;
        int middle = 0;
        middle = ((n & 1) == 1) ? number(n / 2) : (number(n / 2) + number(n / 2 - 1)) / 2;


        for (int i = 1; i < middle; i+=2) {
            ans+= (middle - i);
        }
        return ans;
    }

    public int number(int i) {
        return (2 * i) + 1;
    }

    // TODO
    public int maxDistance(int[] position, int m) {
        return 0;
    }

    // TODO
    public int minDays(int n) {
        return 0;
    }
}
