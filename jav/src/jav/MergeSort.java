package jav;
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11, 90, 33, 50};

        System.out.println("Array antes da ordenação:");
        printArray(arr);

        mergeSort(arr, 0, arr.length - 1);

        System.out.println("\nArray após a ordenação:");
        printArray(arr);
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            // Encontra o meio do array
            int middle = left + (right - left) / 2;

            // Ordena a primeira e a segunda metade
            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);

            // Junta as duas metades ordenadas
            merge(arr, left, middle, right);
        }
    }

    public static void merge(int[] arr, int left, int middle, int right) {
        // Tamanhos dos subarrays para combinar
        int n1 = middle - left + 1;
        int n2 = right - middle;

        // Arrays temporários
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copia os dados para os arrays temporários
        for (int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[middle + 1 + j];
        }

        // Índices iniciais dos subarrays e do array combinado
        int i = 0, j = 0;
        int k = left;

        // Junta os arrays L e R de volta no array original
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copia os elementos restantes de L, se houver algum
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copia os elementos restantes de R, se houver algum
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

