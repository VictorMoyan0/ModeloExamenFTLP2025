public class Main {
    public static void main(String[] args) {
    }
}

public abstract class Vehiculo {
    // --- Atributos comunes a todos los vehículos ---
    private String id;
    private double kilometraje;
    private double capacidadCarga;

    // --- Constructor ---
    public Vehiculo(String id, double kilometraje, double capacidadCarga) {
        this.id = id;
        this.kilometraje = kilometraje;
        this.capacidadCarga = capacidadCarga;
    }

    // --- Getters y Setters (encapsulamiento) ---
    public String getId() { return id; }
    public double getKilometraje() { return kilometraje; }
    public double getCapacidadCarga() { return capacidadCarga; }

    public void setKilometraje(double kilometraje) {
        if (kilometraje >= 0) this.kilometraje = kilometraje;
    }

    // --- Métodos abstractos (comportamientos que varían por tipo de vehículo) ---
    public abstract double costoMantenimiento();
    public abstract String simulacionJornada(double km);
    public abstract String etiquetaAmbiental();
    public abstract int evaluacionRiesgo();
    public abstract String diagnosticoNeumaticos();
    public abstract boolean chequeoFrenado();
    public abstract double tiempoCarga(double peso);
}

class Camion extends Vehiculo {
    private double capacidadCarga; // en toneladas

    public Camion(double costoMantenimiento, String simulacionJornada, String etiquetaAmbiental,
                  int evaluacionRiesgo, String diagnosticoNeumaticos, boolean chequeoFrenado, double tiempoCarga,
                  double capacidadCarga) {
        super(costoMantenimiento, simulacionJornada, etiquetaAmbiental, evaluacionRiesgo, diagnosticoNeumaticos, chequeoFrenado, tiempoCarga);
        this.capacidadCarga = capacidadCarga;
    }

    @Override
    public void realizarMantenimiento() {
        System.out.println("🔧 Mantenimiento del camión:");
        System.out.println("- Revisión del motor diésel y frenos neumáticos");
        System.out.println("- Verificación de carga máxima de " + capacidadCarga + " toneladas");
    }
}

class Furgoneta extends Vehiculo {
    private boolean usoUrbano;

    public Furgoneta(double costoMantenimiento, String simulacionJornada, String etiquetaAmbiental,
                     int evaluacionRiesgo, String diagnosticoNeumaticos, boolean chequeoFrenado, double tiempoCarga,
                     boolean usoUrbano) {
        super(costoMantenimiento, simulacionJornada, etiquetaAmbiental, evaluacionRiesgo, diagnosticoNeumaticos, chequeoFrenado, tiempoCarga);
        this.usoUrbano = usoUrbano;
    }

    @Override
    public void realizarMantenimiento() {
        System.out.println("🔧 Mantenimiento de furgoneta:");
        if (usoUrbano) {
            System.out.println("- Revisión de suspensión y frenos urbanos");
        } else {
            System.out.println("- Revisión de sistema de carga para trayectos largos");
        }
    }
}

class AutoEspecializado extends Vehiculo {
    private String tipoServicio; // Ej: "Emergencias", "Seguridad", "Transporte VIP"

    public AutoEspecializado(double costoMantenimiento, String simulacionJornada, String etiquetaAmbiental,
                             int evaluacionRiesgo, String diagnosticoNeumaticos, boolean chequeoFrenado, double tiempoCarga,
                             String tipoServicio) {
        super(costoMantenimiento, simulacionJornada, etiquetaAmbiental, evaluacionRiesgo, diagnosticoNeumaticos, chequeoFrenado, tiempoCarga);
        this.tipoServicio = tipoServicio;
    }

    @Override
    public void realizarMantenimiento() {
        System.out.println("🔧 Mantenimiento del auto especializado:");
        System.out.println("- Revisión del equipo de " + tipoServicio);
        System.out.println("- Chequeo del rendimiento y confort");
    }
}
