package linearalgebracalculator;

public class Multiplication {

		private int[]vector;
		private Matrix m1;
		private Matrix m2;
		
		Multiplication(Matrix m1){
			this.m1 = m1;
		}
	
		int[][] MtimesV(int[] v) {
	        int[][] result = new int[m1.getArray().length][1];
	        for (int outer = 0; outer < m1.getNumRows(); outer++) {
	            int sum = 0;
	            for (int inner = 0; inner < m1.getNumColumns(); inner++) {
	                sum += m1.getArray()[outer][inner] * v[inner];
	            }
	            result[outer][0] = sum;
	        }
	        System.out.println("[" + result[0][0] + ", " + result[1][0] + ", " + result[2][0] + "]");
	        vector = v;
	        return result;
	    }

	    int[][] MtimesM(Matrix M) {
	    	int [][] m = M.getArray();
	        int[][] result = new int[m1.getArray().length][m[0].length]; // size = r1 x c2
	        System.out.println(m1.getArray().toString());
	        System.out.println(m.toString());
	        int sum;
	        for (int outer = 0; outer < m[0].length; outer++) { // outer iterates through columns
	            for (int middle = 0; middle < m1.getArray()[0].length; middle++) {
	                sum = 0;
	                for (int inner = 0; inner < m.length; inner++) {
	                    sum += m1.getArray()[outer][inner] * m[inner][middle];
	                }
	                System.out.println(sum);
	                result[outer][middle] = sum;
	            }
	        }
	        return result;
	    }
	
}
