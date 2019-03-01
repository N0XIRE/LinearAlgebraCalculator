

package linearalgebracalculator;


public class Array {
   
    private Fraction[][] identity;
    private Fraction[][] arr;
    private Fraction[][] arr2;
    private Fraction[] vector;
    private int columns;
    private int rows;
    private MatrixMath math;
    
    public Array(){
        columns = 0;
        rows = 0;
    }
    
    public Array(int r, int c){
        arr = new Fraction[r][c];
        rows = r;
        columns = c;
        math = new MatrixMath(arr);
        if(rows==columns){
        setIdentity();
        }
    }
    
    
    public Array(Fraction[][] arr){
        this.arr = arr;
        rows = arr.length;
        columns = arr.length;
        math = new MatrixMath(arr);
        if(rows==columns){
        setIdentity();
        }
    }
    
    void addSecondArray(Fraction [][] arr2){
        this.arr2 = arr2;
    }
    
    void setArray(Fraction[][] arr){
        this.arr = arr;
        math = new MatrixMath(arr);
    }
    void setIdentity(){
        identity = new Fraction[rows][columns];
        for(int outer = 0; outer < rows; outer++){
            for(int inner = 0; inner<columns; inner++){
                if(inner ==  outer){
                    identity[inner][outer] = new Fraction(1);
                }else{
                    identity[inner][outer] = new Fraction(0);
                }
            }
        }
    }
    
    Fraction [][] Identity(){
        return identity;
    }
    
    String identityString(){
        return math.getIdentityString();
    }
    
    void MtimesV(){
        MtimesV(vector);
    }
    
    Fraction[] MtimesV(int[] v){
        vector = math.convertToFraction(v);
        return math.MtimesV(v);
    }
    
    Fraction[] MtimesV(Fraction[] v){
        vector = v;
        return math.MtimesV(v);
    }
    
    String ELop(String s){
        return math.ELop(s);
    }
    
    
    void MtimesM(){
        MtimesM(arr2);
    }
    
    Fraction [][] MtimesM(Fraction [][] arr2){
        this.arr2 = arr2;
        return math.MtimesM(arr2);
    }
    
    String LinearCombination(){
        return math.getLinearCombination();
    }
    
    String MtimesMstring(Fraction [][] arr2){
        this.arr2 = arr2;
        return MtimesMstring();
    }
    
    String MtimesMstring(){
        return math.toString(math.MtimesM(arr2));
    }
}
