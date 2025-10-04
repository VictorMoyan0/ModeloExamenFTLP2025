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
        @Override
    public double calcularCostoMantenimiento() {
        return ejes * 1000; // ejemplo simple
    }

    @Override
    public String simularJornada(double kmRecorridos) {
        setKilometraje(getKilometraje() + kmRecorridos);
        return "Camión " + getId() + " recorrió " + kmRecorridos + " km, total: " + getKilometraje();
    }

    @Override
    public String obtenerEtiquetaAmbiental() {
        return "Roja";
    }

    @Override
    public int evaluarRiesgo() {
        return getKilometraje() > 100000 ? 8 : 4;
    }

    @Override
    public String diagnosticarNeumaticos() {
        return "Revisar presión y desgaste";
    }

    @Override
    public boolean chequeoFrenado() {
        return getKilometraje() > 100000;
    }

    @Override
    public double calcularTiempoCarga(double cantidadKg) {
        return cantidadKg / getCapacidadCarga();
    }
}
public class Furgoneta extends Vehiculo {
    private double volumen;
    private double tarifaBase;
    public Furgoneta(String id, double kilometraje, double capacidadCarga, double volumen, double tarifaBase) {
        super(id, kilometraje, capacidadCarga);
        this.volumen = volumen;
        this.tarifaBase = tarifaBase;
    }
}