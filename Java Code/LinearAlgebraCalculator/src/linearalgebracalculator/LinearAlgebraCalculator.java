

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
        int[] v = new int[columnSize];
        for(int i = 0; i < columnSize; i++){
            v[i] = xd.nextInt();
        }
        Array arr = new Array(temp);
        System.out.println(arr.identityString());
    }

}
