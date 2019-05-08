package util;

public class PontosDTO {
    private Double seconds;
    private Double mV;
    private Double derivada;
    private Double derivadaSegunda;

    PontosDTO(Double seconds, Double mV) {
        this.seconds = seconds;
        this.mV = mV;
    }

    public Double getSeconds() {
        return seconds;
    }

    public Double getmV() {
        return mV;
    }

    public Double getDerivada() {
        return derivada;
    }

    public Double getDerivadaSegunda() {
        return derivadaSegunda;
    }

    public void setSeconds(Double seconds) {
        this.seconds = seconds;
    }

    public void setmV(Double mV) {
        this.mV = mV;
    }

    public void setDerivada(Double derivada) {
        this.derivada = derivada;
    }

    public void setDerivadaSegunda(Double derivadaSegunda) {
        this.derivadaSegunda = derivadaSegunda;
    }
}
