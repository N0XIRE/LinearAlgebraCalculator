

package linearalgebracalculator;


public class MatrixMath {
    
    private int[][] arr;
    private int[] vector;
    private int[][] arr2;
    private int[][] identity;
    private int columns;
    private int rows;
    
    MatrixMath(){
        arr = null;
    }
    
    MatrixMath(int[][] arr){
        this.arr = arr;
        rows = arr.length;
        columns = arr[0].length;
        setIdentity();
    }
    
    int[] MtimesV(int[] v){
        int[] result = new int[columns];
        for(int outer = 0; outer<rows; outer++){
            int sum = 0;
            for(int inner = 0; inner<columns; inner++){
                sum+= arr[outer][inner] * v[inner];
            }
            result[outer] = sum;
        }
        System.out.println("[" + result[0] + ", " + result[1] + ", " + result[2] + "]");
        vector = v;
        return result;
    }
    
    String getLinearCombination(){
        String s = "";
        for(int outer = 0; outer < columns; outer++){
            s += vector[outer] + "[";
            for(int inner = 0; inner < rows; inner ++){
                s += arr[inner][outer] + ", ";
            }
            s = s.substring(0,s.length()-2);
            s += "] ";
        }
        return s;
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
    
    int [][] getIdentity(){
        return identity;
    }
    
    String getIdentityString(){
        return toString(identity);
    }
    
    public String toString(){
       String s = "";
               for(int[] row : arr){
                   
                   for(int i: row){
                     s+=(i + " ");  
                   }
                   s+=("\n");
               }
       return s;
    }
    
    public String toString(int[][] a){
        String s = "";
            for(int[] row : a){
                   
                   for(int i: row){
                     s+=(i + " ");  
                   }
                   s+=("\n");
               }
        return s;
    }

}
