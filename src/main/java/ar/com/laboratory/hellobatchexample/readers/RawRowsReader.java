package ar.com.laboratory.hellobatchexample.readers;


import ar.com.laboratory.hellobatchexample.models.entities.RawRow;
import lombok.AllArgsConstructor;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
@AllArgsConstructor
public class RawRowsReader {

    private DataSource dataSource;
    public JdbcCursorItemReader<RawRow> reader() {
        JdbcCursorItemReader<RawRow> reader = new JdbcCursorItemReader<>();
        reader.setDataSource(dataSource);
        reader.setSql("SELECT id, raw_row, status FROM raw_rows where status = 'PENDING' ORDER BY id");
        reader.setRowMapper(new RowMapper<RawRow>() {
            @Override
            public RawRow mapRow(ResultSet rs, int rowNum) throws SQLException {
                RawRow rawRow = new RawRow();
                rawRow.setId(rs.getLong("id"));
                rawRow.setRawRow(rs.getString("raw_row"));
                rawRow.setStatus(rs.getString("status"));
                return rawRow;
            }
        }
        );
        return reader;
    }

}
