package ar.com.laboratory.hellobatchexample.models.entities;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "raw_rows")
@Data
public class RawRow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "raw_row")
    private String rawRow;
    private String status;
}
