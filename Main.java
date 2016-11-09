public class Main {

    public static void main(String[] args) throws Exception
    {
        //add two integers from integer string
        HugeInteger num1 = new HugeInteger("1346123");
        System.out.println(num1.toString());

        System.out.println("+");

        HugeInteger num2 = new HugeInteger("44512");
        System.out.println(num2.toString());

        HugeInteger num3 = new HugeInteger();
        num3 = num1.addHugeInteger(num2);
        System.out.println("=");
        System.out.println(num3);

        System.out.println("");

        //add two random HugeIntegers
        HugeInteger num4 = new HugeInteger(21);
        HugeInteger num5 = new HugeInteger(25);
        HugeInteger num6 = num4.addHugeInteger(num5);
        System.out.println(num4);
        System.out.println("+");
        System.out.println(num5);
        System.out.println("=");
        System.out.println(num6);

    }
}
