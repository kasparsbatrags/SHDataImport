/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kaspars
 */
@Entity
@Table(name = "sadale")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sadale.findAll", query = "SELECT s FROM Sadale s"),
    @NamedQuery(name = "Sadale.findByIdent", query = "SELECT s FROM Sadale s WHERE s.ident = :ident"),
    @NamedQuery(name = "Sadale.findByNoK", query = "SELECT s FROM Sadale s WHERE s.noK = :noK"),
    @NamedQuery(name = "Sadale.findByUzK", query = "SELECT s FROM Sadale s WHERE s.uzK = :uzK"),
    @NamedQuery(name = "Sadale.findBySumma", query = "SELECT s FROM Sadale s WHERE s.summa = :summa"),
    @NamedQuery(name = "Sadale.findBySummaV", query = "SELECT s FROM Sadale s WHERE s.summaV = :summaV"),
    @NamedQuery(name = "Sadale.findByDatums", query = "SELECT s FROM Sadale s WHERE s.datums = :datums"),
    @NamedQuery(name = "Sadale.findByKontets", query = "SELECT s FROM Sadale s WHERE s.kontets = :kontets"),
    @NamedQuery(name = "Sadale.findByNoS", query = "SELECT s FROM Sadale s WHERE s.noS = :noS"),
    @NamedQuery(name = "Sadale.findByUzS", query = "SELECT s FROM Sadale s WHERE s.uzS = :uzS"),
    @NamedQuery(name = "Sadale.findByKlients", query = "SELECT s FROM Sadale s WHERE s.klients = :klients")})
public class Sadale implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ident")
    private Long ident;
    @Column(name = "no_k")
    private String noK;
    @Column(name = "uz_k")
    private String uzK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "summa")
    private BigDecimal summa;
    @Column(name = "summa_v")
    private BigDecimal summaV;
    @Column(name = "datums")
    @Temporal(TemporalType.DATE)
    private Date datums;
    @Column(name = "kontets")
    private Boolean kontets;
    @Column(name = "no_s")
    private String noS;
    @Column(name = "uz_s")
    private String uzS;
    @Column(name = "klients")
    private String klients;

    public Sadale() {
    }

    public Sadale(Long ident) {
        this.ident = ident;
    }

    public Long getIdent() {
        return ident;
    }

    public void setIdent(Long ident) {
        this.ident = ident;
    }

    public String getNoK() {
        return noK;
    }

    public void setNoK(String noK) {
        this.noK = noK;
    }

    public String getUzK() {
        return uzK;
    }

    public void setUzK(String uzK) {
        this.uzK = uzK;
    }

    public BigDecimal getSumma() {
        return summa;
    }

    public void setSumma(BigDecimal summa) {
        this.summa = summa;
    }

    public BigDecimal getSummaV() {
        return summaV;
    }

    public void setSummaV(BigDecimal summaV) {
        this.summaV = summaV;
    }

    public Date getDatums() {
        return datums;
    }

    public void setDatums(Date datums) {
        this.datums = datums;
    }

    public Boolean getKontets() {
        return kontets;
    }

    public void setKontets(Boolean kontets) {
        this.kontets = kontets;
    }

    public String getNoS() {
        return noS;
    }

    public void setNoS(String noS) {
        this.noS = noS;
    }

    public String getUzS() {
        return uzS;
    }

    public void setUzS(String uzS) {
        this.uzS = uzS;
    }

    public String getKlients() {
        return klients;
    }

    public void setKlients(String klients) {
        this.klients = klients;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ident != null ? ident.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sadale)) {
            return false;
        }
        Sadale other = (Sadale) object;
        if ((this.ident == null && other.ident != null) || (this.ident != null && !this.ident.equals(other.ident))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Sadale[ ident=" + ident + " ]";
    }
    
}
