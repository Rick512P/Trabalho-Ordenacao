package jav;

import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {
    // Função principal do Bucket Sort
    @SuppressWarnings("unchecked")
    public static void bucketSort(int[] arr) {
        if (arr.length == 0) {
            return;
        }

        // Passo 1: Encontra o valor máximo para definir o intervalo dos buckets
        int max = getMax(arr);

        // Cria um número de buckets proporcional ao tamanho do array
        int n = arr.length;
        ArrayList<Integer>[] buckets = new ArrayList[n];

        // Inicializa os buckets como listas vazias
        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Passo 2: Distribui os elementos do array nos buckets
        for (int num : arr) {
            int bucketIndex = (num * n) / (max + 1); // Distribui com base no valor do elemento
            buckets[bucketIndex].add(num);
        }

        // Passo 3: Ordena individualmente cada bucket
        for (ArrayList<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }

        // Passo 4: Concatena todos os elementos dos buckets no array original
        int index = 0;
        for (ArrayList<Integer> bucket : buckets) {
            for (int num : bucket) {
                arr[index++] = num;
            }
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

    // Método para exibir o array
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
