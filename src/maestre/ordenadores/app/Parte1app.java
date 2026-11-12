/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maestre.ordenadores.app;
import maestre.ordenadores.modelo.*;
import java.util.Scanner;
import java.util.InputMismatchException;
/**
 *Aplicación principal en la gestión de ordenadores
 * @author María Méndez Navas
 * @version 1.0 Fecha 07/03/2026
 */
public class Parte1app {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        // Array precargado (Polimorfismo: se guardan portátiles y sobremesa)
        Ordenador[] lista = new Ordenador[6];

        try {
            lista[0] = new Portatil("P-001", "MSI Katana", 16, "i7-12700H", 14, "SSD", 15, 300);
            lista[1] = new Portatil("P-002", "MacBook Air", 8, "M2", 8, "SSD", 13, 240);
            lista[2] = new Portatil("P-003", "HP Pavilion", 12, "Ryzen 5", 6, "SSD", 14, 120);
            lista[3] = new Sobremesa("S-101", "Custom Gaming", 32, "i9-13900K", 24, "SSD", "Z790", "RTX 4080");
            lista[4] = new Sobremesa("S-102", "Office PC", 8, "i3-10100", 4, "HDD", "H410M", "Integrada");
            lista[5] = new Sobremesa("S-103", "Workstation", 64, "Threadripper", 32, "SSD", "X399", "Quadro RTX");
        } catch (OrdenadorException e) {
            System.out.println("Error en la precarga: " + e.getMessage());
        }

        //Bienvenida y listado inicial
        System.out.println("******************************************");
        System.out.println("* BIENVENIDO A LA GESTIÓN DE ORDENADORES *");
        System.out.println("******************************************");
        listarTodo(lista);

        int opcion = -1;
        while (opcion != 0) {
            try {
                mostrarMenu();
                System.out.print("Seleccione una opción: ");
                opcion = teclado.nextInt();

                switch (opcion) {
                    case 1 -> listarTodo(lista);
                    case 2 -> listarPortatiles(lista);
                    case 3 -> listarSobremesa(lista);
                    case 4 -> accionarOrdenador(lista, teclado, true); // Encender
                    case 5 -> accionarOrdenador(lista, teclado, false); // Apagar
                    case 6 -> dibujarOrdenador(lista, teclado);
                    case 7 -> gestionarBateria(lista, teclado, true); // Cargar
                    case 8 -> gestionarBateria(lista, teclado, false); // Descargar
                    case 0 -> System.out.println("Saliendo del programa...");
                    default -> System.out.println("Opción no válida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe introducir un número entero.");
                teclado.next(); // Limpiar el buffer
            } catch (Exception e) {
                System.out.println("Ha ocurrido un error inesperado: " + e.getMessage());
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("\n--- MENÚ DE OPCIONES ---");
        System.out.println("1. Listar todos");
        System.out.println("2. Listar solo Portátiles");
        System.out.println("3. Listar solo Sobremesa");
        System.out.println("4. Encender ordenador");
        System.out.println("5. Apagar ordenador");
        System.out.println("6. Dibujar ordenador");
        System.out.println("7. Cargar Portátiles");
        System.out.println("8. Descargar Portátiles");
        System.out.println("0. Salir");
    }

    // --- MÉTODOS DEL MENU ---

    private static void listarTodo(Ordenador[] lista) {
        System.out.println("\n--- LISTA COMPLETA ---");
        for (int i = 0; i < lista.length; i++) {
            System.out.println(i + ". " + lista[i]);
        }
    }

    private static void listarPortatiles(Ordenador[] lista) {
        System.out.println("\n--- SOLO PORTÁTILES ---");
        for (Ordenador o : lista) {
            if (o instanceof Portatil) { // instanceof pregunta si ese objeto o es Portatil
                System.out.println(o);//Si es que si lo imprime, sino lo ignora.
            }
        }
    }

    private static void listarSobremesa(Ordenador[] lista) {
        System.out.println("\n--- SOLO SOBREMESA ---");
        for (Ordenador o : lista) {
            if (o instanceof Sobremesa) { // instanceof pregunta si ese objeto o es Sobremesa
                System.out.println(o);//Si es que si lo imprime, sino lo ignora
            }
        }
    }

    private static void accionarOrdenador(Ordenador[] lista, Scanner teclado, boolean encender) {
        System.out.print("Indique la posición (0-5): ");
        int pos = teclado.nextInt();
        if (encender) lista[pos].arrancar();
        else lista[pos].apagar();
    }

    private static void dibujarOrdenador(Ordenador[] lista, Scanner teclado) {
        System.out.print("Indique la posición para dibujar: ");
        int pos = teclado.nextInt();
        lista[pos].dibujar(); // Polimorfismo: llama al método de la clase hija real
    }

    private static void gestionarBateria(Ordenador[] lista, Scanner teclado, boolean cargar) {
        System.out.print("Indique los minutos: ");
        int min = teclado.nextInt();
        for (Ordenador o : lista) {
            if (o instanceof Portatil) { //Filtro para saber si es de tipo Portatil
                Portatil p = (Portatil) o; // Casting: tratamos el Ordenador como Portatil
                if (cargar) p.cargar(min);
                else p.descargar(min);
            }
        }
        System.out.println("Operación de batería completada en todos los portátiles.");
    }
}
