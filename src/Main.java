import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MinHeap heap = new MinHeap();

        int opcion = -1;

        do {
            System.out.println("\n===== MENÚ MIN-HEAP =====");
            System.out.println("1. Insertar elemento");
            System.out.println("2. Eliminar mínimo");
            System.out.println("3. Ver mínimo (peek)");
            System.out.println("4. Heapify desde arreglo");
            System.out.println("5. Mostrar heap interno");
            System.out.println("0. Salir");
            System.out.print("Elija una opción: ");

            opcion = leerEntero(sc);

            switch (opcion) {
                case 1:
                    System.out.print("Valor a insertar: ");
                    int valor = leerEntero(sc);
                    heap.insertar(valor);
                    System.out.println("Elemento insertado.");
                    break;

                case 2:
                    Integer min = heap.eliminarMin();
                    if (min == null) {
                        System.out.println("El heap está vacío.");
                    } else {
                        System.out.println("Mínimo eliminado: " + min);
                    }
                    break;
 
                case 3:
                    Integer peek = heap.peek();
                    if (peek == null) {
                        System.out.println("El heap está vacío.");
                    } else {
                        System.out.println("Mínimo actual: " + peek);
                    }
                    break;

                case 4:
                    System.out.print("¿Cuántos elementos tendrá el arreglo? ");
                    int n = leerEntero(sc);
                    int[] arr = new int[n];

                    for (int i = 0; i < n; i++) {
                        System.out.print("Elemento " + (i + 1) + ": ");
                        arr[i] = leerEntero(sc);
                    }

                    heap.heapify(arr);
                    System.out.println("Heap creado a partir del arreglo.");
                    break;

                case 5:
                    System.out.print("Heap interno: ");
                    heap.imprimirHeap();
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }

        } while (opcion != 0);

        sc.close();
    }

    // Lee un entero evitando errores
    private static int leerEntero(Scanner sc) {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.print("Ingrese un número válido: ");
            }
        }
    }
}
