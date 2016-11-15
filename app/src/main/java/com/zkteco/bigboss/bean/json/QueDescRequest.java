package com.zkteco.bigboss.bean.json;

/**
 * Created by jiang_ruicheng on 16/11/13.
 */
public class QueDescRequest {
    /**
     * agent : ZK_Boss
     * intfVer : 1.0.0
     * lang : zh-CN
     * platform : appbigboss
     * sys : zkboss
     * tz : +8:00
     * cmpId : 8a294c1356923967015696002a270005
     * sessionId : c0b19b1a9539689022b6e548846b7222
     * payload : {"params":{"cmpId":"8a294c1356923967015696002a270005","empId":"8aad387e56927587015696002b750013","indexId":"10010"},"datafmt":1}
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
     * params : {"cmpId":"8a294c1356923967015696002a270005","empId":"8aad387e56927587015696002b750013","indexId":"10010"}
     * datafmt : 1
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
         * cmpId : 8a294c1356923967015696002a270005
         * empId : 8aad387e56927587015696002b750013
         * indexId : 10010
         */

        private ParamsBean params = new ParamsBean();
        private int datafmt = 1;

        public ParamsBean getParams() {
            return params;
        }

        public void setParams(ParamsBean params) {
            this.params = params;
        }

        public int getDatafmt() {
            return datafmt;
        }

        public void setDatafmt(int datafmt) {
            this.datafmt = datafmt;
        }

        public static class ParamsBean {
            private String cmpId;
            private String empId;
            private String indexId = "10010";

            public String getCmpId() {
                return cmpId;
            }

            public void setCmpId(String cmpId) {
                this.cmpId = cmpId;
            }

            public String getEmpId() {
                return empId;
            }

            public void setEmpId(String empId) {
                this.empId = empId;
            }

            public String getIndexId() {
                return indexId;
            }

            public void setIndexId(String indexId) {
                this.indexId = indexId;
            }
        }
    }
}
