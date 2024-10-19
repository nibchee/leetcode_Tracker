class Solution {
    public char findKthBit(int n, int k) {
      int nearest_n= (int)(Math.log(k) / Math.log(2))+1;
      int possible_size=(int)Math.pow(2,nearest_n);
     //System.out.println(nearest_n+" "+possible_size);
      char arr[]=new char[possible_size];
      arr[0]='0';
      int a=0;
      int i=0;
      while(i<k){
        int range1=(int)Math.pow(2,a);
        int range2=(int)Math.pow(2,a+1);
        for(i=range1;i<range2-1;i++){
          arr[i]=arr[range2-i]=='1'?'0':'1';
      //    System.out.print(arr[i]+" ");
        }
        arr[i]='1';
        a++;
      //  System.out.print(arr[i]+" ");
      }
         if(k==1) return '0';
         return arr[k];
    }
}