package ar.com.laboratory.hellobatchexample.models.dtos;

import lombok.Data;

@Data
public class TransactionDTO {
    private String fechaOperacion;
    private String horaOperacion;
    private String fechaContable;
    private String idCoelsa;
    private String cuitOrigen;
    private String nombreOrigen;
    private String bankId;
    private String cvuOrigen;
    private String cuitDestino;
    private String nombreDestino;
    private String cvuDestino;
    private double importe;
    private String summary;
    private String status;
    private String type;
    private String entity;
    private String procesadoPor;
    private String debinId;
    private String nsbt;
}