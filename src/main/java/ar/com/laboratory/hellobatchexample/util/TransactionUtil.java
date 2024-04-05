package ar.com.laboratory.hellobatchexample.util;


import ar.com.laboratory.hellobatchexample.models.dtos.TransactionDTO;
import org.springframework.stereotype.Component;

@Component
public class TransactionUtil {
    public static TransactionDTO fromString(String data) {
        String[] parts = data.split("\\|");
        TransactionDTO transaction = new TransactionDTO();
        transaction.setFechaOperacion(parts[0]);
        transaction.setHoraOperacion(parts[1]);
        transaction.setFechaContable(parts[2]);
        transaction.setIdCoelsa(parts[3]);
        transaction.setCuitOrigen(parts[4]);
        transaction.setNombreOrigen(parts[5]);
        transaction.setBankId(parts[6]);
        transaction.setCvuOrigen(parts[7]);
        transaction.setCuitDestino(parts[8]);
        transaction.setNombreDestino(parts[9]);
        transaction.setCvuDestino(parts[10]);
        transaction.setImporte(Double.parseDouble(parts[11]));
        transaction.setSummary(parts[12]);
        transaction.setStatus(parts[13]);
        transaction.setType(parts[14]);
        transaction.setEntity(parts[15]);
        transaction.setProcesadoPor(parts[16]);
        transaction.setDebinId(parts[17]);
        transaction.setNsbt(parts[18]);
        return transaction;
    }
}
