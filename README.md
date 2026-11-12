# Gestión de ordenadores (Java)

Aplicación de consola en Java para gestionar ordenadores portátiles y de sobremesa. Ejercicio de Programación del ciclo de Desarrollo de Aplicaciones Web (unidad "Utilización avanzada de clases"). Proyecto creado con NetBeans.

## Qué incluye
- **Clase abstracta** `Ordenador` con los atributos comunes y los métodos `arrancar()`, `apagar()` y `dibujar()` (abstracto).
- **Herencia:** `Portatil` y `Sobremesa` heredan de `Ordenador`.
- **Interfaz** `Reparable`, implementada por `Portatil`, `Sobremesa` y `Aspirador` (esta última no hereda de `Ordenador`).
- **Polimorfismo:** arrays de `Ordenador` y de `Reparable` con objetos de distinto tipo, uso de `instanceof` y *casting*.
- **Excepción propia** `OrdenadorException`, que valida el número de serie, la RAM y los núcleos.
- **Ordenación:** `Portatil` implementa `Comparable` y se ordena por pulgadas con `Arrays.sort`.
- **Menú interactivo** por consola con `Scanner` y control de errores de entrada.

## Estructura
- `maestre.ordenadores.modelo`: `Ordenador`, `Portatil`, `Sobremesa`, `OrdenadorException`
- `maestre.ordenadores.app`: `Parte1app` (menú de gestión)
- `maestre.general.interfaces`: `Reparable`
- `maestre.general.app`: `Parte2app` (reparación y ordenación)
- `maestre.electrodomesticos`: `Aspirador`

## Cómo ejecutarlo
1. Descarga el repositorio y ábrelo como proyecto en NetBeans.
2. Ejecuta `Parte1app` para el menú de gestión de ordenadores.
3. Ejecuta `Parte2app` para la demostración de reparaciones y ordenación de portátiles.

## Tecnologías
Java · NetBeans
