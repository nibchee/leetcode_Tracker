class Solution {
    public int findTheWinner(int n, int k) {
        List<Integer> friends = new LinkedList<Integer>();
        for (int i = 1; i <= n; i++) {
            friends.add(i);
        }

        int i=0;
        while (friends.size()!=1){
            int  killedFriendPos = (i+k-1) % friends.size();
            friends.remove(killedFriendPos);
            i =killedFriendPos ;
        }

        return friends.get(0);
    }
}