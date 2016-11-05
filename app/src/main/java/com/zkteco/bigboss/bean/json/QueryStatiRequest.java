package com.zkteco.bigboss.bean.json;

import java.util.Calendar;

/**
 * Created by jiang_ruicheng on 16/11/3.
 */
public class QueryStatiRequest {

    /**
     * agent : ZK
     * intfVer : 1.0.0
     * lang : zh_CN
     * platform : timecube
     * sys : timecube
     * tz : +8:00
     * cmpId : 8a294c1356923967015696002a270005
     * sessionId : d091b86fe81167912bf7299f2944c4aa
     * payload : {"params":{"cmpId":"8a294c1356923967015696002a270005","yearMonth":201609,"empId":"8aad387e56927587015696002b750013"}}
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
     * params : {"cmpId":"8a294c1356923967015696002a270005","yearMonth":201609,"empId":"8aad387e56927587015696002b750013"}
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
         * yearMonth : 201609
         * empId : 8aad387e56927587015696002b750013
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
            private int yearMonth = Calendar.getInstance().get(Calendar.YEAR) * 100 + Calendar.getInstance().get(Calendar.MONTH);
            private String empId;

            public String getCmpId() {
                return cmpId;
            }

            public void setCmpId(String cmpId) {
                this.cmpId = cmpId;
            }

            public int getYearMonth() {
                return yearMonth;
            }

            public void setYearMonth(int yearMonth) {
                this.yearMonth = yearMonth;
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
