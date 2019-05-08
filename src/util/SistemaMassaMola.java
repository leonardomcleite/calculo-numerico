package util;

public class SistemaMassaMola {

    public Double[] rungeKuttaOrdemQuatro(int tFinal, Double x1, Double x2, Double x3, Double p1, Double p2, Double p3, Double m1, Double m2, Double m3, Double k1, Double k12, Double k23, Double k3) {
        Double h = 0.01;
        Double tn = 0.0;
        Double [][] kx = new Double [4][3];
        Double [][] kp = new Double [4][3];

        for (tn = 0.0; tn < tFinal; tn = tn + h) {
            kx[0][0] = funcaoX(p1, m1);
            kx[0][1] = funcaoX(p2, m2);
            kx[0][2] = funcaoX(p3, m3);

            kx[1][0] = funcaoX(p1 + (h / 2 * kx[0][0]), m1 + (h / 2 * kx[0][0]));
            kx[1][1] = funcaoX(p2 + (h / 2 * kx[0][1]), m2 + (h / 2 * kx[0][1]));
            kx[1][2] = funcaoX(p3 + (h / 2 * kx[0][2]), m3 + (h / 2 * kx[0][2]));

            kx[2][0] = funcaoX(p1 + (h / 2 * kx[1][0]), m1 + (h / 2 * kx[1][0]));
            kx[2][1] = funcaoX(p2 + (h / 2 * kx[1][1]), m3 + (h / 2 * kx[1][1]));
            kx[2][2] = funcaoX(p3 + (h / 2 * kx[1][2]), m3 + (h / 2 * kx[1][2]));

            kx[3][0] = funcaoX(p1 + (h * kx[2][0]), m1 + (h * kx[2][0]));
            kx[3][1] = funcaoX(p2 + (h * kx[2][1]), m2 + (h * kx[2][1]));
            kx[3][2] = funcaoX(p3 + (h * kx[2][2]), m3 + (h * kx[2][2]));

            kp[0][0] = funcaoP1(k1, k12, k23, k3, x1, x2, x3);
            kp[0][1] = funcaoP2(k1, k12, k23, k3, x1, x2, x3);
            kp[0][2] = funcaoP3(k1, k12, k23, k3, x1, x2, x3);

            kp[1][0] = funcaoP1(k1, k12, k23, k3, x1 + (h / 2 * kp[0][0]), x2 + (h / 2 * kp[0][0]), x3 + (h / 2 * kp[0][0]));
            kp[1][1] = funcaoP2(k1, k12, k23, k3, x1 + (h / 2 * kp[0][1]), x2 + (h / 2 * kp[0][1]), x3 + (h / 2 * kp[0][1]));
            kp[1][2] = funcaoP3(k1, k12, k23, k3, x1 + (h / 2 * kp[0][2]), x2 + (h / 2 * kp[0][2]), x3 + (h / 2 * kp[0][2]));

            kp[2][0] = funcaoP1(k1, k12, k23, k3, x1 + (h / 2 * kp[1][0]), x2 + (h / 2 * kp[1][0]), x3 + (h / 2 * kp[1][0]));
            kp[2][1] = funcaoP2(k1, k12, k23, k3, x1 + (h / 2 * kp[1][1]), x2 + (h / 2 * kp[1][1]), x3 + (h / 2 * kp[1][1]));
            kp[2][2] = funcaoP3(k1, k12, k23, k3, x1 + (h / 2 * kp[1][2]), x2 + (h / 2 * kp[1][2]), x3 + (h / 2 * kp[1][2]));

            kp[3][0] = funcaoP1(k1, k12, k23, k3, x1 + (h * kp[2][0]), x2 + (h * kp[2][0]), x3 + (h * kp[2][0]));
            kp[3][1] = funcaoP2(k1, k12, k23, k3, x1 + (h * kp[2][1]), x2 + (h * kp[2][1]), x3 + (h * kp[2][1]));
            kp[3][2] = funcaoP3(k1, k12, k23, k3, x1 + (h * kp[2][2]), x2 + (h * kp[2][2]), x3 + (h * kp[2][2]));

            x1 = x1 + (h / 6 * (kx[0][0] + 2 * (kx[1][0] + kx[2][0]) + kx[3][0]));
            x2 = x2 + (h / 6 * (kx[0][1] + 2 * (kx[1][1] + kx[2][1]) + kx[3][1]));
            x3 = x3 + (h / 6 * (kx[0][2] + 2 * (kx[1][2] + kx[2][2]) + kx[3][2]));

            p1 = p1 + (h / 6 * (kp[0][0] + 2 * (kp[1][0] + kp[2][0]) + kp[3][0]));
            p2 = p2 + (h / 6 * (kp[0][1] + 2 * (kp[1][1] + kp[2][1]) + kp[3][1]));
            p3 = p3 + (h / 6 * (kp[0][2] + 2 * (kp[1][2] + kp[2][2]) + kp[3][2]));

            System.out.println(tn + ";" + x1  + ";" + p1 + ";" + x2  + ";" + p2 + ";" + x3  + ";" + p3);
        }
        return new Double[]{m1, m2, m3};
    }

    private static Double funcaoP1(Double k1, Double k12, Double k23, Double k3, Double x1, Double x2, Double x3) {
        return ((-k1 - k12) * x1) + (k12 * x2);
    }

    private static Double funcaoP2(Double k1, Double k12, Double k23, Double k3, Double x1, Double x2, Double x3) {
        return (k12 * x1) + ((-k12 - k23) * x2) + (k23 * x3);
    }

    private static Double funcaoP3(Double k1, Double k12, Double k23, Double k3, Double x1, Double x2, Double x3) {
        return (k23 * x2) + ((-k23 - k3) * x3);
    }

    private static Double funcaoX(Double p, Double m) {
        return p/m;
    }

}
