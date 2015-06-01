/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.ed.proyecto;

import java.io.Serializable;
import org.bson.types.ObjectId;

/**
 *
 * @author shaheer
 */
public class Team implements Serializable {

    private ObjectId id;
    private String nm;
    private String pj;
    private String pg;
    private String pe;
    private String pp;
    private String gf;
    private String gc;
    private String puntos;

    public Team() {

    }

    public Team(ObjectId id, String nm, String pj, String pg, String pe, String pp, String gf, String gc, String puntos) {
        this.id = id;
        this.nm = nm;
        this.pj = pj;
        this.pg = pg;
        this.pe = pe;
        this.pp = pp;
        this.gf = gf;
        this.gc = gc;
        this.puntos = puntos;
    }

    public Team(String nm, String pj, String pg, String pe, String pp, String gf, String gc, String puntos) {
        this.nm = nm;
        this.pj = pj;
        this.pg = pg;
        this.pe = pe;
        this.pp = pp;
        this.gf = gf;
        this.gc = gc;
        this.puntos = puntos;
    }

    public String getNombre() {
        return nm;
    }

    public void setNombre(String nm) {
        this.nm = nm;
    }

    public String getPj() {
        return pj;
    }

    public void setPj(String pj) {
        this.pj = pj;
    }

    public String getPg() {
        return pg;
    }

    public void setPg(String pg) {
        this.pg = pg;
    }

    public String getPe() {
        return pe;
    }

    public void setPe(String pe) {
        this.pe = pe;
    }

    public String getPp() {
        return pp;
    }

    public void setPp(String pp) {
        this.pp = pp;
    }

    public String getGf() {
        return gf;
    }

    public void setGf(String gf) {
        this.gf = gf;
    }

    public String getGc() {
        return gc;
    }

    public void setGc(String gc) {
        this.gc = gc;
    }

    public String getPuntos() {
        return puntos;
    }

    public void setPuntos(String puntos) {
        this.puntos = puntos;
    }

    public Object getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

}
