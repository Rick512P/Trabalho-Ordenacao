package jav;

import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {

    public static void bucketSort(int[] arr) {
        int max = findMax(arr);
        int min = findMin(arr); // Encontra o menor valor para normalizar

        int numBuckets = (int) Math.sqrt(arr.length);
        ArrayList<Integer>[] buckets = new ArrayList[numBuckets];

        for (int i = 0; i < numBuckets; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Distribui os elementos nos buckets, ajustando para o intervalo correto
        for (int num : arr) {
            int bucketIndex = (num - min) * numBuckets / (max - min + 1);
            buckets[bucketIndex].add(num);
        }

        // Ordena cada bucket e concatena no array original
        int index = 0;
        for (ArrayList<Integer> bucket : buckets) {
            Collections.sort(bucket);
            for (int num : bucket) {
                arr[index++] = num;
            }
        }
    }

    private static int findMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) max = num;
        }
        return max;
    }

    private static int findMin(int[] arr) {
        int min = arr[0];
        for (int num : arr) {
            if (num < min) min = num;
        }
        return min;
    }
}
