package linearalgebracalculator;

public class ElementaryRowOp {

        private Matrix E;
        private IdentityMatrix I;
        private int[][] e;
        private int numRows;
        private int numColumns;

        ElementaryRowOp() {
        	I = new IdentityMatrix();
        }

        ElementaryRowOp(Matrix M, String op) {
            numRows = M.getNumRows();
            numColumns = M.getNumColumns();
            I = new IdentityMatrix(numRows);
            E = new Matrix(I.getArray());
            e = E.getArray();
            ElementaryRowMatrix(numRows, numColumns, op); // sets e to the operation result
            E.setArray(e);
        }

        void ElementaryRowMatrix(int r, int c, String op) {
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
                Fraction coeff1 = new Fraction(firstCoeff);  // NEEDS FIXING, PARSE INT WILL LOSE THE FRACTION PRECISION
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

        Matrix getE() {
            return E;
        }

}
