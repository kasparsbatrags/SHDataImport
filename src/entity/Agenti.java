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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Agenti.findAll", query = "SELECT a FROM Agenti a"),
    @NamedQuery(name = "Agenti.findById", query = "SELECT a FROM Agenti a WHERE a.id = :id"),
    @NamedQuery(name = "Agenti.findByAgents", query = "SELECT a FROM Agenti a WHERE a.agents = :agents"),
    @NamedQuery(name = "Agenti.findBySharesNos", query = "SELECT a FROM Agenti a WHERE a.sharesNos = :sharesNos"),
    @NamedQuery(name = "Agenti.findByTeksts", query = "SELECT a FROM Agenti a WHERE a.teksts = :teksts")})
public class Agenti implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Column(length = 30)
    private String agents;
    @Column(name = "shares_nos", length = 50)
    private String sharesNos;
    @Column(length = 30)
    private String teksts;

    public Agenti() {
    }

    public Agenti(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAgents() {
        return agents;
    }

    public void setAgents(String agents) {
        this.agents = agents;
    }

    public String getSharesNos() {
        return sharesNos;
    }

    public void setSharesNos(String sharesNos) {
        this.sharesNos = sharesNos;
    }

    public String getTeksts() {
        return teksts;
    }

    public void setTeksts(String teksts) {
        this.teksts = teksts;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Agenti)) {
            return false;
        }
        Agenti other = (Agenti) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Agenti[ id=" + id + " ]";
    }
    
}
