package leo.prj.petrocoin.db.petro_coin.petro_coin.currency.generated;

import com.speedment.common.annotation.GeneratedCode;
import com.speedment.runtime.config.identifier.TableIdentifier;
import com.speedment.runtime.core.component.SqlAdapter;
import com.speedment.runtime.core.db.SqlFunction;
import java.sql.ResultSet;
import java.sql.SQLException;
import leo.prj.petrocoin.db.petro_coin.petro_coin.currency.Currency;
import leo.prj.petrocoin.db.petro_coin.petro_coin.currency.CurrencyImpl;
import static com.speedment.common.injector.State.RESOLVED;
import static com.speedment.runtime.core.internal.util.sql.ResultSetUtil.*;

/**
 * The generated Sql Adapter for a {@link
 * leo.prj.petrocoin.db.petro_coin.petro_coin.currency.Currency} entity.
 * <p>
 * This file has been automatically generated by Speedment. Any changes made to
 * it will be overwritten.
 * 
 * @author Speedment
 */
@GeneratedCode("Speedment")
public abstract class GeneratedCurrencySqlAdapter implements SqlAdapter<Currency> {
    
    private final TableIdentifier<Currency> tableIdentifier;
    
    protected GeneratedCurrencySqlAdapter() {
        this.tableIdentifier = TableIdentifier.of("petro-coin", "petro-coin", "currency");
    }
    
    protected Currency apply(ResultSet resultSet, int offset) throws SQLException {
        return createEntity()
            .setId(          resultSet.getLong(1 + offset))
            .setName(        resultSet.getString(2 + offset))
            .setIsPetroCoin( getInt(resultSet, 3 + offset))
            .setCreatedDate( resultSet.getTimestamp(4 + offset))
            .setUpdatedDate( resultSet.getTimestamp(5 + offset))
            ;
    }
    
    protected CurrencyImpl createEntity() {
        return new CurrencyImpl();
    }
    
    @Override
    public TableIdentifier<Currency> identifier() {
        return tableIdentifier;
    }
    
    @Override
    public SqlFunction<ResultSet, Currency> entityMapper() {
        return entityMapper(0);
    }
    
    @Override
    public SqlFunction<ResultSet, Currency> entityMapper(int offset) {
        return rs -> apply(rs, offset);
    }
}