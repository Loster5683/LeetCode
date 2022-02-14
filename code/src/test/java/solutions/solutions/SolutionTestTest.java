package solutions.solutions;

import org.junit.jupiter.api.Test;
import solutions.base.DataStructBuilder;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTestTest extends Solution {

    @Test
    void testTwoSum2() {
        System.out.println(Arrays.equals(twoSum2(DataStructBuilder.initIntArray("[2,3,4]"), 6), new int[]{0, 2}));
    }

    @Test
    void testCoinChange() {
        System.out.println(coinChange(DataStructBuilder.initIntArray("[186,419,83,408]"), 6249) == 20);
    }

    @Test
    void testLengthOfLIS2() {
        System.out.println(lengthOfLIS2(DataStructBuilder.initIntArray("[3,5,6,2,5,4,19,5,6,7,12]")) == 4);
    }

    @Test
    void testLengthOfLIS31() {
        System.out.println(lengthOfLIS3(DataStructBuilder.initIntArray("[10,9,2,5,3,7,101,18]")) == 4);
    }

    @Test
    void testPermute() {
        System.out.println(permute(DataStructBuilder.initIntArray("[1,2,3]")));
    }
}