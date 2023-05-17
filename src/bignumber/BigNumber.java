package bignumber;

public interface BigNumber {
    //size
    int length();
    //negative number means shiftright()
    void shiftLeft(int shift);
    //negative number means shiftLeft()
    void shiftRight( int shift);

    // 5/3/1
    //addFDigit(9) exception the negative number means addFDigit(-6) && addFDigit(10)
    //-----
    //int 540
    void addDigit (int number);

    // 5/3/1
    //getDigitAt(0) means I should give you 1
    // no negative position && not more than the length();
    int getDigitAt(int position);
    //deep copy
    BigNumber copy();
    //returns the result of addition
    BigNumber add(BigNumber otherBigNumber);
    Node getHead();
    int compareTo(BigNumber bigNumber);


    void setHead(Node next);
    //void setPreve(Node next);
}
