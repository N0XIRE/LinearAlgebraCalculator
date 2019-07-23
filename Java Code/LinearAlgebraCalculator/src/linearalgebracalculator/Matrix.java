

package linearalgebracalculator;


public class Matrix {
   
    private int[][] m1;
    private int numColumns;
    private int numRows;
    private MatrixMath math;
    
    public Matrix(){
        numColumns = 0;
        numRows = 0;
        
    }
    
    public Matrix(int r, int c){
        m1 = new int[r][c];
        numRows = r;
        numColumns = c;
    }
    
    public Matrix(int[][] m1){
        this.m1 = m1;
        numRows = m1.length;
        numColumns = m1.length;
    }
    
    void setArray(int[][] m1){
        this.m1 = m1;
    }
    
    
    int[][] getArray(){
    	return m1;
    }
    
    int getNumRows() {
    	return numRows;
    }
    
    int getNumColumns() {
    	return numColumns;
    }
}
