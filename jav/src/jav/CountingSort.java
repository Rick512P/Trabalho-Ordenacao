package jav;

public class CountingSort {

    public static void countingSort(int[] arr) {
        if (arr.length == 0) {
            return;
        }

        // Encontrar o maior valor no array para definir o tamanho do array de contagem
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // Inicializar o array de contagem
        int[] count = new int[max + 1];

        // Contar a frequência de cada valor no array original
        for (int num : arr) {
            count[num]++;
        }

        // Modificar o array original com os valores ordenados
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr[index++] = i;
                count[i]--;
            }
        }
    }

    // Método para exibir o array
    public static void printArray(int[] arr) {
       /* for (int num : arr) {
            System.out.print(num + " ");
        }*/
        System.out.println();
    }
}

