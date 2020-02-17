package linearalgebracalculator;

public class MatrixMath {

    private int[][] arr;
    private Fraction[] vector;
    private Fraction[][] identity;
    private int columns;
    private int rows;
    private Fraction[][] fracArr;

    MatrixMath() {
        arr = null;
    }

    MatrixMath(int[][] arr) {
        this.arr = arr;
        rows = arr.length;
        columns = arr[0].length;
        setIdentity();
        fracArr = convertToFraction(arr);

       // System.out.println(toString(fracArr));

       //ElementaryRowOp test = new ElementaryRowOp(arr.length, arr[0].length, "3r1+r3");
       // System.out.println(toString(test.getE()));
    }
    
    MatrixMath(Fraction[][] fracArr){
        this.fracArr = fracArr;
        rows = fracArr.length;
        columns = fracArr[0].length;
        System.out.println(rows);
        System.out.println(columns);
        setIdentity();
    }

    Fraction [] convertToFraction(int[] a){
        Fraction[] frac = new Fraction[a.length];
        for(int column = 0; column< a.length;column++){
            frac[column] = new Fraction(a[column]);
        }
        return frac;
    }
    
    Fraction [][] convertToFraction(int [][] a){
        Fraction[][] frac = new Fraction[a.length][a[0].length];
        for(int r = 0; r<rows; r++){
            for(int c = 0; c<columns; c++){
                frac[r][c] = new Fraction(arr[r][c]);
            }
        }
        return frac;
    }
    
    String ELop(String operation){
        ElementaryRowOp op = new ElementaryRowOp(rows, columns, operation);
        return toString(op.getE());
    }
    
    Fraction [] MtimesV(int[] v) {
        Fraction [] f = convertToFraction(v);
        return MtimesV(f);
    }
    
    Fraction[] MtimesV(Fraction[] v){
        Fraction[] result = new Fraction[columns];
        for (int outer = 0; outer < rows; outer++) {
            Fraction sum = new Fraction(0);
            for (int inner = 0; inner < columns; inner++) {
                sum.add(new Fraction(arr[outer][inner]).multiply(v[inner]));
            }
            result[outer] = sum;
        }
        vector = v;
        System.out.println("[" + result[0] + ", " + result[1] + ", " + result[2] + "]");
        return result;
    }

    Fraction[][] MtimesM(int[][] m) {
        Fraction[][] f = convertToFraction(m);
        return MtimesM(f);
    }
    
    Fraction[][] MtimesM(Fraction[][] m){
        
        Fraction[][] result = new Fraction[m[0].length][m.length];
        System.out.println(toString(fracArr));
        System.out.println("times");
        System.out.println(toString(m));
        Fraction sum;
        for (int outer = 0; outer < m[0].length; outer++) { // outer iterates through columns
            for (int middle = 0; middle < fracArr[0].length; middle++) {
                sum = new Fraction(0);
                for (int inner = 0; inner < m.length; inner++) {
                    sum = sum.add(fracArr[middle][inner].multiply(m[inner][outer]));
                   // System.out.println(fracArr[middle][inner].multiply(m[inner][outer]));
                }
                result[middle][outer] = sum;
            }
        }
        return result;
    }
    
    Fraction[][] UpperTriangular(){
        return UpperTriangular(fracArr);
    }
    
    Fraction[][] UpperTriangular(Fraction[][] a){
        fracArr = a;
        
        
        
        return fracArr;
    }

    String getLinearCombination() {
        String s = "";
        for (int outer = 0; outer < columns; outer++) {
            s += vector[outer] + "[";
            for (int inner = 0; inner < rows; inner++) {
                s += arr[inner][outer] + ", ";
            }
            s = s.substring(0, s.length() - 2);
            s += "] ";
        }
        return s;
    }

    void setIdentity() {
        identity = new Fraction[rows][columns];
        for (int outer = 0; outer < rows; outer++) {
            for (int inner = 0; inner < columns; inner++) {
                if (inner == outer) {
                    identity[inner][outer] = new Fraction(1);
                } else {
                    identity[inner][outer] = new Fraction(0);
                }
            }
        }
    }

    Fraction[][] getIdentity() {
        return identity;
    }

    String getIdentityString() {
        return toString(identity);
    }

    public String toString() {
        String s = "";
        for (int[] row : arr) {

            for (int i : row) {
                s += (i + " ");
            }
            s += ("\n");
        }
        return s;
    }

    public String toString(Fraction[][] a) {
        String s = "";
        for (Fraction[] row : a) {

            for (Fraction i : row) {
                s += (i + " ");
            }
            s += ("\n");
        }
        return s;
    }

    public class ElementaryRowOp {

        private Fraction[][] e;
        private int rows;
        private int columns;

        ElementaryRowOp() {

        }

        ElementaryRowOp(int r, int c, String op) {
            rows = r;
            columns = c;
            Identity();
            e = identity;
            ElementaryRowMatrix(r, c, op);
        }

        void ElementaryRowMatrix(int r, int c, String op) {
            
            Fraction firstRowCo;
            Fraction secondRowCo;
            Fraction temp;
            int firstRindex = op.indexOf("r");
            int lastRindex = op.lastIndexOf("r");
            if (firstRindex == lastRindex) { // if operation only involves one row, then its multiplication
                String coeffS = op.substring(0, op.indexOf("r"));
                
                int rowNum = Integer.parseInt(op.substring(op.length() - 1))-1;
                firstRowCo = new Fraction(coeffS);
                for (int i = 0; i < e[rowNum].length; i++) {
                    temp = e[rowNum][i];
                    e[rowNum][i] = e[rowNum][i].multiply(firstRowCo);
                }

            } else { // if operation involves two rows
                String firstCoeff = op.substring(0, firstRindex);
                String secondCoeff;
                secondCoeff = op.substring(firstRindex+3, lastRindex);
                int co1;
                int co2;
                if (firstCoeff.length() == 0) {
                    firstRowCo = new Fraction(1);
                } else {
                     firstRowCo = new Fraction(firstCoeff);
                }
                if (secondCoeff.length() == 0) {
                    secondRowCo = new Fraction(1);
                } else {
                    secondRowCo = new Fraction(secondCoeff);
                }
                Fraction coeff1 = new Fraction(firstCoeff);
                Fraction coeff2 = new Fraction(secondCoeff);
                String operator = op.substring(op.indexOf("r")+2, op.indexOf("r")+3);
                int first = Integer.parseInt(op.substring(firstRindex + 1, firstRindex + 2)) - 1;
                int second = Integer.parseInt(op.substring(lastRindex + 1, lastRindex + 2)) - 1;
                for (int i = 0; i < e[0].length; i++) {
                    switch (operator) {
                        case ("+"):
                            e[first][i] = e[first][i].multiply(firstRowCo).add(e[second][i].multiply(secondRowCo));
                            break;
                        case ("-"):
                            e[first][i] = e[first][i].multiply(firstRowCo).subtract(e[second][i].multiply(secondRowCo));
                            break;
                        case ("*"):
                            e[first][i] =  e[first][i].multiply(firstRowCo).multiply(e[second][i].multiply(secondRowCo));
                            break;
                        case ("/"):
                            e[first][i] = e[first][i].multiply(firstRowCo).divide(e[second][i].multiply(secondRowCo));
                            break;
                        default: //swap
                            Fraction t = e[first][i];
                            e[first][i] = e[second][i];
                            e[second][i] = t;
                    }
                }
            }

        }

        Fraction[][] getE() {
            return e;
        }

        void Identity() {
            identity = new Fraction[rows][columns];
            for (int outer = 0; outer < rows; outer++) {
                for (int inner = 0; inner < columns; inner++) {
                    if (inner == outer) {
                        identity[inner][outer] = new Fraction(1);
                    } else {
                        identity[inner][outer] = new Fraction(0);
                    }
                }
            }
           // e = identity;
        }

    } 

}

 