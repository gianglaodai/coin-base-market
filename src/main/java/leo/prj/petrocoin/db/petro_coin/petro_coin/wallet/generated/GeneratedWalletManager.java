package leo.prj.petrocoin.db.petro_coin.petro_coin.wallet.generated;

import com.speedment.common.annotation.GeneratedCode;
import com.speedment.runtime.config.identifier.TableIdentifier;
import com.speedment.runtime.core.manager.Manager;
import com.speedment.runtime.field.Field;
import java.util.List;
import leo.prj.petrocoin.db.petro_coin.petro_coin.wallet.Wallet;
import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableList;

/**
 * The generated base interface for the manager of every {@link
 * leo.prj.petrocoin.db.petro_coin.petro_coin.wallet.Wallet} entity.
 * <p>
 * This file has been automatically generated by Speedment. Any changes made to
 * it will be overwritten.
 * 
 * @author Speedment
 */
@GeneratedCode("Speedment")
public interface GeneratedWalletManager extends Manager<Wallet> {
    
    TableIdentifier<Wallet> IDENTIFIER = TableIdentifier.of(
        "petro-coin",
        "petro-coin",
        "wallet"
    )
    ;
    List<Field<Wallet>> FIELDS = unmodifiableList(asList(
        Wallet.ID,
        Wallet.FK_USER,
        Wallet.FK_CURRENCY,
        Wallet.AMOUNT,
        Wallet.WALLET_ADDRESS
    ));
    
    @Override
    default Class<Wallet> getEntityClass() {
        return Wallet.class;
    }
}