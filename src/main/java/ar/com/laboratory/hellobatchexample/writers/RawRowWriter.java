package ar.com.laboratory.hellobatchexample.writers;

import org.springframework.batch.item.support.AbstractItemStreamItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class RawRowWriter extends AbstractItemStreamItemWriter {
    @Override
    public void write(List items) throws Exception {
        items.stream().forEach(i -> System.out.println(i.toString()));
        System.out.println(" ************ writing each chunck ***********");
    }
}



