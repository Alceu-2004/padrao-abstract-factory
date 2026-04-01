package factory;

import model.*;

public class BebidaQuenteFactory implements BebidaFactory {

    public Cafe criarCafe() {
        return new CafeQuente();
    }

    public Cha criarCha() {
        return new ChaQuente();
    }
}