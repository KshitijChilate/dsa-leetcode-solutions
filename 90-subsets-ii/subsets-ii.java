import java.util.*;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Step 1: sort to handle duplicates
        backtrack(0, nums, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int start, int[] nums, List<Integer> path, List<List<Integer>> result) {
        result.add(new ArrayList<>(path)); // add current subset
        
        for (int i = start; i < nums.length; i++) {
            // Step 2: skip duplicates
            if (i > start && nums[i] == nums[i - 1]) continue;
            
            path.add(nums[i]);                 // choose
            backtrack(i + 1, nums, path, result); // explore
            path.remove(path.size() - 1);      // un-choose (backtrack)
        }
    }
}