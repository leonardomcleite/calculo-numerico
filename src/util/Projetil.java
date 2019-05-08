package util;

public class Projetil {

    public void PercursoProjetil(Double xn, Double vn, int tFinal) {
        Double h = 0.01;
        Double k1, k2, k3, k4, l1, l2, l3, l4;
        for (Double tn = 0.0; tn < tFinal; tn = tn + h) {
            k1 = fx(tn, xn, vn);
            l1 = gx(tn, xn, vn);

            k2 = fx(tn + (h / 2), xn + (h / 2 * k1), vn + (h / 2 * k1));
            l2 = gx(tn + (h / 2), xn + (h / 2 * l1), vn + (h / 2 * l1));

            k3 = fx(tn + (h / 2), xn + (h / 2 * k2), vn + (h / 2 * k2));
            l3 = gx(tn + (h / 2), xn + (h / 2 * l2), vn + (h / 2 * l2));

            k4 = fx(tn + h, xn + (h * k3), vn + (h * k3));
            l4 = gx(tn + h, xn + (h * l3), vn + (h * l3));

            xn = xn + (h / 6 * (k1 + 2 * (k2 + k3) + k4));
            vn = vn + (h / 6 * (l1 + 2 * (l2 + l3) + l4));

            System.out.println("[" + tn + ";" + xn + ";" + vn + "]");
        }
    }

    private Double fx(Double t, Double x, Double  v) {
        return v;
    }

    private Double gx(Double t, Double x, Double v) {
        //AK-47
        Double m = 7.9 / 1000;
        Double coeficiente = 0.5;
        Double densidade = 1.2927;
        Double gravidade = 9.8;
        Double calibre = 7.62;
        Double area = Math.PI * Math.pow(calibre / 2, 2) * 0.000001;
        Double fator = v < 0.0 ? 1.0 : -1.0;
        return (
                fator *
                1 / (2 * m) *
                coeficiente *
                densidade *
                area *
                Math.pow(v, 2) -
                gravidade
        );
    }

}
