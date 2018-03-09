package com.algorithms.standard.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FirstNameDuplicates {
    public static void main(String[] args) {
        new FirstNameDuplicates().execute();
    }

    public void execute() {
        List<Name> input = new ArrayList<>();
        input.add(new Name("Sunil", "Gavaskar"));
        input.add(new Name("Ian", "Chapel"));
        input.add(new Name("David", "Gower"));
        input.add(new Name("Ian", "Botham"));
        input.add(new Name("Sunil", "Botham"));

        List<Name> result = removeDuplicates(input);
        for (Name name : result) {
            System.out.println(name.firstName + "-" + name.lastName);
        }
    }

    public List<Name> removeDuplicates(List<Name> A) {
        Collections.sort(A);
        int writeIdx = 0;
        for (int i = 1; i < A.size(); i++) {
            if (!A.get(i).firstName.equals(A.get(writeIdx).firstName)) {
                A.set(++writeIdx, A.get(i));
            }
        }
        A.subList(++writeIdx, A.size()).clear();
        return A;
    }
}



class Name implements Comparable<Name> {
    String firstName;
    String lastName;

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public int compareTo(Name o) {
        int cmpFirst = firstName.compareTo(o.firstName);
        if (cmpFirst != 0) {
            return cmpFirst;
        }

        return lastName.compareTo(o.lastName);
    }
}
