package UIConsole;

import IMC.IMC;

public class appIMCConsole {

	
    public void startIMC() {

    	//imc
    	IMC calcIMC = new IMC();
   	
    	// solicita dados IMC
		System.out.println( "");
		System.out.println( "");
		System.out.println( "------------------------------------------");
		System.out.println( "App  <<<  IMC INDICE DE MASSA CORPORAL >>>");
		System.out.println( "------------------------------------------");
		System.out.println( "");
        calcIMC.setAltura( Double.parseDouble( ImputDados.imputDados("Informe a sua Altura em metros", 0, 3)));
	
		System.out.println( "");
        calcIMC.setPeso( Double.parseDouble( ImputDados.imputDados("Informe a seu Peso  em kgs ", 0, 300)));

		System.out.println( "");
	    System.out.println("Seu IMC Calculado é de:: " + calcIMC.imcCalcularFormatado());
	    
		System.out.println( "");
	    System.out.println("Analise:  " + calcIMC.analiseIMC());

        ImputDados.imputWait("");	    
	    
    }

}
