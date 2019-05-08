package core;

import util.EdoRungeKutta;

public class EquacaoDiferencialOrdinaria {

    public static void main(String[] args) throws Exception {

        EdoRungeKutta edo = new EdoRungeKutta();
        Double edoResult = edo.calcula(2, 0.1, 1.0, 0.0, 1.0);
        System.out.println(edoResult);

    }

}
