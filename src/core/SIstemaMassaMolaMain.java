package core;

import util.SistemaMassaMola;

public class SIstemaMassaMolaMain {

    public static void main(String[] args) throws Exception {
        SistemaMassaMola smm = new SistemaMassaMola();

        Double [] rk4 = smm.rungeKuttaOrdemQuatro(100, 1.0, 2.0, 3.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 0.1, 0.2, 0.3, 0.4);

    }
}
