package leo.prj.petrocoin.db.petro_coin.petro_coin.wallet.generated;

import com.speedment.common.annotation.GeneratedCode;
import com.speedment.runtime.config.identifier.TableIdentifier;
import com.speedment.runtime.core.manager.AbstractManager;
import com.speedment.runtime.field.Field;
import java.util.stream.Stream;
import leo.prj.petrocoin.db.petro_coin.petro_coin.wallet.Wallet;
import leo.prj.petrocoin.db.petro_coin.petro_coin.wallet.WalletManager;

/**
 * The generated base implementation for the manager of every {@link
 * leo.prj.petrocoin.db.petro_coin.petro_coin.wallet.Wallet} entity.
 * <p>
 * This file has been automatically generated by Speedment. Any changes made to
 * it will be overwritten.
 * 
 * @author Speedment
 */
@GeneratedCode("Speedment")
public abstract class GeneratedWalletManagerImpl 
extends AbstractManager<Wallet> 
implements GeneratedWalletManager {
    
    private final TableIdentifier<Wallet> tableIdentifier;
    
    protected GeneratedWalletManagerImpl() {
        this.tableIdentifier = TableIdentifier.of("petro-coin", "petro-coin", "wallet");
    }
    
    @Override
    public TableIdentifier<Wallet> getTableIdentifier() {
        return tableIdentifier;
    }
    
    @Override
    public Stream<Field<Wallet>> fields() {
        return WalletManager.FIELDS.stream();
    }
    
    @Override
    public Stream<Field<Wallet>> primaryKeyFields() {
        return Stream.of(
            Wallet.ID
        );
    }
}