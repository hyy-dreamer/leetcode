package leetcode;

public class FindFirstandLastinSortedArray {
	 public int[] searchRange(int[] nums, int target) {
	        if (nums.length == 0) {
	            return new int[]{-1, -1};
	        }
	        int firstPosition = findFirstPosition(nums, target);
	        if (firstPosition == -1) {
	            return new int[]{-1, -1};
	        }
	        int lastPosition = findLastPosition(nums, target);
	        return new int[]{firstPosition, lastPosition};
	    }


	    private int findFirstPosition(int[] nums, int target) {
	        int left = 0;
	        int right = nums.length - 1;

	        while (left <= right) {
	            int mid = left + (right - left) / 2;
	            if (nums[mid] == target) {
	                // �� ������ֱ�ӷ��أ�Ӧ�ü���������ң��� [left, mid - 1] ��������
	                right = mid - 1;
	            } else if (nums[mid] < target) {
	                // Ӧ�ü������ұ��ң��� [mid + 1, right] ��������
	                left = mid + 1;
	            } else {
	                // ��ʱ nums[mid] > target��Ӧ�ü���������ң��� [left, mid - 1] ��������
	                right = mid - 1;
	            }
	        }

	        // ��ʱ left �� right ��λ�ù�ϵ�� [right, left]��ע������� �٣���ʱ left ���ǵ� 1 ��Ԫ�س��ֵ�λ��
	        // ��˻���Ҫ�ر���һ���ж�
	        if (left != nums.length && nums[left] == target) {
	            return left;
	        }
	        return -1;
	    }

	    private int findLastPosition(int[] nums, int target) {
	        int left = 0;
	        int right = nums.length - 1;
	        while (left <= right) {
	            int mid = left + (right - left) / 2;
	            if (nums[mid] == target) {
	                // ֻ�����ﲻһ����������ֱ�ӷ��أ�Ӧ�ü������ұ��ң��� [mid + 1, right] ��������
	                left = mid + 1;
	            } else if (nums[mid] < target) {
	                // Ӧ�ü������ұ��ң��� [mid + 1, right] ��������
	                left = mid + 1;
	            } else {
	                // ��ʱ nums[mid] > target��Ӧ�ü���������ң��� [left, mid - 1] ��������
	                right = mid - 1;
	            }
	        }
	        // ���� findFirstPosition �������Է����Ƿ��ҵ����������赥�������ж�
	        return right;
	    }

}
