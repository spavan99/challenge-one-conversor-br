package Pesos;

public enum PesosTipo {

    // padromizado no KG
	//desc/ nr/ uni / fator conversao relacoa ao metros
        Libras(1, "lb", 2.20750552),
	    Ounce(2, "oz", 35.2112667),
		USSTonelada(3, "USSton", 0.00110254),
		Tonelada(4, "ton", 0.001),
		Arroba(5, "@", 0.06666667),
		Quilograma(6, "kg", 1),
		Hectograma(7, "hg", 10),
		Decagrama(8, "dag", 100),
		Grama(9, "g", 1000),
		Decigrama(10, "dg", 10000),
		Miligrama(11, "nm", 100000);

		private final int numero;
	    private final String simbolo;
	    private final double fatorconversao;
	    
	    PesosTipo(int numero, String simbolo, double fatorconversao) {
	        this.numero = numero;
	        this.simbolo = simbolo;
	        this.fatorconversao = fatorconversao;
	    }

	    public int getNumero() {
	        return this.numero;
	    }
	    
	    public String getSimbolo() {
	        return this.simbolo;
	    }
		
	    public Double getFatorConversao() {
	        return this.fatorconversao;
	    }

	
	
	
}
