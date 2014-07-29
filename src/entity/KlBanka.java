/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kaspars
 */
@Entity
@Table(name = "kl_banka")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KlBanka.findAll", query = "SELECT k FROM KlBanka k"),
    @NamedQuery(name = "KlBanka.findByIdent", query = "SELECT k FROM KlBanka k WHERE k.ident = :ident"),
    @NamedQuery(name = "KlBanka.findByNr", query = "SELECT k FROM KlBanka k WHERE k.nr = :nr"),
    @NamedQuery(name = "KlBanka.findByNosaukums", query = "SELECT k FROM KlBanka k WHERE k.nosaukums = :nosaukums"),
    @NamedQuery(name = "KlBanka.findByKods", query = "SELECT k FROM KlBanka k WHERE k.kods = :kods"),
    @NamedQuery(name = "KlBanka.findByAdrese", query = "SELECT k FROM KlBanka k WHERE k.adrese = :adrese"),
    @NamedQuery(name = "KlBanka.findByKonts1", query = "SELECT k FROM KlBanka k WHERE k.konts1 = :konts1"),
    @NamedQuery(name = "KlBanka.findByKonts2", query = "SELECT k FROM KlBanka k WHERE k.konts2 = :konts2"),
    @NamedQuery(name = "KlBanka.findByTelefons", query = "SELECT k FROM KlBanka k WHERE k.telefons = :telefons"),
    @NamedQuery(name = "KlBanka.findByBankaS", query = "SELECT k FROM KlBanka k WHERE k.bankaS = :bankaS"),
    @NamedQuery(name = "KlBanka.findByAdreseSb", query = "SELECT k FROM KlBanka k WHERE k.adreseSb = :adreseSb"),
    @NamedQuery(name = "KlBanka.findBySanemSb", query = "SELECT k FROM KlBanka k WHERE k.sanemSb = :sanemSb"),
    @NamedQuery(name = "KlBanka.findByKontsSb", query = "SELECT k FROM KlBanka k WHERE k.kontsSb = :kontsSb"),
    @NamedQuery(name = "KlBanka.findBySwift", query = "SELECT k FROM KlBanka k WHERE k.swift = :swift"),
    @NamedQuery(name = "KlBanka.findByAbaRout", query = "SELECT k FROM KlBanka k WHERE k.abaRout = :abaRout"),
    @NamedQuery(name = "KlBanka.findByChipsP", query = "SELECT k FROM KlBanka k WHERE k.chipsP = :chipsP"),
    @NamedQuery(name = "KlBanka.findByChipsU", query = "SELECT k FROM KlBanka k WHERE k.chipsU = :chipsU")})
public class KlBanka implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ident")
    private Long ident;
    @Column(name = "nr")
    private Integer nr;
    @Column(name = "nosaukums")
    private String nosaukums;
    @Column(name = "kods")
    private String kods;
    @Column(name = "adrese")
    private String adrese;
    @Column(name = "konts_1")
    private String konts1;
    @Column(name = "konts_2")
    private String konts2;
    @Column(name = "telefons")
    private String telefons;
    @Column(name = "banka_s")
    private String bankaS;
    @Column(name = "adrese_sb")
    private String adreseSb;
    @Column(name = "sanem_sb")
    private String sanemSb;
    @Column(name = "konts_sb")
    private String kontsSb;
    @Column(name = "swift")
    private String swift;
    @Column(name = "aba_rout")
    private String abaRout;
    @Column(name = "chips_p")
    private String chipsP;
    @Column(name = "chips_u")
    private String chipsU;

    public KlBanka() {
    }

    public KlBanka(Long ident) {
        this.ident = ident;
    }

    public Long getIdent() {
        return ident;
    }

    public void setIdent(Long ident) {
        this.ident = ident;
    }

    public Integer getNr() {
        return nr;
    }

    public void setNr(Integer nr) {
        this.nr = nr;
    }

    public String getNosaukums() {
        return nosaukums;
    }

    public void setNosaukums(String nosaukums) {
        this.nosaukums = nosaukums;
    }

    public String getKods() {
        return kods;
    }

    public void setKods(String kods) {
        this.kods = kods;
    }

    public String getAdrese() {
        return adrese;
    }

    public void setAdrese(String adrese) {
        this.adrese = adrese;
    }

    public String getKonts1() {
        return konts1;
    }

    public void setKonts1(String konts1) {
        this.konts1 = konts1;
    }

    public String getKonts2() {
        return konts2;
    }

    public void setKonts2(String konts2) {
        this.konts2 = konts2;
    }

    public String getTelefons() {
        return telefons;
    }

    public void setTelefons(String telefons) {
        this.telefons = telefons;
    }

    public String getBankaS() {
        return bankaS;
    }

    public void setBankaS(String bankaS) {
        this.bankaS = bankaS;
    }

    public String getAdreseSb() {
        return adreseSb;
    }

    public void setAdreseSb(String adreseSb) {
        this.adreseSb = adreseSb;
    }

    public String getSanemSb() {
        return sanemSb;
    }

    public void setSanemSb(String sanemSb) {
        this.sanemSb = sanemSb;
    }

    public String getKontsSb() {
        return kontsSb;
    }

    public void setKontsSb(String kontsSb) {
        this.kontsSb = kontsSb;
    }

    public String getSwift() {
        return swift;
    }

    public void setSwift(String swift) {
        this.swift = swift;
    }

    public String getAbaRout() {
        return abaRout;
    }

    public void setAbaRout(String abaRout) {
        this.abaRout = abaRout;
    }

    public String getChipsP() {
        return chipsP;
    }

    public void setChipsP(String chipsP) {
        this.chipsP = chipsP;
    }

    public String getChipsU() {
        return chipsU;
    }

    public void setChipsU(String chipsU) {
        this.chipsU = chipsU;
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
        if (!(object instanceof KlBanka)) {
            return false;
        }
        KlBanka other = (KlBanka) object;
        if ((this.ident == null && other.ident != null) || (this.ident != null && !this.ident.equals(other.ident))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.KlBanka[ ident=" + ident + " ]";
    }
    
}
