package com.company.petro_coin.petro_coin.petro_coin.user.generated;

import com.company.petro_coin.petro_coin.petro_coin.user.User;
import com.speedment.common.annotation.GeneratedCode;
import com.speedment.runtime.config.identifier.ColumnIdentifier;
import com.speedment.runtime.config.identifier.TableIdentifier;
import com.speedment.runtime.core.util.OptionalUtil;
import com.speedment.runtime.field.ComparableField;
import com.speedment.runtime.field.IntField;
import com.speedment.runtime.field.StringField;
import com.speedment.runtime.typemapper.TypeMapper;
import java.util.Optional;
import java.util.OptionalInt;

/**
 * The generated base for the {@link
 * com.company.petro_coin.petro_coin.petro_coin.user.User}-interface
 * representing entities of the {@code user}-table in the database.
 * <p>
 * This file has been automatically generated by Speedment. Any changes made to
 * it will be overwritten.
 * 
 * @author Speedment
 */
@GeneratedCode("Speedment")
public interface GeneratedUser {
    
    /**
     * This Field corresponds to the {@link User} field that can be obtained
     * using the {@link User#getId()} method.
     */
    IntField<User, Integer> ID = IntField.create(
        Identifier.ID,
        User::getId,
        User::setId,
        TypeMapper.primitive(),
        true
    );
    /**
     * This Field corresponds to the {@link User} field that can be obtained
     * using the {@link User#getFullName()} method.
     */
    StringField<User, String> FULL_NAME = StringField.create(
        Identifier.FULL_NAME,
        o -> OptionalUtil.unwrap(o.getFullName()),
        User::setFullName,
        TypeMapper.identity(),
        false
    );
    /**
     * This Field corresponds to the {@link User} field that can be obtained
     * using the {@link User#getPassword()} method.
     */
    StringField<User, String> PASSWORD = StringField.create(
        Identifier.PASSWORD,
        o -> OptionalUtil.unwrap(o.getPassword()),
        User::setPassword,
        TypeMapper.identity(),
        false
    );
    /**
     * This Field corresponds to the {@link User} field that can be obtained
     * using the {@link User#getEmail()} method.
     */
    StringField<User, String> EMAIL = StringField.create(
        Identifier.EMAIL,
        o -> OptionalUtil.unwrap(o.getEmail()),
        User::setEmail,
        TypeMapper.identity(),
        false
    );
    /**
     * This Field corresponds to the {@link User} field that can be obtained
     * using the {@link User#getMobile()} method.
     */
    StringField<User, String> MOBILE = StringField.create(
        Identifier.MOBILE,
        o -> OptionalUtil.unwrap(o.getMobile()),
        User::setMobile,
        TypeMapper.identity(),
        false
    );
    /**
     * This Field corresponds to the {@link User} field that can be obtained
     * using the {@link User#getNation()} method.
     */
    StringField<User, String> NATION = StringField.create(
        Identifier.NATION,
        o -> OptionalUtil.unwrap(o.getNation()),
        User::setNation,
        TypeMapper.identity(),
        false
    );
    /**
     * This Field corresponds to the {@link User} field that can be obtained
     * using the {@link User#getIsActive()} method.
     */
    ComparableField<User, Integer, Integer> IS_ACTIVE = ComparableField.create(
        Identifier.IS_ACTIVE,
        o -> OptionalUtil.unwrap(o.getIsActive()),
        User::setIsActive,
        TypeMapper.identity(),
        false
    );
    /**
     * This Field corresponds to the {@link User} field that can be obtained
     * using the {@link User#getIsDelete()} method.
     */
    ComparableField<User, Integer, Integer> IS_DELETE = ComparableField.create(
        Identifier.IS_DELETE,
        o -> OptionalUtil.unwrap(o.getIsDelete()),
        User::setIsDelete,
        TypeMapper.identity(),
        false
    );
    /**
     * This Field corresponds to the {@link User} field that can be obtained
     * using the {@link User#getBankCode()} method.
     */
    StringField<User, String> BANK_CODE = StringField.create(
        Identifier.BANK_CODE,
        o -> OptionalUtil.unwrap(o.getBankCode()),
        User::setBankCode,
        TypeMapper.identity(),
        false
    );
    
    /**
     * Returns the id of this User. The id field corresponds to the database
     * column petro-coin.petro-coin.user.id.
     * 
     * @return the id of this User
     */
    int getId();
    
    /**
     * Returns the fullName of this User. The fullName field corresponds to the
     * database column petro-coin.petro-coin.user.full_name.
     * 
     * @return the fullName of this User
     */
    Optional<String> getFullName();
    
    /**
     * Returns the password of this User. The password field corresponds to the
     * database column petro-coin.petro-coin.user.password.
     * 
     * @return the password of this User
     */
    Optional<String> getPassword();
    
    /**
     * Returns the email of this User. The email field corresponds to the
     * database column petro-coin.petro-coin.user.email.
     * 
     * @return the email of this User
     */
    Optional<String> getEmail();
    
    /**
     * Returns the mobile of this User. The mobile field corresponds to the
     * database column petro-coin.petro-coin.user.mobile.
     * 
     * @return the mobile of this User
     */
    Optional<String> getMobile();
    
    /**
     * Returns the nation of this User. The nation field corresponds to the
     * database column petro-coin.petro-coin.user.nation.
     * 
     * @return the nation of this User
     */
    Optional<String> getNation();
    
    /**
     * Returns the isActive of this User. The isActive field corresponds to the
     * database column petro-coin.petro-coin.user.is_active.
     * 
     * @return the isActive of this User
     */
    OptionalInt getIsActive();
    
    /**
     * Returns the isDelete of this User. The isDelete field corresponds to the
     * database column petro-coin.petro-coin.user.is_delete.
     * 
     * @return the isDelete of this User
     */
    OptionalInt getIsDelete();
    
    /**
     * Returns the bankCode of this User. The bankCode field corresponds to the
     * database column petro-coin.petro-coin.user.bank_code.
     * 
     * @return the bankCode of this User
     */
    Optional<String> getBankCode();
    
    /**
     * Sets the id of this User. The id field corresponds to the database column
     * petro-coin.petro-coin.user.id.
     * 
     * @param id to set of this User
     * @return   this User instance
     */
    User setId(int id);
    
    /**
     * Sets the fullName of this User. The fullName field corresponds to the
     * database column petro-coin.petro-coin.user.full_name.
     * 
     * @param fullName to set of this User
     * @return         this User instance
     */
    User setFullName(String fullName);
    
    /**
     * Sets the password of this User. The password field corresponds to the
     * database column petro-coin.petro-coin.user.password.
     * 
     * @param password to set of this User
     * @return         this User instance
     */
    User setPassword(String password);
    
    /**
     * Sets the email of this User. The email field corresponds to the database
     * column petro-coin.petro-coin.user.email.
     * 
     * @param email to set of this User
     * @return      this User instance
     */
    User setEmail(String email);
    
    /**
     * Sets the mobile of this User. The mobile field corresponds to the
     * database column petro-coin.petro-coin.user.mobile.
     * 
     * @param mobile to set of this User
     * @return       this User instance
     */
    User setMobile(String mobile);
    
    /**
     * Sets the nation of this User. The nation field corresponds to the
     * database column petro-coin.petro-coin.user.nation.
     * 
     * @param nation to set of this User
     * @return       this User instance
     */
    User setNation(String nation);
    
    /**
     * Sets the isActive of this User. The isActive field corresponds to the
     * database column petro-coin.petro-coin.user.is_active.
     * 
     * @param isActive to set of this User
     * @return         this User instance
     */
    User setIsActive(Integer isActive);
    
    /**
     * Sets the isDelete of this User. The isDelete field corresponds to the
     * database column petro-coin.petro-coin.user.is_delete.
     * 
     * @param isDelete to set of this User
     * @return         this User instance
     */
    User setIsDelete(Integer isDelete);
    
    /**
     * Sets the bankCode of this User. The bankCode field corresponds to the
     * database column petro-coin.petro-coin.user.bank_code.
     * 
     * @param bankCode to set of this User
     * @return         this User instance
     */
    User setBankCode(String bankCode);
    
    enum Identifier implements ColumnIdentifier<User> {
        
        ID        ("id"),
        FULL_NAME ("full_name"),
        PASSWORD  ("password"),
        EMAIL     ("email"),
        MOBILE    ("mobile"),
        NATION    ("nation"),
        IS_ACTIVE ("is_active"),
        IS_DELETE ("is_delete"),
        BANK_CODE ("bank_code");
        
        private final String columnId;
        private final TableIdentifier<User> tableIdentifier;
        
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
            return "user";
        }
        
        @Override
        public String getColumnId() {
            return this.columnId;
        }
        
        @Override
        public TableIdentifier<User> asTableIdentifier() {
            return this.tableIdentifier;
        }
    }
}