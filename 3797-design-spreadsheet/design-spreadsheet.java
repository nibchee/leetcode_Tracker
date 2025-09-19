class Spreadsheet {
    private int rows;
    private HashMap<String,Long> cells;

    public Spreadsheet(int rows) {
        this.rows=rows;
        this.cells=new HashMap<>();
    }
    
    public void setCell(String cell, int value) {
        Long val=(long)value;
        cells.put(cell,val);
        
    }
    
    public void resetCell(String cell) {
        cells.remove(cell);
    }
    
    public int getValue(String formula) {
        formula=formula.substring(1);
        String cellOrValues[]=formula.split("\\+");
         Long ans=0l;
        for(String val:cellOrValues){
           Long v=0l;
            if(val.charAt(0)>='A' && val.charAt(0)<='Z')
                v=cells.getOrDefault(val,0l);
            else 
                v=Long.parseLong(val);
            ans+=v;
        }
    return (int)(long)ans;
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */