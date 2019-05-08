package util;

public class MediaEDesvioDTO {
    private Double media;
    private Double desvio;

    public MediaEDesvioDTO(Double media, Double desvio) {
        this.media = media;
        this.desvio = desvio;
    }

    public Double getMedia() {
        return media;
    }

    public Double getDesvio() {
        return desvio;
    }

    public void setMedia(Double media) {
        this.media = media;
    }

    public void setDesvio(Double desvio) {
        this.desvio = desvio;
    }

}
