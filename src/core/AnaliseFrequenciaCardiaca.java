package core;

import util.Derivadas;
import util.MediaEDesvioDTO;
import util.PontosDTO;
import util.Arquivo;

import java.util.ArrayList;

public class AnaliseFrequenciaCardiaca {

    public static void main(String[] args) {
        Arquivo ar = new Arquivo();
        Derivadas drv = new Derivadas();

        ArrayList<PontosDTO> derivadaPrimeira;
        ArrayList<PontosDTO> derivadaSegunda;
        ArrayList<PontosDTO> lista = ar.lerAqruivo("14046.txt");
        derivadaPrimeira = drv.calculaDerivada(lista);
//        derivadaSegunda = drv.calculaDerivadaSegunda(derivadaPrimeira);
        MediaEDesvioDTO mediaEDesvioDTO = drv.calculaMediaDesvioSegunda(derivadaPrimeira);
        System.out.println(mediaEDesvioDTO.getMedia() + " ; " + mediaEDesvioDTO.getDesvio());

        Double limitInf = mediaEDesvioDTO.getMedia() - mediaEDesvioDTO.getDesvio();

        Double r = 0.594;
        for(int i = 0; i<derivadaPrimeira.size() - 1; i++) {
            if(derivadaPrimeira.get(i).getDerivada() <= limitInf && derivadaPrimeira.get(i).getmV() > 0) {
                System.out.println(derivadaPrimeira.get(i).getSeconds() + " ; "+derivadaPrimeira.get(i).getmV()+ " ; "+derivadaPrimeira.get(i).getDerivada());
            }
        }

    }
}
