package Tareas;

/**
 * Nombre del programa: Salario de Peleadores
 * Descripcion: Este programa calcula el salario de los peleadores según su número de peleas y ranking
 * Autor: Kimberly C.
 * Fecha de creacion: 14 Julio 2021
 * Modificado por: Kimberly Cascante Mora.
 * fecha de modificacion: 14 Julio 2021.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class requerimiento3 {
    public static BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
    public static PrintStream escribir = System.out;

    public static void main(String[] args) throws IOException {

        String nombre;
        int ranking;
        int peleas;
        int vendidas;
        int resultado;
        String bonoPerformance;
        String bonoNoche;
        int salario;
        double salarioTotal;
        int salarioPeleas=0;
        int ppvs=0;
        double taquilla;
        //int pagoPerformance=0;
        //int pagoNoche=0;
        int totalPagoPerformance=0;
        int totalPagoNoche=0;

        escribir.println("Digite el nombre del jugador: ");
        nombre = leer.readLine();

        escribir.println("Digite el numero de raking: ");
        ranking = Integer.parseInt(leer.readLine());

        escribir.println("Digite el numero de peleas: ");
        peleas = Integer.parseInt(leer.readLine());

        for (int count = 0; count < peleas; count++) {
            escribir.println("Digite la cantidad de PPVs vendidas: ");
            vendidas = Integer.parseInt(leer.readLine());

            escribir.println("Digite 1. Si Ganó 2. Si Perdió 3. Empató 4. Descalificado ");
            resultado = Integer.parseInt(leer.readLine());

            if (resultado == 1) {
                escribir.println("¿El jugador recibió el bono “Performance de la noche”: (Si/No)");
                bonoPerformance = leer.readLine();
                if(bonoPerformance.equalsIgnoreCase("Si")){
                    totalPagoPerformance = totalPagoPerformance + 1;
                }// Fin del contador de bonos performance
            } // Fin del if para cononcer si recibio el bono

            escribir.println("¿El jugador recibió el bono “Pelea de la noche”: (Si/No)");
            bonoNoche = leer.readLine();
            if(bonoNoche.equalsIgnoreCase("Si")){
                totalPagoNoche = totalPagoNoche + 1;
            }//Fin del contactor de bonos de noche


            if (resultado == 1) {
                salario = 40000;
            } else if (resultado == 2) {
                salario = 20000;
            } else if (resultado == 3) {
                salario = 30000;
            } else {
                salario = 0;
            } // Fin del if para el salario

            salarioPeleas = salarioPeleas + salario;
            ppvs = ppvs + vendidas;
            
        } // Fin del for de cada pelea

        if (ranking <= 10) {
            salarioTotal = salarioPeleas * 3;
        } else if (ranking > 10 && ranking < 20) {
            salarioTotal = salarioPeleas * 2;
        } else {
            salarioTotal = salarioPeleas;
        }

        taquilla = (ppvs*60) * 0.04; 

        salarioTotal = salarioTotal + taquilla;
        salarioTotal = salarioTotal + (totalPagoPerformance*50000);
        salarioTotal = salarioTotal + (totalPagoNoche*25000);

        escribir.println("Salario pagado al peleador " + nombre + " es de " + salarioTotal + " dolares");

    } // Fin del Main
} // Fin de la clase