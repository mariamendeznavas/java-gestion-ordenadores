/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maestre.electrodomesticos;

import maestre.general.interfaces.Reparable;

/**
 * Clase Aspirador: no hereda de Ordenador, pero sí se puede reparar.
 *
 * @author María Méndez Navas Marzo 2026
 */
public class Aspirador implements Reparable {

    private String modelo;
    private int potencia;

    // Constructor 
    public Aspirador(String modelo, int potencia) {
        this.modelo = modelo;
        this.potencia = potencia;
    }

    // Implementación del método reparar
    @Override
    public void reparar() {
        System.out.println("\n<<<< MANTENIMIENTO TÉCNICO: Aspirador >>>>");
        System.out.println("---- Limpiando filtros del modelo: " + modelo);
        System.out.println("---- Comprobando motor de " + potencia + "W");
        System.out.println("<<<< REPARACIÓN FINALIZADA >>>>");
    }
}
