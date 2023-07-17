package Metricas;

public enum MetricasTipo {

//desc/ nr/ uni / fator conversao relacoa ao metros
	Quilometro(1, "km", 0.001),
	Hectomero(2, "hm", 0.01),
	Decamentro(3, "dam", 0.1),
	Metro(4, "m", 1),
	Decimetro(5, "dm", 10),
	Centimetro(6, "cm", 100),
	Milimetro(7, "mm", 1000),
	Micrometro(8, "micron", 1000000),
	Nanometro(9, "nm", 1000000000),
	Polegadas(10, "in", 39.3700787),
	Pes(11, "ft", 3.2808399),
	Jarda(12, "yd", 1.0936133),
	Milas(13, "mi", 0.0006213712),
	MilasNauticas(14, "NM", 0.0005399568);

	private final int numero;
    private final String simbolo;
    private final double fatorconversao;
    
    MetricasTipo(int numero, String simbolo, double fatorconversao) {
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

