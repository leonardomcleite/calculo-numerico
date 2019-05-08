package util;

import java.util.ArrayList;

public class Derivadas {

    public ArrayList<PontosDTO> calculaDerivada(ArrayList<PontosDTO> lista) {
        ArrayList<PontosDTO> zerosDaFuncao = new ArrayList();
        for (int i=0; i<lista.size() -1; i++) {
            try {
                Double derivada = (lista.get(i+1).getmV() - lista.get(i).getmV()) / (lista.get(i+1).getSeconds() - lista.get(i).getSeconds());
                lista.get(i).setDerivada(derivada);
                zerosDaFuncao.add(lista.get(i));
            } catch(Exception e) {

            }
        }
        return zerosDaFuncao;
    }

    public ArrayList<PontosDTO> calculaDerivadaSegunda(ArrayList<PontosDTO> lista) {
        ArrayList<PontosDTO> zerosDaDerivada = new ArrayList();
        for (int i=0; i<lista.size() -1; i++) {
            try {
                Double derivadaSegunda = (lista.get(i+1).getDerivada() - lista.get(i).getDerivada()) / (lista.get(i+1).getSeconds() - lista.get(i).getSeconds());
                lista.get(i).setDerivadaSegunda(derivadaSegunda);
                zerosDaDerivada.add(lista.get(i));
            } catch(Exception e) {

            }
        }
        return zerosDaDerivada;
    }

    public MediaEDesvioDTO calculaMediaDesvioSegunda(ArrayList<PontosDTO> lista) {
        Double soma = 0.0;
        Double media = 0.0;
        Double dvp = 0.0;
        int cont = 0;

        for (int i=0; i<lista.size(); i++) {
            if (lista.get(i).getmV() > 0) {
                soma += lista.get(i).getDerivada();
                cont++;
            }
        }
        media = (soma/cont);
        for (int i=0; i<lista.size(); i++) {
            dvp += Math.pow(lista.get(i).getDerivada() - media, 2);
        }
        dvp = Math.sqrt(dvp/cont);
        return new MediaEDesvioDTO(media, dvp);
    }
}
