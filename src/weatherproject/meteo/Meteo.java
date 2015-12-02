package weatherproject.meteo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Paolo
 */
public class Meteo {
    private double temperatura;
    private double min;
    private double max;
    private String sky;

    public Meteo(double temperatura, double min, double max, String sky) {
        this.temperatura = temperatura;
        this.min = min;
        this.max = max;
        this.sky = sky;
    }

    public Meteo() {
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public String getSky() {
        return sky;
    }

    public void setSky(String sky) {
        this.sky = sky;
    }
}
