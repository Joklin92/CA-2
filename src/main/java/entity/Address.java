package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "address")
@NamedQueries({
    @NamedQuery(name = "Address.findAll", query = "SELECT a FROM Address a")
    , @NamedQuery(name = "Address.findByStreet", query = "SELECT a FROM Address a WHERE a.street = :street")
    , @NamedQuery(name = "Address.findByAdditionalInfo", query = "SELECT a FROM Address a WHERE a.additionalInfo = :additionalInfo")})
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Street")
    private String street;
    @Size(max = 45)
    @Column(name = "AdditionalInfo")
    private String additionalInfo;
    
    @OneToMany (cascade = CascadeType.ALL, mappedBy = "address")
    private List<Person> personAddress = new ArrayList();
  
    @ManyToOne
    @JoinColumn
    private Cityinfo city;
    
    public Address() {
    }

    public Address(String street) {
        this.street = street;
    }

    public List<Person> getPersonAddress() {
        return personAddress;
    }

    public void setPersonAddress(List<Person> personAddress) {
        this.personAddress = personAddress;
    }

    
    
    public Address(String street, Cityinfo cityinfo) {
        this.street = street;
        this.city = cityinfo;
    }

    public Address(Cityinfo cityinfo) {
        this.city = cityinfo;
    }
    
    public Cityinfo getCityinfo() {
        return city;
    }

    public void setCityinfo(Cityinfo cityinfo) {
        this.city = cityinfo;
    }
    
    

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (street != null ? street.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Address other = (Address) obj;
        if (!Objects.equals(this.street, other.street)) {
            return false;
        }
        if (!Objects.equals(this.additionalInfo, other.additionalInfo)) {
            return false;
        }
        if (!Objects.equals(this.personAddress, other.personAddress)) {
            return false;
        }
        if (!Objects.equals(this.city, other.city)) {
            return false;
        }
        return true;
    }

  

    @Override
    public String toString() {
        return "entity.Address[ street=" + street + " ]";
    }
    
}
