package factory;

import model.*;

public class BebidaFriaFactory implements BebidaFactory {

    public Cafe criarCafe() {
        return new CafeGelado();
    }

    public Cha criarCha() {
        return new ChaGelado();
    }
}