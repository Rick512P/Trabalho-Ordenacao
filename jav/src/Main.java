import jav.BubbleSort;
import jav.BucketSort;
import jav.CountingSort;
import jav.InsertionSort;
import jav.SelectionSort;
import jav.ShellSort;
import jav.HeapSort;
import jav.MergeSort;
import jav.QuickSort;
import jav.RadixSort;

import java.util.Random;


public class Main {

    public static void main(String[] args) {
        int size = 10;
    	int[] originalArray = generateRandomArray(size);

        //System.out.println("Array antes da ordenação:");
        //printArray(originalArray);
        System.out.println();

        // Testando cada algoritmo de ordenação com medição de tempo
        System.out.println("Vetor Size:" + size);
        System.out.println(" ");

        testSortingAlgorithm("BubbleSort", originalArray.clone());
        testSortingAlgorithm("InsertionSort", originalArray.clone());
        testSortingAlgorithm("SelectionSort", originalArray.clone());
        testSortingAlgorithm("ShellSort", originalArray.clone());
        testSortingAlgorithm("HeapSort", originalArray.clone());
        testSortingAlgorithm("MergeSort", originalArray.clone());
        testSortingAlgorithm("QuickSort", originalArray.clone());
        testSortingAlgorithm("CountingSort", originalArray.clone());
        testSortingAlgorithm("RadixSort", originalArray.clone());
        testSortingAlgorithm("BucketSort", originalArray.clone());
    }

    public static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(size); // Gera números entre 0 e 999
        }
        return array;
    }
    
    public static void testSortingAlgorithm(String algorithmName, int[] arr) {
        long startTime = System.nanoTime(); // Inicia o cronômetro

        switch (algorithmName) {
            case "BubbleSort":
                System.out.println(algorithmName);
                BubbleSort.bubbleSort(arr);
                break;
            case "InsertionSort":
                System.out.println(algorithmName);
                InsertionSort.insertionSort(arr);
                break;
            case "SelectionSort":
                System.out.println(algorithmName);
                SelectionSort.selectionSort(arr);
                break;
            case "ShellSort":
                System.out.println(algorithmName);
                ShellSort.shellSort(arr);
                break;
            case "HeapSort":
                System.out.println(algorithmName);
                HeapSort.heapSort(arr);
                break;
            case "MergeSort":
                System.out.println(algorithmName);
                MergeSort.mergeSort(arr, 0, arr.length - 1);
                break;
            case "QuickSort":
                System.out.println(algorithmName);
                QuickSort.quickSort(arr, 0, arr.length - 1);
                break;

            case "CountingSort":
                System.out.println(algorithmName);
                CountingSort.countingSort(arr);
                break;
            case "RadixSort":
                System.out.println(algorithmName);
                RadixSort.radixSort(arr);
                break;
            case "BucketSort":
                System.out.println(algorithmName);
                BucketSort.bucketSort(arr);
                break;
            default:
                System.out.println("Algoritmo não encontrado.");
                return;
        }

        long endTime = System.nanoTime(); // Para o cronômetro
        double durationInSeconds = (endTime - startTime) / 1_000_000_000.0;

        System.out.printf("Ordenação Durou %.4f Segundos.%n", durationInSeconds);
        //System.out.println("Array após a ordenação com " + algorithmName + ":");
        printArray(arr);
        System.out.println();
    }

    public static void printArray(int[] arr) {
       /* for (int i : arr) {
            System.out.print(i + " ");
        }*/
        System.out.println();
    }
}
