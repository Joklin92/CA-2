package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "cityinfo")
@NamedQueries({
    @NamedQuery(name = "Cityinfo.findAll", query = "SELECT c FROM Cityinfo c")
    , @NamedQuery(name = "Cityinfo.findByZipCode", query = "SELECT c FROM Cityinfo c WHERE c.zipCode = :zipCode")
    , @NamedQuery(name = "Cityinfo.findByCity", query = "SELECT c FROM Cityinfo c WHERE c.city = :city")})
public class Cityinfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ZIP")
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private Integer zipCode;
    @Size(max = 45)
    @Column(name = "CITY")
    private String city;
    
    @OneToMany (cascade = CascadeType.ALL, mappedBy = "city")
    private List<Address> addressCity = new ArrayList();

    public Cityinfo() {
    }

    public Cityinfo(Integer zipCode) {
        this.zipCode = zipCode;
    }

    public List<Address> getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(List<Address> addressCity) {
        this.addressCity = addressCity;
    }

    
    
    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (zipCode != null ? zipCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cityinfo)) {
            return false;
        }
        Cityinfo other = (Cityinfo) object;
        if ((this.zipCode == null && other.zipCode != null) || (this.zipCode != null && !this.zipCode.equals(other.zipCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cityinfo{" + "zipCode=" + zipCode + ", city=" + city + '}';
    }

    
    
}
