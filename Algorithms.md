**1.Two Sum**

若数组为有序则可以使用双指针解决，此题没有标明数组有序，我们使用HashMap存储数组元素value与index值

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int [] result = new int[2];
        HashMap<Integer,Integer>  m = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            if(m.containsKey(target-nums[i])){
                return new int [] {m.get(target-nums[i]),i};
            }
            else{
                m.put(nums[i],i);
            }
        }
        return result;
    }
    
}
```

对于每一个数，如果map.containsKey (target-num[i]) 则表示找到两个数的组合。

**2. Add Two Numbers**

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode s = new ListNode(0);
        ListNode t = s;
        int i=0,j=0,k=0,d=0,m=1;
        while(l1!=null || l2!= null){
            k = k/10;
            if(l1!=null){
                k += l1.val;
                l1 = l1.next;
            }
            if(l2!=null){
                k += l2.val;
                l2 = l2.next;
            }
            t.next = new ListNode( k%10 );
            t = t.next;
        }
        if(k/10==1){
            t.next = new ListNode(1);
        }
        return s.next;
    }
}
```

两个数均从低位开始加，对每一个数位进行与其进位进行计算。

**3. Longest Substring Without Repeating Characters**

标准的滑动窗口思想，两个指针均从左移动，保持i,j之间的段不含重复字符，右指针移动出现重复字符则移动左指针，找到最大的一个窗口。

```java
数组:
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }
}
HashMap:
import java.util.HashMap;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0){
            return 0;
        }
        HashMap<Character,Integer> h = new HashMap<Character,Integer>();
        int max = 0;
        for(int i=0,j=0;i<s.length();i++){
            if(h.containsKey(s.charAt(i))){
                j = Math.max(j,h.get(s.charAt(i))+1);
            }
            h.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);
        }
        return max; 
    }
}
```





