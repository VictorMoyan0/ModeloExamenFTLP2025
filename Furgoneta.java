public class Furgoneta extends Vehiculo {
    private double volumen;
    private double tarifaBase;
    public Furgoneta(String id, double kilometraje, double capacidadCarga, double volumen, double tarifaBase) {
        super(id, kilometraje, capacidadCarga);
        this.volumen = volumen;
        this.tarifaBase = tarifaBase;
    }
    public double calcularCostoMantenimiento() {
        if (getKilometraje() > 50000) {
            return tarifaBase * 1.2; // recargo por km
        }
        return tarifaBase;
    }
    public String simularJornada(double kmRecorridos) {
        setKilometraje(getKilometraje() + kmRecorridos);
        return "Furgoneta " + getId() + " recorrió " + kmRecorridos + " km, total: " + getKilometraje();
    }
    public String obtenerEtiquetaAmbiental() {
        return "Amarilla";
    }
    public int evaluarRiesgo() {
        return getKilometraje() > 75000 ? 7 : 3;
    }
    public String diagnosticarNeumaticos() {
        return "Revisar desgaste y alineación";
    }
    public boolean chequeoFrenado() {
        return getKilometraje() > 75000;
    }
    public double calcularTiempoCarga(double cantidadKg) {
        return cantidadKg / 1500.0; // velocidad media de carga 1500 kg/h
    }
}