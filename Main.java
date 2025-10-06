import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FlotaManagement flota = new FlotaManagement(5);

        // Crear vehículos
        Camion camion = new Camion("C001", 120000, 20000, 6, 0.8);
        Furgoneta furgoneta = new Furgoneta("F101", 60000, 3000, 12.5, 1500);
        AutoEspecializado auto = new AutoEspecializado("A501", 40000, 1000, 5000, "Eléctrico");

        // Agregar a la flota
        flota.agregarVehiculo(camion);
        flota.agregarVehiculo(furgoneta);
        flota.agregarVehiculo(auto);

        // Consultas de ejemplo
        System.out.println("=== Inspección masiva ===");
        System.out.println(flota.inspeccionMasiva());

        System.out.println("=== Filtro de riesgo >= 5 ===");
        System.out.println(flota.filtroDeRiesgo(5));

        System.out.println("=== Tiempo promedio de carga ===");
        System.out.println(flota.tiempoPromedioDeCarga(5000) + " horas");
    }
}

// -----------------------------------------------------------------------------
// Clase abstracta base
// -----------------------------------------------------------------------------
abstract class Vehiculo {
    private String id;
    private double kilometraje;
    private double capacidadCarga; // en Kg

    public Vehiculo(String id, double kilometraje, double capacidadCarga) {
        this.id = id;
        this.kilometraje = kilometraje;
        this.capacidadCarga = capacidadCarga;
    }

    public String getId() { return id; }
    public double getKilometraje() { return kilometraje; }
    public double getCapacidadCarga() { return capacidadCarga; }

    public void setKilometraje(double kilometraje) {
        if (kilometraje >= 0) this.kilometraje = kilometraje;
    }

    // Métodos abstractos (cada vehículo los implementa diferente)
    public abstract double costoMantenimiento();
    public abstract String simulacionJornada(double km);
    public abstract String etiquetaAmbiental();
    public abstract int evaluacionRiesgo();
    public abstract String diagnosticoNeumaticos();
    public abstract boolean chequeoFrenado();
    public abstract double tiempoCarga(double peso);
}

// -----------------------------------------------------------------------------
// Subclase: Camión (Carga Pesada)
// -----------------------------------------------------------------------------
class Camion extends Vehiculo {
    private int ejes;
    private double consumoCombustiblePorKm;

    public Camion(String id, double kilometraje, double capacidadCarga, int ejes, double consumoCombustiblePorKm) {
        super(id, kilometraje, capacidadCarga);
        this.ejes = ejes;
        this.consumoCombustiblePorKm = consumoCombustiblePorKm;
    }

    @Override
    public double costoMantenimiento() {
        return 1000 * ejes; // costo depende del número de ejes
    }

    @Override
    public String simulacionJornada(double km) {
        setKilometraje(getKilometraje() + km);
        double combustible = km * consumoCombustiblePorKm;
        return "Camión " + getId() + " recorrió " + km + " km. Combustible consumido: " + combustible + " L.";
    }

    @Override
    public String etiquetaAmbiental() {
        return "Roja";
    }

    @Override
    public int evaluacionRiesgo() {
        return getKilometraje() > 100000 ? 8 : 5;
    }

    @Override
    public String diagnosticoNeumaticos() {
        return "Revisar presión y desgaste por carga pesada.";
    }

    @Override
    public boolean chequeoFrenado() {
        return getKilometraje() > 100000;
    }

    @Override
    public double tiempoCarga(double peso) {
        return peso / 5000.0; // Ejemplo: 5000 kg/hora
    }
}

// -----------------------------------------------------------------------------
// Subclase: Furgoneta (Distribución Media)
// -----------------------------------------------------------------------------
class Furgoneta extends Vehiculo {
    private double volumenCubico;
    private double tarifaServicioBase;

    public Furgoneta(String id, double kilometraje, double capacidadCarga, double volumenCubico, double tarifaServicioBase) {
        super(id, kilometraje, capacidadCarga);
        this.volumenCubico = volumenCubico;
        this.tarifaServicioBase = tarifaServicioBase;
    }

    @Override
    public double costoMantenimiento() {
        double base = tarifaServicioBase;
        if (getKilometraje() > 50000) base *= 1.2;
        return base;
    }

    @Override
    public String simulacionJornada(double km) {
        setKilometraje(getKilometraje() + km);
        return "Furgoneta " + getId() + " completó una jornada de " + km + " km en zona media.";
    }

    @Override
    public String etiquetaAmbiental() {
        return "Amarilla";
    }

    @Override
    public int evaluacionRiesgo() {
        return getKilometraje() > 75000 ? 7 : 4;
    }

    @Override
    public String diagnosticoNeumaticos() {
        return "Revisar alineación y desgaste urbano.";
    }

    @Override
    public boolean chequeoFrenado() {
        return getKilometraje() > 75000;
    }

    @Override
    public double tiempoCarga(double peso) {
        return peso / 1500.0; // 1500 kg/hora
    }
}

// -----------------------------------------------------------------------------
// Subclase: Auto Especializado
// -----------------------------------------------------------------------------
class AutoEspecializado extends Vehiculo {
    private double costoBaseMantenimiento;
    private String tipoMotor; // "Eléctrico" o "Convencional"

    public AutoEspecializado(String id, double kilometraje, double capacidadCarga, double costoBaseMantenimiento, String tipoMotor) {
        super(id, kilometraje, capacidadCarga);
        this.costoBaseMantenimiento = costoBaseMantenimiento;
        this.tipoMotor = tipoMotor;
    }

    @Override
    public double costoMantenimiento() {
        if (tipoMotor.equalsIgnoreCase("Eléctrico"))
            return costoBaseMantenimiento * 0.8; // 20% de descuento
        else
            return costoBaseMantenimiento;
    }

    @Override
    public String simulacionJornada(double km) {
        setKilometraje(getKilometraje() + km);
        return "Auto especializado " + getId() + " realizó servicio rápido de " + km + " km.";
    }

    @Override
    public String etiquetaAmbiental() {
        return tipoMotor.equalsIgnoreCase("Eléctrico") ? "Verde" : "Amarilla";
    }

    @Override
    public int evaluacionRiesgo() {
        return tipoMotor.equalsIgnoreCase("Eléctrico") ? 2 : 5;
    }

    @Override
    public String diagnosticoNeumaticos() {
        return "Neumáticos en buen estado. Revisión cada 20.000 km.";
    }

    @Override
    public boolean chequeoFrenado() {
        return false; // nunca requiere reemplazo inmediato
    }

    @Override
    public double tiempoCarga(double peso) {
        return peso / 1000.0; // 1000 kg/hora
    }
}

// -----------------------------------------------------------------------------
// Clase de gestión de flota
// -----------------------------------------------------------------------------
class FlotaManagement {
    private List<Vehiculo> flota;
    private int capacidadMaxima;

    public FlotaManagement(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
        this.flota = new ArrayList<>();
    }

    public boolean agregarVehiculo(Vehiculo v) {
        if (flota.size() < capacidadMaxima) {
            flota.add(v);
            return true;
        }
        return false;
    }

    public boolean eliminarVehiculo(String id) {
        return flota.removeIf(v -> v.getId().equals(id));
    }

    public double tiempoPromedioDeCarga(double peso) {
        if (flota.isEmpty()) return 0;
        double total = 0;
        for (Vehiculo v : flota) {
            total += v.tiempoCarga(peso);
        }
        return total / flota.size();
    }

    public String filtroDeRiesgo(int umbral) {
        StringBuilder sb = new StringBuilder();
        for (Vehiculo v : flota) {
            int riesgo = v.evaluacionRiesgo();
            if (riesgo >= umbral) {
                sb.append("ID: ").append(v.getId())
                  .append(" | Riesgo: ").append(riesgo)
                  .append(" | Etiqueta: ").append(v.etiquetaAmbiental())
                  .append("\n");
            }
        }
        return sb.toString();
    }

    public String inspeccionMasiva() {
        StringBuilder sb = new StringBuilder();
        for (Vehiculo v : flota) {
            sb.append("ID: ").append(v.getId())
              .append(" | Neumáticos: ").append(v.diagnosticoNeumaticos())
              .append(" | Frenos: ").append(v.chequeoFrenado() ? "Requiere cambio" : "En buen estado")
              .append("\n");
        }
        return sb.toString();
    }
}
