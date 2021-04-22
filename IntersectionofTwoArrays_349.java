package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class IntersectionofTwoArrays_349 {
	 public int[] intersection(int[] nums1, int[] nums2) {
	       int len1 = nums1.length;
	       int len2 = nums2.length;
	       int[] res = new int[len1 + len2];
	       Arrays.parallelSort(nums1);
	       Arrays.parallelSort(nums2);
	       int index_1 = 0;
	       int index_2 = 0;
	       int index = 0;
	       while(index_1 != len1 && index_2 != len2)
	       {
	    	   if(nums1[index_1] == nums2[index_2])
	    	   {
	    		   if(index == 0 || nums1[index_1] != res[index - 1])
	    		   {
	    			   res[index] = nums1[index_1];
		    		   index ++;
	    		   }
	    		   index_1 ++;//注意此处
	    		   index_2 ++;//注意此处
	    	   }
	    	   else if(nums1[index_1] > nums2[index_2])
	    	   {
	    		   index_2 ++;
	    	   }
	    	   else if(nums2[index_2] > nums1[index_1])
	    	   {
	    		   index_1 ++;
	    	   }
	       }
	       return Arrays.copyOfRange(res, 0, index);
	 }
}
