package Conversor;

import Calculadora.StartCalc;
import UICalcCoonversorSwing.CalcStart;
import UIConsole.appConversorConsole;
import UISwing.appConversorSwing;

public class Conversor  {
	
	//https://meuconversordemedidas.com/comprimento/jarda/milha/1
    	
    public static void main(String[] args) {

		// VERSAO CONSOLE   **********   OK    *******************
		//appConversorConsole conversor = new appConversorConsole(); 
    	//conversor.startApp();
    	
		// VERSAO SWING 1-0 **********   OK    *******************
		//appConversorSwing conversor = new appConversorSwing(); 
        
		// VERSAO SWING 2-0 -FORMATO CALULADORA -**********   OK    *******************
    	//**********   desenvolvendo  OK    *******************
    	StartCalc.getInstance();
 		
    }

    //**************************************************************************
    // -------------  EM DESENVOLVIMENTO 
	// VERSAO SWING 3-0 -FORMATO CALULADORA TOTAL
	//CalcStart calculadora = new CalcStart(); 
    //***************************************************************************
    
}


