package com.easygo.vo.ejdb;

import java.util.Date;

public class TblDictionary {
    private Integer id;

    private String lookupkey;

    private String lookupvalue;

    private String describeinfo;

    private Date updatetime;

    private String backup;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLookupkey() {
        return lookupkey;
    }

    public void setLookupkey(String lookupkey) {
        this.lookupkey = lookupkey;
    }

    public String getLookupvalue() {
        return lookupvalue;
    }

    public void setLookupvalue(String lookupvalue) {
        this.lookupvalue = lookupvalue;
    }

    public String getDescribeinfo() {
        return describeinfo;
    }

    public void setDescribeinfo(String describeinfo) {
        this.describeinfo = describeinfo;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getBackup() {
        return backup;
    }

    public void setBackup(String backup) {
        this.backup = backup;
    }
}