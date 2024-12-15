package examenFicheros;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;

public class Prueba {
	
	public static final String OLD="D:\\Estaciones.txt";
	public static final String CLEAR="D:\\Limpio.txt";
	public static final String HISTORY="D:\\History.txt";
	public static final String STORY="D:\\Relato.txt";

	public static void main(String[] args) {
		
		ArrayList<Estacion> estaciones = new ArrayList<>();
		
		
		//inserccion de nuevos registros
		Coordenada axis1 = new Coordenada(23,24);
		Coordenada axis2 = new Coordenada(256,254);
		Coordenada axis3 = new Coordenada(2893,234);
		
		Estacion estacion1 = new Estacion("Estacion perdida",axis1);
		Estacion estacion2 = new Estacion("Estacion encontrada",axis2);
		Estacion estacion3 = new Estacion("Estacion destruida",axis3);
		
		estaciones.add(estacion1);
		estaciones.add(estacion2);
		estaciones.add(estacion3);
				
		ArrayList<String> people1 = new ArrayList<>();
		people1.add("Pepe");
		people1.add("Maria");
				
		ArrayList<String> people2 = new ArrayList<>();
		people2.add("Juan");
		people2.add("Reyes");
				
				
		estacion1.setPeople(people1);
		estacion2.setPeople(people2);
		
		
		//funciones
		fileToArray(estaciones);
		
		
		arrayToScreen(estaciones);
		arrayToFile(estaciones);
		
		
		historyFile(estaciones);
		countWords();
		

	}

	
	//funcion para leer el fichero y pasarlo al array de estaciones
	public static void fileToArray(ArrayList<Estacion> estaciones) {
		
		String[] pieces;
		
		try {
			
			FileReader fr= new FileReader(OLD);
            BufferedReader br = new BufferedReader(fr);

            String newLine = br.readLine();
            
            while (newLine != null) {
            	
            	//ignoramos la primera linea
            	if(!newLine.contains("----")) {
            		pieces=newLine.split(";");

                	//compruebo si la linea es completamente basura
                	if(!isTrash(pieces[0])) {
                		
                		//si no es basura tiene minimo 2 campos separados por ";" , el nombre y las coordenadas
                		
                		String[]piecesAxis= pieces[1].split(",");
                		Coordenada axis = new Coordenada(Integer.parseInt(piecesAxis[0]),Integer.parseInt(piecesAxis[1]));
                		estaciones.add(new Estacion(pieces[0],axis));
                		
                		//comprobamos si tiene 3er campo, que puede ser personas o basura
                		
                		if(pieces.length==3) {
                			
                			//comprobamos si el ultimo campo es basura
                			if(!isTrash(pieces[2])) {
                				
                				
                				//creamos un arraylist de personas
                				String[] people = pieces[2].split(" ");
                				ArrayList<String> peopleList = new ArrayList<>();
                				for(int i=0;i<people.length;i++) {
                					peopleList.add(people[i]);
                				}
                				
                				//recuperamos la ultima estacion del arraylist y le añadimos las personas
                				estaciones.getLast().setPeople(peopleList);
                			}
                			
                		}
                		
                		
                	}
            	}
            	
            	newLine = br.readLine();
            	
            	
                

            }

            br.close();
            fr.close();
			
		}catch (IOException e) {
            System.out.println("Hay un problema con el fichero "+e.getMessage());
        } catch (Exception error){
            System.out.println("Error inesperado "+error.getMessage());
        }
	
		
		
	}
	
	
	
	
	//funcion que muestra con formato humano en pantalla
	public static void arrayToScreen(ArrayList<Estacion> estaciones) {
		for(int i =0;i<estaciones.size();i++) {
			System.out.println(estaciones.get(i).toString());
		}
	}

	//funcion que copia el array al fichero nuevo Limpio.txt
	public static void arrayToFile(ArrayList<Estacion> estaciones) {
		
		try {
            FileWriter fw= new FileWriter(CLEAR);
            fw.flush();
            PrintWriter pw= new PrintWriter(fw,true);

            int i=0;


            while (i<estaciones.size()) {
                pw.println(estaciones.get(i).putString());
                i++;
            }

            pw.close();
            fw.close();
            
        } catch (IOException e) {
            
            System.out.println("Hay un problema con el fichero "+e.getMessage());
        }
		
		
	}


	//funcion que escriba el historico en el fichero History.txt
	public static void historyFile(ArrayList<Estacion> estaciones) {
		
		try {
            FileWriter fw= new FileWriter(HISTORY,true);
            //fw.flush();
            PrintWriter pw= new PrintWriter(fw,true);

            int i=0;

            pw.println("RESUMEN: "+fechaActual());
            while (i<estaciones.size()) {
                pw.println(estaciones.get(i).toString());
                i++;
            }

            pw.println("");
            pw.close();
            fw.close();
            
        } catch (IOException e) {
            
            System.out.println("Hay un problema con el fichero "+e.getMessage());
        }
	}	
	
	//funcion para comprobar si la linea es basura
	public static boolean isTrash(String line) {
		boolean trash=false;
		
		if(line.contains("#")) {
			trash=true;
		}
		
		return trash;
	}
	
	
	//funcion que cuenta las palabras del fichero Relato.txt
	public static void countWords() {
		String words="";
		

        String[] pieces;
        int count=0;

        try {
            FileReader fr= new FileReader(STORY);
            BufferedReader br = new BufferedReader(fr);

            String newLine = br.readLine();
            while (newLine != null) {
            	//lo separo por espacios y obvio los puntos y comas
                pieces=newLine.split(" ");

                count+=pieces.length;
                newLine=br.readLine();
          
            }

            br.close();
            fr.close();

        } catch (IOException e) {
            System.out.println("Hay un problema con el fichero "+e.getMessage());
        } catch (Exception error){
            System.out.println("Error inesperado "+error.getMessage());
        }
		
        System.out.println("\nEl fichero Relato.txt tiene "+count+" palabras.");
		
	}
	
	
	
	//Devuelve la fecha actual en el formato [dd/mm/yyyy , hh:mm]
    public static String fechaActual(){

        Calendar calendario = Calendar.getInstance();

        int dia = calendario.get(Calendar.DAY_OF_MONTH);
        int mes = (calendario.get(Calendar.MONTH)+1);
        int anio = calendario.get(Calendar.YEAR);
        int hora = calendario.get(Calendar.HOUR_OF_DAY);
        int minutos = calendario.get(Calendar.MINUTE);
        String aux="";

        if (minutos<10) {
            aux="0";
        }

        String fecha = "["+dia+"/"+mes+"/"+anio+" , "+hora+":"+aux+minutos+"]";

        return fecha;
    }
}
