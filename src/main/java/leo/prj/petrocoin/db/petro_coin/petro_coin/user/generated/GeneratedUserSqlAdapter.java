package leo.prj.petrocoin.db.petro_coin.petro_coin.user.generated;

import com.speedment.common.annotation.GeneratedCode;
import com.speedment.runtime.config.identifier.TableIdentifier;
import com.speedment.runtime.core.component.SqlAdapter;
import com.speedment.runtime.core.db.SqlFunction;
import java.sql.ResultSet;
import java.sql.SQLException;
import leo.prj.petrocoin.db.petro_coin.petro_coin.user.User;
import leo.prj.petrocoin.db.petro_coin.petro_coin.user.UserImpl;
import static com.speedment.common.injector.State.RESOLVED;
import static com.speedment.runtime.core.internal.util.sql.ResultSetUtil.*;

/**
 * The generated Sql Adapter for a {@link
 * leo.prj.petrocoin.db.petro_coin.petro_coin.user.User} entity.
 * <p>
 * This file has been automatically generated by Speedment. Any changes made to
 * it will be overwritten.
 * 
 * @author Speedment
 */
@GeneratedCode("Speedment")
public abstract class GeneratedUserSqlAdapter implements SqlAdapter<User> {
    
    private final TableIdentifier<User> tableIdentifier;
    
    protected GeneratedUserSqlAdapter() {
        this.tableIdentifier = TableIdentifier.of("petro-coin", "petro-coin", "user");
    }
    
    protected User apply(ResultSet resultSet, int offset) throws SQLException {
        return createEntity()
            .setMobile(          resultSet.getString(1 + offset))
            .setBankCode(        resultSet.getString(2 + offset))
            .setId(              resultSet.getLong(3 + offset))
            .setFullName(        resultSet.getString(4 + offset))
            .setPassword(        resultSet.getString(5 + offset))
            .setEmail(           resultSet.getString(6 + offset))
            .setPhone(           resultSet.getString(7 + offset))
            .setNation(          resultSet.getString(8 + offset))
            .setIsActive(        getInt(resultSet, 9 + offset))
            .setIsDelete(        getInt(resultSet, 10 + offset))
            .setBankName(        resultSet.getString(11 + offset))
            .setBankAccount(     resultSet.getString(12 + offset))
            .setBankAccountName( resultSet.getString(13 + offset))
            .setCreatedDate(     resultSet.getTimestamp(14 + offset))
            .setUpdatedDate(     resultSet.getTimestamp(15 + offset))
            ;
    }
    
    protected UserImpl createEntity() {
        return new UserImpl();
    }
    
    @Override
    public TableIdentifier<User> identifier() {
        return tableIdentifier;
    }
    
    @Override
    public SqlFunction<ResultSet, User> entityMapper() {
        return entityMapper(0);
    }
    
    @Override
    public SqlFunction<ResultSet, User> entityMapper(int offset) {
        return rs -> apply(rs, offset);
    }
}