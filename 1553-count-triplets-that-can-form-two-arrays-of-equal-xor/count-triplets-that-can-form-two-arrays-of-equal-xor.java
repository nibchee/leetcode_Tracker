class Solution {
    public int countTriplets(int[] arr) {
        int n=arr.length;
        int xor[]=new int[n];
        xor[0]=arr[0];
        for(int i=1;i<n;i++)
        xor[i]=xor[i-1]^arr[i];
         int count=0;
        for(int i=0;i<n;i++){
            int x=(i>0)?xor[i-1]:0;
            for(int j=i+1;j<n;j++){
                //System.out.println(i+" "+j+" "+(xor[j]^x));
                if((xor[j]^x)==0)
                count+=(j-i);
            }
        }
    return count;
    }

}