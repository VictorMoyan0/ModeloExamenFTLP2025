public class Main {

}
public abstract class Vehiculo {
    // Propiedades comunes
    private String id;
    private double kilometraje;
    private double capacidadCarga;
    // Constructor
    public Vehiculo(String id, double kilometraje, double capacidadCarga) {
        this.id = id;
        this.kilometraje = kilometraje;
        this.capacidadCarga = capacidadCarga;
    }
    // Getters y Setters
    public String getId() { return id; }
    public double getKilometraje() { return kilometraje; }
    public void setKilometraje(double km) { this.kilometraje = km; }
    public double getCapacidadCarga() { return capacidadCarga; }
    // Métodos abstractos
    public abstract double calcularCostoMantenimiento();
    public abstract String simularJornada(double kmRecorridos);
    public abstract String obtenerEtiquetaAmbiental();
    public abstract int evaluarRiesgo();
    public abstract String diagnosticarNeumaticos();
    public abstract boolean chequeoFrenado();
    public abstract double calcularTiempoCarga(double cantidadKg);
}
public class Camion extends Vehiculo{
    private int ejes;
    private double consumoCombustibleKm;
    public Camion(String id, double kilometraje, double capacidadCarga, int ejes, double consumoKm) {
        super(id, kilometraje, capacidadCarga);
        this.ejes = ejes;
        this.consumoCombustibleKm = consumoKm;
    }
}