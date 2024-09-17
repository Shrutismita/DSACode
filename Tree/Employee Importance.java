Q:- https://leetcode.com/problems/employee-importance/

T.C:- O(n)
S.C:- O(n)

 ====================================================================================================
  
class Solution {
    static int dfs(Map<Integer, Employee> inputMap, int id)
    {
        int imp = inputMap.get(id).importance;
        for(int subId : inputMap.get(id).subordinates)
        {
            imp += dfs(inputMap,subId);
        }
        return imp;
    }
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> inputMap = new HashMap<>();
        for(Employee e : employees)
        {
            inputMap.put(e.id,e);
        }
        return dfs(inputMap,id);
    }
}
