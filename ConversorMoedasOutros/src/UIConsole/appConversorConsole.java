package UIConsole;

import java.io.IOException;
import java.util.Scanner;

public class appConversorConsole {

	
	public void startApp() {
    
        menuConversor();
		
		//MoedasCambio vr = new MoedasCambio( 300.00,  10.0);
    	//System.out.println(vr); 
    	
	}


	private void menuConversor()  {
		
		boolean loopPrincipal = true;
        int choice = 0; 
        String space = "                          ";
        Scanner s = new Scanner(System.in);
		
		while( loopPrincipal) {
			
			
			// ver site fazer conversore 
			//https://www.convert-me.com/pt/convert/temperature-inc/?u=dcelsiusi&v=32
		
			// limpar a tela  verificar e analisar nao esta fucinando dentro do eclipce
            //ImputDados.limpaTela();
            
			System.out.println(space + "--------------------------");
			System.out.println(space +  "App  <<< My Conversor  >>>");
			System.out.println(space +  "--------------------------");
			System.out.println( "");
			System.out.println(space +  "1 - Conversor de Moedas");
			System.out.println(space +  "2 - Calcular IMC");
			System.out.println(space +  "3 - Conversor de Medidas");
			System.out.println(space +  "4 - Conversor de Pesos");
			
			//System.out.println(space +  "5 - Conversor de Temperaturas");
			//System.out.println(space +  "6 - Cotacao Bolsa");
			System.out.println( "");
			System.out.println(space +  "0 - Sair/Exit");
			System.out.println( "");
			System.out.println( "");
			System.out.print(space +  "Digite a Opcao: ");
            
			choice = s.nextInt();
			
						
			switch(choice) 
			{
				case 1: 
                    appMoedaConsole  moeda = new appMoedaConsole();
                    moeda.startMoeda();
                    break;
					
				case 2:
					appIMCConsole imc = new appIMCConsole();
					imc.startIMC();
                    break;

				case 3:
					appMetricaConsole metrica = new appMetricaConsole();
					metrica.startMetrica();
                    break;

				case 4:
					appPesoConsole peso = new appPesoConsole();
					peso.startPeso();
                    break;

				case 0: 
                    System.out.println(" .");
                    System.out.println(" ....");
					System.out.println(" .........Fim de programa, até breve.....");
					loopPrincipal = false;
					break;
					
			}		
 			
			
		}
        s.close();

	}
	
}

