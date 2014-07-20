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
@Table(name = "gramata")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gramata.findAll", query = "SELECT g FROM Gramata g"),
    @NamedQuery(name = "Gramata.findByAgents", query = "SELECT g FROM Gramata g WHERE g.agents = :agents"),
    @NamedQuery(name = "Gramata.findByNum", query = "SELECT g FROM Gramata g WHERE g.num = :num"),
    @NamedQuery(name = "Gramata.findByAvNum", query = "SELECT g FROM Gramata g WHERE g.avNum = :avNum"),
    @NamedQuery(name = "Gramata.findByIdent", query = "SELECT g FROM Gramata g WHERE g.ident = :ident"),
    @NamedQuery(name = "Gramata.findByMaksa", query = "SELECT g FROM Gramata g WHERE g.maksa = :maksa"),
    @NamedQuery(name = "Gramata.findByMkods", query = "SELECT g FROM Gramata g WHERE g.mkods = :mkods"),
    @NamedQuery(name = "Gramata.findBySanem", query = "SELECT g FROM Gramata g WHERE g.sanem = :sanem"),
    @NamedQuery(name = "Gramata.findBySkods", query = "SELECT g FROM Gramata g WHERE g.skods = :skods"),
    @NamedQuery(name = "Gramata.findBySumma", query = "SELECT g FROM Gramata g WHERE g.summa = :summa"),
    @NamedQuery(name = "Gramata.findBySummaV", query = "SELECT g FROM Gramata g WHERE g.summaV = :summaV"),
    @NamedQuery(name = "Gramata.findByValuta", query = "SELECT g FROM Gramata g WHERE g.valuta = :valuta"),
    @NamedQuery(name = "Gramata.findByDTips", query = "SELECT g FROM Gramata g WHERE g.dTips = :dTips"),
    @NamedQuery(name = "Gramata.findByOTips", query = "SELECT g FROM Gramata g WHERE g.oTips = :oTips"),
    @NamedQuery(name = "Gramata.findByDatums", query = "SELECT g FROM Gramata g WHERE g.datums = :datums"),
    @NamedQuery(name = "Gramata.findByKurss", query = "SELECT g FROM Gramata g WHERE g.kurss = :kurss"),
    @NamedQuery(name = "Gramata.findByPiezime", query = "SELECT g FROM Gramata g WHERE g.piezime = :piezime"),
    @NamedQuery(name = "Gramata.findByKontets", query = "SELECT g FROM Gramata g WHERE g.kontets = :kontets"),
    @NamedQuery(name = "Gramata.findBySident", query = "SELECT g FROM Gramata g WHERE g.sident = :sident"),
    @NamedQuery(name = "Gramata.findBySbident", query = "SELECT g FROM Gramata g WHERE g.sbident = :sbident"),
    @NamedQuery(name = "Gramata.findByMident", query = "SELECT g FROM Gramata g WHERE g.mident = :mident"),
    @NamedQuery(name = "Gramata.findByMbident", query = "SELECT g FROM Gramata g WHERE g.mbident = :mbident"),
    @NamedQuery(name = "Gramata.findBySDatums", query = "SELECT g FROM Gramata g WHERE g.sDatums = :sDatums"),
    @NamedQuery(name = "Gramata.findByADatums", query = "SELECT g FROM Gramata g WHERE g.aDatums = :aDatums"),
    @NamedQuery(name = "Gramata.findByOp", query = "SELECT g FROM Gramata g WHERE g.op = :op"),
    @NamedQuery(name = "Gramata.findByMaksas", query = "SELECT g FROM Gramata g WHERE g.maksas = :maksas"),
    @NamedQuery(name = "Gramata.findByMkodss", query = "SELECT g FROM Gramata g WHERE g.mkodss = :mkodss"),
    @NamedQuery(name = "Gramata.findBySanems", query = "SELECT g FROM Gramata g WHERE g.sanems = :sanems"),
    @NamedQuery(name = "Gramata.findBySkodss", query = "SELECT g FROM Gramata g WHERE g.skodss = :skodss"),
    @NamedQuery(name = "Gramata.findBySidents", query = "SELECT g FROM Gramata g WHERE g.sidents = :sidents"),
    @NamedQuery(name = "Gramata.findByMidents", query = "SELECT g FROM Gramata g WHERE g.midents = :midents"),
    @NamedQuery(name = "Gramata.findByStruktura", query = "SELECT g FROM Gramata g WHERE g.struktura = :struktura"),
    @NamedQuery(name = "Gramata.findByIevDat", query = "SELECT g FROM Gramata g WHERE g.ievDat = :ievDat"),
    @NamedQuery(name = "Gramata.findByIevOp", query = "SELECT g FROM Gramata g WHERE g.ievOp = :ievOp"),
    @NamedQuery(name = "Gramata.findByDokDat", query = "SELECT g FROM Gramata g WHERE g.dokDat = :dokDat"),
    @NamedQuery(name = "Gramata.findByApmVeids", query = "SELECT g FROM Gramata g WHERE g.apmVeids = :apmVeids"),
    @NamedQuery(name = "Gramata.findByStavoklis", query = "SELECT g FROM Gramata g WHERE g.stavoklis = :stavoklis"),
    @NamedQuery(name = "Gramata.findByApmDat", query = "SELECT g FROM Gramata g WHERE g.apmDat = :apmDat"),
    @NamedQuery(name = "Gramata.findByMerkis", query = "SELECT g FROM Gramata g WHERE g.merkis = :merkis"),
    @NamedQuery(name = "Gramata.findByAlgas", query = "SELECT g FROM Gramata g WHERE g.algas = :algas"),
    @NamedQuery(name = "Gramata.findByPamatoj", query = "SELECT g FROM Gramata g WHERE g.pamatoj = :pamatoj"),
    @NamedQuery(name = "Gramata.findByLigums", query = "SELECT g FROM Gramata g WHERE g.ligums = :ligums"),
    @NamedQuery(name = "Gramata.findByRekPvn", query = "SELECT g FROM Gramata g WHERE g.rekPvn = :rekPvn"),
    @NamedQuery(name = "Gramata.findByVidTips", query = "SELECT g FROM Gramata g WHERE g.vidTips = :vidTips"),
    @NamedQuery(name = "Gramata.findByPriority", query = "SELECT g FROM Gramata g WHERE g.priority = :priority"),
    @NamedQuery(name = "Gramata.findByCharges", query = "SELECT g FROM Gramata g WHERE g.charges = :charges"),
    @NamedQuery(name = "Gramata.findBySektors", query = "SELECT g FROM Gramata g WHERE g.sektors = :sektors"),
    @NamedQuery(name = "Gramata.findByDarVeids", query = "SELECT g FROM Gramata g WHERE g.darVeids = :darVeids"),
    @NamedQuery(name = "Gramata.findByLigPiez", query = "SELECT g FROM Gramata g WHERE g.ligPiez = :ligPiez"),
    @NamedQuery(name = "Gramata.findByTimeIns", query = "SELECT g FROM Gramata g WHERE g.timeIns = :timeIns")})
public class Gramata implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "agents")
    private String agents;
    @Column(name = "num")
    private String num;
    @Column(name = "av_num")
    private String avNum;
    @Id
    @Basic(optional = false)
    @Column(name = "ident")
    private Long ident;
    @Column(name = "maksa")
    private String maksa;
    @Column(name = "mkods")
    private String mkods;
    @Column(name = "sanem")
    private String sanem;
    @Column(name = "skods")
    private String skods;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "summa")
    private BigDecimal summa;
    @Column(name = "summa_v")
    private BigDecimal summaV;
    @Column(name = "valuta")
    private String valuta;
    @Column(name = "d_tips")
    private String dTips;
    @Column(name = "o_tips")
    private String oTips;
    @Column(name = "datums")
    @Temporal(TemporalType.DATE)
    private Date datums;
    @Column(name = "kurss")
    private BigDecimal kurss;
    @Column(name = "piezime")
    private String piezime;
    @Column(name = "kontets")
    private Boolean kontets;
    @Column(name = "sident")
    private Long sident;
    @Column(name = "sbident")
    private Integer sbident;
    @Column(name = "mident")
    private Long mident;
    @Column(name = "mbident")
    private Integer mbident;
    @Column(name = "s_datums")
    @Temporal(TemporalType.DATE)
    private Date sDatums;
    @Column(name = "a_datums")
    @Temporal(TemporalType.DATE)
    private Date aDatums;
    @Column(name = "op")
    private String op;
    @Column(name = "maksas")
    private String maksas;
    @Column(name = "mkodss")
    private String mkodss;
    @Column(name = "sanems")
    private String sanems;
    @Column(name = "skodss")
    private String skodss;
    @Column(name = "sidents")
    private Long sidents;
    @Column(name = "midents")
    private Long midents;
    @Column(name = "struktura")
    private String struktura;
    @Column(name = "iev_dat")
    @Temporal(TemporalType.DATE)
    private Date ievDat;
    @Column(name = "iev_op")
    private String ievOp;
    @Column(name = "dok_dat")
    @Temporal(TemporalType.DATE)
    private Date dokDat;
    @Column(name = "apm_veids")
    private String apmVeids;
    @Column(name = "stavoklis")
    private Short stavoklis;
    @Column(name = "apm_dat")
    @Temporal(TemporalType.DATE)
    private Date apmDat;
    @Column(name = "merkis")
    private String merkis;
    @Column(name = "algas")
    private String algas;
    @Column(name = "pamatoj")
    private String pamatoj;
    @Column(name = "ligums")
    private Long ligums;
    @Column(name = "rek_pvn")
    private String rekPvn;
    @Column(name = "vid_tips")
    private String vidTips;
    @Column(name = "priority")
    private String priority;
    @Column(name = "charges")
    private String charges;
    @Column(name = "sektors")
    private String sektors;
    @Column(name = "dar_veids")
    private String darVeids;
    @Column(name = "lig_piez")
    private String ligPiez;
    @Column(name = "time_ins")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeIns;

    public Gramata() {
    }

    public Gramata(Long ident) {
        this.ident = ident;
    }

    public String getAgents() {
        return agents;
    }

    public void setAgents(String agents) {
        this.agents = agents;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getAvNum() {
        return avNum;
    }

    public void setAvNum(String avNum) {
        this.avNum = avNum;
    }

    public Long getIdent() {
        return ident;
    }

    public void setIdent(Long ident) {
        this.ident = ident;
    }

    public String getMaksa() {
        return maksa;
    }

    public void setMaksa(String maksa) {
        this.maksa = maksa;
    }

    public String getMkods() {
        return mkods;
    }

    public void setMkods(String mkods) {
        this.mkods = mkods;
    }

    public String getSanem() {
        return sanem;
    }

    public void setSanem(String sanem) {
        this.sanem = sanem;
    }

    public String getSkods() {
        return skods;
    }

    public void setSkods(String skods) {
        this.skods = skods;
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

    public String getValuta() {
        return valuta;
    }

    public void setValuta(String valuta) {
        this.valuta = valuta;
    }

    public String getDTips() {
        return dTips;
    }

    public void setDTips(String dTips) {
        this.dTips = dTips;
    }

    public String getOTips() {
        return oTips;
    }

    public void setOTips(String oTips) {
        this.oTips = oTips;
    }

    public Date getDatums() {
        return datums;
    }

    public void setDatums(Date datums) {
        this.datums = datums;
    }

    public BigDecimal getKurss() {
        return kurss;
    }

    public void setKurss(BigDecimal kurss) {
        this.kurss = kurss;
    }

    public String getPiezime() {
        return piezime;
    }

    public void setPiezime(String piezime) {
        this.piezime = piezime;
    }

    public Boolean getKontets() {
        return kontets;
    }

    public void setKontets(Boolean kontets) {
        this.kontets = kontets;
    }

    public Long getSident() {
        return sident;
    }

    public void setSident(Long sident) {
        this.sident = sident;
    }

    public Integer getSbident() {
        return sbident;
    }

    public void setSbident(Integer sbident) {
        this.sbident = sbident;
    }

    public Long getMident() {
        return mident;
    }

    public void setMident(Long mident) {
        this.mident = mident;
    }

    public Integer getMbident() {
        return mbident;
    }

    public void setMbident(Integer mbident) {
        this.mbident = mbident;
    }

    public Date getSDatums() {
        return sDatums;
    }

    public void setSDatums(Date sDatums) {
        this.sDatums = sDatums;
    }

    public Date getADatums() {
        return aDatums;
    }

    public void setADatums(Date aDatums) {
        this.aDatums = aDatums;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public String getMaksas() {
        return maksas;
    }

    public void setMaksas(String maksas) {
        this.maksas = maksas;
    }

    public String getMkodss() {
        return mkodss;
    }

    public void setMkodss(String mkodss) {
        this.mkodss = mkodss;
    }

    public String getSanems() {
        return sanems;
    }

    public void setSanems(String sanems) {
        this.sanems = sanems;
    }

    public String getSkodss() {
        return skodss;
    }

    public void setSkodss(String skodss) {
        this.skodss = skodss;
    }

    public Long getSidents() {
        return sidents;
    }

    public void setSidents(Long sidents) {
        this.sidents = sidents;
    }

    public Long getMidents() {
        return midents;
    }

    public void setMidents(Long midents) {
        this.midents = midents;
    }

    public String getStruktura() {
        return struktura;
    }

    public void setStruktura(String struktura) {
        this.struktura = struktura;
    }

    public Date getIevDat() {
        return ievDat;
    }

    public void setIevDat(Date ievDat) {
        this.ievDat = ievDat;
    }

    public String getIevOp() {
        return ievOp;
    }

    public void setIevOp(String ievOp) {
        this.ievOp = ievOp;
    }

    public Date getDokDat() {
        return dokDat;
    }

    public void setDokDat(Date dokDat) {
        this.dokDat = dokDat;
    }

    public String getApmVeids() {
        return apmVeids;
    }

    public void setApmVeids(String apmVeids) {
        this.apmVeids = apmVeids;
    }

    public Short getStavoklis() {
        return stavoklis;
    }

    public void setStavoklis(Short stavoklis) {
        this.stavoklis = stavoklis;
    }

    public Date getApmDat() {
        return apmDat;
    }

    public void setApmDat(Date apmDat) {
        this.apmDat = apmDat;
    }

    public String getMerkis() {
        return merkis;
    }

    public void setMerkis(String merkis) {
        this.merkis = merkis;
    }

    public String getAlgas() {
        return algas;
    }

    public void setAlgas(String algas) {
        this.algas = algas;
    }

    public String getPamatoj() {
        return pamatoj;
    }

    public void setPamatoj(String pamatoj) {
        this.pamatoj = pamatoj;
    }

    public Long getLigums() {
        return ligums;
    }

    public void setLigums(Long ligums) {
        this.ligums = ligums;
    }

    public String getRekPvn() {
        return rekPvn;
    }

    public void setRekPvn(String rekPvn) {
        this.rekPvn = rekPvn;
    }

    public String getVidTips() {
        return vidTips;
    }

    public void setVidTips(String vidTips) {
        this.vidTips = vidTips;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getCharges() {
        return charges;
    }

    public void setCharges(String charges) {
        this.charges = charges;
    }

    public String getSektors() {
        return sektors;
    }

    public void setSektors(String sektors) {
        this.sektors = sektors;
    }

    public String getDarVeids() {
        return darVeids;
    }

    public void setDarVeids(String darVeids) {
        this.darVeids = darVeids;
    }

    public String getLigPiez() {
        return ligPiez;
    }

    public void setLigPiez(String ligPiez) {
        this.ligPiez = ligPiez;
    }

    public Date getTimeIns() {
        return timeIns;
    }

    public void setTimeIns(Date timeIns) {
        this.timeIns = timeIns;
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
        if (!(object instanceof Gramata)) {
            return false;
        }
        Gramata other = (Gramata) object;
        if ((this.ident == null && other.ident != null) || (this.ident != null && !this.ident.equals(other.ident))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Gramata[ ident=" + ident + " ]";
    }
    
}
