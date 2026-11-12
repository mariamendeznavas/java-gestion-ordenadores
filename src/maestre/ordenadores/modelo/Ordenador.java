/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maestre.ordenadores.modelo;

import java.util.Objects;

/**
 * Clase abstracta, será la base de cualquier ordenador. Contiene los atributos
 * comunes y el comportamiento básico de encendido.
 *
 * @author María Méndez Navas
 * @version 1.0 04/03/2026
 *
 */
public abstract class Ordenador {

    /**
     * Número de serie (máx 20 caracteres)
     */
    protected String numSerie;
    /**
     * Marca y modelo del ordenador
     */
    protected String marcaModelo;
    /**
     * Memoria RAM en GB (máx 3 dígitos)
     */
    protected int ram;
    /**
     * Modelo del procesador
     */
    protected String procesador;
    /**
     * Número de núcleos del procesador (máx 2 dígitos)
     */
    protected int nucleos;
    /**
     * Tipo de almacenamiento: HDD o SSD
     */
    protected String tipoDisco;
    /**
     * Estado del ordenador: true si está encendido, false si está apagado
     */
    protected boolean arrancado;

    /**
     * Constructor por defecto. Inicializa con valores genéricos y apagado.
     */
    public Ordenador() {
        this.numSerie = "SN-0000";
        this.marcaModelo = "Genérico";
        this.ram = 0;
        this.procesador = "Desconocido";
        this.nucleos = 0;
        this.tipoDisco = "HDD";
        this.arrancado = false;
    }

    /**
     * Constructor completo que valida los datos antes de asignar.
     *
     * @throws OrdenadorException Si algún parámetro no cumple las
     * restricciones.
     */
    public Ordenador(String numSerie, String marcaModelo, int ram, String procesador, int nucleos, String tipoDisco)
            throws OrdenadorException {
        // Se usan los setters para que la validación esté en un solo sitio
        setNumSerie(numSerie);
        setRam(ram);
        setNucleos(nucleos);
        this.marcaModelo = marcaModelo;
        this.procesador = procesador;
        this.tipoDisco = tipoDisco;
        this.arrancado = false;
    }

    /**
     * Cambia el estado del ordenador a encendido y muestra un mensaje.
     */
    public void arrancar() {
        if (this.arrancado) {
            System.out.println("(!) El ordenador ya estaba encendido.");
        } else {
            this.arrancado = true;
            System.out.println("____________________________________");
            System.out.println("[ LOADING SYSTEM... PLEASE WAIT ]");
            System.out.println("[#######-----------] 35%");
            System.out.println("[##############----] 70%");
            System.out.println("[##################] 100%");
            System.out.println(">> " + marcaModelo + " ARRANCADO CORRECTAMENTE.");
        }
    }

    /**
     * Cambia el estado del ordenador a apagado y muestra un mensaje.
     */
    public void apagar() {
        if (!this.arrancado) {
            System.out.println("\n[!] El sistema ya se encuentra APAGADO.");
        } else {
            System.out.println("\n------------------------------------");
            System.out.println("<<< CERRANDO SESIÓN EN: " + this.marcaModelo);
            System.out.println("<<< Finalizando procesos en " + this.nucleos + " núcleos...");
            System.out.println("<<< Vaciando " + this.ram + " GB de memoria RAM...");

            this.arrancado = false; // Cambiamos el estado

            System.out.println("[ SISTEMA APAGADO CORRECTAMENTE ]");
            System.out.println("------------------------------------");
        }
    }

    /**
     * Método abstracto que obliga a las clases hijas a definir su propia
     * representación visual.
     */
    public abstract void dibujar();

    /**
     * Devuelve una cadena con los datos técnicos del ordenador.
     *
     * @return Representación textual de la clase.
     */
    @Override
    public String toString() {
        return String.format("S/N: %s | %s | RAM: %dGB | CPU: %s (%d núcleos) | Disco: %s | Estado: %s",
                numSerie, marcaModelo, ram, procesador, nucleos, tipoDisco, (arrancado ? "ON" : "OFF"));
    }

    /**
     * Compara dos ordenadores basándose en su número de serie.
     *
     * @param obj Objeto a comparar.
     * @return true si los números de serie son iguales.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Ordenador other = (Ordenador) obj;
        return Objects.equals(this.numSerie, other.numSerie);
    }

    // --- Getters y Setters ---
    public String getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(String numSerie) throws OrdenadorException {
        if (numSerie == null || numSerie.isEmpty()) {
            throw new OrdenadorException("El número de serie no puede estar vacío.");
        }
        if (numSerie.length() > 20) {
            throw new OrdenadorException("El número de serie no puede superar los 20 caracteres.");
        }
        this.numSerie = numSerie;
    }

    public String getMarcaModelo() {
        return marcaModelo;
    }

    public void setMarcaModelo(String marcaModelo) {
        this.marcaModelo = marcaModelo;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) throws OrdenadorException {
        if (ram < 0 || ram > 999) {
            throw new OrdenadorException("La RAM debe ser un número positivo de máximo 3 dígitos.");
        }
        this.ram = ram;
    }

    public int getNucleos() {
        return nucleos;
    }

    public void setNucleos(int nucleos) throws OrdenadorException {
        if (nucleos < 0 || nucleos > 99) {
            throw new OrdenadorException("El número de núcleos debe ser de máximo 2 dígitos.");
        }
        this.nucleos = nucleos;
    }

    public boolean isArrancado() {
        return arrancado;
    }
}
