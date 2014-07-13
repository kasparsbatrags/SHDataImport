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
@Table(name = "useri")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Useri.findAll", query = "SELECT u FROM Useri u"),
    @NamedQuery(name = "Useri.findByVards", query = "SELECT u FROM Useri u WHERE u.vards = :vards"),
    @NamedQuery(name = "Useri.findByUzvards", query = "SELECT u FROM Useri u WHERE u.uzvards = :uzvards"),
    @NamedQuery(name = "Useri.findByPerskods", query = "SELECT u FROM Useri u WHERE u.perskods = :perskods"),
    @NamedQuery(name = "Useri.findByOp", query = "SELECT u FROM Useri u WHERE u.op = :op"),
    @NamedQuery(name = "Useri.findByPasswd", query = "SELECT u FROM Useri u WHERE u.passwd = :passwd"),
    @NamedQuery(name = "Useri.findByPieeja", query = "SELECT u FROM Useri u WHERE u.pieeja = :pieeja"),
    @NamedQuery(name = "Useri.findByEkonomists", query = "SELECT u FROM Useri u WHERE u.ekonomists = :ekonomists"),
    @NamedQuery(name = "Useri.findByLigumi", query = "SELECT u FROM Useri u WHERE u.ligumi = :ligumi"),
    @NamedQuery(name = "Useri.findByPaligs", query = "SELECT u FROM Useri u WHERE u.paligs = :paligs"),
    @NamedQuery(name = "Useri.findByAlga", query = "SELECT u FROM Useri u WHERE u.alga = :alga"),
    @NamedQuery(name = "Useri.findByPerson", query = "SELECT u FROM Useri u WHERE u.person = :person"),
    @NamedQuery(name = "Useri.findByLietv", query = "SELECT u FROM Useri u WHERE u.lietv = :lietv"),
    @NamedQuery(name = "Useri.findByPamatl", query = "SELECT u FROM Useri u WHERE u.pamatl = :pamatl"),
    @NamedQuery(name = "Useri.findByGalvenais", query = "SELECT u FROM Useri u WHERE u.galvenais = :galvenais"),
    @NamedQuery(name = "Useri.findByUserId", query = "SELECT u FROM Useri u WHERE u.userId = :userId")})
public class Useri implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "vards")
    private String vards;
    @Column(name = "uzvards")
    private String uzvards;
    @Column(name = "perskods")
    private String perskods;
    @Id
    @Basic(optional = false)
    @Column(name = "op")
    private String op;
    @Column(name = "passwd")
    private String passwd;
    @Column(name = "pieeja")
    private Boolean pieeja;
    @Column(name = "ekonomists")
    private Boolean ekonomists;
    @Column(name = "ligumi")
    private Boolean ligumi;
    @Column(name = "paligs")
    private Boolean paligs;
    @Column(name = "alga")
    private Boolean alga;
    @Column(name = "person")
    private Boolean person;
    @Column(name = "lietv")
    private Boolean lietv;
    @Column(name = "pamatl")
    private Boolean pamatl;
    @Column(name = "galvenais")
    private Boolean galvenais;
    @Column(name = "user_id")
    private Short userId;

    public Useri() {
    }

    public Useri(String op) {
        this.op = op;
    }

    public String getVards() {
        return vards;
    }

    public void setVards(String vards) {
        this.vards = vards;
    }

    public String getUzvards() {
        return uzvards;
    }

    public void setUzvards(String uzvards) {
        this.uzvards = uzvards;
    }

    public String getPerskods() {
        return perskods;
    }

    public void setPerskods(String perskods) {
        this.perskods = perskods;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public Boolean getPieeja() {
        return pieeja;
    }

    public void setPieeja(Boolean pieeja) {
        this.pieeja = pieeja;
    }

    public Boolean getEkonomists() {
        return ekonomists;
    }

    public void setEkonomists(Boolean ekonomists) {
        this.ekonomists = ekonomists;
    }

    public Boolean getLigumi() {
        return ligumi;
    }

    public void setLigumi(Boolean ligumi) {
        this.ligumi = ligumi;
    }

    public Boolean getPaligs() {
        return paligs;
    }

    public void setPaligs(Boolean paligs) {
        this.paligs = paligs;
    }

    public Boolean getAlga() {
        return alga;
    }

    public void setAlga(Boolean alga) {
        this.alga = alga;
    }

    public Boolean getPerson() {
        return person;
    }

    public void setPerson(Boolean person) {
        this.person = person;
    }

    public Boolean getLietv() {
        return lietv;
    }

    public void setLietv(Boolean lietv) {
        this.lietv = lietv;
    }

    public Boolean getPamatl() {
        return pamatl;
    }

    public void setPamatl(Boolean pamatl) {
        this.pamatl = pamatl;
    }

    public Boolean getGalvenais() {
        return galvenais;
    }

    public void setGalvenais(Boolean galvenais) {
        this.galvenais = galvenais;
    }

    public Short getUserId() {
        return userId;
    }

    public void setUserId(Short userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (op != null ? op.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Useri)) {
            return false;
        }
        Useri other = (Useri) object;
        if ((this.op == null && other.op != null) || (this.op != null && !this.op.equals(other.op))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Useri[ op=" + op + " ]";
    }
    
}
