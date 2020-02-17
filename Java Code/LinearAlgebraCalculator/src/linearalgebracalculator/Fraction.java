

package linearalgebracalculator;


 public class Fraction {

        private int numerator;
        private int denominator;
        private int gcd;
        private int lcm;

        Fraction() {

        }

        Fraction(int num) {
            if(num==0){
                numerator = 0;
                denominator = 1;
            }else{
            numerator = num;
            denominator = 1;
            }
        }

        Fraction(int numerator, int denominator) {
            if(denominator == 0){
               System.out.println("figure out how to throw error");
            }else{
            this.numerator = numerator;
            this.denominator = denominator;
            }
        }

        Fraction(String s) {
            if(s.length()==0){
                numerator = 1;
                denominator = 1;
                return;
            }
            if (s.contains("/")) {
                System.out.println("CONTAINS");
                numerator = Integer.parseInt(s.substring(0, s.indexOf("/")));
                denominator = Integer.parseInt(s.substring(s.indexOf("/")+1));
                System.out.println("numerator:" + numerator + "denominator" + denominator);
            } else {
                numerator = Integer.parseInt(s);
                denominator = 1;
            }

        }

        Fraction add(Fraction f2) {

            if (denominator == f2.getDenom()) {
                Fraction result = new Fraction(numerator + f2.getNum(), denominator);
               // System.out.println(result);
                return result;
            } else { // need to find lcm  lcm = ( denom1 * denom2 ) / gcd     use euclidian algorithim to find gcd
                 gcd = GCD(denominator, f2.getDenom());
                lcm = (denominator * f2.getDenom()) / gcd;
                Fraction result = new Fraction(numerator * (lcm/denominator) + f2.getNum() * (lcm/f2.getDenom()), lcm);
                return result;
            }
        }

        int GCD(int denom1, int denom2) {
            if (denom1 == 0) {
                return denom2;
            }
            return GCD(denom2%denom1, denom1);
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
        
        Fraction multiply(int x){
            Fraction result = new Fraction(numerator*x, denominator);
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
            if(denominator == 1 ){
                return "" + numerator;
            }else if(numerator == denominator){
                return "" + 1;
            }else if(numerator%denominator==0){
                return "" + numerator/denominator;
            }
            return numerator + "/" + denominator;
        }

    }
