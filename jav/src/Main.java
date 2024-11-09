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
    private static double totalTime = 0.0; // Variável global para acumular o tempo

    public static void main(String[] args) {
        // Expoentes de 10¹ até 10⁶
        int[] sizes = {100, 1000, 10000, 100000, 1000000};

        for (int size : sizes) {
            System.out.println("\nTamanho do Vetor: " + size);

            // Gera 30 vetores diferentes para o tamanho especificado
            int[][] arrays = new int[30][];
            for (int i = 0; i < 30; i++) {
                arrays[i] = generateRandomArray(size);
            }

            // Testa cada algoritmo de ordenação 30 vezes com vetores clonados
            testAlgorithmMultipleRuns("BubbleSort", arrays);
            testAlgorithmMultipleRuns("InsertionSort", arrays);
            testAlgorithmMultipleRuns("SelectionSort", arrays);
            testAlgorithmMultipleRuns("ShellSort", arrays);
            testAlgorithmMultipleRuns("HeapSort", arrays);
            testAlgorithmMultipleRuns("MergeSort", arrays);
            testAlgorithmMultipleRuns("QuickSort", arrays);
            testAlgorithmMultipleRuns("CountingSort", arrays);
            testAlgorithmMultipleRuns("RadixSort", arrays);
            testAlgorithmMultipleRuns("BucketSort", arrays);
        }
    }

    // Gera um array de números aleatórios entre 0 e size - 1
    public static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(size);
        }
        return array;
    }

    // Executa um algoritmo de ordenação 30 vezes para cada vetor e calcula a média
    public static void testAlgorithmMultipleRuns(String algorithmName, int[][] arrays) {
        totalTime = 0.0; // Zera o tempo acumulado antes das 30 execuções

        for (int i = 0; i < 30; i++) {
            int[] arrClone = arrays[i].clone(); // Clona o vetor original para cada execução
            totalTime += testSortingAlgorithm(algorithmName, arrClone);
        }

        double averageTime = totalTime / 30; // Calcula a média do tempo
        System.out.printf("Média de tempo para %s com %d elementos: %.4f segundos.%n", algorithmName, arrays[0].length, averageTime);
    }

    // Executa o algoritmo e retorna o tempo de execução em segundos
    public static double testSortingAlgorithm(String algorithmName, int[] arr) {
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
            case "CountingSort":
                startTime = System.nanoTime();
                CountingSort.countingSort(arr);
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

        return (endTime - startTime) / 1_000_000_000.0; // Converte o tempo para segundos e retorna
    }
}
