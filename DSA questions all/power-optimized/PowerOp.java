public class PowerOp {

    static int calcPower(int num,int pow) {
        if (pow == 0) {
            return 1;
        }

        if (pow % 2 == 0) {
            return calcPower(num, pow / 2) * calcPower(num, pow / 2);
        }
        else {
            return 2 * calcPower(num, pow / 2) * calcPower(num, pow / 2);
        }
    }
    public static void main(String args[]) {
        System.out.println(calcPower(2, 11));
    }
}