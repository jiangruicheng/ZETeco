package com.zkteco.bigboss.bean.json;

/**
 * Created by jiang_ruicheng on 16/10/30.
 */
public class VerifyRequest {
    /**
     * agent : ZK_Boss
     * intfVer : 1.0.0
     * lang : zh-CN
     * platform : appbigboss
     * sys : zkboss
     * tz : +8:00
     * payload : {"params":{"username":"Green.liu@zkteco.com"},"datafmt":1}
     */
    private String agent = "ZK_Boss";
    private String intfVer = "1.0.0";
    private String lang = "zh-CN";
    private String platform = "appbigboss";
    private String sys = "zkboss";
    private String tz = "+8:00";

    /**
     * params : {"username":"Green.liu@zkteco.com"}
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

    public PayloadBean getPayload() {
        return payload;
    }

    public void setPayload(PayloadBean payload) {
        this.payload = payload;
    }

    public static class PayloadBean {
        /**
         * username : Green.liu@zkteco.com
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
            private String username;

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }
        }
    }
}
