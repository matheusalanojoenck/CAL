#include <stdio.h>
#include <stdlib.h>
#include <sys/time.h>

struct Lista
{
    int elem;
    struct Lista *ptr;
} typedef node_lista;

/**
 * Retorna um novo nó que vai ser inserido na lista
 */
node_lista *cria_node()
{
    node_lista *novo_node;
    novo_node = (node_lista *)malloc(sizeof(node_lista));

    return novo_node;
}

/**
 * Insere um novo elemento no incia da lista.
 */
void ins_inic_lista(int elem, node_lista **head)
{
    node_lista *novo_node = cria_node();

    novo_node->elem = elem;
    novo_node->ptr = *head;
    *head = novo_node;
}

/**
 * Insere um elemento no final da lista
 */
void ins_fim_lista(int elem, node_lista **L)
{
    if (*L == NULL)
    {
        node_lista *novo_node = cria_node();
        *L = novo_node;
        novo_node->elem = elem;
        novo_node->ptr = NULL;
        return;
    }
    else
    {
        node_lista *novo_node, *aux;
        aux = *L;
        while (aux->ptr != NULL)
        {
            aux = aux->ptr;
        }

        novo_node = cria_node();
        novo_node->elem = elem;
        novo_node->ptr = NULL;
        aux->ptr = novo_node;
        return;
    }
}

struct Arvore
{
    int elem;
    struct Arvore *esq, *dir;
} typedef node_arvore;

/**
 * Imprime todos os nós da arvore binaria
 */
void print_tree(node_arvore *root)
{
    node_arvore *current, *prev;
    if (root == NULL)
    {
        return;
    }

    current = root;

    while (current != NULL)
    {
        if (current->esq == NULL)
        {
            printf("%d\n", current->elem);
            current = current->dir;
        }
        else
        {
            prev = current->esq;
            while (prev->dir != NULL && prev->dir != NULL)
            {
                prev = prev->dir;
            }
            if (prev->dir == NULL)
            {
                prev->dir = current;
                current = current->esq;
            }
            else
            {
                prev->dir = NULL;
                printf("%d\n", current->elem);
                current = current->dir;
            }
        }
    }
}

void imp_lista(node_lista *L)
{
    int i = 1;
    do
    {
        printf("node_%d: %d\n", i, L->elem);
        L = L->ptr;
        i++;
    } while (L != NULL);
    return;
}

/**
 * Calcula o n-ésimo numero da sequencia de fibonacci não recursiva
 */
unsigned int fib_n_rec(unsigned int n)
{
    unsigned int a = 0, b = 1, c;
    if (n == 0)
        return a;
    for (int i = 2; i <= n; i++)
    {
        c = a + b;
        a = b;
        b = c;
    }
    return b;
}

/**
 * Calcula o n-ésimo numero da sequencia de fibonacci de forma recursiva
 */
unsigned int fib_rec(unsigned int n)
{
    if (n < 2)
    {
        return n;
    }

    return fib_rec(n - 2) + fib_rec(n - 1);
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