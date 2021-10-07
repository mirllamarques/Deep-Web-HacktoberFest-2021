import sys
from time import time

def bubble_sort(lista):
    ordenado = False 

    while not ordenado:
        ordenado = True
        for i in range(len(lista)-1):
            if lista[i] > lista[i+1]:
                lista[i], lista[i+1] = lista[i+1], lista[i]
                ordenado = False

def merge_sort(array, begin=0, end=None):
    if end == None:
        end = len(array)

    if (end-begin) > 1:
        middle = (begin+end) // 2
        merge_sort(array, begin, middle)
        merge_sort(array, middle, end)
        merge(array, begin, middle, end)

def merge(array, begin, middle, end):
    left = array[begin:middle]
    right = array[middle:end]
    l, r = 0, 0

    for i in range(begin, end):
        if l >= len(left):
            array[i] = right[r]
            r += 1
        elif r >= len(right):
            array[i] = left[l]
            l += 1
        elif left[l] < right[r]:
            array[i] = left[l]
            l += 1
        else:
            array[i] = right[r]
            r += 1

def minimo(lista, index):
    tamanho = len(lista)
    index_minimo = index
    for j in range(index, tamanho):
            if lista[index_minimo] > lista[j]:
                index_minimo = j 
    return index_minimo 

def selection_sort(lista):
    tamanho = len(lista)
    for i in range(tamanho - 1):
        index_minimo = minimo(lista, i)
        if lista[i] > lista[index_minimo]:
            lista[i], lista[index_minimo] = lista[index_minimo], lista[i]

def insertion_sort(lista):
    tamanho = len(lista) 
    for i in range(1, tamanho): 
        pivot = i 
        anterior = i - 1 
        while anterior >= 0 and lista[pivot] < lista[anterior]:
            lista[pivot], lista[anterior] = lista[anterior], lista[pivot]
            anterior -= 1 
            pivot -= 1 

def quick_sort(lista, inicio=0, fim=None):
    if fim is None:
        fim = len(lista) - 1
    if inicio < fim:
        p = partition(lista, inicio, fim)
        quick_sort(lista, inicio, p - 1)
        quick_sort(lista, p + 1, fim)

def partition(lista, inicio, fim):
    pivot = lista[fim]
    i = inicio
    for c in range(inicio, fim):
        if lista[c] <= pivot:
            lista[c], lista[i] = lista[i], lista[c]
            i += 1
    lista[i], lista[fim] = lista[fim], lista[i]
    return i


if __name__ == "__main__":
    # Para executar um algoritmo específico use o terminal:
    # python3 algoritmos_de_ordenacao.py <nome_do_algoritmo> <lista>
    # EXEMPLO:
    # python3 algoritmos_de_ordenacao.py bubble 2 5 8 9 4 1
    args = sys.argv
    try:
        entrada_flag = args[1]
        entrada_lista = args[2:]
        lambda_converter = lambda n: int(n)
        lista = list(map(lambda_converter, entrada_lista))

        if entrada_flag == "quick":
            inicio = time()
            quick_sort(lista)
            final = time()
            print(lista)
            print(f"O algoritmo executou em {(final-inicio)*(10**9)} ns")
        elif entrada_flag == "bubble":
            inicio = time()
            bubble_sort(lista)
            final = time()
            print(lista)
            print(f"O algoritmo executou em {(final-inicio)*(10**9)} ns")
        elif entrada_flag == "merge":
            inicio = time()
            merge_sort(lista)
            final = time()
            print(lista)
            print(f"O algoritmo executou em {(final-inicio)*(10**9)} ns")
        elif entrada_flag == "insertion":
            inicio = time()
            insertion_sort(lista)
            final = time()
            print(lista)
            print(f"O algoritmo executou em {(final-inicio)*(10**9)} ns")
        elif entrada_flag == "selection":
            inicio = time()
            selection_sort(lista)
            final = time()
            print(lista)
            print(f"O algoritmo executou em {(final-inicio)*(10**9)} ns")       
        else:
            print("Algoritmo indicado não encontrado...")     
    except:
        print("Algo deu errado... verifique os argumentos")

