class Solution { 
    static void combinationsFinder(int[] arr,int idx,int target,List<Integer> 
list,List<List<Integer>> ans){ 
        if(idx == arr.length){ 
            if(target==0){ 
                ans.add(new ArrayList<>(list)); 
            } 
            return; 
              
        } 
        if(arr[idx]<=target){ 
            list.add(arr[idx]); 
            combinationsFinder(arr,idx,target - arr[idx],list,ans); 
            list.remove(list.size() - 1); 
        } 
        combinationsFinder(arr,idx+1,target,list,ans); 
    } 
 
    public List<List<Integer>> combinationSum(int[] candidates, int target) { 
        List<List<Integer>> ans = new ArrayList<>(); 
         
        combinationsFinder(candidates,0,target,new ArrayList<>(),ans); 
         
        return ans; 
    } 
} 
 
