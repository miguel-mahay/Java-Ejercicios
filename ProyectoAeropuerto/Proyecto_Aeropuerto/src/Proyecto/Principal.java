
package Proyecto;

import java.util.Scanner;


public class Principal {
    static Scanner entrada = new Scanner(System.in);
    final static int num = 4; // Numero de aeropuertos
    static Aeropuerto aeropuertos[] = new Aeropuerto[num];

    
    public static void main(String[] args) {
        
        //Insertar datos de los aeropuertos
        insertarDatosAeropuerto(aeropuertos);
        
        menu();
        
        
    }
    
    public static void insertarDatosAeropuerto(Aeropuerto aeropuerto[]){
        aeropuerto[0] = new AeropuertoPublico(8000000, "Jorge Chavez", "Lima", "Peru");
        aeropuerto[0].insertarCompania(new Compania("Aeroperu"));
        aeropuerto[0].insertarCompania(new Compania("LATAM"));
        aeropuerto[0].getCompania("Aeroperu").insertarVuelo(new Vuelo("IB20", "Lima", "Mexico", 190.50, 100));
        aeropuerto[0].getCompania("Aeroperu").insertarVuelo(new Vuelo("IB21", "Lima", "Buenos aires",150.99, 120));
        aeropuerto[0].getCompania("LATAM").insertarVuelo(new Vuelo("FC12", "Lima", "Londres",480.27, 150));
        aeropuerto[0].getCompania("Aeroperu").getVuelo("IB20").insertarPasajero(new Pasajero("Miguel", "MX20BGH", "Mexicano"));
        aeropuerto[0].getCompania("Aeroperu").getVuelo("IB20").insertarPasajero(new Pasajero("Rosa", "PR16LKH", "Peruana"));
        aeropuerto[0].getCompania("LATAM").getVuelo("FC12").insertarPasajero(new Pasajero("Leonor", "PR18FG41", "Peruana"));
        
        aeropuerto[1] = new AeropuertoPrivado("Central Ciudad Real", "Ciudad Real", "España");
        aeropuerto[1].insertarCompania(new Compania("AirEuropa"));
        String empresas[] = {"Cobresol", "Anguila"};
        ((AeropuertoPrivado)aeropuerto[1]).insertarEmpresas(empresas);
        aeropuerto[1].getCompania("AirEuropa").insertarVuelo(new Vuelo("AE025", "Madrid", "Buenos Aires", 550.74, 135));
        aeropuerto[1].getCompania("AirEuropa").getVuelo("AE025").insertarPasajero(new Pasajero("Roman", "ES475HMD", "Español"));
        
        aeropuerto[2] = new AeropuertoPublico(2000000, "Aeropuerto Bogota", "Bogota", "Colombia");
        aeropuerto[2].insertarCompania(new Compania("AirAmerica"));
        aeropuerto[2].insertarCompania(new Compania("VuelaBogota"));
        aeropuerto[2].getCompania("AirAmerica").insertarVuelo(new Vuelo("AE030", "Bogota", "Lima", 170.05, 110));
        aeropuerto[2].getCompania("AirAmerica").insertarVuelo(new Vuelo("AE031", "Bogota", "Lima",200.17, 130));
        aeropuerto[2].getCompania("AirAmerica").getVuelo("AE030").insertarPasajero(new Pasajero("Samantha", "COL478FGS", "Colombiana"));
        aeropuerto[2].getCompania("AirAmerica").getVuelo("AE030").insertarPasajero(new Pasajero("Julio", "COL184MHW", "Colombiano"));
        
        aeropuerto[3] = new AeropuertoPublico(4000000, "Aeropuerto Mexico", "Ciudad de Mexico", "Mexico");
        aeropuerto[3].insertarCompania(new Compania("AeroMexico"));
        aeropuerto[3].getCompania("AeroMexico").insertarVuelo(new Vuelo("IB2040", "Ciudad de Mexico", "Rio de Janeiro", 200.91, 150));
        aeropuerto[3].getCompania("AeroMexico").insertarVuelo(new Vuelo("IB2042", "Ciudad de Mexico", "Vancouver", 160.72, 100));
        aeropuerto[3].getCompania("AeroMexico").getVuelo("IB2040").insertarPasajero(new Pasajero("Joao", "BR175DGD", "Brasileno"));
        
    }
    
    
    public static void menu(){
        String nombreAeropuerto, nombreCompania, origen, destino;
        int opcion;
        Aeropuerto aeropuerto;
        Compania compania;
        
        do{
            System.out.println("\t..::MENU::..");
            System.out.println("1. Ver aeropuertos gestionados (Publicos o Privados");
            System.out.println("2. Ver empresas patrocinadora(Privado) o subvención (Público)");
            System.out.println("3. Lista de compañias de un aeropuerto");
            System.out.println("4. Lista de vuelos por Compañia");
            System.out.println("5. Listar posibles vuelos de Origen a Destino");
            System.out.println("6. Salir");
            System.out.print("Digite una opción del menu: ");
            opcion = entrada.nextInt();
            
            switch(opcion){
                case 1: // Ver aeropuertos gestionados (Publicos o Privados
                        System.out.println("");
                        mostrarDatosAeropuertos(aeropuertos);
                        break;
                        
                case 2: // Ver empresas patrocinadora(Privado) o subvención (Público)
                        System.out.println("");
                        mostrarPatrocinio(aeropuertos);
                        break;
                
                case 3: // Lista de compañias de un aeropuerto
                        entrada.nextLine();
                        System.out.print("\nDigite el nombre del aeropuerto: ");
                        nombreAeropuerto = entrada.nextLine();
                        aeropuerto = buscarAeropuerto(nombreAeropuerto, aeropuertos);
                        
                        if(aeropuerto == null){
                            System.out.println("El aeropuerto no existe");
                        }
                        else{
                            mostrarCompanias(aeropuerto);
                        }
                        
                        break;
                        
                case 4: // Lista de vuelos por Compañia
                        entrada.nextLine();
                        System.out.print("\nDigite el nombre del aeropuerto: ");
                        nombreAeropuerto = entrada.nextLine();
                        aeropuerto = buscarAeropuerto(nombreAeropuerto, aeropuertos);
                        
                        if(aeropuerto == null){
                            System.out.println("El aeropuerto no existe");
                        }
                        else{
                            System.out.print("Digite el nombre de la compañia: ");
                            nombreCompania = entrada.nextLine();
                            compania = aeropuerto.getCompania(nombreCompania);
                            mostrarVuelos(compania);
                            
                        }
                        
                        break;
                        
                case 5: //Listar posibles vuelos de Origen a Destino
                        entrada.nextLine();
                        System.out.print("\nDigite la ciudad de origen: ");
                        origen = entrada.nextLine();
                        System.out.print("Digite la ciudad de destino: ");
                        destino = entrada.nextLine();
                        mostrarVueloOrigenDestino(origen, destino, aeropuertos);
                        
                        break;
                        
                case 6: break;
                
                default: System.out.println("Opción inválida. Intentelo de nuevo");
                
            }
            System.out.println("");
            
        }while(opcion != 6);
    }
    
    
    public static void mostrarDatosAeropuertos(Aeropuerto aeropuertos[]){
        for(int i=0; i<aeropuertos.length; i++){
            if(aeropuertos[i] instanceof AeropuertoPrivado){
                System.out.println("Aeropuerto Privado");
                System.out.println("Nombre: " + aeropuertos[i].getNombre());
                System.out.println("Ciudad: " + aeropuertos[i].getCiudad());
                System.out.println("País: " + aeropuertos[i].getPais());
            }
            else{
                System.out.println("Aeropuerto Público");
                System.out.println("Nombre: " + aeropuertos[i].getNombre());
                System.out.println("Ciudad: " + aeropuertos[i].getCiudad());
                System.out.println("País: " + aeropuertos[i].getPais());
            }
            System.out.println("");
        }
    }
    
    
    
    public static void mostrarPatrocinio(Aeropuerto aeropuertos[]){
        String empresas[];
        
        for(int i=0; i<aeropuertos.length; i++){
            if(aeropuertos[i] instanceof AeropuertoPrivado){
                System.out.println("Aeropuerto Privado: " + aeropuertos[i].getNombre());
                empresas = ((AeropuertoPrivado)aeropuertos[i]).getListaEmpresas();
                System.out.println("Empresas: ");
                
                for(int j=0; j<empresas.length; j++){
                    System.out.println(empresas[j]);
                }
            }
            else{
                System.out.println("Aeropuerto Público: " + aeropuertos[i].getNombre());
                System.out.println("Subvención: " + ((AeropuertoPublico)aeropuertos[i]).getSubvencion());
            }
            System.out.println("");
        }
    }
    
    
    public static Aeropuerto buscarAeropuerto(String nombre, Aeropuerto aeropuertos[]){
        boolean encontrado = false;
        int i=0;
        Aeropuerto aero = null;
        
        while((!encontrado) && (i<aeropuertos.length)){
            if(nombre.equals(aeropuertos[i].getNombre())){
                encontrado = true;
                aero = aeropuertos[i];
            }
            i++;
        }
        
        return aero;
    }
    
    
    public static void mostrarCompanias(Aeropuerto aeropuerto){
        System.out.println("Las compañias del aeropuerto " + aeropuerto.getNombre() + " son: ");
        for(int i=0; i<aeropuerto.getNumCompania(); i++){
            System.out.println(aeropuerto.getCompania(i).getNombre());
        }
    }
    
    public static void mostrarVuelos(Compania compania){
        Vuelo vuelo;
        
        System.out.println("Los vuelos de la compañia " + compania.getNombre() + " son:");
        for(int i=0; i<compania.getNumVuelo(); i++){
            vuelo = compania.getVuelo(i);
            System.out.println("Identificador: " + vuelo.getIdentificador());
            System.out.println("Ciudad origen: " + vuelo.getCiudadOrigen());
            System.out.println("Ciudad destino: " + vuelo.getCiudadDestino());
            System.out.println("Precio: " + vuelo.getPrecio() );
            System.out.println("");
        }
    }
    
    
    public static Vuelo[] buscarVuelosOrigenDestino(String origen, String destino, Aeropuerto aeropuertos[]){
        Vuelo vuelo;
        int contador = 0;
        Vuelo listaVuelos[];
        
        for(int i=0; i<aeropuertos.length; i++){ //Recorremos los aeropuertos
            for(int j=0; j<aeropuertos[i].getNumCompania(); j++){
                for(int k=0; k<aeropuertos[i].getCompania(j).getNumVuelo(); k++){ //Recorremos los vuelos
                    vuelo = aeropuertos[i].getCompania(j).getVuelo(k);
                    if(origen.equals(vuelo.getCiudadOrigen()) && (destino.equals(vuelo.getCiudadDestino()))){
                        contador++;
                    }
                }
            }
        }
        
        listaVuelos = new Vuelo[contador];
        int q=0;
        
        for(int i=0; i<aeropuertos.length; i++){
            for(int j=0; j<aeropuertos[i].getNumCompania(); j++){
                for(int k=0; k<aeropuertos[i].getCompania(j).getNumVuelo(); k++){
                    vuelo = aeropuertos[i].getCompania(j).getVuelo(k);
                    if(origen.equals(vuelo.getCiudadOrigen()) && (destino.equals(vuelo.getCiudadDestino()))){
                        listaVuelos[q] = vuelo;
                        q++;
                    }
                }
                
            }
        }
        
        return listaVuelos;
    }
            
                
    public static void mostrarVueloOrigenDestino(String origen, String destino, Aeropuerto aeropuertos[]){
        Vuelo vuelos[];
        vuelos = buscarVuelosOrigenDestino(origen, destino, aeropuertos);
        
        if(vuelos.length == 0){
            System.out.println("No existen vuelos de esa ciudad origen a destino");
        }
        else{
            System.out.println("\nVuelos encontrados: ");
            for(int i=0; i<vuelos.length; i++){
                System.out.println("Identificador: " + vuelos[i].getIdentificador());
                System.out.println("Ciudad origen: " + vuelos[i].getCiudadOrigen());
                System.out.println("Ciudad destino: " + vuelos[i].getCiudadDestino());
                System.out.println("Precio: $" + vuelos[i].getPrecio());
                System.out.println("");
            }
        }
        
        
    }
    
}
