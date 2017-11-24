package main;

public class Main {

    public static void main(String[] args) {
        Sequence firstSequence = new Sequence(10);
        Sequence secondSequence = new Sequence(1, 2, 3);
        Sequence thirdSequence = new Sequence(1, 2, 3, 10, 0, 0);
        Sequence fourthSequence = new Sequence(2, 10, 0, 0, 1, 3);
        Sequence fifthSequence = new Sequence(10, 3, 1, 0, 2, 0);

        // test set method
        secondSequence.set(3, 10);

        System.out.println("Range Test: should be: 10 times 0");
        System.out.println(firstSequence);
        System.out.println();

        System.out.println("Set test: should be 1, 2, 3, 10, 0, 0");
        System.out.println(secondSequence);
        System.out.println();

        System.out.println("Equal Test 1: should be false");
        System.out.println(firstSequence.isEqual(secondSequence));
        System.out.println();

        System.out.println("Equal Test 1: should be false");
        System.out.println(secondSequence.isEqual(thirdSequence));
        System.out.println();

        System.out.println("Same values Test: should be true");
        System.out.println(thirdSequence.hasSameValues(fourthSequence));
        System.out.println();

        System.out.println("Permutation Test: should be true");
        System.out.println(fourthSequence.isPermutationOf(fifthSequence));
        System.out.println();

    }

}
