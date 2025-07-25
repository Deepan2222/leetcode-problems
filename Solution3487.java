/*
3487. Maximum Unique Subarray Sum After Deletion
Solved
Easy
Topics
premium lock icon
Companies
Hint
You are given an integer array nums.

You are allowed to delete any number of elements from nums without making it empty. After performing the deletions, select a subarray of nums such that:

All elements in the subarray are unique.
The sum of the elements in the subarray is maximized.
Return the maximum sum of such a subarray.

 

Example 1:

Input: nums = [1,2,3,4,5]

Output: 15

Explanation:

Select the entire array without deleting any element to obtain the maximum sum.

Example 2:

Input: nums = [1,1,0,1,1]

Output: 1

Explanation:

Delete the element nums[0] == 1, nums[1] == 1, nums[2] == 0, and nums[3] == 1. Select the entire array [1] to obtain the maximum sum.

Example 3:

Input: nums = [1,2,-1,-2,1,0,-1]

Output: 3

Explanation:

Delete the elements nums[2] == -1 and nums[3] == -2, and select the subarray [2, 1] from [1, 2, 1, 0, -1] to obtain the maximum sum.

 

Constraints:

1 <= nums.length <= 100
-100 <= nums[i] <= 100
*/

// ******** below two method of approach is there **********

// ---1.(Method Based Approach)-----


class Solution {
    // static   int nc=0;
    static int on(int[] num){
        int max=num[0];
         for(int i = 1; i < num.length; i++) {
            if (num[i] > max) {
                max = num[i];   
            }}
        return max;
    }
    static int mixed(int[] num){
        int max=Integer.MIN_VALUE;
        Set<Integer> s = new HashSet();
        for(int i=0;i<num.length;i++){
           if((num[i]>0) && (!s.contains(num[i]))){
                s.add(num[i]);}
            }
        int sum=0;
        for(int a:s){
           sum+=a;
        }
    return sum;    
    }
    public int maxSum(int[] nums) {
        int nv=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0){
              nv++;
            }

        }
    return nv==nums.length?on(nums):mixed(nums);
    }

}


// ---2.(optimized approach)-----

class Solution {
    public int maxSum(int[] nums) {
        int count =0;
        int max=Integer.MIN_VALUE;
        Set<Integer> s = new HashSet();
        for(int i=0;i<nums.length;i++){
           if((nums[i]>0) && (!s.contains(nums[i]))){
                s.add(nums[i]);
            }
           if ( nums[i]<0) {
               count++;
                max = Math.max(max,nums[i]);   
            }
        }
        int sum=0;
        for(int a:s){
           sum+=a;
        }
    return count==nums.length?max:sum;   
    }
}