package linearalgebracalculator;

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
