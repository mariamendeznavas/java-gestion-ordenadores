/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maestre.ordenadores.modelo;

import maestre.general.interfaces.Reparable;

/**
 * Representa un ordenador de sobremesa con componentes específicos como placa
 * base y gráfica.
 *
 * @author María Méndez Navas
 * @version 1.0 Fecha Marzo 2026
 */

public class Sobremesa extends Ordenador implements Reparable{
    /** Modelo de la placa base*/
    private String placaBase;
    /** Modelo de la tarjeta gráfica*/
    private String tarjetaGrafica;

    /**
     * Constructor con valores por defecto.
     */
    public Sobremesa() {
        super(); // Llama al padre para inicializar S/N, RAM, etc.
        this.placaBase = "Genérica";
        this.tarjetaGrafica = "Integrada";
    }

    /**
     * Constructor que recibe todos los parámetros para inicializar los atributos.
     * @param numSerie S/N del equipo (Heredado).
     * @param marcaModelo Marca y modelo (Heredado).
     * @param ram Memoria RAM en GB (Heredado).
     * @param procesador Modelo de CPU (Heredado).
     * @param nucleos Número de núcleos (Heredado).
     * @param tipoDisco HDD o SSD (Heredado).
     * @param placaBase Modelo de la placa base específica.
     * @param tarjetaGrafica Modelo de la tarjeta gráfica específica.
     * @throws OrdenadorException Si los datos básicos del ordenador no son válidos.
     */
    public Sobremesa(String numSerie, String marcaModelo, int ram, String procesador, 
                     int nucleos, String tipoDisco, String placaBase, String tarjetaGrafica) 
                     throws OrdenadorException {
        super(numSerie, marcaModelo, ram, procesador, nucleos, tipoDisco);
        this.placaBase = placaBase;
        this.tarjetaGrafica = tarjetaGrafica;
    }

    /**
     * Implementación del dibujo técnico del ordenador de sobremesa.
     * Muestra una cuadrícula de asteriscos (RAM x Núcleos) si está encendido.
     */
    @Override
    public void dibujar() {
        System.out.println("=== VISUALIZACIÓN SOBREMESA ===");
        // Mostramos los datos completos usando nuestro toString especializado
        System.out.println(this.toString());
        
        //Muestra el dibujo de asterisco SOLO si el ordenador está arrancado
        if (!this.arrancado) {//Si arrancado es false muestra mensaje de error
            System.out.println("Error: No se puede dibujar. El ordenador está APAGADO.");
        } else {
            // Un * por cada GB de RAM en cada línea de núcleo 
            for (int i = 0; i < this.nucleos; i++) {
                for (int j = 0; j < this.ram; j++) {
                    System.out.print("*");
                }
                System.out.println(); 
            }
        }
    }

    /**
     * Sobrescritura y ampliación del toString de la clase padre.
     * @return Cadena con todos los datos del ordenador de sobremesa.
     */
    @Override
    public String toString() {
        // Usamos String.format para añadir la placa y la gráfica al texto del padre
        return super.toString() + String.format(" | Placa: %s | Gráfica: %s", placaBase, tarjetaGrafica);
    }
    
    /**
     * Realiza las tareas de mantenimiento y reparación específicas del sobremesa.
     * Muestra por consola el progreso de la reparación con un formato de asteriscos.
     */
    @Override
    public void reparar() {
        System.out.println("\n*****************************************");
        System.out.println("*** REPARANDO SOBREMESA: " + this.marcaModelo + " ***");
        System.out.println("*** Limpiando ventiladores y fuente... ***");
        System.out.println("*** Testeando placa base " + this.placaBase + " ***");
        System.out.println("*****************************************");
    }

    // --- Getters y Setters ---
    public String getPlacaBase() { return placaBase; }
    public void setPlacaBase(String placaBase) { this.placaBase = placaBase; }
    public String getTarjetaGrafica() { return tarjetaGrafica; }
    public void setTarjetaGrafica(String tarjetaGrafica) { this.tarjetaGrafica = tarjetaGrafica; }
    
    
}
