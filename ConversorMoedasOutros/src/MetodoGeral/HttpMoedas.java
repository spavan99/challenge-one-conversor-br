package MetodoGeral;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;


//String apiEndereco = "http://economia.awesomeapi.com.br/json/last/";
//String apiDados = "USD-BRL,USD-CAD,USD-EUR,USD-GBP,USD-ARS,USD-JPY,USD-CHF,USD-AUD,USD-CNY,USD-ILS,USD-CHF";
//int    timeOutServidor = 8;

public class HttpMoedas {

	public static void main(String[] args) {

   		String ntem =	HttpEconomia();
		 
		LerJson.LerJsonArray(ntem);
		
	}	
		
		
	public static String HttpEconomia() {	

        String nret = "";
        
		try {
        	
        	String apiEndereco = "http://economia.awesomeapi.com.br/json/last/";
        	String apiDados = "USD-BRL,USD-CAD,USD-EUR,USD-GBP,USD-ARS,USD-JPY,USD-CHF,USD-AUD,USD-CNY,USD-ILS,USD-CHF";
        	int    timeOutServ = 8;
        	
        	// URI do endere�o a ser requisitado
            URI uri = URI.create(apiEndereco+apiDados);

           	HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create(apiEndereco+apiDados))
                    .timeout(Duration.ofSeconds(timeOutServ))
                    .build();

            HttpClient httpClient = HttpClient.newBuilder()
                    .connectTimeout(Duration.ofSeconds(timeOutServ))
                    .followRedirects(Redirect.NORMAL)
                    .build();

            HttpResponse<String> response = httpClient.send(request, 
            		                        BodyHandlers.ofString());
            
            // Verifica se a resposta foi obtida com sucesso
            if (response.statusCode() == 200) {
                nret = response.body();
            	System.out.println(response.body());
                System.out.println(nret);       
            
            } else {
                
            	System.out.println("Falha na obten��o da resposta");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nret;
	}
}



//************************************************************
/*
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ProxySelector;
import java.net.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;

// site cotacoes da moedas
//https://docs.awesomeapi.com.br/api-de-moedas

// exemplo como pegar as moedas 

public class HttpMoedas {
    public static void main(String[] args) throws IOException, InterruptedException {

    	String moedasReal = "USD-BRL,CAD-BRL,EUR-BRL,GBP-BRL,ARS-BRL,BTC-BRL,LTC-BRL,JPY-BRL,CHF-BRL,AUD-BRL,CNY-BRL,ILS-BRL,ETH-BRL";
      	String moedasDolar = "USD-BRL,USD-CAD,USD-EUR,USD-GBP,USD-ARS,USD-JPY,USD-CHF,USD-AUD,USD-CNY,USD-ILS,USD-CHF";
    	String http = "http://economia.awesomeapi.com.br/json/last/";

    	//"http://economia.awesomeapi.com.br/json/last/USD-BRL,USD-EUR,USD-GBP"
    	
    	
    	String moedasUnica = "USD-BRL";
       
    	HttpRequest request = HttpRequest.newBuilder()
                .GET()
//                .DELETE()
//                .uri(URI.create("https://cat-fact.herokuapp.com/facts/"))
//                .uri(URI.create("https://www.getpostman.com"))
//                .uri(URI.create("https://postman-echo.com/delete"))
//                .uri(URI.create("https://apichallenges.herokuapp.com/todos"))
//                .uri(URI.create("https://xkcd.com/info.0.json"))
                .uri(URI.create(http+moedasUnica))
//                .headers("Accept", "application/json")
//                .headers("Accept", "application/xml", "chave", "valor", "chave", "valor")
//                .header(null, null)
                .timeout(Duration.ofSeconds(8))
                .build();

        HttpClient httpClient = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(8))
                .followRedirects(Redirect.NORMAL)
                .build();

        HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());

        
         String nret = response.body();
        
         
         System.out.println(nret);
        
        System.out.println(response.body());

 //        System.out.println(response.statusCode());
//        System.out.println(response.headers());
//        System.out.println(response.version());

//        httpClient.sendAsync(request, BodyHandlers.ofString())
//                .thenApply(HttpResponse::body)
//                .thenApply(String::toUpperCase)
//                .thenAccept(System.out::println);
    }

}

*/