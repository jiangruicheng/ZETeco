package com.zkteco.bigboss.bean;

/**
 * Created by jiang_ruicheng on 16/10/27.
 */
public class TimeTag {
    /**
     * agent : ZK_Boss
     * intfVer : 1.0.0
     * lang : zh-CN
     * platform : appbigboss
     * sys : zkboss
     * tz : +8:00
     * cmpId : 8a294c1356923967015696002a270005
     * sessionId : 0621527dbb36b02a81dfddaf341fa3ca
     * payload : {"params":{"cmpId":"8a294c1356923967015696002a270005","empId":"8aad387e56927587015696002b750013","startTime":1474905600000,"endTime":1474905600000}}
     */

    private String agent;
    private String intfVer;
    private String lang;
    private String platform;
    private String sys;
    private String tz;
    private String cmpId;
    /**
     * params : {"cmpId":"8a294c1356923967015696002a270005","empId":"8aad387e56927587015696002b750013","startTime":1474905600000,"endTime":1474905600000}
     */

    private PayloadBean payload;

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
         * startTime : 1474905600000
         * endTime : 1474905600000
         */

        private ParamsBean params;

        public ParamsBean getParams() {
            return params;
        }

        public void setParams(ParamsBean params) {
            this.params = params;
        }

        public static class ParamsBean {
            private String cmpId;
            private String empId;
            private long startTime;
            private long endTime;

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

            public long getStartTime() {
                return startTime;
            }

            public void setStartTime(long startTime) {
                this.startTime = startTime;
            }

            public long getEndTime() {
                return endTime;
            }

            public void setEndTime(long endTime) {
                this.endTime = endTime;
            }
        }
    }
}
