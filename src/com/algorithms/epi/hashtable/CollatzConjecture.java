package com.algorithms.epi.hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * Given any number the Collatz Conjecture is
 * - If the number is odd then multiply by 3 and add 1
 * - If the number is even, the divide the number by 2
 *
 * It can fail if the sequence returns to a previous computed number since it will go
 * into an infinite loop.
 */
public class CollatzConjecture {
    public static void main(String[] args) {
        new CollatzConjecture().execute();
    }

    private void execute() {
        int input = 19;
        boolean result = collatzConjecture(input);
        System.out.println(result);
    }

    private boolean collatzConjecture(int input) {
        // set of already verified number
        Set<Long> verifiedSet = new HashSet<>();

        for (int i = 3; i <= input; i += 2 ) {
            Set<Long> sequence = new HashSet<>();
            long testI = i;
            System.out.println(testI);

            while (testI >= i) {
                if (!sequence.add(testI)) {
                    return false;
                }

                if (testI % 2 != 0) {
                    if (!verifiedSet.add(testI)) {
                        System.out.println("Break out: " + testI);
                        break;
                    }
                    testI = testI * 3 + 1;
                } else {
                    testI /= 2;
                }
            }
        }
        return true;
    }
}
