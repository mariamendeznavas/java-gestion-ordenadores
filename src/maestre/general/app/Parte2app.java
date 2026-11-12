/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maestre.general.app;

import maestre.general.interfaces.Reparable;
import maestre.ordenadores.modelo.Portatil;
import maestre.ordenadores.modelo.Sobremesa;
import maestre.electrodomesticos.Aspirador;
import java.util.Arrays;

/**
 *
 * Aplicación principal para la Parte 2 de la tarea. Demuestra el uso de
 * interfaces, polimorfismo y ordenación.
 *
 * @author María Méndez Navas Marzo 2026
 */
public class Parte2app {

    public static void main(String[] args) {
        // --- ORDENACION DE OBJETOS DIFERENTES: se crea array para la reparación de objetos de diferente clase---
        Reparable[] cosas = new Reparable[6];

        try {
            // Mezclamos 2 Portátiles, 2 Sobremesas y 2 Aspiradores
            cosas[0] = new Portatil("SN-P1", "MSI Katana", 16, "i7", 8, "SSD", 17, 100);
            cosas[1] = new Portatil("SN-P2", "MacBook Air", 8, "M2", 8, "SSD", 13, 100);
            cosas[2] = new Sobremesa("SN-S1", "Gaming Tower", 32, "Ryzen 9", 12, "HDD", "Asus", "RTX 4080");
            cosas[3] = new Sobremesa("SN-S2", "Office Pro", 16, "i5", 6, "SSD", "Gigabyte", "Intel UHD");
            cosas[4] = new Aspirador("Dyson V15", 240);
            cosas[5] = new Aspirador("Cecotec Conga", 150);

            System.out.println("=== INICIANDO EL SERVICIO TÉCNICO GENERAL ===");
            reparaTodo(cosas);

        } catch (Exception e) {
            System.out.println("Error al precargar los objetos: " + e.getMessage());
        }

        // ---ORDENACIÓN DE PORTÁTILES: 6 portátiles precarados---
        System.out.println("\n\n=== PRUEBA DE ORDENACIÓN DE PORTÁTILES (POR PULGADAS) ===");

        try {
            Portatil[] misPortatiles = {
                new Portatil("P01", "Modelo A", 8, "i5", 4, "SSD", 17, 100),
                new Portatil("P02", "Modelo B", 8, "i5", 4, "SSD", 12, 100),
                new Portatil("P03", "Modelo C", 8, "i5", 4, "SSD", 15, 100),
                new Portatil("P04", "Modelo D", 8, "i5", 4, "SSD", 13, 100),
                new Portatil("P05", "Modelo E", 8, "i5", 4, "SSD", 14, 100),
                new Portatil("P06", "Modelo F", 8, "i5", 4, "SSD", 11, 100)
            };

            System.out.println("\n--- Lista desordenada ---");
            for (Portatil p : misPortatiles) {
                System.out.println(p.getMarcaModelo() + " -> " + p.getPulgadas() + "\"");
            }

            // Arrays.sort usa compareTo(al haber obligado a los portátiles, a implementar el compareTo, ya te permite usar el método sort)
            Arrays.sort(misPortatiles);

            System.out.println("\n--- Lista ordenada ascendentemente ---");
            for (Portatil p : misPortatiles) {
                System.out.println(p.getMarcaModelo() + " -> " + p.getPulgadas() + "\"");
            }

        } catch (Exception e) {
            System.out.println("Error en la sección de ordenación: " + e.getMessage());
        }
    }

    /**
     * Método estático que repara cualquier objeto que implemente Reparable.
     *
     * @param cosas Array de objetos reparables.
     */
    static void reparaTodo(Reparable cosas[]) {
        for (Reparable r : cosas) {
            if (r != null) {
                r.reparar();
            }
        }
    }
}
