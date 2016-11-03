package com.zkteco.bigboss.bean.json.bean;

/**
 * Created by jiang_ruicheng on 16/10/30.
 */
public class UserMesg {
    private String account;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    private String username;
    private String password;
    private String zkcloudID;
    private boolean iscompany;
    private String seisionID;
    private String cmpid;
    private boolean isIotAdmin;
    private boolean isAdmin;
    private String accountSessionId;

    private UserMesg() {
    }

    private static UserMesg userMesg;

    public static UserMesg getInstance() {
        if (userMesg == null) {
            userMesg = new UserMesg();
        }
        return userMesg;
    }

    public String getAccountSessionId() {
        return accountSessionId;
    }

    public void setAccountSessionId(String accountSessionId) {
        this.accountSessionId = accountSessionId;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public boolean isIotAdmin() {
        return isIotAdmin;
    }

    public void setIotAdmin(boolean iotAdmin) {
        isIotAdmin = iotAdmin;
    }

    public String getCmpid() {
        return cmpid;
    }

    public void setCmpid(String cmpid) {
        this.cmpid = cmpid;
    }

    public String getSeisionID() {
        return seisionID;
    }

    public void setSeisionID(String seisionID) {
        this.seisionID = seisionID;
    }

    public boolean iscompany() {
        return iscompany;
    }

    public void setIscompany(boolean iscompany) {
        this.iscompany = iscompany;
    }

    public String getZkcloudID() {
        return zkcloudID;
    }

    public void setZkcloudID(String zkcloudID) {
        this.zkcloudID = zkcloudID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
