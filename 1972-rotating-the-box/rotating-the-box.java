class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m=box.length;
        int n=box[0].length;
        char ans[][]=new char[n][m];
        for(int i=0;i<m;i++){
            applyGravity(box[i]);
        }
       
        for(int i=0;i<m;i++){
         //   applyGravity(box[i]);
            for(int j=0;j<n;j++){
               // System.out.print(box[i][j]+" ");
                ans[j][i]=box[m-i-1][j];
            }
            //System.out.println();
        }
        return ans;
    }

    private void applyGravity(char box[]){
        int i=0,j=0;
        int n=box.length;
        while(j<n){
            int c=0;
           while(j<n && box[j]!='*'){
            if(box[j]=='#')
            c++;
            j++;
           }
           //System.out.println("Count "+c+" i "+i+" j "+j);
           while(j-i-c>0){
            box[i]='.';
            i++;
           }
            //System.out.println(" i "+i+" j "+j);
          
           while(i<j){
            box[i]='#';
            i++;
           }
           // System.out.println(" i "+i+" j "+j);
          
           while(j<n && box[j]=='*')
           j++;
           
           i=j;
          //System.out.println(" i "+i+" j "+j);
          
        }
    
    }
}