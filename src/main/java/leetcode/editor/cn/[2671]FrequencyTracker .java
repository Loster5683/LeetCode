package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

class FrequencyTrackerDemo{
    public static void main(String[] args) {
        FrequencyTracker solution = new FrequencyTracker();
       BaseTest.baseTest(solution, "");
    }
static
//leetcode submit region begin(Prohibit modification and deletion)
class FrequencyTracker {

    Map<Integer, Integer> freq;
    Map<Integer, Integer> getFreq;
    public FrequencyTracker() {
        freq = new HashMap<>();
        getFreq = new HashMap<>();
    }
    
    public void add(int number) {
        freq.merge(number, 1, Integer::sum);
        getFreq.merge(freq.get(number), 1, Integer::sum);
        getFreq.merge(freq.get(number) - 1, -1, Integer::sum);

    }
    
    public void deleteOne(int number) {
        if (freq.getOrDefault(number, 0) > 0) {
            freq.merge(number, -1, Integer::sum);
            getFreq.merge(freq.get(number), 1, Integer::sum);
            getFreq.merge(freq.get(number) + 1, -1, Integer::sum);
        }
    }
    
    public boolean hasFrequency(int frequency) {
        return getFreq.getOrDefault(frequency, 0) > 0;
    }
}

/**
 * Your FrequencyTracker object will be instantiated and called as such:
 * FrequencyTracker obj = new FrequencyTracker();
 * obj.add(number);
 * obj.deleteOne(number);
 * boolean param_3 = obj.hasFrequency(frequency);
 */
//leetcode submit region end(Prohibit modification and deletion)

}