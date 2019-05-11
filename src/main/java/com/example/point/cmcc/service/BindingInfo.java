package com.example.point.cmcc.service;

import java.io.Serializable;
import java.util.Date;

/**
 * binding_info
 * @author 
 */
public class BindingInfo implements Serializable {
    private Integer id;

    private String userid;

    private String appid;

    private String outerUserid;

    private String mobileid;

    private String state;

    private String bindingtimes;

    private Date modtime;

    private Date intime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getOuterUserid() {
        return outerUserid;
    }

    public void setOuterUserid(String outerUserid) {
        this.outerUserid = outerUserid;
    }

    public String getMobileid() {
        return mobileid;
    }

    public void setMobileid(String mobileid) {
        this.mobileid = mobileid;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getBindingtimes() {
        return bindingtimes;
    }

    public void setBindingtimes(String bindingtimes) {
        this.bindingtimes = bindingtimes;
    }

    public Date getModtime() {
        return modtime;
    }

    public void setModtime(Date modtime) {
        this.modtime = modtime;
    }

    public Date getIntime() {
        return intime;
    }

    public void setIntime(Date intime) {
        this.intime = intime;
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
        BindingInfo other = (BindingInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getAppid() == null ? other.getAppid() == null : this.getAppid().equals(other.getAppid()))
            && (this.getOuterUserid() == null ? other.getOuterUserid() == null : this.getOuterUserid().equals(other.getOuterUserid()))
            && (this.getMobileid() == null ? other.getMobileid() == null : this.getMobileid().equals(other.getMobileid()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getBindingtimes() == null ? other.getBindingtimes() == null : this.getBindingtimes().equals(other.getBindingtimes()))
            && (this.getModtime() == null ? other.getModtime() == null : this.getModtime().equals(other.getModtime()))
            && (this.getIntime() == null ? other.getIntime() == null : this.getIntime().equals(other.getIntime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getAppid() == null) ? 0 : getAppid().hashCode());
        result = prime * result + ((getOuterUserid() == null) ? 0 : getOuterUserid().hashCode());
        result = prime * result + ((getMobileid() == null) ? 0 : getMobileid().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getBindingtimes() == null) ? 0 : getBindingtimes().hashCode());
        result = prime * result + ((getModtime() == null) ? 0 : getModtime().hashCode());
        result = prime * result + ((getIntime() == null) ? 0 : getIntime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userid=").append(userid);
        sb.append(", appid=").append(appid);
        sb.append(", outerUserid=").append(outerUserid);
        sb.append(", mobileid=").append(mobileid);
        sb.append(", state=").append(state);
        sb.append(", bindingtimes=").append(bindingtimes);
        sb.append(", modtime=").append(modtime);
        sb.append(", intime=").append(intime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}