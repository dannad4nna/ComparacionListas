import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BenchmarkListas {
    private static final int N = 100_000;

    public static void main(String[] args) {
        System.out.println("--- Acceso con get(i) ---");
        List<Integer> a1 = new ArrayList<>();
        List<Integer> l1 = new LinkedList<>();
        llenar(a1);
        llenar(l1);
        medirAccesoGet("ArrayList", a1);
        medirAccesoGet("LinkedList", l1);

        System.out.println("\n--- Acceso con for-each ---");
        medirAccesoForEach("ArrayList", a1);
        medirAccesoForEach("LinkedList", l1);

        System.out.println("\n--- Insercion al inicio ---");
        medirInsercionInicio("ArrayList", new ArrayList<>());
        medirInsercionInicio("LinkedList", new LinkedList<>());

        System.out.println("\n=== Insercion al final ---");
        medirInsercionFinal("ArrayList", new ArrayList<>());
        medirInsercionFinal("LinkedList", new LinkedList<>());

        System.out.println("\n---Eliminacion al inicio ---");
        List<Integer> a2 = new ArrayList<>();
        List<Integer> l2 = new LinkedList<>();
        llenar(a2);
        llenar(l2);
        medirEliminacionInicio("ArrayList", a2);
        medirEliminacionInicio("LinkedList", l2);
    }

    private static void llenar(List<Integer> lista) {
        for (int i = 0; i < N; i++) {
            lista.add(i);
        }
    }

    private static void imprimir(String nombre, long inicio, long fin) {
        System.out.printf("%s: %.3f ms%n", nombre, (fin - inicio) / 1_000_000.0);
    }

    private static void medirAccesoGet(String nombre, List<Integer> lista) {
        long inicio = System.nanoTime();
        long suma = 0;
        for (int i = 0; i < lista.size(); i++) {
            suma += lista.get(i);
        }
        long fin = System.nanoTime();
        imprimir(nombre, inicio, fin);
        System.out.println("Suma: " + suma);
    }

    private static void medirAccesoForEach(String nombre, List<Integer> lista) {
        long inicio = System.nanoTime();
        long suma = 0;
        for (Integer valor : lista) {
            suma += valor;
        }
        long fin = System.nanoTime();
        imprimir(nombre, inicio, fin);
        System.out.println("Suma: " + suma);
    }

    private static void medirInsercionInicio(String nombre, List<Integer> lista) {
        long inicio = System.nanoTime();
        for (int i = 0; i < 50_000; i++) {
            lista.add(0, i);
        }
        long fin = System.nanoTime();
        imprimir(nombre, inicio, fin);
    }

    private static void medirInsercionFinal(String nombre, List<Integer> lista) {
        long inicio = System.nanoTime();
        for (int i = 0; i < 100_000; i++) {
            lista.add(i);
        }
        long fin = System.nanoTime();
        imprimir(nombre, inicio, fin);
    }

    private static void medirEliminacionInicio(String nombre, List<Integer> lista) {
        long inicio = System.nanoTime();
        while (!lista.isEmpty()) {
            lista.remove(0);
        }
        long fin = System.nanoTime();
        imprimir(nombre, inicio, fin);
    }
}