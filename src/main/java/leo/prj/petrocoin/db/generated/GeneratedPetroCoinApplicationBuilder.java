package leo.prj.petrocoin.db.generated;

import com.speedment.common.annotation.GeneratedCode;
import com.speedment.common.injector.Injector;
import com.speedment.runtime.application.AbstractApplicationBuilder;
import leo.prj.petrocoin.db.PetroCoinApplication;
import leo.prj.petrocoin.db.PetroCoinApplicationBuilder;
import leo.prj.petrocoin.db.PetroCoinApplicationImpl;
import leo.prj.petrocoin.db.petro_coin.petro_coin.currency.CurrencyManagerImpl;
import leo.prj.petrocoin.db.petro_coin.petro_coin.currency.CurrencySqlAdapter;
import leo.prj.petrocoin.db.petro_coin.petro_coin.deposit_history.DepositHistoryManagerImpl;
import leo.prj.petrocoin.db.petro_coin.petro_coin.deposit_history.DepositHistorySqlAdapter;
import leo.prj.petrocoin.db.petro_coin.petro_coin.petro_transaction.PetroTransactionManagerImpl;
import leo.prj.petrocoin.db.petro_coin.petro_coin.petro_transaction.PetroTransactionSqlAdapter;
import leo.prj.petrocoin.db.petro_coin.petro_coin.rating.RatingManagerImpl;
import leo.prj.petrocoin.db.petro_coin.petro_coin.rating.RatingSqlAdapter;
import leo.prj.petrocoin.db.petro_coin.petro_coin.transaction.TransactionManagerImpl;
import leo.prj.petrocoin.db.petro_coin.petro_coin.transaction.TransactionSqlAdapter;
import leo.prj.petrocoin.db.petro_coin.petro_coin.user.UserManagerImpl;
import leo.prj.petrocoin.db.petro_coin.petro_coin.user.UserSqlAdapter;
import leo.prj.petrocoin.db.petro_coin.petro_coin.wallet.WalletManagerImpl;
import leo.prj.petrocoin.db.petro_coin.petro_coin.wallet.WalletSqlAdapter;

/**
 * A generated base {@link
 * com.speedment.runtime.application.AbstractApplicationBuilder} class for the
 * {@link com.speedment.runtime.config.Project} named petro-coin.
 * <p>
 * This file has been automatically generated by Speedment. Any changes made to
 * it will be overwritten.
 * 
 * @author Speedment
 */
@GeneratedCode("Speedment")
public abstract class GeneratedPetroCoinApplicationBuilder extends AbstractApplicationBuilder<PetroCoinApplication, PetroCoinApplicationBuilder> {
    
    protected GeneratedPetroCoinApplicationBuilder() {
        super(PetroCoinApplicationImpl.class, GeneratedPetroCoinMetadata.class);
        withManager(CurrencyManagerImpl.class);
        withManager(DepositHistoryManagerImpl.class);
        withManager(PetroTransactionManagerImpl.class);
        withManager(RatingManagerImpl.class);
        withManager(TransactionManagerImpl.class);
        withManager(UserManagerImpl.class);
        withManager(WalletManagerImpl.class);
        withComponent(CurrencySqlAdapter.class);
        withComponent(DepositHistorySqlAdapter.class);
        withComponent(PetroTransactionSqlAdapter.class);
        withComponent(RatingSqlAdapter.class);
        withComponent(TransactionSqlAdapter.class);
        withComponent(UserSqlAdapter.class);
        withComponent(WalletSqlAdapter.class);
    }
    
    @Override
    public PetroCoinApplication build(Injector injector) {
        return injector.getOrThrow(PetroCoinApplication.class);
    }
}