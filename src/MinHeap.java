import java.util.ArrayList;

public class MinHeap {
    //Atributos

    private ArrayList<Integer> heap;

    //Constructor 
    public MinHeap() {
        heap = new ArrayList<>(); 
    }

    public boolean estaVacio() {
        return heap.isEmpty();
    }

    public int tamano() {
        return heap.size();
    }

//Cambiar de lugar posiciones
    private void intercambiar(int i, int j) {
        int aux = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, aux);
    }

    public void insertar(int valor) {
        heap.add(valor);
        int indice = heap.size() -1;
        upHeapify(indice);
    }
    
    // Sube el elemento mientras sea menor que su padre
    private void upHeapify(int indice) {
        while (indice > 0) {
            int padre = (indice - 1) / 2;

            if (heap.get(indice) < heap.get(padre)) {
                intercambiar(indice, padre);
                indice = padre;
            } else {
                break;
            }
        }
    }

    public Integer eliminarMin() {
        if (heap.isEmpty()) {
            return null;
        }

        int minimo = heap.get(0);

        int ultimo = heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {
            heap.set(0, ultimo);
            downHeapify(0);
        }
        return minimo;
    }

    public void downHeapify(int indice) {
        int tamano = heap.size();

        while (true) { 
            int izq = 2* indice +1;
            int der = 2* indice +2;
            int menor = indice;

            if (izq < tamano && heap.get(izq) < heap.get(menor)) {
                menor = izq;
            }

            if (der < tamano && heap.get(der) < heap.get(menor)) {
                menor = der;
            }

            if (menor != indice) {
                intercambiar(indice, menor);
                indice = menor;
            } else {
                break;
            }
        }
    }

    public Integer peek() {
        if (heap.isEmpty()) {
            return null;
        }
        return heap.get(0);
    }

    public void heapify(int[] arreglo) {
        heap.clear();;

        for (int x : arreglo) {
            heap.add(x);
        }

        int ultimoPadre = (heap.size() / 2) - 1;

        for (int i = ultimoPadre; i >= 0; i--) {
            downHeapify(i);
        }
    }

    public void imprimirHeap() {
        System.out.println(heap);
    }

}