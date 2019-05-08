package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Arquivo {

    public ArrayList<PontosDTO> lerAqruivo(String nome) {
        ArrayList<PontosDTO> lista = new ArrayList();
        try {
            FileReader arq = new FileReader(nome);
            BufferedReader lerArq = new BufferedReader(arq);

            String linha = lerArq.readLine();

            while (linha != null) {
                linha = lerArq.readLine();
                if (linha != null) {
                    linha = linha.replace(" ", "");
                    String seconds = linha.substring(0, linha.indexOf(";"));
                    String mV = linha.substring(linha.indexOf(";") + 1);

                    try {
                        lista.add(new PontosDTO(Double.parseDouble(seconds), Double.parseDouble(mV)));
                    } catch(Exception e) {}
                }
            }

            arq.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }
        return lista;
    }
}
