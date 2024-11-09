package jav;

public class RadixSort {
        // Função principal do Radix Sort
        public static void radixSort(int[] arr) {
            if (arr.length == 0) {
                return;
            }
    
            // Encontra o maior número para saber o número de dígitos
            int max = getMax(arr);
    
            // Executa o Counting Sort para cada dígito, começando pelo menos significativo
            for (int exp = 1; max / exp > 0; exp *= 10) {
                countingSortByDigit(arr, exp);
            }
        }
    
        // Função auxiliar para encontrar o maior número no array
        private static int getMax(int[] arr) {
            int max = arr[0];
            for (int num : arr) {
                if (num > max) {
                    max = num;
                }
            }
            return max;
        }
    
        // Função de Counting Sort aplicada a um dígito específico
        private static void countingSortByDigit(int[] arr, int exp) {
            int n = arr.length;
            int[] output = new int[n]; // Array de saída para armazenar o resultado temporário
            int[] count = new int[10]; // Array de contagem para os dígitos (0 a 9)
    
            // Conta as ocorrências dos dígitos
            for (int i = 0; i < n; i++) {
                int digit = (arr[i] / exp) % 10;
                count[digit]++;
            }
    
            // Modifica count para que ele contenha a posição de cada dígito no array de saída
            for (int i = 1; i < 10; i++) {
                count[i] += count[i - 1];
            }
    
            // Constrói o array de saída
            for (int i = n - 1; i >= 0; i--) {
                int digit = (arr[i] / exp) % 10;
                output[count[digit] - 1] = arr[i];
                count[digit]--;
            }
    
            // Copia o array de saída para arr, ordenando os números pelo dígito atual
            System.arraycopy(output, 0, arr, 0, n);
        }
    
        // Método para exibir o array
        public static void printArray(int[] arr) {
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
}
