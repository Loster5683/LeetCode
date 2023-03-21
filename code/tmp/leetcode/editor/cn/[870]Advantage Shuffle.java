//You are given two integer arrays nums1 and nums2 both of the same length. The 
//advantage of nums1 with respect to nums2 is the number of indices i for which 
//nums1[i] > nums2[i]. 
//
// Return any permutation of nums1 that maximizes its advantage with respect to 
//nums2. 
//
// 
// Example 1: 
// Input: nums1 = [2,7,11,15], nums2 = [1,10,4,11]
//Output: [2,11,7,15]
// 
// Example 2: 
// Input: nums1 = [12,24,8,32], nums2 = [13,25,32,11]
//Output: [24,32,8,12]
// 
// 
// Constraints: 
//
// 
// 1 <= nums1.length <= 10⁵ 
// nums2.length == nums1.length 
// 0 <= nums1[i], nums2[i] <= 10⁹ 
// 
//
// Related Topics 贪心 数组 双指针 排序 👍 293 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int len = nums2.length;
        Integer [] sortIndex = new Integer[len];

        //LITTLE TIPS : get array sort index array;
        for (int i = 0; i < len; i++) {
            sortIndex[i] = i;
        }
        Arrays.sort(sortIndex, Comparator.comparingInt(i -> nums2[i]));
        Arrays.sort(nums1);
        int left = 0, right = len - 1;
        for (int num : nums1) {
            if (num > nums2[sortIndex[left]]) {
                nums2[sortIndex[left++]] = num;
            } else {
                nums2[sortIndex[right--]] = num;
            }
        }
        return nums2;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
