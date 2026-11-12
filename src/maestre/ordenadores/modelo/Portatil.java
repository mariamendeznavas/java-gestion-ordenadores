/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maestre.ordenadores.modelo;

import maestre.general.interfaces.Reparable;

/**
 * Representa un ordenador de tipo portátil con batería y pantalla. Implementa
 * la interfaz Reparable
 *
 * @author María Méndez Navas
 * @version 1.0 06/03/2026
 */
public class Portatil extends Ordenador implements Reparable, Comparable<Portatil> {

    private int pulgadas;
    private int bateria = 300; // Valor inicial por defecto según enunciado

    /**
     * Constructor con valores por defecto.
     */
    public Portatil() {
        super(); // Llama al constructor por defecto de Ordenador
        this.pulgadas = 15;
        this.bateria = 300;
    }

    /**
     * Constructor que recibe todos los parámetros para inicializar los
     * atributos.
     *
     * @param numSerie S/N del equipo (Heredado).
     * @param marcaModelo Marca y modelo (Heredado).
     * @param ram Memoria RAM en GB (Heredado).
     * @param procesador Modelo de CPU (Heredado).
     * @param nucleos Número de núcleos (Heredado).
     * @param tipoDisco HDD o SSD (Heredado).
     * @param pulgadas Tamaño de la pantalla.
     * @param bateria Duración de la batería en minutos.
     * @throws maestre.ordenadores.modelo.OrdenadorException Propaga la
     * excepción si los datos del padre son inválidos.
     */
    public Portatil(String numSerie, String marcaModelo, int ram, String procesador,
            int nucleos, String tipoDisco, int pulgadas, int bateria)
            throws OrdenadorException {
        // super debe ser la primera línea. Si falla, el objeto no se crea.
        super(numSerie, marcaModelo, ram, procesador, nucleos, tipoDisco);
        this.pulgadas = pulgadas;
        this.bateria = bateria;
    }

    /**
     * Incrementa la duración de la batería.
     *
     * @param minutos Tiempo a sumar.
     */
    public void cargar(int minutos) {
        this.bateria += minutos;
    }

    /**
     * Reduce la duración de la batería.
     *
     * @param minutos Tiempo a restar.
     */
    public void descargar(int minutos) {
        this.bateria = Math.max(0, this.bateria - minutos);
    }

    /**
     * Implementación del dibujo técnico del portátil. Muestra una cuadrícula de
     * asteriscos (RAM x Núcleos) si está encendido.
     */
    @Override
    public void dibujar() {
        System.out.println("=== VISUALIZACIÓN PORTÁTIL ===");
        System.out.println(this.toString());

        //Muestra el dibujo de asterisco SOLO si el ordenador está arrancado
        if (!this.arrancado) {//Si arrancado es false muestra mensaje de error
            System.out.println("Error: No se puede dibujar. El ordenador está APAGADO.");
        } else {
            // Un * por cada GB de RAM en cada línea de núcleo
            for (int i = 0; i < this.nucleos; i++) {// Bucle externo (Filas)Se repite tantas veces como núcleos tenga el ordenador. Si tiene 4 núcleos, hará 4 filas.
                for (int j = 0; j < this.ram; j++) {// Bucle interno (Columnas)Dentro de cada fila, se repite tantas veces como GB de RAM. Si tiene 8 GB, imprimirá 8 asteriscos seguidos
                    System.out.print("*");
                }
                System.out.println(); // Salto de línea por cada núcleo
            }
        }
    }

    /**
     * Amplía el método toString del padre añadiendo datos del portátil.
     *
     * @return Información completa del equipo.
     */
    @Override
    public String toString() {
        return super.toString() + String.format(" | Pantalla: %d\" | Batería: %d min", pulgadas, bateria);
    }
    /**
     * Realiza las tareas de mantenimiento y reparación específicas del dispositivo.
     * Muestra por consola el progreso de la reparación con un formato visual 
     * característico según el tipo de objeto.
     */
    @Override
    public void reparar() {
        System.out.println("\n************************************");
        System.out.println("*** REPARANDO PORTÁTIL: " + this.marcaModelo + " ***");
        System.out.println("*** Revisando conexiones y pantalla... ***");
        System.out.println("************************************");
    }
    /**
     * Compara este portátil con otro basado en el tamaño de sus pantallas (pulgadas).
     * @param otro El objeto Portatil con el que se va a comparar.
     * @return Un número entero negativo si este portátil tiene menos pulgadas,
     * cero si tienen las mismas, 
     * o un número entero positivo si tiene más pulgadas.
     */
    @Override
    public int compareTo(Portatil otro) {
        // Si este portátil tiene menos pulgadas que el "otro", devolvemos -1 (es menor)
        if (this.pulgadas < otro.pulgadas) {
            return -1;
        } // Si tiene más pulgadas, devolvemos 1 (es mayor)
        else if (this.pulgadas > otro.pulgadas) {
            return 1;
        } // Si tienen las mismas, devolvemos 0 (son iguales)
        else {
            return 0;
        }
    }

    // --- Getters y Setters ---
    public int getPulgadas() {
        return pulgadas;
    }

    public void setPulgadas(int pulgadas) {
        this.pulgadas = pulgadas;
    }

    public int getBateria() {
        return bateria;
    }
}
