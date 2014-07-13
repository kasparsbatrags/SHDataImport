/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
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
@Table(name = "firmas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Firmas.findAll", query = "SELECT f FROM Firmas f"),
    @NamedQuery(name = "Firmas.findByFirma", query = "SELECT f FROM Firmas f WHERE f.firma = :firma"),
    @NamedQuery(name = "Firmas.findByNosaukums", query = "SELECT f FROM Firmas f WHERE f.nosaukums = :nosaukums"),
    @NamedQuery(name = "Firmas.findByLietotaji", query = "SELECT f FROM Firmas f WHERE f.lietotaji = :lietotaji"),
    @NamedQuery(name = "Firmas.findByPamKat", query = "SELECT f FROM Firmas f WHERE f.pamKat = :pamKat"),
    @NamedQuery(name = "Firmas.findByFormKat", query = "SELECT f FROM Firmas f WHERE f.formKat = :formKat"),
    @NamedQuery(name = "Firmas.findByDatKat", query = "SELECT f FROM Firmas f WHERE f.datKat = :datKat"),
    @NamedQuery(name = "Firmas.findByTmpKat", query = "SELECT f FROM Firmas f WHERE f.tmpKat = :tmpKat"),
    @NamedQuery(name = "Firmas.findBySaitKat", query = "SELECT f FROM Firmas f WHERE f.saitKat = :saitKat"),
    @NamedQuery(name = "Firmas.findByAlgKat", query = "SELECT f FROM Firmas f WHERE f.algKat = :algKat"),
    @NamedQuery(name = "Firmas.findByPamlKat", query = "SELECT f FROM Firmas f WHERE f.pamlKat = :pamlKat"),
    @NamedQuery(name = "Firmas.findByNolKat", query = "SELECT f FROM Firmas f WHERE f.nolKat = :nolKat"),
    @NamedQuery(name = "Firmas.findByStrKat", query = "SELECT f FROM Firmas f WHERE f.strKat = :strKat"),
    @NamedQuery(name = "Firmas.findByVad", query = "SELECT f FROM Firmas f WHERE f.vad = :vad"),
    @NamedQuery(name = "Firmas.findByGram", query = "SELECT f FROM Firmas f WHERE f.gram = :gram"),
    @NamedQuery(name = "Firmas.findByKas", query = "SELECT f FROM Firmas f WHERE f.kas = :kas"),
    @NamedQuery(name = "Firmas.findByPaskaidroj", query = "SELECT f FROM Firmas f WHERE f.paskaidroj = :paskaidroj"),
    @NamedQuery(name = "Firmas.findByCwtemplate", query = "SELECT f FROM Firmas f WHERE f.cwtemplate = :cwtemplate"),
    @NamedQuery(name = "Firmas.findByLogo", query = "SELECT f FROM Firmas f WHERE f.logo = :logo"),
    @NamedQuery(name = "Firmas.findByVid", query = "SELECT f FROM Firmas f WHERE f.vid = :vid"),
    @NamedQuery(name = "Firmas.findBySqlServer", query = "SELECT f FROM Firmas f WHERE f.sqlServer = :sqlServer"),
    @NamedQuery(name = "Firmas.findBySqlDb", query = "SELECT f FROM Firmas f WHERE f.sqlDb = :sqlDb"),
    @NamedQuery(name = "Firmas.findByIsSql", query = "SELECT f FROM Firmas f WHERE f.isSql = :isSql"),
    @NamedQuery(name = "Firmas.findByDatGatv", query = "SELECT f FROM Firmas f WHERE f.datGatv = :datGatv")})
public class Firmas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "firma")
    private String firma;
    @Basic(optional = false)
    @Column(name = "nosaukums")
    private String nosaukums;
    @Basic(optional = false)
    @Column(name = "lietotaji")
    private String lietotaji;
    @Basic(optional = false)
    @Column(name = "pam_kat")
    private String pamKat;
    @Basic(optional = false)
    @Column(name = "form_kat")
    private String formKat;
    @Basic(optional = false)
    @Column(name = "dat_kat")
    private String datKat;
    @Basic(optional = false)
    @Column(name = "tmp_kat")
    private String tmpKat;
    @Basic(optional = false)
    @Column(name = "sait_kat")
    private String saitKat;
    @Basic(optional = false)
    @Column(name = "alg_kat")
    private String algKat;
    @Basic(optional = false)
    @Column(name = "paml_kat")
    private String pamlKat;
    @Basic(optional = false)
    @Column(name = "nol_kat")
    private String nolKat;
    @Basic(optional = false)
    @Column(name = "str_kat")
    private String strKat;
    @Basic(optional = false)
    @Column(name = "vad")
    private String vad;
    @Basic(optional = false)
    @Column(name = "gram")
    private String gram;
    @Basic(optional = false)
    @Column(name = "kas")
    private String kas;
    @Basic(optional = false)
    @Column(name = "paskaidroj")
    private String paskaidroj;
    @Basic(optional = false)
    @Column(name = "cwtemplate")
    private String cwtemplate;
    @Basic(optional = false)
    @Column(name = "logo")
    private String logo;
    @Basic(optional = false)
    @Column(name = "vid")
    private String vid;
    @Basic(optional = false)
    @Column(name = "sql_server")
    private String sqlServer;
    @Basic(optional = false)
    @Column(name = "sql_db")
    private String sqlDb;
    @Column(name = "is_sql")
    private Boolean isSql;
    @Column(name = "dat_gatv")
    @Temporal(TemporalType.DATE)
    private Date datGatv;

    public Firmas() {
    }

    public Firmas(String firma) {
        this.firma = firma;
    }

    public Firmas(String firma, String nosaukums, String lietotaji, String pamKat, String formKat, String datKat, String tmpKat, String saitKat, String algKat, String pamlKat, String nolKat, String strKat, String vad, String gram, String kas, String paskaidroj, String cwtemplate, String logo, String vid, String sqlServer, String sqlDb) {
        this.firma = firma;
        this.nosaukums = nosaukums;
        this.lietotaji = lietotaji;
        this.pamKat = pamKat;
        this.formKat = formKat;
        this.datKat = datKat;
        this.tmpKat = tmpKat;
        this.saitKat = saitKat;
        this.algKat = algKat;
        this.pamlKat = pamlKat;
        this.nolKat = nolKat;
        this.strKat = strKat;
        this.vad = vad;
        this.gram = gram;
        this.kas = kas;
        this.paskaidroj = paskaidroj;
        this.cwtemplate = cwtemplate;
        this.logo = logo;
        this.vid = vid;
        this.sqlServer = sqlServer;
        this.sqlDb = sqlDb;
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    public String getNosaukums() {
        return nosaukums;
    }

    public void setNosaukums(String nosaukums) {
        this.nosaukums = nosaukums;
    }

    public String getLietotaji() {
        return lietotaji;
    }

    public void setLietotaji(String lietotaji) {
        this.lietotaji = lietotaji;
    }

    public String getPamKat() {
        return pamKat;
    }

    public void setPamKat(String pamKat) {
        this.pamKat = pamKat;
    }

    public String getFormKat() {
        return formKat;
    }

    public void setFormKat(String formKat) {
        this.formKat = formKat;
    }

    public String getDatKat() {
        return datKat;
    }

    public void setDatKat(String datKat) {
        this.datKat = datKat;
    }

    public String getTmpKat() {
        return tmpKat;
    }

    public void setTmpKat(String tmpKat) {
        this.tmpKat = tmpKat;
    }

    public String getSaitKat() {
        return saitKat;
    }

    public void setSaitKat(String saitKat) {
        this.saitKat = saitKat;
    }

    public String getAlgKat() {
        return algKat;
    }

    public void setAlgKat(String algKat) {
        this.algKat = algKat;
    }

    public String getPamlKat() {
        return pamlKat;
    }

    public void setPamlKat(String pamlKat) {
        this.pamlKat = pamlKat;
    }

    public String getNolKat() {
        return nolKat;
    }

    public void setNolKat(String nolKat) {
        this.nolKat = nolKat;
    }

    public String getStrKat() {
        return strKat;
    }

    public void setStrKat(String strKat) {
        this.strKat = strKat;
    }

    public String getVad() {
        return vad;
    }

    public void setVad(String vad) {
        this.vad = vad;
    }

    public String getGram() {
        return gram;
    }

    public void setGram(String gram) {
        this.gram = gram;
    }

    public String getKas() {
        return kas;
    }

    public void setKas(String kas) {
        this.kas = kas;
    }

    public String getPaskaidroj() {
        return paskaidroj;
    }

    public void setPaskaidroj(String paskaidroj) {
        this.paskaidroj = paskaidroj;
    }

    public String getCwtemplate() {
        return cwtemplate;
    }

    public void setCwtemplate(String cwtemplate) {
        this.cwtemplate = cwtemplate;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public String getSqlServer() {
        return sqlServer;
    }

    public void setSqlServer(String sqlServer) {
        this.sqlServer = sqlServer;
    }

    public String getSqlDb() {
        return sqlDb;
    }

    public void setSqlDb(String sqlDb) {
        this.sqlDb = sqlDb;
    }

    public Boolean getIsSql() {
        return isSql;
    }

    public void setIsSql(Boolean isSql) {
        this.isSql = isSql;
    }

    public Date getDatGatv() {
        return datGatv;
    }

    public void setDatGatv(Date datGatv) {
        this.datGatv = datGatv;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (firma != null ? firma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Firmas)) {
            return false;
        }
        Firmas other = (Firmas) object;
        if ((this.firma == null && other.firma != null) || (this.firma != null && !this.firma.equals(other.firma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Firmas[ firma=" + firma + " ]";
    }
    
}
