package com.tjpu.zzk.model;

import java.io.Serializable;

/**
 * p
 * @author 
 */
public class P implements Serializable {
    private Integer PNO;

    private String PNAME;

    private String COLOR;

    private String WEIGHT;

    private static final long serialVersionUID = 1L;

    public Integer getPNO() {
        return PNO;
    }

    public void setPNO(Integer PNO) {
        this.PNO = PNO;
    }

    public String getPNAME() {
        return PNAME;
    }

    public void setPNAME(String PNAME) {
        this.PNAME = PNAME;
    }

    public String getCOLOR() {
        return COLOR;
    }

    public void setCOLOR(String COLOR) {
        this.COLOR = COLOR;
    }

    public String getWEIGHT() {
        return WEIGHT;
    }

    public void setWEIGHT(String WEIGHT) {
        this.WEIGHT = WEIGHT;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        P other = (P) that;
        return (this.getPNO() == null ? other.getPNO() == null : this.getPNO().equals(other.getPNO()))
            && (this.getPNAME() == null ? other.getPNAME() == null : this.getPNAME().equals(other.getPNAME()))
            && (this.getCOLOR() == null ? other.getCOLOR() == null : this.getCOLOR().equals(other.getCOLOR()))
            && (this.getWEIGHT() == null ? other.getWEIGHT() == null : this.getWEIGHT().equals(other.getWEIGHT()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPNO() == null) ? 0 : getPNO().hashCode());
        result = prime * result + ((getPNAME() == null) ? 0 : getPNAME().hashCode());
        result = prime * result + ((getCOLOR() == null) ? 0 : getCOLOR().hashCode());
        result = prime * result + ((getWEIGHT() == null) ? 0 : getWEIGHT().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", PNO=").append(PNO);
        sb.append(", PNAME=").append(PNAME);
        sb.append(", COLOR=").append(COLOR);
        sb.append(", WEIGHT=").append(WEIGHT);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}