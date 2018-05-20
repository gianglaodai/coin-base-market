package leo.prj.petrocoin.db.petro_coin.petro_coin.transaction.generated;

import com.speedment.common.annotation.GeneratedCode;
import com.speedment.runtime.config.identifier.ColumnIdentifier;
import com.speedment.runtime.config.identifier.TableIdentifier;
import com.speedment.runtime.core.manager.Manager;
import com.speedment.runtime.core.util.OptionalUtil;
import com.speedment.runtime.field.ComparableField;
import com.speedment.runtime.field.ComparableForeignKeyField;
import com.speedment.runtime.field.StringField;
import com.speedment.runtime.typemapper.TypeMapper;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalLong;
import leo.prj.petrocoin.db.petro_coin.petro_coin.transaction.Transaction;
import leo.prj.petrocoin.db.petro_coin.petro_coin.user.User;

/**
 * The generated base for the {@link
 * leo.prj.petrocoin.db.petro_coin.petro_coin.transaction.Transaction}-interface
 * representing entities of the {@code transaction}-table in the database.
 * <p>
 * This file has been automatically generated by Speedment. Any changes made to
 * it will be overwritten.
 * 
 * @author Speedment
 */
@GeneratedCode("Speedment")
public interface GeneratedTransaction {
    
    /**
     * This Field corresponds to the {@link Transaction} field that can be
     * obtained using the {@link Transaction#getId()} method.
     */
    ComparableField<Transaction, BigInteger, BigInteger> ID = ComparableField.create(
        Identifier.ID,
        Transaction::getId,
        Transaction::setId,
        TypeMapper.identity(),
        true
    );
    /**
     * This Field corresponds to the {@link Transaction} field that can be
     * obtained using the {@link Transaction#getFkUserFrom()} method.
     */
    ComparableForeignKeyField<Transaction, Long, Long, User> FK_USER_FROM = ComparableForeignKeyField.create(
        Identifier.FK_USER_FROM,
        o -> OptionalUtil.unwrap(o.getFkUserFrom()),
        Transaction::setFkUserFrom,
        User.ID,
        TypeMapper.identity(),
        false
    );
    /**
     * This Field corresponds to the {@link Transaction} field that can be
     * obtained using the {@link Transaction#getFkUserTo()} method.
     */
    ComparableForeignKeyField<Transaction, Long, Long, User> FK_USER_TO = ComparableForeignKeyField.create(
        Identifier.FK_USER_TO,
        o -> OptionalUtil.unwrap(o.getFkUserTo()),
        Transaction::setFkUserTo,
        User.ID,
        TypeMapper.identity(),
        false
    );
    /**
     * This Field corresponds to the {@link Transaction} field that can be
     * obtained using the {@link Transaction#getFkCurrency()} method.
     */
    ComparableForeignKeyField<Transaction, Long, Long, User> FK_CURRENCY = ComparableForeignKeyField.create(
        Identifier.FK_CURRENCY,
        o -> OptionalUtil.unwrap(o.getFkCurrency()),
        Transaction::setFkCurrency,
        User.ID,
        TypeMapper.identity(),
        false
    );
    /**
     * This Field corresponds to the {@link Transaction} field that can be
     * obtained using the {@link Transaction#getAmount()} method.
     */
    ComparableField<Transaction, Double, Double> AMOUNT = ComparableField.create(
        Identifier.AMOUNT,
        o -> OptionalUtil.unwrap(o.getAmount()),
        Transaction::setAmount,
        TypeMapper.identity(),
        false
    );
    /**
     * This Field corresponds to the {@link Transaction} field that can be
     * obtained using the {@link Transaction#getStatus()} method.
     */
    StringField<Transaction, String> STATUS = StringField.create(
        Identifier.STATUS,
        o -> OptionalUtil.unwrap(o.getStatus()),
        Transaction::setStatus,
        TypeMapper.identity(),
        false
    );
    /**
     * This Field corresponds to the {@link Transaction} field that can be
     * obtained using the {@link Transaction#getContent()} method.
     */
    StringField<Transaction, String> CONTENT = StringField.create(
        Identifier.CONTENT,
        o -> OptionalUtil.unwrap(o.getContent()),
        Transaction::setContent,
        TypeMapper.identity(),
        false
    );
    /**
     * This Field corresponds to the {@link Transaction} field that can be
     * obtained using the {@link Transaction#getCreatedDate()} method.
     */
    ComparableField<Transaction, Timestamp, Timestamp> CREATED_DATE = ComparableField.create(
        Identifier.CREATED_DATE,
        o -> OptionalUtil.unwrap(o.getCreatedDate()),
        Transaction::setCreatedDate,
        TypeMapper.identity(),
        false
    );
    /**
     * This Field corresponds to the {@link Transaction} field that can be
     * obtained using the {@link Transaction#getExecutionDate()} method.
     */
    ComparableField<Transaction, Timestamp, Timestamp> EXECUTION_DATE = ComparableField.create(
        Identifier.EXECUTION_DATE,
        o -> OptionalUtil.unwrap(o.getExecutionDate()),
        Transaction::setExecutionDate,
        TypeMapper.identity(),
        false
    );
    
    /**
     * Returns the id of this Transaction. The id field corresponds to the
     * database column petro-coin.petro-coin.transaction.id.
     * 
     * @return the id of this Transaction
     */
    BigInteger getId();
    
    /**
     * Returns the fkUserFrom of this Transaction. The fkUserFrom field
     * corresponds to the database column
     * petro-coin.petro-coin.transaction.fk_user_from.
     * 
     * @return the fkUserFrom of this Transaction
     */
    OptionalLong getFkUserFrom();
    
    /**
     * Returns the fkUserTo of this Transaction. The fkUserTo field corresponds
     * to the database column petro-coin.petro-coin.transaction.fk_user_to.
     * 
     * @return the fkUserTo of this Transaction
     */
    OptionalLong getFkUserTo();
    
    /**
     * Returns the fkCurrency of this Transaction. The fkCurrency field
     * corresponds to the database column
     * petro-coin.petro-coin.transaction.fk_currency.
     * 
     * @return the fkCurrency of this Transaction
     */
    OptionalLong getFkCurrency();
    
    /**
     * Returns the amount of this Transaction. The amount field corresponds to
     * the database column petro-coin.petro-coin.transaction.amount.
     * 
     * @return the amount of this Transaction
     */
    OptionalDouble getAmount();
    
    /**
     * Returns the status of this Transaction. The status field corresponds to
     * the database column petro-coin.petro-coin.transaction.status.
     * 
     * @return the status of this Transaction
     */
    Optional<String> getStatus();
    
    /**
     * Returns the content of this Transaction. The content field corresponds to
     * the database column petro-coin.petro-coin.transaction.content.
     * 
     * @return the content of this Transaction
     */
    Optional<String> getContent();
    
    /**
     * Returns the createdDate of this Transaction. The createdDate field
     * corresponds to the database column
     * petro-coin.petro-coin.transaction.created_date.
     * 
     * @return the createdDate of this Transaction
     */
    Optional<Timestamp> getCreatedDate();
    
    /**
     * Returns the executionDate of this Transaction. The executionDate field
     * corresponds to the database column
     * petro-coin.petro-coin.transaction.execution_date.
     * 
     * @return the executionDate of this Transaction
     */
    Optional<Timestamp> getExecutionDate();
    
    /**
     * Sets the id of this Transaction. The id field corresponds to the database
     * column petro-coin.petro-coin.transaction.id.
     * 
     * @param id to set of this Transaction
     * @return   this Transaction instance
     */
    Transaction setId(BigInteger id);
    
    /**
     * Sets the fkUserFrom of this Transaction. The fkUserFrom field corresponds
     * to the database column petro-coin.petro-coin.transaction.fk_user_from.
     * 
     * @param fkUserFrom to set of this Transaction
     * @return           this Transaction instance
     */
    Transaction setFkUserFrom(Long fkUserFrom);
    
    /**
     * Sets the fkUserTo of this Transaction. The fkUserTo field corresponds to
     * the database column petro-coin.petro-coin.transaction.fk_user_to.
     * 
     * @param fkUserTo to set of this Transaction
     * @return         this Transaction instance
     */
    Transaction setFkUserTo(Long fkUserTo);
    
    /**
     * Sets the fkCurrency of this Transaction. The fkCurrency field corresponds
     * to the database column petro-coin.petro-coin.transaction.fk_currency.
     * 
     * @param fkCurrency to set of this Transaction
     * @return           this Transaction instance
     */
    Transaction setFkCurrency(Long fkCurrency);
    
    /**
     * Sets the amount of this Transaction. The amount field corresponds to the
     * database column petro-coin.petro-coin.transaction.amount.
     * 
     * @param amount to set of this Transaction
     * @return       this Transaction instance
     */
    Transaction setAmount(Double amount);
    
    /**
     * Sets the status of this Transaction. The status field corresponds to the
     * database column petro-coin.petro-coin.transaction.status.
     * 
     * @param status to set of this Transaction
     * @return       this Transaction instance
     */
    Transaction setStatus(String status);
    
    /**
     * Sets the content of this Transaction. The content field corresponds to
     * the database column petro-coin.petro-coin.transaction.content.
     * 
     * @param content to set of this Transaction
     * @return        this Transaction instance
     */
    Transaction setContent(String content);
    
    /**
     * Sets the createdDate of this Transaction. The createdDate field
     * corresponds to the database column
     * petro-coin.petro-coin.transaction.created_date.
     * 
     * @param createdDate to set of this Transaction
     * @return            this Transaction instance
     */
    Transaction setCreatedDate(Timestamp createdDate);
    
    /**
     * Sets the executionDate of this Transaction. The executionDate field
     * corresponds to the database column
     * petro-coin.petro-coin.transaction.execution_date.
     * 
     * @param executionDate to set of this Transaction
     * @return              this Transaction instance
     */
    Transaction setExecutionDate(Timestamp executionDate);
    
    /**
     * Queries the specified manager for the referenced User. If no such User
     * exists, an {@code NullPointerException} will be thrown.
     * 
     * @param foreignManager the manager to query for the entity
     * @return               the foreign entity referenced
     */
    Optional<User> findFkUserFrom(Manager<User> foreignManager);
    
    /**
     * Queries the specified manager for the referenced User. If no such User
     * exists, an {@code NullPointerException} will be thrown.
     * 
     * @param foreignManager the manager to query for the entity
     * @return               the foreign entity referenced
     */
    Optional<User> findFkUserTo(Manager<User> foreignManager);
    
    /**
     * Queries the specified manager for the referenced User. If no such User
     * exists, an {@code NullPointerException} will be thrown.
     * 
     * @param foreignManager the manager to query for the entity
     * @return               the foreign entity referenced
     */
    Optional<User> findFkCurrency(Manager<User> foreignManager);
    
    enum Identifier implements ColumnIdentifier<Transaction> {
        
        ID             ("id"),
        FK_USER_FROM   ("fk_user_from"),
        FK_USER_TO     ("fk_user_to"),
        FK_CURRENCY    ("fk_currency"),
        AMOUNT         ("amount"),
        STATUS         ("status"),
        CONTENT        ("content"),
        CREATED_DATE   ("created_date"),
        EXECUTION_DATE ("execution_date");
        
        private final String columnId;
        private final TableIdentifier<Transaction> tableIdentifier;
        
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
            return "transaction";
        }
        
        @Override
        public String getColumnId() {
            return this.columnId;
        }
        
        @Override
        public TableIdentifier<Transaction> asTableIdentifier() {
            return this.tableIdentifier;
        }
    }
}