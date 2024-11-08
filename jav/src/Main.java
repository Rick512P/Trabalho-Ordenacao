import jav.BubbleSort;
import jav.InsertionSort;
import jav.SelectionSort;
import jav.ShellSort;
import jav.HeapSort;
import jav.MergeSort;
import jav.QuickSort;
import java.util.Random;


public class Main {

    public static void main(String[] args) {
    	int[] originalArray = generateRandomArray(1000000);

        System.out.println("Array antes da ordenação:");
        printArray(originalArray);
        System.out.println();

        // Testando cada algoritmo de ordenação com medição de tempo
        testSortingAlgorithm("BubbleSort", originalArray.clone());
        testSortingAlgorithm("InsertionSort", originalArray.clone());
        testSortingAlgorithm("SelectionSort", originalArray.clone());
        testSortingAlgorithm("ShellSort", originalArray.clone());
        testSortingAlgorithm("HeapSort", originalArray.clone());
        testSortingAlgorithm("MergeSort", originalArray.clone());
        testSortingAlgorithm("QuickSort", originalArray.clone());
    }

    public static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(1000); // Gera números entre 0 e 999
        }
        return array;
    }
    
    public static void testSortingAlgorithm(String algorithmName, int[] arr) {
        long startTime = System.nanoTime(); // Inicia o cronômetro

        switch (algorithmName) {
            case "BubbleSort":
                BubbleSort.bubbleSort(arr);
                break;
            case "InsertionSort":
                InsertionSort.insertionSort(arr);
                break;
            case "SelectionSort":
                SelectionSort.selectionSort(arr);
                break;
            case "ShellSort":
                ShellSort.shellSort(arr);
                break;
            case "HeapSort":
                HeapSort.heapSort(arr);
                break;
            case "MergeSort":
                MergeSort.mergeSort(arr, 0, arr.length - 1);
                break;
            case "QuickSort":
                QuickSort.quickSort(arr, 0, arr.length - 1);
                break;
            default:
                System.out.println("Algoritmo não encontrado.");
                return;
        }

        long endTime = System.nanoTime(); // Para o cronômetro
        double durationInSeconds = (endTime - startTime) / 1_000_000_000.0;

        System.out.printf("%s levou %.4f segundos.%n", algorithmName, durationInSeconds);
        System.out.println("Array após a ordenação com " + algorithmName + ":");
        printArray(arr);
        System.out.println();
    }

    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
