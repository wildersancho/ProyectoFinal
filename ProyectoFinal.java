import java.io.*;
import java.util.Arrays;

public class App {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

 
    public static void main(final String[] args) throws IOException {

        int numJuegos[], numOponentes[], cantEquipos, puntajeTotal[],acumulaPts[], acumuladoJuegos;
        String equipos[], partidos[],resultados[];
        String equipo1, equipo2;
    
        out.println("Digite la cantidad total de equipos del torneo ");
        cantEquipos = Integer.parseInt(in.readLine());
    
        equipos = new String[cantEquipos];
        numJuegos = new int[cantEquipos];
        numOponentes = new int[cantEquipos];
        puntajeTotal = new int[cantEquipos];
        partidos = new String[cantEquipos / 2];
        acumulaPts = new int [cantEquipos];
    
        for (int i = 0; i < equipos.length; i++) {
          equipos[i] = "value";
        }

    
        llenarArregloStringYLlenarArregloEnteros(equipos, puntajeTotal, numJuegos,numOponentes);
        out.printf("Los equipos son: \n");
        imprimirArregloStringYLlenarArregloEnteros(equipos, numJuegos, numOponentes);
        //llenarNumeroJuegos(numJuegos, equipos);
        acumuladoJuegos = llenarNumeroJuegos(numJuegos, equipos);
        //acumuladoJuegos = numJuegos.length+1;
        resultados = new String[acumuladoJuegos];
        for (int i = 0; i < resultados.length; i++) {
            resultados[i] = "value";
          }
        calcularResultadoYCalcularPuntaje(equipos, numJuegos, numOponentes, resultados, acumulaPts);
        out.println("Resumen resultados:");
        imprimirCalcularResultadoYCalcularPuntaje(equipos, numJuegos, numOponentes, resultados);
        puntajeTotal(equipos, acumulaPts, numJuegos, numOponentes);
    
      }
    
      static void llenarArregloStringYLlenarArregloEnteros(String[] pNombres, int[] pPuntajeTotal, int[] pNumJuegos, int [] pNumOponentes) throws IOException {
        
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
          pNumOponentes[i]= numOponentes;

        }
      }
    
      static int llenarNumeroJuegos(int[] pJuegos, String[] pNombres) throws IOException {
        int acumulaJuegos = 0;
        for (int i = 0; i < pNombres.length; i++) {
          out.println("Digite el numero de juegos del equipo " + pNombres[i] + ": ");
          pJuegos[i] = Integer.parseInt(in.readLine());
          acumulaJuegos =  pJuegos[i]+acumulaJuegos;
        }
        return acumulaJuegos;
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
    
      static void calcularResultadoYCalcularPuntaje(String[] equipos, int[] numJuegos, int[] numOponentes, String[] resultados, int [] acumulaPts)
          throws IOException {
        String equipo1, equipo2, respuestaSnitch1, respuestaSnitch2, codigo1, codigo2, acumulador = "";
        int marcadorEquipo1, contador, marcadorEquipo2, acumPts = 0;
        out.println(numJuegos.length);
        //int i=0;
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
            //acumulador = acumulador + equipos[i] + " vs " + equipo2 + " " + resultados[i] + codigo1 + "-" + marcadorEquipo2
              //  + codigo2 + "\n";
              acumulador = equipos[i] + " vs " + equipo2 + " " + marcadorEquipo1 + codigo1 + "-" + marcadorEquipo2
              + codigo2;
              contador= equipoRutina(resultados);
              out.println(contador);
              out.println(resultados.length);
              resultados[contador]= acumulador;
          }    
        }
        out.println("El puntaje total de partidos de" +Arrays.toString(acumulaPts));
      }
    
      static void imprimirCalcularResultadoYCalcularPuntaje(String[] equipos, int[] numJuegos, int[] numOponentes,
          String[] resultados) throws IOException {
        for (int i = 0; i < resultados.length; i++) {
          //out.println(equipos[i]);
          out.println(resultados[i]);
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

      static void puntajeTotal(String[] equipos, int[] acumulaPuntos, int[] numJuegos, int [] numOponentes) throws IOException {
        String nombreEquipo = " ";
        double puntosJuegos = 0.00;
        double puntosOponentes = 0.00;
        for(int i=0; i<equipos.length;i++){
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
                puntosAcumulados= puntosAcumulados+puntosJuegos+puntosOponentes;
                out.println("El puntaje total del "+nombreEquipo+" fue: "+puntosAcumulados+" puntos");
            }
        
                
        }
        
    
}
    
    