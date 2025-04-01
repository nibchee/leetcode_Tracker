class Solution {
    public long mostPoints(int[][] questions) {
        long maxPoints[]=new long[questions.length];
        maxPoints[questions.length-1]=(long)getPoints(questions,questions.length-1);
        for(int i=questions.length-2;i>=0;i--){
            maxPoints[i]=Math.max(getPoints(questions,i)+getMaxPoints(maxPoints,i+getBrainPower(questions,i)+1),maxPoints[i+1]);
        }
     return maxPoints[0];
    }

    private long getMaxPoints(long[] maxPoints,int i){
        if(i>=maxPoints.length){
            return 0;
        }
        return maxPoints[i];
    }

    private int getPoints(int[][]questions,int i){
        return questions[i][0];
    }

    private int getBrainPower(int[][] questions,int i){
        return questions[i][1];
    }

}