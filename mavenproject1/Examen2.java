 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author Laboratorio
 */
import javax.swing.JOptionPane;

public class Examen2 {

    public static void main(String[] args) {

        JOptionPane.showMessageDialog(null, "Sistema para el Hotel");

        Hotel hotel = new Hotel();

        int opcion = 0;

        while (opcion != 4) {

            String menu = JOptionPane.showInputDialog("""
                    1. Mostrar Estado Habitaciones
                    2. Modificar Habitación
                    3. Mostrar Resumen Hotel
                    4. Salir
                    """);

            if (menu == null) {
                break;
            }

            opcion = Integer.parseInt(menu);

            switch (opcion) {

                case 1 ->
                    hotel.mostrarEstadoHabitaciones();

                case 2 -> {
                    int numero = Integer.parseInt(
                            JOptionPane.showInputDialog("Número de habitación:")
                    );
                    hotel.modificarHabitacion(numero);
                }

                case 3 ->
                    hotel.mostrarResumenHotel();

                case 4 ->
                    JOptionPane.showMessageDialog(null, "Saliendo...");

                default ->
                    JOptionPane.showMessageDialog(null, "Opción inválida");
            }
        }
    }
}
