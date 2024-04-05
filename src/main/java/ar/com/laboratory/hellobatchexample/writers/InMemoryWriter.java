package ar.com.laboratory.hellobatchexample.writers;

import org.springframework.batch.item.support.AbstractItemStreamItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class InMemoryWriter  extends AbstractItemStreamItemWriter {
    @Override
    public void write(List items) throws Exception {
        items.stream().forEach(System.out::println);
        System.out.println(" ************ writing each chunck ***********");
    }
}



