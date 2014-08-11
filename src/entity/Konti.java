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
@Table(name = "konti")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Konti.findAll", query = "SELECT k FROM Konti k"),
    @NamedQuery(name = "Konti.findByKonts", query = "SELECT k FROM Konti k WHERE k.konts = :konts"),
    @NamedQuery(name = "Konti.findByVards", query = "SELECT k FROM Konti k WHERE k.vards = :vards"),
    @NamedQuery(name = "Konti.findByAP", query = "SELECT k FROM Konti k WHERE k.aP = :aP"),
    @NamedQuery(name = "Konti.findByBilancei", query = "SELECT k FROM Konti k WHERE k.bilancei = :bilancei"),
    @NamedQuery(name = "Konti.findByValuta", query = "SELECT k FROM Konti k WHERE k.valuta = :valuta"),
    @NamedQuery(name = "Konti.findBySumma", query = "SELECT k FROM Konti k WHERE k.summa = :summa"),
    @NamedQuery(name = "Konti.findBySummaG", query = "SELECT k FROM Konti k WHERE k.summaG = :summaG"),
    @NamedQuery(name = "Konti.findByBaze", query = "SELECT k FROM Konti k WHERE k.baze = :baze"),
    @NamedQuery(name = "Konti.findByDatums", query = "SELECT k FROM Konti k WHERE k.datums = :datums"),
    @NamedQuery(name = "Konti.findByPelna", query = "SELECT k FROM Konti k WHERE k.pelna = :pelna"),
    @NamedQuery(name = "Konti.findByZaudejums", query = "SELECT k FROM Konti k WHERE k.zaudejums = :zaudejums"),
    @NamedQuery(name = "Konti.findByOp", query = "SELECT k FROM Konti k WHERE k.op = :op"),
    @NamedQuery(name = "Konti.findByADatums", query = "SELECT k FROM Konti k WHERE k.aDatums = :aDatums"),
    @NamedQuery(name = "Konti.findByNozime", query = "SELECT k FROM Konti k WHERE k.nozime = :nozime")})
public class Konti implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "konts")
    private String konts;
    @Column(name = "vards")
    private String vards;
    @Column(name = "a_p")
    private Boolean aP;
    @Column(name = "bilancei")
    private Boolean bilancei;
    @Column(name = "valuta")
    private String valuta;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "summa")
    private BigDecimal summa;
    @Column(name = "summa_g")
    private BigDecimal summaG;
    @Column(name = "baze")
    private Boolean baze;
    @Column(name = "datums")
    @Temporal(TemporalType.DATE)
    private Date datums;
    @Column(name = "pelna")
    private String pelna;
    @Column(name = "zaudejums")
    private String zaudejums;
    @Column(name = "op")
    private String op;
    @Column(name = "a_datums")
    @Temporal(TemporalType.DATE)
    private Date aDatums;
    @Column(name = "nozime")
    private String nozime;

    public Konti() {
    }

    public Konti(String konts) {
        this.konts = konts;
    }

    public String getKonts() {
        return konts;
    }

    public void setKonts(String konts) {
        this.konts = konts;
    }

    public String getVards() {
        return vards;
    }

    public void setVards(String vards) {
        this.vards = vards;
    }

    public Boolean getAP() {
        return aP;
    }

    public void setAP(Boolean aP) {
        this.aP = aP;
    }

    public Boolean getBilancei() {
        return bilancei;
    }

    public void setBilancei(Boolean bilancei) {
        this.bilancei = bilancei;
    }

    public String getValuta() {
        return valuta;
    }

    public void setValuta(String valuta) {
        this.valuta = valuta;
    }

    public BigDecimal getSumma() {
        return summa;
    }

    public void setSumma(BigDecimal summa) {
        this.summa = summa;
    }

    public BigDecimal getSummaG() {
        return summaG;
    }

    public void setSummaG(BigDecimal summaG) {
        this.summaG = summaG;
    }

    public Boolean getBaze() {
        return baze;
    }

    public void setBaze(Boolean baze) {
        this.baze = baze;
    }

    public Date getDatums() {
        return datums;
    }

    public void setDatums(Date datums) {
        this.datums = datums;
    }

    public String getPelna() {
        return pelna;
    }

    public void setPelna(String pelna) {
        this.pelna = pelna;
    }

    public String getZaudejums() {
        return zaudejums;
    }

    public void setZaudejums(String zaudejums) {
        this.zaudejums = zaudejums;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public Date getADatums() {
        return aDatums;
    }

    public void setADatums(Date aDatums) {
        this.aDatums = aDatums;
    }

    public String getNozime() {
        return nozime;
    }

    public void setNozime(String nozime) {
        this.nozime = nozime;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (konts != null ? konts.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Konti)) {
            return false;
        }
        Konti other = (Konti) object;
        if ((this.konts == null && other.konts != null) || (this.konts != null && !this.konts.equals(other.konts))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Konti[ konts=" + konts + " ]";
    }
    
}
