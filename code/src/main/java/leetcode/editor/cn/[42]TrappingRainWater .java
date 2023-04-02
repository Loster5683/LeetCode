package leetcode.editor.cn;
class TrappingRainWater{
    public static void main(String[] args) {
       Solution solution = new TrappingRainWater().new Solution();
       BaseTest.baseTest(solution, "trap", "[4,2,0,3,2,5]");
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    //前缀最大值，后缀最大值 分开算
    //时间O(n) 空间O(n)
    public int trap2(int[] height) {
        int n = height.length;
        int[] premax = new int[n];
        int[] sufmax = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            premax[i] = Math.max(max, height[i]);
            max = premax[i];
        }
        max= 0;
        for (int i = n - 1; i >= 0; i--) {
            sufmax[i] = Math.max(max, height[i]);
            max = sufmax[i];
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            res += Math.min(premax[i], sufmax[i]) - height[i];
        }
        return res;
    }


    //利用前后缀关系提前计算
    public int trap(int[] height) {
        int n = height.length;
        int premax = 0;
        int sufmax = 0;
        int res = 0;
        int left = 0, right = n - 1;
        while (left <= right) {
            if (premax < sufmax) {
                premax = Math.max(premax, height[left]);
                res += premax - height[left];
                left++;
            } else {
                sufmax = Math.max(sufmax, height[right]);
                res += sufmax - height[right];
                right--;
            }
        }
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}