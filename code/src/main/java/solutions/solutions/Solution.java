package solutions.solutions;

import org.omg.PortableInterceptor.INACTIVE;
import solutions.base.ListNode;

import java.util.*;

public class Solution {

    //1. Two Sum    use hashmap
    public int[] twoSum(int[] nums, int target) {
        int [] result = new int[2];
        HashMap<Integer, Integer>  m = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(m.containsKey(target - nums[i])){
                return new int [] {m.get(target - nums[i]), i};
            }
            else{
                m.put(nums[i], i);
            }
        }
        return result;
    }

    //1. Two Sum    use double pointer if array sorted
    public int[] twoSum2(int[] nums, int target) {
        int [] result = new int[2];
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum == target) {
                return new int[] {i, j};
            } else if (sum > target) {
                j--;
            } else {
                i++;
            }
        }
        return result;
    }


    //322. Coin Change  use dp with memo
    public int[] memo;
    public int coinChange(int[] coins, int amount) {
        memo = new int[amount + 1];
        Arrays.fill(memo, -2);
        return dp(coins, amount);
    }

    public int dp(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        if(amount < 0) {
            return -1;
        }

        if(memo[amount] != -2) {
            return memo[amount];
        }

        int value = Integer.MAX_VALUE;
        for(int coin : coins) {
            int sub = dp(coins, amount - coin);
            if (sub == -1) {
                continue;
            }
            value = Math.min(value, sub + 1);
        }
        memo[amount] = (value == Integer.MAX_VALUE) ? -1 : value;
        return memo[amount];
    }

    //300. Longest Increasing Subsequence  dp O(n^2)
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    //300. Longest Increasing Subsequence  贪心算法 O(nlogn)
    public int lengthOfLIS2(int[] nums) {
        List<Integer> list = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int index = Arrays.binarySearch(list.toArray(), 0, list.size(), nums[i]);
            if (index >= 0) {
                continue;
            } else if (-index - 1 < list.size()){
                list.set(-index - 1, nums[i]);
            } else {
                list.add(nums[i]);
            }
        }
        return list.size();
    }

    //300. Longest Increasing Subsequence  二分查找 O(nlogn)
    public int lengthOfLIS3(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        int len = 0;
        for(int num : nums) {

            int index = Arrays.binarySearch(dp, 0, len, num);

            if(index < 0) {
                index = -(index + 1);
            }

            dp[index] = num;

            if(index == len) {
                len++;
            }
        }

        return len;
    }

    //53. Maximum Subarray
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int dp0 = nums[0];
        int dp1 = 0;
        int res = dp0;
        for (int i = 1; i < nums.length; i++) {
            dp1 = Math.max(nums[i], dp0 + nums[i]);
            dp0 = dp1;
            res = Math.max(res, dp1);
        }
        return res;
    }

    //46. Permutations 回溯
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result= new LinkedList<>();
        int[] visited = new int[nums.length];
        pullback(result, nums, new LinkedList<>(), visited);
        return result;
    }

    public void pullback(List<List<Integer>> result, int[] nums, LinkedList<Integer> path, int[] visited) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            int node = nums[i];
            if (visited[i] == 1) {
                continue;
            }
            path.add(node);
            visited[i] = 1;
            pullback(result, nums, path, visited);
            visited[i] = 0;
            path.removeLast();
        }
    }

    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode curr = head;

        while (curr != null) {
            // At each iteration, we insert an element into the resulting list.
            ListNode prev = dummy;

            // find the position to insert the current node
            while (prev.next != null && prev.next.val < curr.val) {
                prev = prev.next;
            }

            ListNode next = curr.next;
            // insert the current node to the new list
            curr.next = prev.next;
            prev.next = curr;

            // moving on to the next iteration
            curr = next;
        }

        return dummy.next;
    }
}