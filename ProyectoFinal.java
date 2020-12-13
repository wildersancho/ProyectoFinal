package Proyecto;

import java.io.*;
import java.util.Arrays;

public class ProyectoFinal {

  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static PrintStream out = System.out;

  public static void main(final String[] args) throws IOException {

    int numJuegos[], numOponentes[], cantEquipos, puntajeTotal[];
    String equipos[], partidos[],resultados[];
    String equipo1, equipo2;

    out.println("Digite la cantidad total de equipos del torneo ");
    cantEquipos = Integer.parseInt(in.readLine());

    equipos = new String[cantEquipos];
    numJuegos = new int[cantEquipos];
    numOponentes = new int[cantEquipos];
    resultados = new String[cantEquipos];
    puntajeTotal = new int[cantEquipos];
    partidos = new String[cantEquipos / 2];

    for (int i = 0; i < equipos.length; i++) {
      equipos[i] = "value";
    }

    llenarArregloStringYLlenarArregloEnteros(equipos, puntajeTotal, numJuegos, partidos);
    out.printf("Los equipos son: \n");
    imprimirArregloStringYLlenarArregloEnteros(equipos, numJuegos, numOponentes);
    llenarNumeroJuegos(numJuegos, equipos);
    calcularResultadoYCalcularPuntaje(equipos, numJuegos, numOponentes, resultados);
    out.println("Resumen resultados: \n");
    imprimirCalcularResultadoYCalcularPuntaje(equipos, numJuegos, numOponentes, resultados);

  }

  static void llenarArregloStringYLlenarArregloEnteros(String[] pNombres, int[] pPuntajeTotal, int[] pNumJuegos,
    String[] pResultados) throws IOException {
    
    String equipo1, equipo2;
    int contador;

    for (int i = 0; i < pNombres.length - 1; i++) {
      contador = equipoRutina(pNombres);

      out.print("Digite el nombre del equipo " + (contador + 1) + ": ");
      equipo1 = in.readLine();
      pNombres[contador] = equipo1;

      out.print("Digite el nombre del equipo " + (contador + 2) + ": ");
      equipo2 = in.readLine();
      pResultados[i] = equipo1 + "-" + equipo2;
      contador = equipoRutina(pNombres);
      pNombres[contador] = equipo2;
    }
  }

  static void llenarNumeroJuegos(int[] pJuegos, String[] pNombres) throws IOException {
    for (int i = 0; i < pNombres.length; i++) {
      out.println("Digite el numero de juegos del equipo " + pNombres[i] + ": ");
      pJuegos[i] = Integer.parseInt(in.readLine());
    }
  }

  static void acumularPuntos(int[] acumuladorPuntos, int acumuladorEquipo1) throws IOException {
    for (int i = 0; i < acumuladorPuntos.length; i++) {
      acumuladorPuntos[i] = acumuladorEquipo1;
    }
  }

  static void imprimirArregloStringYLlenarArregloEnteros(String[] pNombres, int[] pJuegos, int[] pOponentes)
      throws IOException {
    int i;
    for (i = 0; i < pNombres.length; i++) {
      out.println(pNombres[i]);
      // out.println(pJuegos[i]);
      // out.println(pOponentes[i]);
    }
  }

  static void calcularResultadoYCalcularPuntaje(String[] equipos, int[] numJuegos, int[] numOponentes, String[] resultados)
      throws IOException {
    String equipo1, equipo2, respuestaSnitch1, respuestaSnitch2, codigo1, codigo2, acumulador = "";
    int marcadorEquipo1, marcadorEquipo2, acumPts = 0;
    out.println(numJuegos.length);
    //int i=0;
    for (int i = 0; i < numJuegos.length; i++) {
      for (int j = 0; j < numJuegos[i]; j++) {
        System.out.println("Juego " + (j + 1) + " " + equipos[i] + " contra: ");
        equipo2 = in.readLine();
        System.out.println("Marcador del equipo " + equipos[i]);
        marcadorEquipo1 = Integer.parseInt(in.readLine());
        System.out.println("Atrapó la Snitch: ");
        respuestaSnitch1 = in.readLine();
        acumPts += marcadorEquipo1;
        if (respuestaSnitch1.equals("si") || respuestaSnitch1.equals("SI")) {
          codigo1 = "*";
        } else {
          codigo1 = "";
        }
        System.out.println("Marcador del equipo " + equipo2);
        marcadorEquipo2 = Integer.parseInt(in.readLine());
        System.out.println("Atrapó la Snitch: ");
        respuestaSnitch2 = in.readLine();
        if (respuestaSnitch2.equals("si") || respuestaSnitch2.equals("SI")) {
          codigo2 = "*";
        } else {
          codigo2 = "";
        }
        //acumulador = acumulador + equipos[i] + " vs " + equipo2 + " " + resultados[i] + codigo1 + "-" + marcadorEquipo2
          //  + codigo2 + "\n";
          resultados[i] = equipos[i] + " vs " + equipo2 + " " + marcadorEquipo1 + codigo1 + "-" + marcadorEquipo2
          + codigo2;
      }
      
    }
    out.println("Resultados de juegos: \n" +Arrays.toString(resultados));
    out.println("El puntaje total de partidos de \n" + equipos[i] + " es: " + acumPts);
  }

  static void imprimirCalcularResultadoYCalcularPuntaje(String[] equipos, int[] numJuegos, int[] numOponentes,
      String[] resultados) throws IOException {
    int i;
    for (i = 0; i < numJuegos.length; i++) {
      out.println(equipos[i]);
      out.print(resultados[i]);
    }
  }

  static int equipoRutina(String[] arr) throws IOException {
    int contador = 0;
    for (int i = 0; i < arr.length; i++)
      if (!arr[i].equals("value")) {
        contador += 1;
      }
    return contador;
  }
}

