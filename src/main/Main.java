package main;

import controller.ContenidoController;
import view.ContenidoView;

public class Main {
    public static void main(String[] args) {
        ContenidoController controller = new ContenidoController();
        ContenidoView view = new ContenidoView(controller);
        view.iniciar();
    }
}