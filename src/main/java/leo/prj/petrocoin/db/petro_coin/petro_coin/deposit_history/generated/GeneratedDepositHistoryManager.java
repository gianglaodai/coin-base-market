package leo.prj.petrocoin.db.petro_coin.petro_coin.deposit_history.generated;

import com.speedment.common.annotation.GeneratedCode;
import com.speedment.runtime.config.identifier.TableIdentifier;
import com.speedment.runtime.core.manager.Manager;
import com.speedment.runtime.field.Field;
import java.util.List;
import leo.prj.petrocoin.db.petro_coin.petro_coin.deposit_history.DepositHistory;
import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableList;

/**
 * The generated base interface for the manager of every {@link
 * leo.prj.petrocoin.db.petro_coin.petro_coin.deposit_history.DepositHistory}
 * entity.
 * <p>
 * This file has been automatically generated by Speedment. Any changes made to
 * it will be overwritten.
 * 
 * @author Speedment
 */
@GeneratedCode("Speedment")
public interface GeneratedDepositHistoryManager extends Manager<DepositHistory> {
    
    TableIdentifier<DepositHistory> IDENTIFIER = TableIdentifier.of(
        "petro-coin",
        "petro-coin",
        "deposit_history"
    )
    ;
    List<Field<DepositHistory>> FIELDS = unmodifiableList(asList(
        DepositHistory.FK_WALLET,
        DepositHistory.DEPOSIT_DATE,
        DepositHistory.AMOUNT
    ));
    
    @Override
    default Class<DepositHistory> getEntityClass() {
        return DepositHistory.class;
    }
}