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
}