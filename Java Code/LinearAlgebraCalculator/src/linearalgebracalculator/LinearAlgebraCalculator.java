

package linearalgebracalculator;

import java.util.Scanner;


public class LinearAlgebraCalculator {

    public static void main(String[] args) {

        //make rowsize and columnsize user inputted
        int rowSize = 3;
        int columnSize = 3;
        Fraction[][] temp = new Fraction[rowSize][columnSize];
        Scanner xd = new Scanner(System.in);
     
        for (int outer = 0; outer < rowSize; outer++) {
            for (int inner = 0; inner < columnSize; inner++) {
                temp[outer][inner] = new Fraction(xd.nextLine());
            }
        }
        
       /* int[] v = new int[columnSize];
        for(int i = 0; i < columnSize; i++){
            v[i] = xd.nextInt();
        }
        */
       //Fraction[][] b = new Fraction[rowSize][columnSize];
       //for (int outer = 0; outer < rowSize; outer++) {
        //    for (int inner = 0; inner < columnSize; inner++) {
       //         b[outer][inner] = new Fraction(xd.nextLine());
       //     }
       // }
       
        Array arr = new Array(temp);
        String tempo = arr.ELop("r1-5/2r2");
       System.out.println(tempo);
       // System.out.println(arr.MtimesMstring(b));
        /*
        Fraction three = new Fraction(3);
        Fraction fouroverfive = new Fraction("4/5");
        Fraction five = new Fraction(5);
        Fraction four = fouroverfive.multiply(five);
        System.out.println(four);
        */
   
    }

}
