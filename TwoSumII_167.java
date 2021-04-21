package leetcode;

public class TwoSumII_167 {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        int[] res = new int[2];
        while(left < right)
        {
            if(numbers[left] + numbers[right] == target)
            {
                return new int[] {left + 1,right + 1};
            }
            else if(numbers[left] + numbers[right] < target)
            {
            	left ++;
            }
            else if(numbers[left] + numbers[right] > target)
            {
            	right --;
            }
        }
        return res;
    }
}
