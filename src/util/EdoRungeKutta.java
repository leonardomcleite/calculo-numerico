package util;

public class EdoRungeKutta {

    public Double calcula(int ordem, Double passo, Double y0, Double intervaloInferior, Double intervaloSuperior) throws Exception {
        switch (ordem) {
            case 1:
                return calculaOrdemUm(passo, y0, intervaloInferior, intervaloSuperior);
            case 2:
                return calculaOrdemDois(passo, y0, intervaloInferior, intervaloSuperior);
            default:
                throw new Exception("Ordem não mapeada");
        }
    }

    private Double calculaOrdemUm (Double passo, Double y0, Double intervaloInferior, Double intervaloSuperior) {
        Double x = intervaloInferior;
        Double y = y0;
        Double yn = 0.0;

        Double n = (intervaloSuperior - intervaloInferior) / passo;
        for(int i = 0; i < n; i++) {
            yn = y + funcao(x, y) * passo;
            x += passo;
            y = yn;
        }
        return yn;

    }

    private Double calculaOrdemDois (Double passo, Double y0, Double intervaloInferior, Double intervaloSuperior) {
        Double x = intervaloInferior;
        Double y = y0;
        Double k1, k2;
        Double yn = 0.0;

        Double n = (intervaloSuperior - intervaloInferior) / passo;
        for(int i = 0; i < n; i++) {
            k1 = funcao(x, y);
            k2 = funcao(x + passo, y + (passo*k1));
            yn = y + passo/2*(k1+k2);
            x += passo;
            y = yn;
        }
        return yn;

    }

    public Double funcao(Double x, Double y) {
        return (-x)*y;
    }
}
