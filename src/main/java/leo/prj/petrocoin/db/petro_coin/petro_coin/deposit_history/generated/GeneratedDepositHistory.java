package leo.prj.petrocoin.db.petro_coin.petro_coin.deposit_history.generated;

import com.speedment.common.annotation.GeneratedCode;
import com.speedment.runtime.config.identifier.ColumnIdentifier;
import com.speedment.runtime.config.identifier.TableIdentifier;
import com.speedment.runtime.core.manager.Manager;
import com.speedment.runtime.core.util.OptionalUtil;
import com.speedment.runtime.field.ComparableField;
import com.speedment.runtime.field.IntField;
import com.speedment.runtime.field.LongForeignKeyField;
import com.speedment.runtime.typemapper.TypeMapper;
import java.sql.Timestamp;
import java.util.Optional;
import java.util.OptionalDouble;
import leo.prj.petrocoin.db.petro_coin.petro_coin.deposit_history.DepositHistory;
import leo.prj.petrocoin.db.petro_coin.petro_coin.wallet.Wallet;

/**
 * The generated base for the {@link
 * leo.prj.petrocoin.db.petro_coin.petro_coin.deposit_history.DepositHistory}-interface
 * representing entities of the {@code deposit_history}-table in the database.
 * <p>
 * This file has been automatically generated by Speedment. Any changes made to
 * it will be overwritten.
 * 
 * @author Speedment
 */
@GeneratedCode("Speedment")
public interface GeneratedDepositHistory {
    
    /**
     * This Field corresponds to the {@link DepositHistory} field that can be
     * obtained using the {@link DepositHistory#getId()} method.
     */
    IntField<DepositHistory, Integer> ID = IntField.create(
        Identifier.ID,
        DepositHistory::getId,
        DepositHistory::setId,
        TypeMapper.primitive(),
        false
    );
    /**
     * This Field corresponds to the {@link DepositHistory} field that can be
     * obtained using the {@link DepositHistory#getFkWallet()} method.
     */
    LongForeignKeyField<DepositHistory, Long, Wallet> FK_WALLET = LongForeignKeyField.create(
        Identifier.FK_WALLET,
        DepositHistory::getFkWallet,
        DepositHistory::setFkWallet,
        Wallet.ID,
        TypeMapper.primitive(),
        false
    );
    /**
     * This Field corresponds to the {@link DepositHistory} field that can be
     * obtained using the {@link DepositHistory#getDepositDate()} method.
     */
    ComparableField<DepositHistory, Timestamp, Timestamp> DEPOSIT_DATE = ComparableField.create(
        Identifier.DEPOSIT_DATE,
        o -> OptionalUtil.unwrap(o.getDepositDate()),
        DepositHistory::setDepositDate,
        TypeMapper.identity(),
        false
    );
    /**
     * This Field corresponds to the {@link DepositHistory} field that can be
     * obtained using the {@link DepositHistory#getAmount()} method.
     */
    ComparableField<DepositHistory, Double, Double> AMOUNT = ComparableField.create(
        Identifier.AMOUNT,
        o -> OptionalUtil.unwrap(o.getAmount()),
        DepositHistory::setAmount,
        TypeMapper.identity(),
        false
    );
    
    /**
     * Returns the id of this DepositHistory. The id field corresponds to the
     * database column petro-coin.petro-coin.deposit_history.id.
     * 
     * @return the id of this DepositHistory
     */
    int getId();
    
    /**
     * Returns the fkWallet of this DepositHistory. The fkWallet field
     * corresponds to the database column
     * petro-coin.petro-coin.deposit_history.fk_wallet.
     * 
     * @return the fkWallet of this DepositHistory
     */
    long getFkWallet();
    
    /**
     * Returns the depositDate of this DepositHistory. The depositDate field
     * corresponds to the database column
     * petro-coin.petro-coin.deposit_history.deposit_date.
     * 
     * @return the depositDate of this DepositHistory
     */
    Optional<Timestamp> getDepositDate();
    
    /**
     * Returns the amount of this DepositHistory. The amount field corresponds
     * to the database column petro-coin.petro-coin.deposit_history.amount.
     * 
     * @return the amount of this DepositHistory
     */
    OptionalDouble getAmount();
    
    /**
     * Sets the id of this DepositHistory. The id field corresponds to the
     * database column petro-coin.petro-coin.deposit_history.id.
     * 
     * @param id to set of this DepositHistory
     * @return   this DepositHistory instance
     */
    DepositHistory setId(int id);
    
    /**
     * Sets the fkWallet of this DepositHistory. The fkWallet field corresponds
     * to the database column petro-coin.petro-coin.deposit_history.fk_wallet.
     * 
     * @param fkWallet to set of this DepositHistory
     * @return         this DepositHistory instance
     */
    DepositHistory setFkWallet(long fkWallet);
    
    /**
     * Sets the depositDate of this DepositHistory. The depositDate field
     * corresponds to the database column
     * petro-coin.petro-coin.deposit_history.deposit_date.
     * 
     * @param depositDate to set of this DepositHistory
     * @return            this DepositHistory instance
     */
    DepositHistory setDepositDate(Timestamp depositDate);
    
    /**
     * Sets the amount of this DepositHistory. The amount field corresponds to
     * the database column petro-coin.petro-coin.deposit_history.amount.
     * 
     * @param amount to set of this DepositHistory
     * @return       this DepositHistory instance
     */
    DepositHistory setAmount(Double amount);
    
    /**
     * Queries the specified manager for the referenced Wallet. If no such
     * Wallet exists, an {@code NullPointerException} will be thrown.
     * 
     * @param foreignManager the manager to query for the entity
     * @return               the foreign entity referenced
     */
    Wallet findFkWallet(Manager<Wallet> foreignManager);
    
    enum Identifier implements ColumnIdentifier<DepositHistory> {
        
        ID           ("id"),
        FK_WALLET    ("fk_wallet"),
        DEPOSIT_DATE ("deposit_date"),
        AMOUNT       ("amount");
        
        private final String columnId;
        private final TableIdentifier<DepositHistory> tableIdentifier;
        
        Identifier(String columnId) {
            this.columnId        = columnId;
            this.tableIdentifier = TableIdentifier.of(    getDbmsId(), 
                getSchemaId(), 
                getTableId());
        }
        
        @Override
        public String getDbmsId() {
            return "petro-coin";
        }
        
        @Override
        public String getSchemaId() {
            return "petro-coin";
        }
        
        @Override
        public String getTableId() {
            return "deposit_history";
        }
        
        @Override
        public String getColumnId() {
            return this.columnId;
        }
        
        @Override
        public TableIdentifier<DepositHistory> asTableIdentifier() {
            return this.tableIdentifier;
        }
    }
}