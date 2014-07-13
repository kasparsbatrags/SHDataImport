/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
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
import javax.persistence.Transient;
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
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
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
        String oldFirma = this.firma;
        this.firma = firma;
        changeSupport.firePropertyChange("firma", oldFirma, firma);
    }

    public String getNosaukums() {
        return nosaukums;
    }

    public void setNosaukums(String nosaukums) {
        String oldNosaukums = this.nosaukums;
        this.nosaukums = nosaukums;
        changeSupport.firePropertyChange("nosaukums", oldNosaukums, nosaukums);
    }

    public String getLietotaji() {
        return lietotaji;
    }

    public void setLietotaji(String lietotaji) {
        String oldLietotaji = this.lietotaji;
        this.lietotaji = lietotaji;
        changeSupport.firePropertyChange("lietotaji", oldLietotaji, lietotaji);
    }

    public String getPamKat() {
        return pamKat;
    }

    public void setPamKat(String pamKat) {
        String oldPamKat = this.pamKat;
        this.pamKat = pamKat;
        changeSupport.firePropertyChange("pamKat", oldPamKat, pamKat);
    }

    public String getFormKat() {
        return formKat;
    }

    public void setFormKat(String formKat) {
        String oldFormKat = this.formKat;
        this.formKat = formKat;
        changeSupport.firePropertyChange("formKat", oldFormKat, formKat);
    }

    public String getDatKat() {
        return datKat;
    }

    public void setDatKat(String datKat) {
        String oldDatKat = this.datKat;
        this.datKat = datKat;
        changeSupport.firePropertyChange("datKat", oldDatKat, datKat);
    }

    public String getTmpKat() {
        return tmpKat;
    }

    public void setTmpKat(String tmpKat) {
        String oldTmpKat = this.tmpKat;
        this.tmpKat = tmpKat;
        changeSupport.firePropertyChange("tmpKat", oldTmpKat, tmpKat);
    }

    public String getSaitKat() {
        return saitKat;
    }

    public void setSaitKat(String saitKat) {
        String oldSaitKat = this.saitKat;
        this.saitKat = saitKat;
        changeSupport.firePropertyChange("saitKat", oldSaitKat, saitKat);
    }

    public String getAlgKat() {
        return algKat;
    }

    public void setAlgKat(String algKat) {
        String oldAlgKat = this.algKat;
        this.algKat = algKat;
        changeSupport.firePropertyChange("algKat", oldAlgKat, algKat);
    }

    public String getPamlKat() {
        return pamlKat;
    }

    public void setPamlKat(String pamlKat) {
        String oldPamlKat = this.pamlKat;
        this.pamlKat = pamlKat;
        changeSupport.firePropertyChange("pamlKat", oldPamlKat, pamlKat);
    }

    public String getNolKat() {
        return nolKat;
    }

    public void setNolKat(String nolKat) {
        String oldNolKat = this.nolKat;
        this.nolKat = nolKat;
        changeSupport.firePropertyChange("nolKat", oldNolKat, nolKat);
    }

    public String getStrKat() {
        return strKat;
    }

    public void setStrKat(String strKat) {
        String oldStrKat = this.strKat;
        this.strKat = strKat;
        changeSupport.firePropertyChange("strKat", oldStrKat, strKat);
    }

    public String getVad() {
        return vad;
    }

    public void setVad(String vad) {
        String oldVad = this.vad;
        this.vad = vad;
        changeSupport.firePropertyChange("vad", oldVad, vad);
    }

    public String getGram() {
        return gram;
    }

    public void setGram(String gram) {
        String oldGram = this.gram;
        this.gram = gram;
        changeSupport.firePropertyChange("gram", oldGram, gram);
    }

    public String getKas() {
        return kas;
    }

    public void setKas(String kas) {
        String oldKas = this.kas;
        this.kas = kas;
        changeSupport.firePropertyChange("kas", oldKas, kas);
    }

    public String getPaskaidroj() {
        return paskaidroj;
    }

    public void setPaskaidroj(String paskaidroj) {
        String oldPaskaidroj = this.paskaidroj;
        this.paskaidroj = paskaidroj;
        changeSupport.firePropertyChange("paskaidroj", oldPaskaidroj, paskaidroj);
    }

    public String getCwtemplate() {
        return cwtemplate;
    }

    public void setCwtemplate(String cwtemplate) {
        String oldCwtemplate = this.cwtemplate;
        this.cwtemplate = cwtemplate;
        changeSupport.firePropertyChange("cwtemplate", oldCwtemplate, cwtemplate);
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        String oldLogo = this.logo;
        this.logo = logo;
        changeSupport.firePropertyChange("logo", oldLogo, logo);
    }

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        String oldVid = this.vid;
        this.vid = vid;
        changeSupport.firePropertyChange("vid", oldVid, vid);
    }

    public String getSqlServer() {
        return sqlServer;
    }

    public void setSqlServer(String sqlServer) {
        String oldSqlServer = this.sqlServer;
        this.sqlServer = sqlServer;
        changeSupport.firePropertyChange("sqlServer", oldSqlServer, sqlServer);
    }

    public String getSqlDb() {
        return sqlDb;
    }

    public void setSqlDb(String sqlDb) {
        String oldSqlDb = this.sqlDb;
        this.sqlDb = sqlDb;
        changeSupport.firePropertyChange("sqlDb", oldSqlDb, sqlDb);
    }

    public Boolean getIsSql() {
        return isSql;
    }

    public void setIsSql(Boolean isSql) {
        Boolean oldIsSql = this.isSql;
        this.isSql = isSql;
        changeSupport.firePropertyChange("isSql", oldIsSql, isSql);
    }

    public Date getDatGatv() {
        return datGatv;
    }

    public void setDatGatv(Date datGatv) {
        Date oldDatGatv = this.datGatv;
        this.datGatv = datGatv;
        changeSupport.firePropertyChange("datGatv", oldDatGatv, datGatv);
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

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
