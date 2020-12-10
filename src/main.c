#include <stdio.h>
#include <stdlib.h>
#include <sys/time.h>

struct Lista
{
    int elem;
    struct Lista *ptr;
}typedef node_lista;

node_lista *cria_node()
{
    node_lista *novo_node;
    novo_node = (node_lista *) malloc(sizeof(node_lista));

    return novo_node;
}

void ins_inic_lista(int elem, node_lista **head)
{
    node_lista *novo_node = cria_node();

    novo_node->elem = elem;
    novo_node->ptr = *head;
    *head = novo_node;
}

void ins_fim_lista( int elem, node_lista **L)
{
    if (*L == NULL)
    {
        node_lista *novo_node = cria_node();
        *L = novo_node;
        novo_node -> elem = elem;
        novo_node -> ptr = NULL;
        return;
    }
    else
    {
        node_lista *novo_node , *aux;
        aux = *L;
        while (aux->ptr != NULL)
        {
            aux = aux -> ptr;
        }

        novo_node = cria_node();
        novo_node -> elem = elem;
        novo_node -> ptr = NULL;
        aux -> ptr = novo_node;
        return;
    }
}

void imp_lista( node_lista *L)
{
    int i = 1;
    do
    {
        printf("node_%d: %d\n", i, L->elem);
        L = L -> ptr;
        i++;
    } while (L != NULL);
    return;
}

unsigned int fib_n_rec(unsigned int n)
{
    unsigned int a = 0, b = 1, c;
    if(n == 0) return a;
    for (int i = 2; i <= n; i++)
    {
        c = a + b;
        a = b;
        b = c;
    }
    return b;
}

unsigned int fib_rec(unsigned int n)
{
    if(n < 2)
    {
        return n;
    }

    return fib_rec(n-2) + fib_rec(n-1);
}

int main(int argc, char const *argv[])
{
    node_lista *L = NULL;

    for (int i = 0; i < 5; i++)
    {
        ins_fim_lista(i, &L);
    }

    imp_lista(L);
    
    return 0;
}