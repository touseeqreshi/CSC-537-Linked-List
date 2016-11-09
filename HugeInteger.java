import java.util.Random;

public class HugeInteger
{
    private LinkedList intList;

    public HugeInteger()
    {
        this.intList = new LinkedList();
    }

    //Initiate a HugeInteger from a integer string
    public HugeInteger(String integers) throws Exception
    {
        this.intList = new LinkedList();
        String digitString = "0123456789";
        for (int i = 0; i < integers.length(); i++)
        {
            if (digitString.indexOf(integers.charAt(i)) < 0)
            {
                throw new Exception("This is not a legal integer string.");
            }
        }
        for (int i = 0; i < integers.length(); i++)
        {
            this.intList.addEnd(Character.getNumericValue(integers.charAt(i)));
        }
        this.removeFrontZero();
    }

    //initiate a new random HugeInteger with given digits number
    public HugeInteger(int digits) throws Exception
    {
        this.intList = new LinkedList();
        for (int i = 0; i < digits; i++)
        {
            this.intList.addFront(randInt(0, 9));
        }
        this.removeFrontZero();
    }

    public HugeInteger addHugeInteger(HugeInteger hugeInteger) throws Exception
    {
        HugeInteger result = new HugeInteger();
        HugeInteger hugeInteger1 = new HugeInteger(this.toString());
        HugeInteger hugeInteger2 = new HugeInteger(hugeInteger.toString());
        int count = (this.intList.length() > hugeInteger2.intList.length()) ? this.intList.length() : hugeInteger2.intList.length();
        int carry = 0;
        for (int i = 0; i < count; i++)
        {
            int currDigit1 = (hugeInteger1.intList.length() > 0) ? hugeInteger1.intList.removeEnd() : 0;

            int currDigit2 = (hugeInteger2.intList.length() > 0) ? hugeInteger2.intList.removeEnd() : 0;
            int currDigitResult = carry + currDigit1 + currDigit2;
            if (currDigitResult >= 10)
            {
                carry = 1;
                currDigitResult = currDigitResult - 10;
                result.intList.addFront(currDigitResult);
            } else {
                carry = 0;
                result.intList.addFront(currDigitResult);
            }
        }
        if (carry != 0)
        {
            result.intList.addFront(carry);
        }
        return result;
    }

    public void display() throws Exception
    {
        this.intList.display();
    }

    public String toString()
    {
        return this.intList.toString();
    }

    public static int randInt(int min, int max)
    {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) +min;
        return randomNum;
    }

    public void removeFrontZero() throws Exception
    {
        int front = this.intList.removeFront();
        while (front == 0)
        {
            front = this.intList.removeFront();
        }
        this.intList.addFront(front);
    }
}
