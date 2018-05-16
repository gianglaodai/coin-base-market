package leo.prj.petrocoin.db.petro_coin.petro_coin.deposit_history.generated;

import com.speedment.common.annotation.GeneratedCode;
import com.speedment.runtime.config.identifier.TableIdentifier;
import com.speedment.runtime.core.component.SqlAdapter;
import com.speedment.runtime.core.db.SqlFunction;
import java.sql.ResultSet;
import java.sql.SQLException;
import leo.prj.petrocoin.db.petro_coin.petro_coin.deposit_history.DepositHistory;
import leo.prj.petrocoin.db.petro_coin.petro_coin.deposit_history.DepositHistoryImpl;
import static com.speedment.common.injector.State.RESOLVED;
import static com.speedment.runtime.core.internal.util.sql.ResultSetUtil.*;

/**
 * The generated Sql Adapter for a {@link
 * leo.prj.petrocoin.db.petro_coin.petro_coin.deposit_history.DepositHistory}
 * entity.
 * <p>
 * This file has been automatically generated by Speedment. Any changes made to
 * it will be overwritten.
 * 
 * @author Speedment
 */
@GeneratedCode("Speedment")
public abstract class GeneratedDepositHistorySqlAdapter implements SqlAdapter<DepositHistory> {
    
    private final TableIdentifier<DepositHistory> tableIdentifier;
    
    protected GeneratedDepositHistorySqlAdapter() {
        this.tableIdentifier = TableIdentifier.of("petro-coin", "petro-coin", "deposit_history");
    }
    
    protected DepositHistory apply(ResultSet resultSet, int offset) throws SQLException {
        return createEntity()
            .setId(          resultSet.getInt(1 + offset))
            .setFkWallet(    resultSet.getLong(2 + offset))
            .setDepositDate( resultSet.getTimestamp(3 + offset))
            .setAmount(      getDouble(resultSet, 4 + offset))
            ;
    }
    
    protected DepositHistoryImpl createEntity() {
        return new DepositHistoryImpl();
    }
    
    @Override
    public TableIdentifier<DepositHistory> identifier() {
        return tableIdentifier;
    }
    
    @Override
    public SqlFunction<ResultSet, DepositHistory> entityMapper() {
        return entityMapper(0);
    }
    
    @Override
    public SqlFunction<ResultSet, DepositHistory> entityMapper(int offset) {
        return rs -> apply(rs, offset);
    }
}