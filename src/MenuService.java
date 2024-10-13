import java.util.Scanner;

public class MenuService {

    private final Scanner scanner;

    public MenuService() {
        this.scanner = new Scanner(System.in);
    }

    public int getOption() {
        System.out.println("""
                \nBienvenido al ¡Conversor de Moneda!
                
                *************************************************
                1) Dolar =>> Peso Argentino
                2) Peso Argentino =>> Dolar
                3) Dolar =>> Real Brasilero
                4) Real Brasirelo =>> Dolar
                5) Dolar =>> Peso Colombiano
                6) Peso Colombiano =>> Dolar
                7) Salir
                ***************************************************

                Elija una opcion valida:""");

        return Integer.parseInt(scanner.nextLine());
    }

    public double getAmount() {
        System.out.println("Ingresa el valor que deseas convertir:");
        return Double.parseDouble(scanner.nextLine());
    }
}
