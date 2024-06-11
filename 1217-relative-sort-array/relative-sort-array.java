class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        TreeMap<Integer,Integer> m=new TreeMap<>();
        for(int i=0;i<arr1.length;i++){
            if(m.containsKey(arr1[i])){
                m.put(arr1[i],m.get(arr1[i])+1); 
            }else{
                m.put(arr1[i],1);
            }
        }

       int k=0;
        for(int i=0;i<arr2.length;i++){
            for(int j=0;j<m.get(arr2[i]);j++){
                arr1[k++]=arr2[i];
            }
            m.remove(arr2[i]);
        }
    if(m.size()>0){
        for(Map.Entry<Integer,Integer> entry:m.entrySet()){
            int v=entry.getKey();
            for(int i=0;i<entry.getValue();i++){
                arr1[k++]=v;
            }
        }
    }

    return arr1;
    }
}