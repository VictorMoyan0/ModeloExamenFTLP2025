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