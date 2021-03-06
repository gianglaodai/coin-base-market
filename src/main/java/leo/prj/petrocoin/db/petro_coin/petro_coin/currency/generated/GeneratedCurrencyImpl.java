package leo.prj.petrocoin.db.petro_coin.petro_coin.currency.generated;

import com.speedment.common.annotation.GeneratedCode;
import com.speedment.runtime.core.util.OptionalUtil;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.StringJoiner;
import leo.prj.petrocoin.db.petro_coin.petro_coin.currency.Currency;

/**
 * The generated base implementation of the {@link
 * leo.prj.petrocoin.db.petro_coin.petro_coin.currency.Currency}-interface.
 * <p>
 * This file has been automatically generated by Speedment. Any changes made to
 * it will be overwritten.
 * 
 * @author Speedment
 */
@GeneratedCode("Speedment")
public abstract class GeneratedCurrencyImpl implements Currency {
    
    private long id;
    private String name;
    private Integer isPetroCoin;
    private Timestamp createdDate;
    private Timestamp updatedDate;
    
    protected GeneratedCurrencyImpl() {}
    
    @Override
    public long getId() {
        return id;
    }
    
    @Override
    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }
    
    @Override
    public OptionalInt getIsPetroCoin() {
        return OptionalUtil.ofNullable(isPetroCoin);
    }
    
    @Override
    public Optional<Timestamp> getCreatedDate() {
        return Optional.ofNullable(createdDate);
    }
    
    @Override
    public Optional<Timestamp> getUpdatedDate() {
        return Optional.ofNullable(updatedDate);
    }
    
    @Override
    public Currency setId(long id) {
        this.id = id;
        return this;
    }
    
    @Override
    public Currency setName(String name) {
        this.name = name;
        return this;
    }
    
    @Override
    public Currency setIsPetroCoin(Integer isPetroCoin) {
        this.isPetroCoin = isPetroCoin;
        return this;
    }
    
    @Override
    public Currency setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
        return this;
    }
    
    @Override
    public Currency setUpdatedDate(Timestamp updatedDate) {
        this.updatedDate = updatedDate;
        return this;
    }
    
    @Override
    public String toString() {
        final StringJoiner sj = new StringJoiner(", ", "{ ", " }");
        sj.add("id = "          + Objects.toString(getId()));
        sj.add("name = "        + Objects.toString(OptionalUtil.unwrap(getName())));
        sj.add("isPetroCoin = " + Objects.toString(OptionalUtil.unwrap(getIsPetroCoin())));
        sj.add("createdDate = " + Objects.toString(OptionalUtil.unwrap(getCreatedDate())));
        sj.add("updatedDate = " + Objects.toString(OptionalUtil.unwrap(getUpdatedDate())));
        return "CurrencyImpl " + sj.toString();
    }
    
    @Override
    public boolean equals(Object that) {
        if (this == that) { return true; }
        if (!(that instanceof Currency)) { return false; }
        final Currency thatCurrency = (Currency)that;
        if (this.getId() != thatCurrency.getId()) { return false; }
        if (!Objects.equals(this.getName(), thatCurrency.getName())) { return false; }
        if (!Objects.equals(this.getIsPetroCoin(), thatCurrency.getIsPetroCoin())) { return false; }
        if (!Objects.equals(this.getCreatedDate(), thatCurrency.getCreatedDate())) { return false; }
        if (!Objects.equals(this.getUpdatedDate(), thatCurrency.getUpdatedDate())) { return false; }
        return true;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Long.hashCode(getId());
        hash = 31 * hash + Objects.hashCode(OptionalUtil.unwrap(getName()));
        hash = 31 * hash + Objects.hashCode(OptionalUtil.unwrap(getIsPetroCoin()));
        hash = 31 * hash + Objects.hashCode(OptionalUtil.unwrap(getCreatedDate()));
        hash = 31 * hash + Objects.hashCode(OptionalUtil.unwrap(getUpdatedDate()));
        return hash;
    }
}