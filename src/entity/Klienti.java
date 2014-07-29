/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKey;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kaspars
 */
@Entity
@Table(name = "klienti")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Klienti.findAll", query = "SELECT k FROM Klienti k"),
    @NamedQuery(name = "Klienti.findByKlients", query = "SELECT k FROM Klienti k WHERE k.klients = :klients"),
    @NamedQuery(name = "Klienti.findByAdrese", query = "SELECT k FROM Klienti k WHERE k.adrese = :adrese"),
    @NamedQuery(name = "Klienti.findByIndekss", query = "SELECT k FROM Klienti k WHERE k.indekss = :indekss"),
    @NamedQuery(name = "Klienti.findByIdent", query = "SELECT k FROM Klienti k WHERE k.ident = :ident"),
    @NamedQuery(name = "Klienti.findByKods", query = "SELECT k FROM Klienti k WHERE k.kods = :kods"),
    @NamedQuery(name = "Klienti.findByNmKods", query = "SELECT k FROM Klienti k WHERE k.nmKods = :nmKods"),
    @NamedQuery(name = "Klienti.findByTelefons", query = "SELECT k FROM Klienti k WHERE k.telefons = :telefons"),
    @NamedQuery(name = "Klienti.findByFakss", query = "SELECT k FROM Klienti k WHERE k.fakss = :fakss"),
    @NamedQuery(name = "Klienti.findByVaditajs", query = "SELECT k FROM Klienti k WHERE k.vaditajs = :vaditajs"),
    @NamedQuery(name = "Klienti.findByEMail", query = "SELECT k FROM Klienti k WHERE k.eMail = :eMail"),
    @NamedQuery(name = "Klienti.findByEMailN", query = "SELECT k FROM Klienti k WHERE k.eMailN = :eMailN"),
    @NamedQuery(name = "Klienti.findByAttalums", query = "SELECT k FROM Klienti k WHERE k.attalums = :attalums"),
    @NamedQuery(name = "Klienti.findByAlgas", query = "SELECT k FROM Klienti k WHERE k.algas = :algas"),
    @NamedQuery(name = "Klienti.findByPilseta", query = "SELECT k FROM Klienti k WHERE k.pilseta = :pilseta"),
    @NamedQuery(name = "Klienti.findByPase", query = "SELECT k FROM Klienti k WHERE k.pase = :pase"),
    @NamedQuery(name = "Klienti.findByTips", query = "SELECT k FROM Klienti k WHERE k.tips = :tips"),
    @NamedQuery(name = "Klienti.findByValsts", query = "SELECT k FROM Klienti k WHERE k.valsts = :valsts"),
    @NamedQuery(name = "Klienti.findByPiegade", query = "SELECT k FROM Klienti k WHERE k.piegade = :piegade"),
    @NamedQuery(name = "Klienti.findByApmDienas", query = "SELECT k FROM Klienti k WHERE k.apmDienas = :apmDienas"),
    @NamedQuery(name = "Klienti.findBySodi", query = "SELECT k FROM Klienti k WHERE k.sodi = :sodi"),
    @NamedQuery(name = "Klienti.findBySektors", query = "SELECT k FROM Klienti k WHERE k.sektors = :sektors"),
    @NamedQuery(name = "Klienti.findByAgents", query = "SELECT k FROM Klienti k WHERE k.agents = :agents"),
    @NamedQuery(name = "Klienti.findByCena", query = "SELECT k FROM Klienti k WHERE k.cena = :cena"),
    @NamedQuery(name = "Klienti.findByTelefons1", query = "SELECT k FROM Klienti k WHERE k.telefons1 = :telefons1"),
    @NamedQuery(name = "Klienti.findByTelefons2", query = "SELECT k FROM Klienti k WHERE k.telefons2 = :telefons2"),
    @NamedQuery(name = "Klienti.findByPasut", query = "SELECT k FROM Klienti k WHERE k.pasut = :pasut"),
    @NamedQuery(name = "Klienti.findByPotPasut", query = "SELECT k FROM Klienti k WHERE k.potPasut = :potPasut"),
    @NamedQuery(name = "Klienti.findByPiegad", query = "SELECT k FROM Klienti k WHERE k.piegad = :piegad"),
    @NamedQuery(name = "Klienti.findByPotPiegad", query = "SELECT k FROM Klienti k WHERE k.potPiegad = :potPiegad"),
    @NamedQuery(name = "Klienti.findByDarbin", query = "SELECT k FROM Klienti k WHERE k.darbin = :darbin"),
    @NamedQuery(name = "Klienti.findByPiezimes", query = "SELECT k FROM Klienti k WHERE k.piezimes = :piezimes"),
    @NamedQuery(name = "Klienti.findByForeignK", query = "SELECT k FROM Klienti k WHERE k.foreignK = :foreignK"),
    @NamedQuery(name = "Klienti.findByVip", query = "SELECT k FROM Klienti k WHERE k.vip = :vip")})
public class Klienti implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "klients")
    private String klients;
    @Column(name = "adrese")
    private String adrese;
    @Column(name = "indekss")
    private String indekss;
    @Id
    @Basic(optional = false)
    @Column(name = "ident")
    private Long ident;
    @Column(name = "kods")
    private String kods;
    @Column(name = "nm_kods")
    private String nmKods;
    @Column(name = "telefons")
    private String telefons;
    @Column(name = "fakss")
    private String fakss;
    @Column(name = "vaditajs")
    private String vaditajs;
    @Column(name = "e_mail")
    private String eMail;
    @Column(name = "e_mail_n")
    private String eMailN;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "attalums")
    private BigDecimal attalums;
    @Column(name = "algas")
    private String algas;
    @Column(name = "pilseta")
    private String pilseta;
    @Column(name = "pase")
    private String pase;
    @Column(name = "tips")
    private String tips;
    @Column(name = "valsts")
    private String valsts;
    @Column(name = "piegade")
    private String piegade;
    @Column(name = "apm_dienas")
    private Long apmDienas;
    @Column(name = "sodi")
    private BigDecimal sodi;
    @Column(name = "sektors")
    private String sektors;
    @Column(name = "agents")
    private String agents;
    @Column(name = "cena")
    private String cena;
    @Column(name = "telefons1")
    private String telefons1;
    @Column(name = "telefons2")
    private String telefons2;
    @Column(name = "pasut")
    private Boolean pasut;
    @Column(name = "pot_pasut")
    private Boolean potPasut;
    @Column(name = "piegad")
    private Boolean piegad;
    @Column(name = "pot_piegad")
    private Boolean potPiegad;
    @Column(name = "darbin")
    private Boolean darbin;
    @Column(name = "piezimes")
    private String piezimes;
    @Column(name = "foreign_k")
    private String foreignK;
    @Column(name = "vip")
    private BigDecimal vip;

    private static int bankNr;
    //private static final long serialVersionUID = 1L;

    public int getBankNr() {
        return bankNr;
    }

    public void setBankNr(int bankNr) {
        this.bankNr = bankNr;
    }

    
    
    public Klienti() {
    }

    public Klienti(Long ident) {
        this.ident = ident;
    }

    public String getKlients() {
        return klients;
    }

    public void setKlients(String klients) {
        this.klients = klients;
    }

    public String getAdrese() {
        return adrese;
    }

    public void setAdrese(String adrese) {
        this.adrese = adrese;
    }

    public String getIndekss() {
        return indekss;
    }

    public void setIndekss(String indekss) {
        this.indekss = indekss;
    }

    public Long getIdent() {
        return ident;
    }

    public void setIdent(Long ident) {
        this.ident = ident;
    }

    public String getKods() {
        return kods;
    }

    public void setKods(String kods) {
        this.kods = kods;
    }

    public String getNmKods() {
        return nmKods;
    }

    public void setNmKods(String nmKods) {
        this.nmKods = nmKods;
    }

    public String getTelefons() {
        return telefons;
    }

    public void setTelefons(String telefons) {
        this.telefons = telefons;
    }

    public String getFakss() {
        return fakss;
    }

    public void setFakss(String fakss) {
        this.fakss = fakss;
    }

    public String getVaditajs() {
        return vaditajs;
    }

    public void setVaditajs(String vaditajs) {
        this.vaditajs = vaditajs;
    }

    public String getEMail() {
        return eMail;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    public String getEMailN() {
        return eMailN;
    }

    public void setEMailN(String eMailN) {
        this.eMailN = eMailN;
    }

    public BigDecimal getAttalums() {
        return attalums;
    }

    public void setAttalums(BigDecimal attalums) {
        this.attalums = attalums;
    }

    public String getAlgas() {
        return algas;
    }

    public void setAlgas(String algas) {
        this.algas = algas;
    }

    public String getPilseta() {
        return pilseta;
    }

    public void setPilseta(String pilseta) {
        this.pilseta = pilseta;
    }

    public String getPase() {
        return pase;
    }

    public void setPase(String pase) {
        this.pase = pase;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public String getValsts() {
        return valsts;
    }

    public void setValsts(String valsts) {
        this.valsts = valsts;
    }

    public String getPiegade() {
        return piegade;
    }

    public void setPiegade(String piegade) {
        this.piegade = piegade;
    }

    public Long getApmDienas() {
        return apmDienas;
    }

    public void setApmDienas(Long apmDienas) {
        this.apmDienas = apmDienas;
    }

    public BigDecimal getSodi() {
        return sodi;
    }

    public void setSodi(BigDecimal sodi) {
        this.sodi = sodi;
    }

    public String getSektors() {
        return sektors;
    }

    public void setSektors(String sektors) {
        this.sektors = sektors;
    }

    public String getAgents() {
        return agents;
    }

    public void setAgents(String agents) {
        this.agents = agents;
    }

    public String getCena() {
        return cena;
    }

    public void setCena(String cena) {
        this.cena = cena;
    }

    public String getTelefons1() {
        return telefons1;
    }

    public void setTelefons1(String telefons1) {
        this.telefons1 = telefons1;
    }

    public String getTelefons2() {
        return telefons2;
    }

    public void setTelefons2(String telefons2) {
        this.telefons2 = telefons2;
    }

    public Boolean getPasut() {
        return pasut;
    }

    public void setPasut(Boolean pasut) {
        this.pasut = pasut;
    }

    public Boolean getPotPasut() {
        return potPasut;
    }

    public void setPotPasut(Boolean potPasut) {
        this.potPasut = potPasut;
    }

    public Boolean getPiegad() {
        return piegad;
    }

    public void setPiegad(Boolean piegad) {
        this.piegad = piegad;
    }

    public Boolean getPotPiegad() {
        return potPiegad;
    }

    public void setPotPiegad(Boolean potPiegad) {
        this.potPiegad = potPiegad;
    }

    public Boolean getDarbin() {
        return darbin;
    }

    public void setDarbin(Boolean darbin) {
        this.darbin = darbin;
    }

    public String getPiezimes() {
        return piezimes;
    }

    public void setPiezimes(String piezimes) {
        this.piezimes = piezimes;
    }

    public String getForeignK() {
        return foreignK;
    }

    public void setForeignK(String foreignK) {
        this.foreignK = foreignK;
    }

    public BigDecimal getVip() {
        return vip;
    }

    public void setVip(BigDecimal vip) {
        this.vip = vip;
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
        if (!(object instanceof Klienti)) {
            return false;
        }
        Klienti other = (Klienti) object;
        if ((this.ident == null && other.ident != null) || (this.ident != null && !this.ident.equals(other.ident))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Klienti[ ident=" + ident + " ]";
    }
    
}
