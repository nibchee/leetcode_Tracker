class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
      int students1=0;
      int students0=0;
      for(int i=0;i<students.length;i++){
        if(students[i]==0)
        students0++;
            if(students[i]==1)
        students1++;
        }

        for(int i=0;i<sandwiches.length;i++){
            if(sandwiches[i]==0){
                if(students0>0)
                students0--;
                else
                break;
            }else{
               if(students1>0)
                students1--;
                else
                break;  
            }
        }

      return students0+students1;
    }
}