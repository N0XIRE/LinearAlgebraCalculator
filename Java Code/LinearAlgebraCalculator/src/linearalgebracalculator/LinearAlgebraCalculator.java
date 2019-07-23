

package linearalgebracalculator;

import java.util.Scanner;


public class LinearAlgebraCalculator {

    public static void main(String[] args) {

        //make rowsize and columnsize user inputted
        int rowSize = 3;
        int columnSize = 3;
        int[][] temp = new int[rowSize][columnSize];
        Scanner xd = new Scanner(System.in);
        for (int outer = 0; outer < rowSize; outer++) {
            for (int inner = 0; inner < columnSize; inner++) {
                temp[outer][inner] = xd.nextInt();
            }
        }
        
       /* int[] v = new int[columnSize];
        for(int i = 0; i < columnSize; i++){
            v[i] = xd.nextInt();
        }
        */
       int[][] b = new int[3][3];
       for (int outer = 0; outer < rowSize; outer++) {
            for (int inner = 0; inner < columnSize; inner++) {
                b[outer][inner] = xd.nextInt();
            }
        }
       
        Matrix m1 = new Matrix(temp);
        Matrix m2 = new Matrix(b);
        MatrixMath math = new MatrixMath(m1);
        System.out.println(math.MtimesMString(m2));
    }

}
