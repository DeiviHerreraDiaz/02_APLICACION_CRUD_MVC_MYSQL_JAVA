package model;

public class BolsilloVO {

    // ATRIBUTOS

    private int IdBolsillo;
    private String nombreBolsillo;
    private Double saldo;
    private boolean estado;

    // CONSTRUCTORES

    public BolsilloVO() {
    }

    public BolsilloVO(int idBolsillo, String nombreBolsillo, Double saldo, boolean estado) {
        IdBolsillo = idBolsillo;
        this.nombreBolsillo = nombreBolsillo;
        this.saldo = saldo;
        this.estado = estado;
    }

    // GETTERS AND SETTERS

    public int getIdBolsillo() {
        return IdBolsillo;
    }

    public void setIdBolsillo(int idBolsillo) {
        IdBolsillo = idBolsillo;
    }

    public String getNombreBolsillo() {
        return nombreBolsillo;
    }

    public void setNombreBolsillo(String nombreBolsillo) {
        this.nombreBolsillo = nombreBolsillo;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}
