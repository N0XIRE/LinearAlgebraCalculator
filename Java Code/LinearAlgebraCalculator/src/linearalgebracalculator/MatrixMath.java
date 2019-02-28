package linearalgebracalculator;

public class MatrixMath {

    private int[][] arr;
    private int[] vector;
    private int[][] identity;
    private int columns;
    private int rows;

    MatrixMath() {
        arr = null;
    }

    MatrixMath(int[][] arr) {
        this.arr = arr;
        rows = arr.length;
        columns = arr[0].length;
        setIdentity();
        ElementaryRowOp test = new ElementaryRowOp(arr.length, arr[0].length, "3r1+r3");
        System.out.println(toString(test.getE()));
    }

    int[] MtimesV(int[] v) {
        int[] result = new int[columns];
        for (int outer = 0; outer < rows; outer++) {
            int sum = 0;
            for (int inner = 0; inner < columns; inner++) {
                sum += arr[outer][inner] * v[inner];
            }
            result[outer] = sum;
        }
        System.out.println("[" + result[0] + ", " + result[1] + ", " + result[2] + "]");
        vector = v;
        return result;
    }

    int[][] MtimesM(int[][] m) {
        int[][] result = new int[arr[0].length][m.length]; // size = c1 * r2
        System.out.println(toString(arr));
        System.out.println(toString(m));
        int sum;
        for (int outer = 0; outer < m[0].length; outer++) { // outer iterates through columns
            for (int middle = 0; middle < arr[0].length; middle++) {
                sum = 0;
                for (int inner = 0; inner < m.length; inner++) {
                    sum += arr[outer][inner] * m[inner][middle];
                }
                System.out.println(sum);
                result[outer][middle] = sum;
            }
        }
        return result;
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
        identity = new int[rows][columns];
        for (int outer = 0; outer < rows; outer++) {
            for (int inner = 0; inner < columns; inner++) {
                if (inner == outer) {
                    identity[inner][outer] = 1;
                } else {
                    identity[inner][outer] = 0;
                }
            }
        }
    }

    int[][] getIdentity() {
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

    public class ElementaryRowOp {

        private int[][] e;
        private int rows;
        private int columns;

        ElementaryRowOp() {

        }

        ElementaryRowOp(int r, int c, String op) {
            rows = r;
            columns = c;
            ElementaryRowMatrix(r, c, op);
        }

        void ElementaryRowMatrix(int r, int c, String op) {

            Identity();
            Fraction firstRow;
            Fraction secondRow;
            Fraction temp;
            int firstRindex = op.indexOf("r");
            int lastRindex = op.lastIndexOf("r");
            if (firstRindex == lastRindex) { // if operation only involves one row, then its multiplication
                String coeffS = op.substring(0, op.indexOf("r"));
                int coeff = Integer.parseInt(coeffS);
                int rowNum = Integer.parseInt(op.substring(op.length() - 1)) - 1;
                firstRow = new Fraction(coeffS);
                for (int i = 0; i < e[rowNum].length; i++) {
                    temp = new Fraction(e[rowNum][i]);
                    e[rowNum][i] = e[rowNum][i] * coeff;
                }

            } else { // if operation involves two rows
                String firstCoeff = op.substring(0, firstRindex);
                String secondCoeff;
                secondCoeff = op.substring(firstRindex+3, lastRindex);
                int co1;
                int co2;
                if (firstCoeff.length() == 0) {
                    co1 = 1;
                } else {
                    co1 = Integer.parseInt(firstCoeff);
                }
                if (secondCoeff.length() == 0) {
                    co2 = 1;
                } else {
                    co2 = Integer.parseInt(secondCoeff);
                }
                Fraction coeff1 = new Fraction(firstCoeff);
                Fraction coeff2 = new Fraction(secondCoeff);
                String operator = op.substring(op.indexOf("r")+2, op.indexOf("r")+3);
                int first = Integer.parseInt(op.substring(firstRindex + 1, firstRindex + 2)) - 1;
                int second = Integer.parseInt(op.substring(lastRindex + 1, lastRindex + 2)) - 1;
                for (int i = 0; i < e[0].length; i++) {
                    firstRow = new Fraction(e[first][i]);
                    secondRow = new Fraction(e[second][i]);
                    System.out.println(co1 + "   " + co2 + "   " + operator);
                    switch (operator) {
                        case ("+"):
                            e[first][i] = co1 * e[first][i] + co2 * e[second][i];
                            break;
                        case ("-"):
                            e[first][i] = co1 * e[first][i] - co2 * e[second][i];
                            break;
                        case ("*"):
                            e[first][i] = co1 * e[first][i] * co2 * e[second][i];
                            break;
                        case ("/"):
                            e[first][i] = co1 * e[first][i] / co2 * e[second][i];
                            break;
                        default: //swap
                            int t = e[first][i];
                            e[first][i] = e[second][i];
                            e[second][i] = t;
                    }
                }
            }

        }

        int[][] getE() {
            return e;
        }

        void Identity() {
            identity = new int[rows][columns];
            for (int outer = 0; outer < rows; outer++) {
                for (int inner = 0; inner < columns; inner++) {
                    if (inner == outer) {
                        identity[inner][outer] = 1;
                    } else {
                        identity[inner][outer] = 0;
                    }
                }
            }
            e = identity;
        }

    }

    public class Fraction {

        private int numerator;
        private int denominator;
        private int gcd;
        private int lcm;

        Fraction() {

        }

        Fraction(int num) {
            numerator = num;
            denominator = num;
        }

        Fraction(int numerator, int denominator) {
            this.numerator = numerator;
            this.denominator = denominator;
        }

        Fraction(String s) {
            if(s.length()==0){
                numerator = 1;
                denominator = 1;
                return;
            }
            if (s.contains("/")) {
                numerator = Integer.parseInt(s.substring(0, s.indexOf("/")));
                denominator = Integer.parseInt(s.substring(0, s.indexOf("/")));
            } else {
                numerator = Integer.parseInt(s);
                denominator = Integer.parseInt(s);
            }

        }

        Fraction add(Fraction f2) {

            if (denominator == f2.getDenom()) {
                Fraction result = new Fraction(numerator + f2.getNum(), denominator);
                return result;
            } else { // need to find lcm  lcm = ( denom1 * denom2 ) / gcd     use euclidian algorithim to find gcd
                if (denominator > f2.getDenom()) { // if denom1 is bigger
                    gcd = GCD(denominator, f2.getDenom());
                } else { /// if denom2 is bigger
                    gcd = GCD(f2.getDenom(), denominator);
                }
                lcm = (denominator * f2.getDenom()) / gcd;
                Fraction result = new Fraction(numerator * lcm + f2.getNum() * lcm, denominator * lcm + f2.getDenom() * lcm);
                return result;
            }
        }

        int GCD(int denom1, int denom2) {
            int remainder = denom1 % denom2;
            if (denom1 == 0 || denom2 == 0) {
                return denom1;
            }
            return GCD(denom2, remainder);
        }

        Fraction subtract(Fraction f2) {
            Fraction negative = new Fraction(-f2.getNum(), f2.getDenom());
            Fraction result = new Fraction(add(negative).getNum(), add(negative).getDenom());
            return result;
        }

        Fraction multiply(Fraction f2) {
            int num2 = f2.getNum();
            int denom2 = f2.getDenom();
            Fraction result = new Fraction(numerator * num2, denominator * denom2);
            return result;
        }

        Fraction divide(Fraction f2) {
            int num2 = f2.getNum();
            int denom2 = f2.getDenom();
            Fraction flipped = new Fraction(denom2, num2);
            Fraction result = multiply(f2);
            return result;
        }

        int getNum() {
            return numerator;
        }

        int getDenom() {
            return denominator;
        }

        public String toString() {
            return numerator + "/" + denominator;
        }

    }

}
