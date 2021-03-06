

package linearalgebracalculator;


public class Array {
   
    private int[][] identity;
    private int[][] arr;
    private int[][] arr2;
    private int[] vector;
    private int columns;
    private int rows;
    private MatrixMath math;
    
    public Array(){
        columns = 0;
        rows = 0;
    }
    
    public Array(int r, int c){
        arr = new int[r][c];
        rows = r;
        columns = c;
        math = new MatrixMath(arr);
        if(rows==columns){
        setIdentity();
        }
    }
    
    public Array(int[][] arr){
        this.arr = arr;
        rows = arr.length;
        columns = arr.length;
        math = new MatrixMath(arr);
        if(rows==columns){
        setIdentity();
        }
    }
    
    void addSecondArray(int [][] arr2){
        this.arr2 = arr2;
    }
    
    void setArray(int[][] arr){
        this.arr = arr;
        math = new MatrixMath(arr);
    }
    void setIdentity(){
        identity = new int[rows][columns];
        for(int outer = 0; outer < rows; outer++){
            for(int inner = 0; inner<columns; inner++){
                if(inner ==  outer){
                    identity[inner][outer] = 1;
                }else{
                    identity[inner][outer] = 0;
                }
            }
        }
    }
    
    int [][] Identity(){
        return identity;
    }
    
    String identityString(){
        return math.getIdentityString();
    }
    
    void MtimesV(){
        MtimesV(vector);
    }
    
    int [] MtimesV(int[] v){
        vector = v;
        return math.MtimesV(v);
    }
    
    void MtimesM(){
        MtimesM(arr2);
    }
    
    int [][] MtimesM(int [][] arr2){
        this.arr2 = arr2;
        return math.MtimesM(arr2);
    }
    
    String LinearCombination(){
        return math.getLinearCombination();
    }
    
    String MtimesMstring(int [][] arr2){
        this.arr2 = arr2;
        return MtimesMstring();
    }
    
    String MtimesMstring(){
        return math.toString(math.MtimesM(arr2));
    }
}
