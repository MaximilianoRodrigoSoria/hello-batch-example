package ar.com.laboratory.hellobatchexample.processor;


import ar.com.laboratory.hellobatchexample.models.entities.RawRow;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class RawRowProcessor implements ItemProcessor<RawRow, RawRow> {
    @Override
    public RawRow process(RawRow item) throws Exception {
        //Aca se llama a WebhookApi
        //.....llamada...



        System.out.println("----------->Processing item: " + item.toString());
        return item;
    }
}
