class Solution {
    int maxTime = 0;

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        ArrayList<ArrayList<Integer>> emp = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            emp.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            if(manager[i]==-1)
            continue;
            emp.get(manager[i]).add(i);
        }
        //System.out.println(emp.toString());
        dfs(headID, 0, informTime, emp);
        return maxTime;
    }

    private void dfs(int node, int time, int[] informTime, ArrayList<ArrayList<Integer>> emp) {
        if (emp.get(node).size() == 0) {
            maxTime = Math.max(maxTime, time);
            return;
        }

        for (int i = 0; i < emp.get(node).size(); i++) {
            int empId = emp.get(node).get(i);
            dfs(empId, time + informTime[node], informTime, emp);
        }
    }
}