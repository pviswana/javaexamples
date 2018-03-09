package com.algorithms.epi.heap;

import java.util.*;

public class FindKLongestStrings {
    public static void main(String[] args) {
        new FindKLongestStrings().execute();
    }

    public void execute() {
        List<String> stringList = new ArrayList<>();
        stringList.add("123456789");
        stringList.add("12345678");
        stringList.add("1234567");
        stringList.add("1234567890");
        stringList.add("12345678901");
        stringList.add("123456");
        stringList.add("123456789012345");

        List<String> results = topK(4, stringList);
        for (String result : results) {
            System.out.println(result);
        }
    }

    private ArrayList<String> topK(int k, List<String> stringList) {
        PriorityQueue<String> minHeap =
                new PriorityQueue<>(k, (String o1, String o2) ->
                        Integer.compare(o1.length(), o2.length()));

        Iterator<String> iterator = stringList.iterator();
        while(iterator.hasNext()) {
            minHeap.add(iterator.next());
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return new ArrayList<>(minHeap);
    }
}
