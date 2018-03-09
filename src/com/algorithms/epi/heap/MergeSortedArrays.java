package com.algorithms.epi.heap;

import java.util.*;

public class MergeSortedArrays {
    public static void main(String[] args) {
        new MergeSortedArrays().execute();
    }

    public void execute() {
        List<Integer> list1 = new ArrayList<>();
        list1.add(3);
        list1.add(5);
        list1.add(7);


        List<Integer> list2 = new ArrayList<>();
        list2.add(0);
        list2.add(6);

        List<Integer> list3 = new ArrayList<>();
        list3.add(0);
        list3.add(6);
        list3.add(28);

        List<List<Integer>> sortedArrays = new ArrayList<>();
        sortedArrays.add(list1);
        sortedArrays.add(list2);
        sortedArrays.add(list3);

        List<Integer> results = mergeSortedArrays(sortedArrays);

        for (Integer result : results) {
            System.out.println(result);
        }
    }

    private static class ArrayEntry {
        public Integer value;
        public Integer arrayId;

        public ArrayEntry(Integer value, Integer arrayId) {
            this.value = value;
            this.arrayId = arrayId;
        }

        public Integer getValue() {
            return value;
        }
    }

    public List<Integer> mergeSortedArrays(List<List<Integer>> sortedArrays) {
        List<Iterator<Integer>> iters = new ArrayList<>();

        for (List<Integer> array : sortedArrays) {
            iters.add(array.iterator());
        }

        PriorityQueue<ArrayEntry> minHeap = new PriorityQueue<>(sortedArrays.size(), Comparator.comparingInt(ArrayEntry::getValue));

        for (int i = 0; i < iters.size(); i++) {
            if (iters.get(i).hasNext()) {
                minHeap.add(new ArrayEntry(iters.get(i).next(), i));
            }
        }

        List<Integer> results = new ArrayList<>();

        while(!minHeap.isEmpty()) {
            ArrayEntry arrayEntry = minHeap.poll();
            results.add(arrayEntry.value);

            if (iters.get(arrayEntry.arrayId).hasNext()) {
                minHeap.add(new ArrayEntry(iters.get(arrayEntry.arrayId).next(), arrayEntry.arrayId));
            }
        }

        return results;
    }
}
