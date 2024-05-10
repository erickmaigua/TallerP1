package Ejerciciopractico;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Ejerciciopractico {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opc, productChoice = 0;
        String productName = "";
        char productCategory = ' ';
        float productPrice = 0f;
        double productDiscount = 0.10;
        String clientName = "";
        String clientID = "";
        int quantity = 0;
        double totalPrice = 0;

        do {
            System.out.println("---------------------MENU----------------------");
            System.out.println("1. Tienda Repuestos");
            System.out.println("2. Salir");

            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, ingrese un numero valido.");
                scanner.next();
            }
            opc = scanner.nextInt();

            switch (opc) {
                case 1:
                    System.out.println("Bienvenido a la tienda de consolas de Videojuegos");
                    System.out.println("\n");
                    System.out.println("----------------------Productos----------------------");
                    System.out.println("1. PlayStation 5");
                    System.out.println("2. Xbox Series X");
                    System.out.println("3. Nintendo Switch");

                    System.out.print("Seleccione el numero del producto: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Por favor, ingrese un numero valido.");
                        scanner.next();
                    }
                    productChoice = scanner.nextInt();

                    switch (productChoice) {
                        case 1:
                            productName = "PlayStation 5";
                            productCategory = 'A';
                            productPrice = 499.99f;
                            break;
                        case 2:
                            productName = "Xbox Series X";
                            productCategory = 'A';
                            productPrice = 499.99f;
                            break;
                        case 3:
                            productName = "Nintendo Switch";
                            productCategory = 'B';
                            productPrice = 299.99f;
                            break;
                        default:
                            System.out.println("Opcion no valida.");
                            break;
                    }

                    if (productChoice >= 1 && productChoice <= 3) {
                        do {
                            System.out.print("Ingrese el nombre del cliente: ");
                            clientName = scanner.next();
                            if (clientName.matches(".*\\d+.*")) {
                                System.out.println("El nombre no puede contener numeros. Intentelo de nuevo.");
                            }
                        } while (clientName.matches(".*\\d+.*"));

                        System.out.print("Ingrese la cedula del cliente: ");
                        while (!scanner.hasNextInt()) {
                            System.out.println("Por favor, ingrese un numero valido.");
                            scanner.next();
                        }
                        clientID = scanner.next();

                        do {
                            System.out.print("Ingrese la cantidad (maximo 5, -1 para cancelar): ");
                            while (!scanner.hasNextInt()) {
                                System.out.println("Por favor, ingrese un numero valido.");
                                scanner.next();
                            }
                            quantity = scanner.nextInt();
                            if (quantity == -1) {
                                break;
                            }
                        } while (quantity < 1 || quantity > 5);

                        if (quantity != -1) {
                            totalPrice = quantity * productPrice * (1 - productDiscount);

                            System.out.println("----------------------Factura----------------------");
                            System.out.println("Cliente: " + clientName);
                            System.out.println("Cedula: " + clientID);
                            System.out.println("Producto: " + productName);
                            System.out.println("Categoria: " + productCategory);
                            System.out.println("Precio Unitario: $" + productPrice);
                            System.out.println("Descuento: " + (productDiscount * 100) + "%");
                            System.out.println("Cantidad: " + quantity);
                            System.out.println("Total a Pagar: $" + totalPrice);

                            try {
                                FileWriter fileWriter = new FileWriter("factura.txt");
                                PrintWriter printWriter = new PrintWriter(fileWriter);

                                printWriter.println("----------------------Factura----------------------");
                                printWriter.println("Cliente: " + clientName);
                                printWriter.println("Cedula: " + clientID);
                                printWriter.println("Producto: " + productName);
                                printWriter.println("Categoria: " + productCategory);
                                printWriter.println("Precio Unitario: $" + productPrice);
                                printWriter.println("Descuento: " + (productDiscount * 100) + "%");
                                printWriter.println("Cantidad: " + quantity);
                                printWriter.println("Total a Pagar: $" + totalPrice);

                                printWriter.close();
                                System.out.println("Factura guardada correctamente en factura.txt");
                            } catch (IOException e) {
                                System.out.println("Error al guardar la factura: " + e.getMessage());
                            }
                        }
                    }
                    break;
                case 2:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opcion no valida. Por favor, ingrese 1 o 2.");
            }
        } while (opc != 2);

        scanner.close();
    }
}
