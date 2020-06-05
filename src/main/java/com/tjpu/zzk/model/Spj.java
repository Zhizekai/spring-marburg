package com.tjpu.zzk.model;

import java.io.Serializable;
import java.util.List;

/**
 *
 * 实体类，定义SPJ实体
 * SPJ
 * @author  用户
 */
public class Spj implements Serializable {
    private Integer qty;

    private Integer jno;

    private Integer pno;


    private Integer sno;

    //一对多关系映射
    private List<SVO> SVOS;

    public List<SVO> getSVOS() {
        return SVOS;
    }

    public void setSVOS(List<SVO> SVOS) {
        this.SVOS = SVOS;
    }


    private static final long serialVersionUID = 1L;

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Integer getJno() {
        return jno;
    }

    public void setJno(Integer jno) {
        this.jno = jno;
    }

    public Integer getPno() {
        return pno;
    }

    public void setPno(Integer pno) {
        this.pno = pno;
    }

    public Integer getSno() {
        return sno;
    }

    public void setSno(Integer sno) {
        this.sno = sno;
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
        Spj other = (Spj) that;
        return (this.getQty() == null ? other.getQty() == null : this.getQty().equals(other.getQty()))
            && (this.getJno() == null ? other.getJno() == null : this.getJno().equals(other.getJno()))
            && (this.getPno() == null ? other.getPno() == null : this.getPno().equals(other.getPno()))
            && (this.getSno() == null ? other.getSno() == null : this.getSno().equals(other.getSno()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getQty() == null) ? 0 : getQty().hashCode());
        result = prime * result + ((getJno() == null) ? 0 : getJno().hashCode());
        result = prime * result + ((getPno() == null) ? 0 : getPno().hashCode());
        result = prime * result + ((getSno() == null) ? 0 : getSno().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", qty=").append(qty);
        sb.append(", jno=").append(jno);
        sb.append(", pno=").append(pno);
        sb.append(", sno=").append(sno);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}