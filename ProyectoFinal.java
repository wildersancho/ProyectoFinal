import java.io.*;
import java.util.Arrays;

public class App {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

 
    public static void main(final String[] args) throws IOException {

      int numJuegos[], numOponentes[], cantEquipos, puntajeTotal[], acumulaPts[], acumuladoJuegos, opcion;
      String equipos[], resultados[], resultadosFinal[], resultadosAcumulados = "";
      double promedioEquipos = 0.00;
      boolean salir;
      salir = false;
  
      equipos = new String[3];
      numJuegos = new int[3];
      numOponentes = new int[3];
      puntajeTotal = new int[3];
      acumulaPts = new int[3];
  
      do {
        System.out.println("Seleccione una opcion del menú digitando el numero");
        menu();
        opcion = Integer.parseInt(in.readLine());
        
        System.out.println();
  
        switch (opcion) {
          case 1:
            out.println("Digite la cantidad total de equipos del torneo ");
            cantEquipos = Integer.parseInt(in.readLine());
          
              equipos = new String[cantEquipos];
              numJuegos = new int[cantEquipos];
              numOponentes = new int[cantEquipos];
              puntajeTotal = new int[cantEquipos];
              acumulaPts = new int[cantEquipos];
            break;
  
          case 2:
          for (int i = 0; i < equipos.length; i++) {
            equipos[i] = "value";
          } 
            llenarArregloStringYLlenarArregloEnteros(equipos, puntajeTotal, numJuegos, numOponentes);
                      
            break;
  
          case 3:
            acumuladoJuegos = llenarNumeroJuegos(numJuegos, equipos);
            resultados = new String[acumuladoJuegos];
            for (int i = 0; i < resultados.length; i++) {
              resultados[i] = "value";//test
            }
            calcularResultadoYCalcularPuntaje(equipos, numJuegos, numOponentes, resultados, acumulaPts);
            resultadosAcumulados = imprimirCalcularResultadoYCalcularPuntaje(resultados);
  
            break;
  
          case 4:
            out.println(resultadosAcumulados);
            break;
  
          case 5:
            puntajeTotal(equipos, acumulaPts, numJuegos, numOponentes);
            break;
  
          case 6:
            promedioEquipos = calcularPromedio(numOponentes);
            out.println("El promedio de oponentes es: " + promedioEquipos);
            break;
  
          case 7:
            equipoMasPartidos(numJuegos, equipos);
            break;
  
          case 8:
            equipoMenosPuntos(acumulaPts, equipos);
            break;
  
          case 9:
            equipoMas5(numJuegos, equipos);
            break;
  
          case 10:
            promedioMayor(numOponentes, equipos, promedioEquipos);
            break;
  
          case 11:
            out.print("Gracias por utilizar Quidditch ");
            break;
  
          default:
            out.println("Opcion invalida");
            break;
        }
  
      } while (opcion != 11);
    }
  
    static void llenarArregloStringYLlenarArregloEnteros(String[] pNombres, int[] pPuntajeTotal, int[] pNumJuegos,
        int[] pNumOponentes) throws IOException {
  
      String equipo1;
      int numOponentes;
      int contador;   
  
      for (int i = 0; i < pNombres.length; i++) {
        
        contador = equipoRutina(pNombres);
        out.print("Digite el nombre del equipo " + (contador + 1) + ": ");
        equipo1 = in.readLine();
        pNombres[contador] = equipo1;
  
        out.print("Digite el numero de oponentes del equipo " + equipo1 + ": ");
        numOponentes = Integer.parseInt(in.readLine());
        pNumOponentes[i] = numOponentes;
  
      }
    }
  
    static int llenarNumeroJuegos(int[] pJuegos, String[] pNombres) throws IOException {
      int acumulaJuegos = 0;
      for (int i = 0; i < pNombres.length; i++) {
        out.println("Digite el numero de juegos del equipo " + pNombres[i] + ": ");
        pJuegos[i] = Integer.parseInt(in.readLine());
        acumulaJuegos = pJuegos[i] + acumulaJuegos;
      }
      return acumulaJuegos;
    }
  
    static void imprimirArregloStringYLlenarArregloEnteros(String[] pNombres, int[] pJuegos, int[] pOponentes)
        throws IOException {
      int i;
      for (i = 0; i < pNombres.length; i++) {
        out.println(pNombres[i]);
  
      }
    }
  
    static void calcularResultadoYCalcularPuntaje(String[] equipos, int[] numJuegos, int[] numOponentes,
      String[] resultados, int[] acumulaPts) throws IOException {
      String equipo2, respuestaSnitch1, respuestaSnitch2, codigo1, codigo2, acumulador = "";
      int marcadorEquipo1, contador, marcadorEquipo2, acumPts = 0;
      out.println(numJuegos.length);
      for (int i = 0; i < numJuegos.length; i++) {
        acumPts = 0;
        for (int j = 0; j < numJuegos[i]; j++) {
          System.out.println("Juego " + (j + 1) + " " + equipos[i] + " contra: ");
          equipo2 = in.readLine();
          System.out.println("Marcador del equipo " + equipos[i]);
          marcadorEquipo1 = Integer.parseInt(in.readLine());
          System.out.println("Atrapó la Snitch: ");
          respuestaSnitch1 = in.readLine();
          acumPts += marcadorEquipo1;
          acumulaPts[i] = acumPts;
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
          acumulador = equipos[i] + " vs " + equipo2 + " " + marcadorEquipo1 + codigo1 + "-" + marcadorEquipo2 + codigo2;
          contador = equipoRutina(resultados);
          resultados[contador] = acumulador;
        }
      }
  
    }
  
    static String imprimirCalcularResultadoYCalcularPuntaje(String[] resultados) throws IOException {
      String resultadosAcumulados = "";
      for (int i = 0; i < resultados.length; i++) {
      resultadosAcumulados = "\n" + resultados[i] + resultadosAcumulados ;
      }
      return resultadosAcumulados;
    }
  
    static int equipoRutina(String[] arr) throws IOException {
      int contador = 0;
      for (int i = 0; i < arr.length; i++){
        if (!arr[i].equals("value")) {
          contador += 1;
        }
      }  
      return contador;
    }
  
    static void puntajeTotal(String[] equipos, int[] acumulaPuntos, int[] numJuegos, int[] numOponentes)
        throws IOException {
      String nombreEquipo = " ";
      double puntosJuegos = 0.00;
      double puntosOponentes = 0.00;
      for (int i = 0; i < equipos.length; i++) {
        double puntosAcumulados = Double.valueOf(acumulaPuntos[i]);
        nombreEquipo = equipos[i];
        if (numJuegos[i] >= 5) {
          puntosJuegos = 1;
        } else if (numJuegos[i] < 5) {
          puntosJuegos = Math.sqrt(numJuegos[i]) / 2.25;
        }
        if (numOponentes[i] == 1 || numOponentes[i] == 2) {
          puntosOponentes = numOponentes[i] / 3;
        } else if (numOponentes[i] >= 3) {
          puntosOponentes = 1;
        }
        puntosAcumulados = puntosAcumulados + puntosJuegos + puntosOponentes;
        out.println("El puntaje total del " + nombreEquipo + " fue: " + puntosAcumulados + " puntos");
      }
  
    }
  
    static double calcularPromedio(int[] arr) throws IOException {
      double suma = 0.00;
      double promedio = 0.00;
      for (int i = 0; i < arr.length; i++) {
        suma = suma + arr[i];
      }
      promedio = suma / arr.length;
      return promedio;
    }
  
    static void promedioMayor(int[] numOponentes, String[] equipos, double calcularPromedio) throws IOException {
      for (int i = 0; i < equipos.length; i++) {
        if (numOponentes[i] > calcularPromedio) {
          out.println("El equipo " + equipos[i] + " tuvo más oponentes que el promedio general");
        }
      }
    }
  
    static void equipoMasPartidos(int[] numJuegos, String[] equipos) throws IOException {
      int masJuegos = 0;
      String equipoMasJuegos = "";
      for (int i = 0; i < equipos.length; i++) {
        if (numJuegos[i] > masJuegos) {
          masJuegos = numJuegos[i];
          equipoMasJuegos = equipos[i];
        }
      }
      out.println("El equipo " + equipoMasJuegos + " fue el que tuvo mas partidos en el torneo");
    }
  
    static void equipoMenosPuntos(int[] puntajeTotal, String[] equipos) throws IOException {
      int menosPuntos = Integer.MAX_VALUE;
      String equipoMenosPuntos = "";
      for (int i = 0; i < equipos.length; i++) {
        if (puntajeTotal[i] < menosPuntos) {
          menosPuntos = puntajeTotal[i];
          equipoMenosPuntos = equipos[i];
        }
      }
      out.println("El equipo " + equipoMenosPuntos + " fue el que tuvo menos puntos en el torneo");
    }
  
    static void equipoMas5(int[] numJuegos, String[] equipos) throws IOException {
      String equipoMas5 = "";
      for (int i = 0; i < equipos.length; i++) {
        if (numJuegos[i] >= 5) {
          equipoMas5 = equipoMas5 + equipos[i] + "\n";
        }
      }
      out.println("Los siguientes equipos tuvieron más de 5 partidos:");
      out.println(equipoMas5);
    }
  
    static void menu() {
  
      System.out.println(
          "*****************************************************************************************************");
      System.out.println();
      System.out.println(" Bienvenido a Quidditch  ");
      System.out.println();
      System.out.println("1. Digite el total de equipos del torneo ");
      System.out.println("2. Registrar informacion de equipos, numero de juegos y numero de oponentes ");
      System.out.println("3. Construir reporte de resultados de equipos  ");
      System.out.println("4. Imprimir reporte resultados de equipos  ");
      System.out.println("5. Imprimir puntaje total de equipos  ");
      System.out.println("6. Calcular el promedio de oponentes diferentes que tienen todos los equipos del torneo ");
      System.out.println("7. Imprimir el nombre del equipo que ha jugado más partidos en todo el torneo ");
      System.out.println("8. Imprimir el nombre del equipo que con menor puntaje en todo el torneo ");
      System.out.println("9. Imprimir los nombres de los equipos que han jugado 5 partidos o más  ");
      System.out.println(
          "10. Imprimir el nombre de los equipos que tengan más oponentes que el promedio general de oponentes ");
      System.out.println("11. Salir ");
      System.out.println();
      System.out.println(
          "*******************************************************************************************************");
  
    }
  
  }
    
    