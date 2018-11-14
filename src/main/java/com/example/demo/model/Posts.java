/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alejandro
 */
@Entity
@Table(name = "posts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Posts.findAll", query = "SELECT p FROM Posts p")
    , @NamedQuery(name = "Posts.findByIdposts", query = "SELECT p FROM Posts p WHERE p.idposts = :idposts")
    , @NamedQuery(name = "Posts.findByTitle", query = "SELECT p FROM Posts p WHERE p.title = :title")
    , @NamedQuery(name = "Posts.findByDate", query = "SELECT p FROM Posts p WHERE p.date = :date")})
public class Posts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idposts")
    private Integer idposts;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 16777215)
    @Column(name = "body")
    private String body;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @JoinColumn(name = "user_iduser", referencedColumnName = "iduser")
    @ManyToOne(optional = false)
    @JsonBackReference
    private User userIduser;

    public Posts() {
    }

    public Posts(Integer idposts) {
        this.idposts = idposts;
    }

    public Posts(Integer idposts, String title, String body, Date date) {
        this.idposts = idposts;
        this.title = title;
        this.body = body;
        this.date = date;
    }

    public Integer getIdposts() {
        return idposts;
    }

    public void setIdposts(Integer idposts) {
        this.idposts = idposts;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUserIduser() {
        return userIduser;
    }

    public void setUserIduser(User userIduser) {
        this.userIduser = userIduser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idposts != null ? idposts.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Posts)) {
            return false;
        }
        Posts other = (Posts) object;
        if ((this.idposts == null && other.idposts != null) || (this.idposts != null && !this.idposts.equals(other.idposts))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject1.model.Posts[ idposts=" + idposts + " ]";
    }
    
}
