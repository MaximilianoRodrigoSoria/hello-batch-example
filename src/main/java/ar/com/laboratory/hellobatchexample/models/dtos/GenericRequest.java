package ar.com.laboratory.hellobatchexample.models.dtos;


import lombok.Data;

@Data
public class GenericRequest {

    private String fechaOperacion;
    private String horaOperacion;
    private String fechaContable;
    private String idCoelsa;
}
