package bignumber;

import javax.print.attribute.standard.NumberOfDocuments;
import java.util.Iterator;

public class BigNumberImpl implements BigNumber {
//    private Node head;
//    private Node tail;
//    private int number;
//    private int size = 0;
    public Node head;

    @Override
    public Node getHead() {
        return head;
    }
    public void setHead(Node head) {
        this.head = head;
    }


//    public bignumber.BigNumberImpl( int number){
//        if(head != null){
//            shiftLeft(1);
//            bignumber.Node node = new bignumber.Node();
//            node.data=number;
//            node=tail;
//            tail=node;
//        }else{
//            bignumber.Node node= new bignumber.Node();
//            node.data=number;
//            head=node;
//        }
//    }

    //add to the front
    //1
    //2,1
    //nnumber= "123"
    //This class should have another constructor that takes a number as a
    // string and represents it. This constructor should throw an IllegalArgumentException
    // if the string passed to it does not represent a valid number.

    public BigNumberImpl(){
        Node node= new Node(0);
        head=node;

    }

    public BigNumberImpl(String input) throws IllegalArgumentException{
        head= new Node(0);
        int n= input.length();
        for(int i=0;i<n;i++){
            shiftLeft(1);
            if(input.charAt(i)<'0' || input.charAt(i)>'9'){
                throw new IllegalArgumentException("invalid number");
            }
            int current=input.charAt(i)-'0';
            addDigit(current);
        }

        //use the for loop and shifts methods
//        if (input == null || input.isBlank()) {
//            throw new IllegalArgumentException(" wrong input");
//        } else {
//            //12swe
//            if(head.data==0){
//
//            }
//            for (int i = 0; i < input.length(); i++) {
//                if (!Character.isDigit(input.charAt(i))) {
//                    System.out.println("from constructor method: char is " + input.charAt(i));
//                    throw new IllegalArgumentException(" it should be a string of number");
//                    //the first element in the List
//                    //00001
//                    //
//
//                }
//                else if (head == null) {
//                    Node node = new Node();
//                    node.data = input.charAt(i) - '0';
//                    //System.out.println("check i in the else if part: "+i+"  is  "+number.charAt(i));
//                    head = node;
//                    //the rest of the element in the List
//                } else {
//                    //Node tp;
//                    Node node = new Node();
//                    node.data = input.charAt(i) - '0';
//                    //tp=head;
//                    //tail=tp;
//                    node.next = head;
//                    //System.out.println("check i in the else: "+i+"  is  "+number.charAt(i));
//                    head = node;
//                }
//            }
//            head = reverse(head);
//        }
    }
    @Override
    //size
    public int length() {
        int count=0;
        Node traverse=head;
        while (traverse != null) {
            count++;
            traverse = traverse.next;
        }
        return count;
    }

    @Override
    //negative number means shiftright()
    //5,6,7

    public void shiftLeft(int shift) {
        if(shift==0){
            return;
        }
        //Node tp=head;
        if(shift<0){
            shiftRight(-shift);
            return;
        }
        //if(getHead().data==0 && getHead().next == null){
        if(head.data==0 && head.next==null){
            return;
        }
        while (shift !=0){
            Node newNode= new Node(0);
            shift--;
            newNode.next=head;
            head=newNode;
            head.next.prev=head;
        }
//        final int N=length();
//        if(N==1 && head.data==0){
//            return;
//        } else if(shift ==0){
//            return;
//        }
//        head=reverse(head);
//        if (shift > 0){
////            if(N==1){
////                return;
////            }
//            //if(head.data !=0){
//                for (int i = 0; i < shift; i++) {
//                    Node node = new Node();
//                    node.data=0;
//                    node.next=head;
//                    head = node;
//                }
//            //}
//            head=reverse(head);
//        } else {
//            shiftRight(-shift);
//        }
    }

    @Override
    //->
    //negative number means shiftLeft()
    //5,6,7 ,  ,shift=1; step 1
    //

    public void shiftRight(int shift) {
        if(shift==0){
            return;
        }
//        Node tp=head;
        if(shift<0){
            shiftLeft(-shift);
            return;
        }
        while (shift !=0 && head.next !=null){
            head=head.next;
            head.prev=null;
            shift--;
        }
        if(shift !=0){
            head.data=0;
        }
    }

//        if(shift==0 ){
//            return;
//        }
//        final int size=length();
//        if (shift > 0 && shift <= length()) {
//            Node traverse = head;
//            int step =0;
//            //int aq= length();
//            step=size - shift - 1;//3-1-1=1
//
//            int count = 0;
//            while (count < step ) {
//                traverse = traverse.next;
//                //int ali=traverse.data;
//                count++;
//            }
//            traverse.next = null;
//            tail = traverse;
//        } else if (shift > length()) {
//            //head=null;
//            head.data = 0;
//        } else {
//            shiftLeft(-shift);
//        }
//    }

    @Override
    //that takes a single digit as an argument and adds.
    // 5/3/1
    //addFDigit(9) exception the negative number means addFDigit(-6) && addFDigit(10)
    //-----
    //int 540
    public void addDigit(int number) {
        if (number < 0 || number > 9) {
            throw new IllegalArgumentException("you can not add negative or double digit number to the bignumber.BigNumber");
        }
        boolean carry =false;
        Node node=head;
        //int total=node.data+ number;
        node.data += number;
        //if(total>=10){
        if(node.data>=10){
            //total %=10;
            node.data%=10;
            carry=true;
        }
        while(carry){
            if(node.next ==null){
                node.next= new Node(0);
                node.next.next=node;
            }
            node=node.next;
            node.data +=1;
            if(node.data >=10){
                node.data %=10;
                carry=true;
            }else{
                carry=false;
            }
        }

//        else if(number ==0) {
//            return;
//        }else{
//            Node temp = null;
//            int sum = 0;
//            int carry = number;
//            //2,3,4,5 +  7
//            //2352
//            //12
//            head = reverse(head);
//            int test=head.data;
//            //5,4,3,2
//            Node copyhead = head;
//            while (copyhead != null) {
//                //Integer.parseInt(String.valueOf(head.data));
//                sum = carry + copyhead.data;
//                //System.out.println(sum+" sum this time");
//                carry = (sum >= 10) ? 1 : 0;
//                //System.out.println(carry+ "carry  this time");
//                sum = sum % 10;
//                //System.out.println("sum%10: "+sum);
//                copyhead.data = sum;
//                //System.out.println("\thead.data:  "+ copyhead.data);
//                temp = copyhead;
//                copyhead = copyhead.next;
//            }
//            if (carry > 0) {
//                int aa=temp.data;
//                temp.next = new Node(carry);
//            }
//        }
//        head = reverse(head);
        //tail=reverse(tail);
    }

    @Override
    //should start from right,if an invalid position is passed.?
    public int getDigitAt(int position) throws IllegalArgumentException {
        Node tp = head;
        while (position != 0) {
            if (tp == null) {
                throw new IllegalArgumentException("invalid position is passed");
            }
            tp = tp.next;
            position--;
        }
        return tp.data;
    }
//        if (position < 0 || position >= this.length()) {
//            throw new IllegalArgumentException("invalid position is passed");
//        } else {
//            head = reverse(head);
//            Node traverse = head;
//            //9:6,8:7,   7:8,      6:4,5:12,4:43,3:77,2:99,1:9
//            //size=9, want (6) means you need to pass 3 to get the one needed.;
//            int count = 0;
//            while (traverse != null) {
//                if (count == position) {
//                    return traverse.data;
//                }
//                count++;
//                traverse = traverse.next;
//            }
//            return -1;
//        }
//    }
    @Override
    public BigNumber copy() {
        Node dummyHead = new Node(-1);
        Node pointer = dummyHead;
        Node curr = head;

        while (curr != null){
            int value = curr.data;
            pointer.next = new Node(value);
            pointer = pointer.next;
            curr = curr.next;
        }
        Node temp = dummyHead.next;
        while (temp.next != null){
            Node prev = temp;
            temp = temp.next;
            temp.prev = prev;
        }
        BigNumber newCopy = new BigNumberImpl();
        newCopy.setHead(dummyHead.next);
        return newCopy;
    }
    private void setPreve(Node head){
        Node temp=head;
        while (temp.next !=null){
            Node prev=temp;
            temp=temp.next;
            temp.prev=prev;
        }

    }

//    @Override
//    //1,2,3,4,5
//    public BigNumber copy() {
//        Node dummyHead = new Node(-1);
//        Node copyTemp = dummyHead;
//        Node temp = head;
//        while (temp != null) {
//            copyTemp.next = new Node(temp.data);
//            copyTemp = copyTemp.next;
//            temp = temp.next;
//        }
//        BigNumber copyBigNum = new BigNumberImpl();
//        copyBigNum.setHead(dummyHead.next);
//        setPreve(dummyHead.next);
//        return copyBigNum;
//    }
//        if(head==null){
//            return null;
//        }
//        //head = reverse(head);
//        Node traverse = head;
//        BigNumber bigNumbCopy = null;
//        //5,4,3,2,1
//        bigNumbCopy = new BigNumberImpl(makeString(traverse));
//        return bigNumbCopy;
 //   }


    @Override
    public BigNumber add(BigNumber otherBigNumber) {

        Node dummy = new Node(-1);
        Node tp = dummy;
        Node tp1 = head;
        Node tp2 = otherBigNumber.getHead();
        boolean carry = false;
        while (tp1 != null && tp2 != null) {
            int sum = tp1.data + tp2.data;
            sum += carry ? 1 : 0;
            if (sum >= 10) {
                sum %= 10;
                carry = true;
            } else {
                carry = false;
            }
            tp.next = new Node(sum);
            tp = tp.next;
            tp1 = tp1.next;
            tp2 = tp2.next;
        }
        while (tp1 != null) {
            int nextData = tp1.data;
            if (carry) {
                nextData += 1;
            }
            if (nextData >= 10) {
                nextData %= 10;
                carry = true;
            } else {
                carry = false;
            }
            tp.next = new Node(nextData);
            tp = tp.next;
            tp1 = tp1.next;
        }
        while (tp2 != null) {
            int nextData = tp2.data;
            if (carry) {
                nextData += 1;
            }
            if (nextData >= 10) {
                nextData %= 10;
                carry = true;
            } else {
                carry = false;
            }
            tp.next = new Node(nextData);
            tp = tp.next;
            tp2 = tp2.next;
        }
        if (carry) {
            tp.next = new Node(1);
        }
        BigNumberImpl result = new BigNumberImpl();
        result.setHead(dummy.next);
        setPreve(dummy.next);

        return result;
    }


        //bignumber.Node resultHead =null;
//        Node resultIterator = null;
//        Node resultHead = null;
//
//        Node reverseHead;
//        reverseHead = reverse(head);
//        head = reverseHead;
//
//        Node second = reverse(otherBigNumber.getHead());
//        //System.out.println(" in the loop \t" + second.data);
//        Node p1 = head;
//        Node p2 = second;
//        boolean carry = false;
////        int sum=0;
//        while (p1 != null || p2 != null) {
//            int sum = 0;
//            if (p1 == null) {
//                sum += p2.data;
//                p2 = p2.next;
//            } else if (p2 == null) {
//                sum += p1.data;
//                p1 = p1.next;
//            } else {
//                sum += p1.data + p2.data;
//                p1 = p1.next;
//                p2 = p2.next;
//            }
//            if (carry) {
//                sum++;
//            }
//
//            if (sum >= 10) {
//                sum = sum % 10;
//                carry = true;
//            } else {
//                carry = false;
//            }
//
//            Node newNode = new Node(sum);
//            if (resultIterator == null) {
//                resultIterator = newNode;
//                resultHead = newNode;
//            } else {
//                resultIterator.next = newNode;
//                resultIterator = resultIterator.next;
//            }
//
//        }
//        if (carry) {
//            resultIterator.next = new Node(1);
//        }
//        //System.out.println("from add method here++++++");
//        //System.out.println("tostring of result-> " + makeString(resultHead));
//        resultHead = reverse(resultHead);
//
//        BigNumber lastResult = new BigNumberImpl(makeString(resultHead));
//        head=reverse(head);
//
//
//        return lastResult;
        //return otherBigNumber;

//    }


    // add node to the front
//    public Node addNode(int data) {
//        Node node = new Node();
//        node.data = data;
//        node.next = head;
//        head = node;
//        return node;
//    }
    //This class should include a toString method that returns a string representation of this number,
    // as simply the number itself.

    public String makeString(Node head) {
        //System.out.println("from toString in IMPL file ");

        Node current = head;
        String result = "";

        while (current != null) {
            // char to string
//          String result02=String.valueOf(trav.data);
            String num = String.valueOf(current.data);
            result = result + num;
//            if(current.next != null){
//                result += ", ";
//            }
            current = current.next;
        }
        return result;
    }

    public int compareTo(BigNumber bigNumber){
        int length=length();
        int otherLength=bigNumber.length();
        if(length<otherLength){
            return -1;
        }else if(length>otherLength){
            return 1;
        }
        Node tp=head;
        Node tpOther=bigNumber.getHead();
        while(tp.next !=null){
            tp=tp.next;
            tpOther=tpOther.next;
        }
        while (tp !=null){
            if(tp.data > tpOther.data){
                return 1;
            }else if(tp.data< tpOther.data){
                return -1;
            }else{
                tp=tp.prev;
                tpOther=tpOther.prev;
            }
        }
//        while (tp.next !=null && tpOther.next !=null){
//            tp=tp.next;
//            tpOther=tpOther.next;
//        }
//        while (tp !=null && tpOther !=null && tp.data==tpOther.data){
//            tp=tp.prev;
//            tpOther=tpOther.prev;
//        }
//        if(tp !=null && tpOther !=null){
//            if(tp.data<tpOther.data){
//                return -1;
//            }else{
//                return 1;
//            }
//        }else if(tp !=null){
//            return 1;
//        }else if(tpOther !=null){
//            return -1;
//        }else{
//            return 0;
//        }
//        //Node second=bigNumber.getHead();
//        Node otp=bigNumber.getHead();
//        otp=reverse(otp);
//        if(tp ==null && otp== null){
//            return 0;
//        }
//        if(length() > bigNumber.length()){
//            return 1;
//        }else if(length()< bigNumber.length()){
//            return -1;
//        }
//        else{
//            //542
//            //636
//            while( tp !=null && otp !=null ){
//                if(tp.data<otp.data){
//                    return -1;
//                }else if(tp.data>otp.data){
//                    return 1;
//                }else{
//                    //542
//                    //536
//                    tp=tp.next;
//                    otp=otp.next;
//                }
//            }
//        }
//
        return 0;
    }
    @Override
    public String toString() {
        //System.out.println("from toString in IMPL file ");
        StringBuilder result= new StringBuilder();
        Node temp=head;
        while (temp !=null){
            result.insert(0,temp.data);
            temp=temp.next;
        }
        return result.toString();

//        Node current = head;
//        String result = "";
//
//        while (current != null) {
//            // char to string
////          String result02=String.valueOf(trav.data);
//            String num = String.valueOf(current.data);
//            result = result + num;
////            if(current.next != null){
////                result += ", ";
////            }
//            current = current.next;
//        }
//        return result;
    }

    //head=list.reverse(head);
//    public Node reverse(Node head) {
//        Node prev = null;
//        Node current = head;
//        Node next = null;
//        while (current != null) {
//            next = current.next;
//            current.next = prev;
//            prev = current;
//            current = next;
//        }
//        head = prev;
//        return head;
//    }




    public static void main(String[] args) {
        BigNumberImpl ali= new BigNumberImpl("012345678");
        BigNumber tom= ali.copy();
        System.out.println(ali.toString());
        System.out.println(tom.toString());
        //System.out.println(tom.getDigitAt(0));
        //compareTo()
        //System.out.println(ali.compareTo(tom));
        ali.addDigit(0);
        ali.shiftLeft(2);
        //ali.getDigitAt(3);
        System.out.println(ali.getDigitAt(4)+" \t "+ali.toString());

        //System.out.println(ali.toString());
    }

}







