package jav;
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11, 90, 33, 50};

        System.out.println("Array antes da ordenação:");
        printArray(arr);

        quickSort(arr, 0, arr.length - 1);

        System.out.println("\nArray após a ordenação:");
        printArray(arr);
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Encontra o índice da partição
            int pi = partition(arr, low, high);

            // Ordena os elementos antes e depois da partição
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // pivô
        int i = (low - 1); // índice do menor elemento

        for (int j = low; j < high; j++) {
            // Se o elemento atual é menor ou igual ao pivô
            if (arr[j] <= pivot) {
                i++;

                // Troca arr[i] com arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Troca arr[i + 1] com o pivô (arr[high])
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

