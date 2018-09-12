package com.android.oscarc.clase1_intento2;

public class ItemAuto {
    String marca, modelo, anio;
    int img_marca;

    public ItemAuto(String marca, String modelo, String anio, int img_marca) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.img_marca = img_marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public int getImg_marca() {
        return img_marca;
    }

    public void setImg_marca(int img_marca) {
        this.img_marca = img_marca;
    }
}
