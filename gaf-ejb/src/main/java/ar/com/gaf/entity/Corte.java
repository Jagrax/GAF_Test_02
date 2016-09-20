package ar.com.gaf.entity;

import java.util.Date;

public class Corte {

    private Long id;
    private String titulo;
    private Integer cantPrendas; // Cantidad de prendas a producir
    private Date fechaEntrega; // Delivery Date
    private Date primerVencimiento; // Due Date
    private Double precio; // Prize
    private Taller tallerId; // Id del taller en el que se esta operando con este corte
    private Integer fromSize; // Desde el talle
    private Integer toSize; // Hasta el talle
    private HojaDeCorte hojaDeCorte; // Id de la hoja de corte que se esta usando
    private Status status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getCantPrendas() {
        return cantPrendas;
    }

    public void setCantPrendas(Integer cantPrendas) {
        this.cantPrendas = cantPrendas;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Date getPrimerVencimiento() {
        return primerVencimiento;
    }

    public void setPrimerVencimiento(Date primerVencimiento) {
        this.primerVencimiento = primerVencimiento;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Taller getTallerId() {
        return tallerId;
    }

    public void setTallerId(Taller tallerId) {
        this.tallerId = tallerId;
    }

    public Integer getFromSize() {
        return fromSize;
    }

    public void setFromSize(Integer fromSize) {
        this.fromSize = fromSize;
    }

    public Integer getToSize() {
        return toSize;
    }

    public void setToSize(Integer toSize) {
        this.toSize = toSize;
    }

    public HojaDeCorte getHojaDeCorte() {
        return hojaDeCorte;
    }

    public void setHojaDeCorte(HojaDeCorte hojaDeCorte) {
        this.hojaDeCorte = hojaDeCorte;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
