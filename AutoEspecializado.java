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
