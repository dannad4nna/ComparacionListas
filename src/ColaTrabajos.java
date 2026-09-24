import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class ColaTrabajos {
    public static void main(String[] args) {
        List<String> trabajos = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n1. Agregar trabajo normal");
            System.out.println("2. Agregar trabajo urgente");
            System.out.println("3. Procesar siguiente trabajo");
            System.out.println("4. Consultar siguiente trabajo");
            System.out.println("5. Mostrar trabajos pendientes");
            System.out.println("6. Mostrar número de trabajos");
            System.out.println("7. Salir");
            System.out.print("Opción: ");

            while (!sc.hasNextInt()) {
                sc.next();
                System.out.print("Ingrese un número válido: ");
            }
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar el salto de línea

            switch (opcion) {
                case 1 -> {
                    System.out.print("Nombre del trabajo: ");
                    trabajos.add(sc.nextLine());
                }
                case 2 -> {
                    System.out.print("Nombre del trabajo urgente: ");
                    trabajos.add(0, sc.nextLine());
                }
                case 3 -> {
                    if (trabajos.isEmpty()) {
                        System.out.println("No hay trabajos pendientes.");
                    } else {
                        System.out.println("Procesado: " + trabajos.remove(0));
                    }
                }
                case 4 -> {
                    if (trabajos.isEmpty()) {
                        System.out.println("No hay trabajos pendientes.");
                    } else {
                        System.out.println("Siguiente: " + trabajos.get(0));
                    }
                }
                case 5 -> System.out.println("Pendientes: " + trabajos);
                case 6 -> System.out.println("Total: " + trabajos.size());
                case 7 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 7);
    }
}
