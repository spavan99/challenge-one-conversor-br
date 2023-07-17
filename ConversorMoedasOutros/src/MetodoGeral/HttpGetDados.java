package MetodoGeral;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;

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

public class HttpGetDados {
	
	private HttpGetDados(){
		//construtor privado private ManipulaJson() para evitar que a 
		//classe seja instanciada. Assim, a classe pode ser chamada diretamente,
		//sem a necessidade do comando new.
	}

	public static String HttpGetDados(String apiSite, String apiDados, int apiTime) {	

        String nret = "";
		try {
        	// URI do endere�o a ser requisitado
            URI uri = URI.create(apiSite+apiDados);

           	HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create(apiSite+apiDados))
                    .timeout(Duration.ofSeconds(apiTime))
                    .build();

            HttpClient httpClient = HttpClient.newBuilder()
                    .connectTimeout(Duration.ofSeconds(apiTime))
                    .followRedirects(Redirect.NORMAL)
                    .build();

            HttpResponse<String> response = httpClient.send(request, 
            		                        BodyHandlers.ofString());
            
            // Verifica se a resposta foi obtida com sucesso
            if (response.statusCode() == 200) {
                nret = response.body();
            	//System.out.println(response.body());
                //System.out.println(nret);       
            } else {
                nret = "***ERROR300";                
            	System.out.println("Falha na obten��o da resposta");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nret;
	}
}
