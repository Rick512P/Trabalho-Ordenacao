import jav.BubbleSort;
import jav.BucketSort;
import jav.CountingSort;
import jav.InsertionSort;
import jav.SelectionSort;
import jav.ShellSort;
import jav.HeapSort;
import jav.MergeSort;
import jav.QuickSort;
import jav.QuickSortDesc;
import jav.RadixSort;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] sizes = {10000, 100000}; // Tamanhos de vetor para teste

        for (int size : sizes) {
            System.out.println("\nTamanho do Vetor: " + size);

            // Para cada tamanho, gerar 30 vetores aleatórios
            Integer[][] randomArrays = new Integer[30][];
            for (int i = 0; i < 30; i++) {
                randomArrays[i] = generateRandomArray(size);
            }

            // Testar com vetores em ordem crescente
            System.out.println("\n=== Vetores em Ordem Crescente ===");
            testAllAlgorithmsWithAverage(randomArrays, true);

            // Testar com vetores em ordem decrescente
            System.out.println("\n=== Vetores em Ordem Decrescente ===");
            testAllAlgorithmsWithAverage(randomArrays, false);
        }
    }

    public static Integer[] generateRandomArray(int size) {
        Random random = new Random();
        Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(size);
        }
        return array;
    }

    public static <T extends Comparable<T>> void testAllAlgorithmsWithAverage(T[][] arrays, boolean ascending) {
        double bubbleSortTotalTime = 0, insertionSortTotalTime = 0, selectionSortTotalTime = 0;
        double shellSortTotalTime = 0, heapSortTotalTime = 0, mergeSortTotalTime = 0;
        double quickSortTotalTime = 0, countingSortTotalTime = 0, radixSortTotalTime = 0;
        double bucketSortTotalTime = 0;

        for (int i = 0; i < 30; i++) {
            T[] arrCopy = arrays[i].clone();
            if (ascending) {
                QuickSort.quickSort(arrCopy, 0, arrCopy.length - 1);
            } else {
                QuickSortDesc.quickSort(arrCopy, 0, arrCopy.length - 1);
            }

            bubbleSortTotalTime += testSortingAlgorithm("BubbleSort", arrCopy.clone());
            insertionSortTotalTime += testSortingAlgorithm("InsertionSort", arrCopy.clone());
            selectionSortTotalTime += testSortingAlgorithm("SelectionSort", arrCopy.clone());
            shellSortTotalTime += testSortingAlgorithm("ShellSort", arrCopy.clone());
            heapSortTotalTime += testSortingAlgorithm("HeapSort", arrCopy.clone());
            mergeSortTotalTime += testSortingAlgorithm("MergeSort", arrCopy.clone());
            quickSortTotalTime += testSortingAlgorithm("QuickSort", arrCopy.clone());
            countingSortTotalTime += testCountingSort((Integer[]) arrays[i].clone());  // Chamada específica para CountingSort
            radixSortTotalTime += testSortingAlgorithm("RadixSort", arrCopy.clone());
            bucketSortTotalTime += testSortingAlgorithm("BucketSort", arrCopy.clone());
        }

        System.out.printf("\nMédia para BubbleSort: %.4f segundos.%n", bubbleSortTotalTime / 30);
        System.out.printf("Média para InsertionSort: %.4f segundos.%n", insertionSortTotalTime / 30);
        System.out.printf("Média para SelectionSort: %.4f segundos.%n", selectionSortTotalTime / 30);
        System.out.printf("Média para ShellSort: %.4f segundos.%n", shellSortTotalTime / 30);
        System.out.printf("Média para HeapSort: %.4f segundos.%n", heapSortTotalTime / 30);
        System.out.printf("Média para MergeSort: %.4f segundos.%n", mergeSortTotalTime / 30);
        System.out.printf("Média para QuickSort: %.4f segundos.%n", quickSortTotalTime / 30);
        System.out.printf("Média para CountingSort: %.4f segundos.%n", countingSortTotalTime / 30);
        System.out.printf("Média para RadixSort: %.4f segundos.%n", radixSortTotalTime / 30);
        System.out.printf("Média para BucketSort: %.4f segundos.%n", bucketSortTotalTime / 30);
    }

    public static <T extends Comparable<T>> double testSortingAlgorithm(String algorithmName, T[] arr) {
        long startTime;
        long endTime;

        switch (algorithmName) {
            case "BubbleSort":
                startTime = System.nanoTime();
                BubbleSort.bubbleSort(arr);
                endTime = System.nanoTime();
                break;
            case "InsertionSort":
                startTime = System.nanoTime();
                InsertionSort.insertionSort(arr);
                endTime = System.nanoTime();
                break;
            case "SelectionSort":
                startTime = System.nanoTime();
                SelectionSort.selectionSort(arr);
                endTime = System.nanoTime();
                break;
            case "ShellSort":
                startTime = System.nanoTime();
                ShellSort.shellSort(arr);
                endTime = System.nanoTime();
                break;
            case "HeapSort":
                startTime = System.nanoTime();
                HeapSort.heapSort(arr);
                endTime = System.nanoTime();
                break;
            case "MergeSort":
                startTime = System.nanoTime();
                MergeSort.mergeSort(arr, 0, arr.length - 1);
                endTime = System.nanoTime();
                break;
            case "QuickSort":
                startTime = System.nanoTime();
                QuickSort.quickSort(arr, 0, arr.length - 1);
                endTime = System.nanoTime();
                break;
            case "RadixSort":
                startTime = System.nanoTime();
                RadixSort.radixSort(arr);
                endTime = System.nanoTime();
                break;
            case "BucketSort":
                startTime = System.nanoTime();
                BucketSort.bucketSort(arr);
                endTime = System.nanoTime();
                break;
            default:
                System.out.println("Algoritmo não encontrado.");
                return 0.0;
        }

        return (endTime - startTime) / 1_000_000_000.0;
    }

    public static double testCountingSort(Integer[] arr) {
        long startTime = System.nanoTime();
        CountingSort.countingSort(arr);
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1_000_000_000.0;
    }
}
