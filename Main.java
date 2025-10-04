public class Main {
    public static void main(String[] args) {
        Camion camion = new Camion("Scania", "R500", 2022, 15000);
        Furgoneta furgoneta = new Furgoneta("Renault", "Kangoo", 2020, 800);
        AutoEspecializado auto = new AutoEspecializado("Toyota", "Hilux", 2021, "Rescate");

        camion.mostrarDatos();
        furgoneta.mostrarDatos();
        auto.mostrarDatos();
    }
}