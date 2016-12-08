package com.zkteco.bigboss.bean.json;

/**
 * Created by jiang_ruicheng on 16/11/12.
 */
public class SignCardRequest {
    /**
     * agent : ZK_Boss
     * intfVer : 1.0.0
     * lang : zh-CN
     * platform : appbigboss
     * sys : zkboss
     * tz : +8:00
     * cmpId : ff808081565553ea01565867f2200003
     * sessionId : c0b19b1a9539689022b6e548846b7222
     * payload : {"params":{"cmpId":"ff808081565553ea01565867f2200003","approveManId":"ff80808156550c8a01565867f182001a","punchTime":1464710400000,"reason":"上班迟到","punchType":1,"empId":"ff80808156550c8a01565867f182001a"}}
     */

    private String agent = "ZK_Boss";
    private String intfVer = "1.0.0";
    private String lang = "zh-CN";
    private String platform = "appbigboss";
    private String sys = "zkboss";
    private String tz = "+8:00";
    private String cmpId;
    private String sessionId;
    /**
     * params : {"cmpId":"ff808081565553ea01565867f2200003","approveManId":"ff80808156550c8a01565867f182001a","punchTime":1464710400000,"reason":"上班迟到","punchType":1,"empId":"ff80808156550c8a01565867f182001a"}
     */

    private PayloadBean payload = new PayloadBean();

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public String getIntfVer() {
        return intfVer;
    }

    public void setIntfVer(String intfVer) {
        this.intfVer = intfVer;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getSys() {
        return sys;
    }

    public void setSys(String sys) {
        this.sys = sys;
    }

    public String getTz() {
        return tz;
    }

    public void setTz(String tz) {
        this.tz = tz;
    }

    public String getCmpId() {
        return cmpId;
    }

    public void setCmpId(String cmpId) {
        this.cmpId = cmpId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public PayloadBean getPayload() {
        return payload;
    }

    public void setPayload(PayloadBean payload) {
        this.payload = payload;
    }

    public static class PayloadBean {
        /**
         * cmpId : ff808081565553ea01565867f2200003
         * approveManId : ff80808156550c8a01565867f182001a
         * punchTime : 1464710400000
         * reason : 上班迟到
         * punchType : 1
         * empId : ff80808156550c8a01565867f182001a
         */

        private ParamsBean params = new ParamsBean();

        public ParamsBean getParams() {
            return params;
        }

        public void setParams(ParamsBean params) {
            this.params = params;
        }

        public static class ParamsBean {
            private String cmpId;
            private String approveManId;
            private long punchTime = -1;
            private String reason;
            private int punchType = -1;
            private String empId;

            public String getCmpId() {
                return cmpId;
            }

            public void setCmpId(String cmpId) {
                this.cmpId = cmpId;
            }

            public String getApproveManId() {
                return approveManId;
            }

            public void setApproveManId(String approveManId) {
                this.approveManId = approveManId;
            }

            public long getPunchTime() {
                return punchTime;
            }

            public void setPunchTime(long punchTime) {
                this.punchTime = punchTime;
            }

            public String getReason() {
                return reason;
            }

            public void setReason(String reason) {
                this.reason = reason;
            }

            public int getPunchType() {
                return punchType;
            }

            public void setPunchType(int punchType) {
                this.punchType = punchType;
            }

            public String getEmpId() {
                return empId;
            }

            public void setEmpId(String empId) {
                this.empId = empId;
            }
        }
    }
}

