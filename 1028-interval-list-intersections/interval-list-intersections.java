class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        LinkedList<int[]> intersections=new LinkedList<>();

        int A=0,B=0;
        while(A<firstList.length && B<secondList.length){
            int mS=Math.max(firstList[A][0],secondList[B][0]);
            int mE=Math.min(firstList[A][1],secondList[B][1]);
           //checking if overlapped
           //let A-[1,3]  B[4,6]  then ms-4  mE=[3] [4,3] is not an intersection
            if(mS<=mE)
            intersections.add(new int[]{mS,mE});

            //incrementing Pointers , with which is less,
            //NOTE: not correct way
            //if(firstList[A][1]<=secondList[B][1])A++;
            //if(firstList[A][1]>=secondList[B][1])B++;
          
            //correct way
            if(firstList[A][1]<=mE)A++;
            if(mE>=secondList[B][1])B++;
        
        } 
        return intersections.toArray(new int[intersections.size()][2]);
    }
}