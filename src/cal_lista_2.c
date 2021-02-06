#include <stdio.h>
#include <stdlib.h>

int esquerda(int i) { return (2 * i + 1); }

int direita(int i) { return (2 * i + 2); }

void heapify(int *a, int n, int i)
{
    int e, d, maior, aux;
    e = esquerda(i);
    d = direita(i);
    if (e < n && a[e] > a[i])
        maior = e;
    else
        maior = i;
    if (d < n && a[d] > a[maior])
        maior = d;
    if (maior != i)
    {
        aux = a[i];
        a[i] = a[maior];
        a[maior] = aux;
        heapify(a, n, maior);
    }
}
void buildHeap(int *a, int n)
{
    int i;
    for (i = (n - 1) / 2; i >= 0; i--)
        heapify(a, n, i);
}
void heapSort(int *a, int n)
{
    int i, aux;
    buildHeap(a, n);
    for (i = n - 1; i > 0; i--)
    {
        aux = a[0];
        a[0] = a[i];
        a[i] = aux;
        heapify(a, i, 0);
    }
}

int main(int argc, char const *argv[])
{
    int vet[] = {1,2,3,4,5,6,7,8};
    buildHeap(vet, 8);
    heapSort(vet, 8);

    for (int i = 0; i < 8; i++)
    {
        printf("%d ", vet[i]);
    }
    
    return 0;
}