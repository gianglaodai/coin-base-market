package leo.prj.petrocoin.db.petro_coin.petro_coin.transaction.generated;

import com.speedment.common.annotation.GeneratedCode;
import com.speedment.runtime.config.identifier.TableIdentifier;
import com.speedment.runtime.core.component.SqlAdapter;
import com.speedment.runtime.core.db.SqlFunction;
import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import leo.prj.petrocoin.db.petro_coin.petro_coin.transaction.Transaction;
import leo.prj.petrocoin.db.petro_coin.petro_coin.transaction.TransactionImpl;
import static com.speedment.common.injector.State.RESOLVED;
import static com.speedment.runtime.core.internal.util.sql.ResultSetUtil.*;

/**
 * The generated Sql Adapter for a {@link
 * leo.prj.petrocoin.db.petro_coin.petro_coin.transaction.Transaction} entity.
 * <p>
 * This file has been automatically generated by Speedment. Any changes made to
 * it will be overwritten.
 * 
 * @author Speedment
 */
@GeneratedCode("Speedment")
public abstract class GeneratedTransactionSqlAdapter implements SqlAdapter<Transaction> {
    
    private final TableIdentifier<Transaction> tableIdentifier;
    
    protected GeneratedTransactionSqlAdapter() {
        this.tableIdentifier = TableIdentifier.of("petro-coin", "petro-coin", "transaction");
    }
    
    protected Transaction apply(ResultSet resultSet, int offset) throws SQLException {
        return createEntity()
            .setId(            (BigInteger) resultSet.getObject(1 + offset))
            .setFkUserFrom(    getLong(resultSet, 2 + offset))
            .setFkUserTo(      getLong(resultSet, 3 + offset))
            .setFkCurrency(    getLong(resultSet, 4 + offset))
            .setAmount(        getDouble(resultSet, 5 + offset))
            .setStatus(        resultSet.getString(6 + offset))
            .setContent(       resultSet.getString(7 + offset))
            .setCreatedDate(   resultSet.getTimestamp(8 + offset))
            .setExecutionDate( resultSet.getTimestamp(9 + offset))
            ;
    }
    
    protected TransactionImpl createEntity() {
        return new TransactionImpl();
    }
    
    @Override
    public TableIdentifier<Transaction> identifier() {
        return tableIdentifier;
    }
    
    @Override
    public SqlFunction<ResultSet, Transaction> entityMapper() {
        return entityMapper(0);
    }
    
    @Override
    public SqlFunction<ResultSet, Transaction> entityMapper(int offset) {
        return rs -> apply(rs, offset);
    }
}