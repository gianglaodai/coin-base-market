package leo.prj.petrocoin.db.petro_coin.petro_coin.wallet.generated;

import com.speedment.common.annotation.GeneratedCode;
import com.speedment.runtime.config.identifier.TableIdentifier;
import com.speedment.runtime.core.component.SqlAdapter;
import com.speedment.runtime.core.db.SqlFunction;
import java.sql.ResultSet;
import java.sql.SQLException;
import leo.prj.petrocoin.db.petro_coin.petro_coin.wallet.Wallet;
import leo.prj.petrocoin.db.petro_coin.petro_coin.wallet.WalletImpl;
import static com.speedment.common.injector.State.RESOLVED;
import static com.speedment.runtime.core.internal.util.sql.ResultSetUtil.*;

/**
 * The generated Sql Adapter for a {@link
 * leo.prj.petrocoin.db.petro_coin.petro_coin.wallet.Wallet} entity.
 * <p>
 * This file has been automatically generated by Speedment. Any changes made to
 * it will be overwritten.
 * 
 * @author Speedment
 */
@GeneratedCode("Speedment")
public abstract class GeneratedWalletSqlAdapter implements SqlAdapter<Wallet> {
    
    private final TableIdentifier<Wallet> tableIdentifier;
    
    protected GeneratedWalletSqlAdapter() {
        this.tableIdentifier = TableIdentifier.of("petro-coin", "petro-coin", "wallet");
    }
    
    protected Wallet apply(ResultSet resultSet, int offset) throws SQLException {
        return createEntity()
            .setId(            resultSet.getLong(1 + offset))
            .setFkUser(        getLong(resultSet, 2 + offset))
            .setFkCurrency(    getLong(resultSet, 3 + offset))
            .setAmount(        getDouble(resultSet, 4 + offset))
            .setWalletAddress( resultSet.getString(5 + offset))
            ;
    }
    
    protected WalletImpl createEntity() {
        return new WalletImpl();
    }
    
    @Override
    public TableIdentifier<Wallet> identifier() {
        return tableIdentifier;
    }
    
    @Override
    public SqlFunction<ResultSet, Wallet> entityMapper() {
        return entityMapper(0);
    }
    
    @Override
    public SqlFunction<ResultSet, Wallet> entityMapper(int offset) {
        return rs -> apply(rs, offset);
    }
}