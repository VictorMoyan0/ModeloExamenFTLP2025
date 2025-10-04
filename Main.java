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

public class AutoEspecializado extends Vehiculo {
    private double costoBaseMantenimiento;
    private String tipoMotor; // "Eléctrico" o "Convencional"
    public AutoEspecializado(String id, double kilometraje, double capacidadCarga, double costoBaseMantenimiento, String tipoMotor) {
        super(id, kilometraje, capacidadCarga);
        this.costoBaseMantenimiento = costoBaseMantenimiento;
        this.tipoMotor = tipoMotor;
    }
        public double calcularCostoMantenimiento() {
        if(tipoMotor.equalsIgnoreCase("Eléctrico")) {
            return costoBaseMantenimiento * 0.8; // descuento eléctrico
        }
        return costoBaseMantenimiento;
    }
    public String simularJornada(double kmRecorridos) {
        setKilometraje(getKilometraje() + kmRecorridos);
        return "Auto " + getId() + " recorrió " + kmRecorridos + " km, total: " + getKilometraje();
    }
    public String obtenerEtiquetaAmbiental() {
        return tipoMotor.equalsIgnoreCase("Eléctrico") ? "Verde" : "Amarilla";
    }
    public int evaluarRiesgo() {
        return 2; // siempre bajo riesgo
    }
    public String diagnosticarNeumaticos() {
        return "Inspección rápida de presión";
    }
    public boolean chequeoFrenado() {
        return false; // nunca requiere reemplazo
    }
    public double calcularTiempoCarga(double cantidadKg) {
        return cantidadKg / getCapacidadCarga(); // velocidad según capacidad
    }
}