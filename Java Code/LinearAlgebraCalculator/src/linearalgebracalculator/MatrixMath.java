package linearalgebracalculator;

public class MatrixMath {

    private Matrix m1;
    private Matrix m2;
    private int[] vector;
    private IdentityMatrix I;
    private Matrix E;
    private int numColumns;
    private int numRows;

    MatrixMath() {
        m1 = null;
    }

    MatrixMath(Matrix m1) {
        this.m1 = m1;
        numRows = m1.getArray().length;
        numColumns = m1.getArray()[0].length;
        if(numRows == numColumns) {
        	I = new IdentityMatrix(numRows);
        }
        ElementaryRowOp test = new ElementaryRowOp(m1, "3r1+r3");
        System.out.println(toString(test.getE()));
    }

    String getLinearCombination() { // might work??
        String s = "";
        for (int outer = 0; outer < numColumns; outer++) {
            s += vector[outer] + "[";
            for (int inner = 0; inner < numRows; inner++) {
                s += m1.getArray()[inner][outer] + ", ";
            }
            s = s.substring(0, s.length() - 2);
            s += "] ";
        }
        return s;
    }


    int[][] getIdentity() {
        return I.getArray();
    }

    String getIdentityString() {
        return toString(I.getArray());
    }

    public String toString() {
        String s = "";
        for (int[] row : m1.getArray()) {

            for (int i : row) {
                s += (i + " ");
            }
            s += ("\n");
        }
        return s;
    }

    public String toString(int[][] a) {
        String s = "";
        for (int[] row : a) {

            for (int i : row) {
                s += (i + " ");
            }
            s += ("\n");
        }
        return s;
    }
    
    public String toString(Matrix m) {
        String s = "";
        for (int[] row : m.getArray()) {

            for (int i : row) {
                s += (i + " ");
            }
            s += ("\n");
        }
        return s;
    }
    
    
    int [][] getIdentityArray(){
        return I.getArray();
    }
    
    void MtimesV() {
    	MtimesV(vector);
    }
    
    int [][] MtimesV(int[] v){
    	Multiplication mult = new Multiplication(m1);
        return mult.MtimesV(v);
    }
    
    int [][] MtimesM(){
        return MtimesM(m2);
    }
    
    int [][] MtimesM(Matrix m2){
        this.m2 = m2;
        Multiplication mult = new Multiplication(m1);
        return mult.MtimesM(m2);
    }
    
    String MtimesMString(){
    	Multiplication mult = new Multiplication(m1);
        return toString(mult.MtimesM(m2));
    }
    
    String MtimesMString(Matrix m2){
    	this.m2 = m2;
    	Multiplication mult = new Multiplication(m1);
        return toString(mult.MtimesM(m2));
    }
    
    Matrix ElRowOp(String op) {
    	return ElRowOp(m1, op);
    }
    
    Matrix ElRowOp(Matrix M, String op) {
    	ElementaryRowOp el = new ElementaryRowOp(M, op);
    	E = el.getE();
    	return E;
    }
    
    Matrix getElementaryMatrix() {
    	return E;
    }
    
    
    


}
