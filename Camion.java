public class Camion extends Vehiculo{
    private int ejes;
    private double consumoCombustibleKm;
    public Camion(String id, double kilometraje, double capacidadCarga, int ejes, double consumoKm) {
        super(id, kilometraje, capacidadCarga);
        this.ejes = ejes;
        this.consumoCombustibleKm = consumoKm;
    }
    
    public double calcularCostoMantenimiento() {
        return ejes * 1000; // ejemplo simple
    }


    public String simularJornada(double kmRecorridos) {
        setKilometraje(getKilometraje() + kmRecorridos);
        return "Camión " + getId() + " recorrió " + kmRecorridos + " km, total: " + getKilometraje();
    }


    public String obtenerEtiquetaAmbiental() {
        return "Roja";
    }


    public int evaluarRiesgo() {
        return getKilometraje() > 100000 ? 8 : 4;
    }


    public String diagnosticarNeumaticos() {
        return "Revisar presión y desgaste";
    }


    public boolean chequeoFrenado() {
        return getKilometraje() > 100000;
    }


    public double calcularTiempoCarga(double cantidadKg) {
        return cantidadKg / getCapacidadCarga();
    }
}