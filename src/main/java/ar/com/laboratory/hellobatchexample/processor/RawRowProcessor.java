package ar.com.laboratory.hellobatchexample.processor;


import ar.com.laboratory.hellobatchexample.models.dtos.GenericRequest;
import ar.com.laboratory.hellobatchexample.models.dtos.TransactionDTO;
import ar.com.laboratory.hellobatchexample.models.entities.RawRow;
import ar.com.laboratory.hellobatchexample.util.TransactionUtil;
import lombok.AllArgsConstructor;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RawRowProcessor implements ItemProcessor<RawRow, RawRow> {

    private TransactionUtil transactionUtil;

    //private ClientExample myclient;

    @Override
    public RawRow process(RawRow item) throws Exception {
        //Transformo el String a un DTO
        TransactionDTO transactionDTO = TransactionUtil.fromString(item.toString());
        GenericRequest request = new GenericRequest();

        //Preparo el request
        request.setFechaContable(transactionDTO.getFechaContable());
        request.setFechaOperacion(transactionDTO.getFechaOperacion());

        System.out.println(">Item que envio: " + request.toString());

        /* Llamo al cliente que me responde con un status valido para cambiar el item
        var response = myClient(request);
        if(respnse.getStatus()== 200) {
            item.setStatus("PROCESSED");
        }
        */
        return item;
    }
}
