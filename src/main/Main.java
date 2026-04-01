import factory.*;

public class Main {

    public static void main(String[] args) {

        BebidaFactory factory = new BebidaQuenteFactory();

        System.out.println(factory.criarCafe().servir());
        System.out.println(factory.criarCha().servir());

        factory = new BebidaFriaFactory();

        System.out.println(factory.criarCafe().servir());
        System.out.println(factory.criarCha().servir());
    }
}