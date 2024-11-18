/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unipi.lsmdproject.GeneratingData;

//Using the Nominatim serivce for making request
import it.unipi.lsmdproject.Nominatim.*;
//Importing for the timestamp of departure and arrival attribute
import java.time.LocalDateTime;
//Importing libraries for JSON files
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import it.unipi.lsmdproject.Nominatim.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 *
 * @author nicol
 */

public class Pool {
    
    private int idPool;
    private String driverName;
    private String driverSurname;
    private String departureCity;
    private String arrivalCity;
    private LocalDateTime departureTime;
    //Uno sarà quello che inserisce il guidatore, l'altro è quello stimato dal sistema
    private LocalDateTime arrivalTimeByDriver;
    private LocalDateTime arrivalTimeBySystem;
    
    //Costruttore iniziale
    public Pool(int idPool, String departureCity, String arrivalCity, LocalDateTime departureTime, LocalDateTime arrivalTimeByDriver, LocalDateTime arrivalTimeBySystem) {
        this.idPool = idPool;
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.departureTime = departureTime;
        this.arrivalTimeByDriver = arrivalTimeByDriver;
        this.arrivalTimeBySystem = arrivalTimeBySystem;
    }
    
    //Costruttore che genera esempi casuali, lo distinguiamo col parametro numero esempi
    public Pool(int numberExamples){
        JSONArray cities = readJsonFromFile();
        //Converto l'array in una lista di oggetti città
        List<ItalianCity> cityList = convertJsonToList(cities);
        //Genera gli esempi randomici di pool passandoli la lista oggetti che ora popolo
        generateRandomPools(cityList, numberExamples);
    }
    
    //Leggo il file JSON e lo ritorno come array per convertirlo in una lista
    private JSONArray readJsonFromFile() {
        //Reading from the local file it.json. This file contains all the city in Italy,
        //With the coords of the central points
        InputStream is = getClass().getClassLoader().getResourceAsStream("it.json");
        
        if (is == null) {
            throw new IllegalStateException("Find not found");
        }
        
        Scanner scanner = new Scanner(is, StandardCharsets.UTF_8.name());
        String json = scanner.useDelimiter("\\A").next();
        scanner.close();
        return new JSONArray(json);
    }
    
    private List<ItalianCity> convertJsonToList(JSONArray citiesJson){
        
        List<ItalianCity> cities = new ArrayList<>();
        
        //Converto le città dal formato JSON in una lista di oggetti ItalianCity (miglior gestione dati)
        for(int i = 0; i < citiesJson.length(); i++){
            JSONObject cityJson = citiesJson.getJSONObject(i);
            cities.add(new ItalianCity(cityJson.getString("city"),cityJson.getDouble("lat"),cityJson.getDouble("lng")));
        }
        return cities;
    }
    
     private void generateRandomPools(List<ItalianCity> cities, int numberExamples) {
         
        //Genero un numero random che mi servirà per scegliere una città a caso 
         Random random = new Random();
         
        for (int i = 0; i < numberExamples; i++) {
            
            //Prendo una città a caso dalla lista delle città (la random va da 0 a dim_lista - 1)
            ItalianCity departure = cities.get(random.nextInt(cities.size()));
            ItalianCity arrival;
            
            //Faccio questo ciclo per evitare che la partenza sia uguale all'arrivo
            //(Lo so che da noia tutto nel while ma volevo evitare un flag bool esterno)
            do{
                arrival = cities.get(random.nextInt(cities.size()));
            }while(departure.getName().equals(arrival.getName()));

            //Queste due righe ho chiesto al sommo e le ha fatte lui (poi si toglie)
            //Prendo la data e ora corrente e aggiungo un numero random di giorni fino a 29, poi tronco
            //Gli orari per prendere ore di partenza secche tipo (14:00) o (15:00)
            //Aggiunge da 0 a 23 ore all'orario messo avendo così partenze sfalzate tra di loro
            LocalDateTime depTime = LocalDateTime.now().plusDays(random.nextInt(30)).truncatedTo(ChronoUnit.HOURS).plusHours(random.nextInt(24));
            //Qui poi aggiungo da 1 a 5 ore all'oraro di arrivo (questi dati sono quelli che metterebbe l'utente)
            //Non quelli stimati dal sistema
            LocalDateTime arrTime = depTime.plusHours(1 + random.nextInt(5));

            System.out.printf("Pool ID: %d, Departure: %s, Arrival: %s, Departure Time: %s, Arrival Time: %s\n",
                    i + 1, departure.getName(), arrival.getName(), depTime, arrTime);
        }
    }
     
    //Methods for retrieve the private fields
    public int getPoolId(){
        return idPool;
    }
    
    public String getDriverName(){
        return driverName;
    }
    
    public String getDriverSurname(){
        return driverSurname;
    }
    
    public String getDepartureCity(){
        return departureCity;
    }
    
    public String getArrivalCity(){
        return arrivalCity;
    }
    
    public LocalDateTime getDepartureTime(){
        return departureTime;
    }
    
    public LocalDateTime getArrivalTimeByDriver(){
        return arrivalTimeByDriver;
    }
    
    public LocalDateTime getArrivalTimeBySystem(){
        return arrivalTimeBySystem;  
    }

    //---------------------------------+CAMPO AUTO NOTE--------------------------------------------------+
    //Per quanto riguarda la macchina lascio commentato perché bisogna formalizzare ancora come si salvano
    //Le macchine. Si presterebbe bene un database SQL tipico, oppure anche un semplice KEY_VALUE database
    //Dove la chiave è la targa della macchina essendo univoca e pensando che l'auto possa essere inserita
    //Solo da una persona.
    
    //Senno in un key value DB possiamo usare come chiave CodiceFiscale + TargaMacchina, consentendo quindi
    //A più persone di usarla. Per esempio marito e moglie che stanno a pezzi, decidono entrambi di fare il 
    //Servizio di bla bla car e entrambi usano la stessa macchina
    
    //Però è un ragionamento più SQL Oriented, c'è da chiedere al prof se va bene. Il prof vuole ALMENO 2 DB
    //NO-SQL quindi uno lo abbiamo già (JSON) (Obbligatorio) l'altro c'è da vedere, potrebbere essere questo 
    //Key-value
    //private String Car;
}
