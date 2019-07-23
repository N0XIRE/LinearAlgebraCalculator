package linearalgebracalculator;

public class IdentityMatrix {
	
	private int numRows;
	private int numColumns;
	private Matrix I;
	
	IdentityMatrix(){
		I = null;
	}
	
	IdentityMatrix(int size){
		I = new Matrix(size, size);
		numRows = size;
		numColumns = size;
		setIdentity();
	}
	
	void setIdentity(){
        for(int outer = 0; outer < numRows; outer++){
            for(int inner = 0; inner<numColumns; inner++){
                if(inner ==  outer){
                    I.getArray()[inner][outer] = 1;
                }else{
                    I.getArray()[inner][outer] = 0;
                }
            }
        }
    }
	
	int[][] getArray(){
		return I.getArray();
	}
}
