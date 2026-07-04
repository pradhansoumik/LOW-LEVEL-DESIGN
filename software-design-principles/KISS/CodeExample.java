/**
 * Bad Code (Too Complex)
 */
class BadCode {

    public static boolean isEven(int number)
    {
        // Using unnecessary logic to determine evenness
        boolean isEven = false;

        if (number % 2 == 0)
        {
            isEven = true;
        }
        else
        {
            isEven = false;
        }

        return isEven;
    }
}

/**
 * Good Code (Simple and Clear)
 */
class GoodCode {

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
