/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Kaspars
 */
@Entity
@Table(name = "gramata", schema = "Public" )
@SequenceGenerator( name = "appUsersSeq", sequenceName = "gramata_ident_seq", allocationSize = 1, initialValue = 1 )
public class Gramata implements Serializable {
    @Column(name = "agents")
    private String agents;
    @Column(name = "num")
    private String num;
    @Column(name = "av_num")
    private String avNum;
    private static final long serialVersionUID = 1L;
    @Id @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "appUsersSeq" )
    @Column(name = "ident",unique = true, nullable = false)
    private Long ident;

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
}
