//package src;

import java.io.*;

public class ProyectoFinal {

  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static PrintStream out = System.out;

  public static void main(final String[] args) throws IOException {

    int numJuegos[], numOponentes[], resultados[], cantEquipos, puntajeTotal[];
    String equipos[];
    String equipo1, equipo2;

    out.println("Digite la cantidad total de equipos del torneo ");
    cantEquipos = Integer.parseInt(in.readLine());

    equipos = new String[cantEquipos];
    numJuegos = new int[cantEquipos];
    numOponentes = new int[cantEquipos];
    resultados = new int[cantEquipos];
    puntajeTotal = new int[cantEquipos];

    for (int i = 0; i < equipos.length; i++) {
      equipos[i] = "value";
    }

    llenarArregloStringYLlenarArregloEnteros(equipos, puntajeTotal,numJuegos);
    out.printf("Los equipos son: ");
    imprimirArregloStringYLlenarArregloEnteros(equipos, numJuegos, numOponentes);
    calcularResultadoYCalcularPuntaje(equipos, numJuegos, numOponentes, resultados);
    out.println("Resumen resultados: ");
    imprimirCalcularResultadoYCalcularPuntaje(equipos, numJuegos, numOponentes, resultados);
    ;
    // llenarArregloNumOponentes(numOponentes);
    // out.println("La cantidad de oponentes es: ");
    // imprimirArregloOponentes(numOponentes);

  }

  static void llenarArregloStringYLlenarArregloEnteros(String[] pNombres, int[] pPuntajeTotal, int[] pNumJuegos)
      throws IOException {
    String equipo1, equipo2;

    for (int i = 0; i < pNombres.length; i++) {
      contador = equipoRutina(pNombres);

      out.println("Digite el nombre del equipo " + (i + 1) + ": ");
      equipo1 =  in.readLine();
      pNombres[contador] = equipo1;
      
      
      out.print("Juego " + (i+1) + " contra: ");
      equipo2 =  in.readLine();
      pJuegos[i] = equipo1+"-"+equipo2;
      contador = equipoRutina(equipos);
      pNombres[contador] = equipo2;

      llenarNumeroJuegos = (pNumJuegos, equipo1, equipo2);
    }
      //out.println("Digite el numero de juegos del equipo " + pNombres[i] + ": ");
      //pJuegos[i] = Integer.parseInt(in.readLine());


      //out.println("Digite el numero de oponentes del equipo " + pNombres[i] + ": ");
      //pOponentes[i] = Integer.parseInt(in.readLine());
    }

    static void llenarNumeroJuegos (int[] pJuegos, equipo1, equipo2){
      
      for (int i = 0; i < pNombres.length; i++) {
        contador = equipoRutina(pNombres);
        
        out.println("Digite el numero de juegos del equipo " + equipo1 + ": ");
        pJuegos[i] = Integer.parseInt(in.readLine());

        out.println("Digite el numero de juegos del equipo " + equipo2 + ": ");
        pJuegos[i] =  Integer.parseInt(in.readLine());

      }

    }    
      static void acumularPuntos(int[] acumuladorPuntos, int acumuladorEquipo1, int acumuladorEquipo2)
      throws IOException {
        for (int i = 0; i < acumuladorPuntos.length; i++) {       
          acumuladorPuntos[i] = acumuladorEquipo1;
          acumuladorPuntos[i+1] = acumuladorEquipo2;
        }
  }

  static void imprimirArregloStringYLlenarArregloEnteros(String[] pNombres, int[] pJuegos, int[] pOponentes)
      throws IOException {
    int i;
    for (i = 0; i < pNombres.length; i++) {
      out.println(pNombres[i]);
      out.println(pJuegos[i]);
      out.println(pOponentes[i]);
    }
  }

  static void calcularResultadoYCalcularPuntaje(String[] equipos, int[] numJuegos, int[] numOponentes, int[] resultados)
      throws IOException {
    String equipo1, equipo2, respuestaSnitch1, respuestaSnitch2, codigo1, codigo2, acumulador = "";
    int i, marcadorEquipo1, marcadorEquipo2, acumPts = 0;

    for (i = 0; i < numJuegos.length; i++) {
      System.out.println("Juego " + numJuegos[i] + " " + equipos[i] + " contra: ");
      equipo2 = in.readLine();
      System.out.println("Marcador del equipo " + equipos[i]);
      resultados[i] = Integer.parseInt(in.readLine());
      System.out.println("Atrapó la Snitch: ");
      respuestaSnitch1 = in.readLine();
      acumPts += resultados[i];
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
      acumulador = acumulador + equipos[i] + " vs " + equipo2 + " " + resultados[i] + codigo1 + "-" + marcadorEquipo2
          + codigo2 + "\n";
    }
    out.println("Resultados de juegos: \n" + acumulador);
    out.println("El puntaje total de partidos de " + equipos[i] + " es: " + acumPts);

  }

  static void imprimirCalcularResultadoYCalcularPuntaje(String[] equipos, int[] numJuegos, int[] numOponentes,
      int[] resultados) throws IOException {
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
