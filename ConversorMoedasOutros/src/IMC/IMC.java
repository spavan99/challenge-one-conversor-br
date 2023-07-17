package IMC;

import java.text.DecimalFormat;

public class IMC {
	
	private double peso;
	private double altura;
    private double imc;
	
	public IMC() {
	}
	
	public IMC(double peso, double altura) {
        this.peso = peso;
        this.altura = altura;
        imcCalcular();
	}
	
	public void setPeso( double peso) {
		this.peso = peso;
	}
	
	public void setAltura( double altura) {
		this.altura = altura;
	}
	
	public double imcCalcular() {
        imc = (peso/(altura*2));
		return imc;
    }
	
	public String imcCalcularFormatado() {
	    return  new DecimalFormat("#.####").format(imcCalcular());
	}
	
	
    public String analiseIMC() {
        String nret = "IMC >>> ";
        if( imc < 18.5) {
        	return( nret +  "Abaixo do Peso");
        }else if ( imc < 24.9) {
           	return( nret +  "Peso Saudável");
        }else if ( imc < 29.9) {
           	return( nret +  "Sobre Peso");
        }else if ( imc < 39.9) {
           	return( nret +  "Obeso");
        }else if ( imc > 40) {
           	return( nret +  "Muito Obeso");
        }
    	return nret;

    
     /*    
    	- Menos de 18,5 - abaixo do peso
    	- 18,5 a 24,9 - peso saudável
    	- 25 a 29,9 - sobrepeso
    	- 30 a 39,9 - obeso
    	- + de 40 - muito obeso (também conhecido como obeso mórbido)
    */    
    
    
    }

}
