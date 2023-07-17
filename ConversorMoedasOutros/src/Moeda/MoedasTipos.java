package Moeda;

import java.util.List;

public enum MoedasTipos {

  // tipo de moedas
  //nome  nr   simb  Iso3217  Pais
	Dolar(1, "$", "USD", "Estado Unidos", 1),
	Real(2, "R$", "BR", "Brasil", 4.93),
	Euro(3, "E", "EUR", "União Europeia", 0.92),
	Iene(4, "YEN", "JPY", "Japão", 144.16);


    private final int numero;
    private final String simbolo;
    private final String iso;
    private final String pais;
    private final double fatorconversao;

    MoedasTipos(int numero, String simbolo, String iso, String pais, double fatorconversao) {
        this.numero = numero;
        this.simbolo = simbolo;
        this.iso = iso;
        this.pais = pais;
        this.fatorconversao = fatorconversao;
    }

    public int getNumero() {
        return this.numero;
    }
    
    public String getSimbolo() {
        return this.simbolo;
    }
	
    public String getIso() {
        return this.iso;
    }

    public String getPais() {
        return this.pais;
    }

    public Double getFatorConversao() {
        return this.fatorconversao;
    }
}



/*
public enum AlgarismoRomano {

    I(1), V(5), X(10), L(50), C(100), D(500), M(1000);

    private int numeroArabico;

    private AlgarismoRomano(int numeroArabico) {
        this.numeroArabico = numeroArabico;
    }

    public static int retornarNumeroArabico(char numeroRomano) {
        return valueOf(String.valueOf(numeroRomano)).numeroArabico;
    }

    public static List<Character> getAlgarismosRomanos() {
        List<Character> algarismos = new ArrayList<Character>();

        for (AlgarismoRomano algarismo : values())
            algarismos.add(algarismo.toString().toCharArray()[0]);

        return algarismos;
    }

}
*/