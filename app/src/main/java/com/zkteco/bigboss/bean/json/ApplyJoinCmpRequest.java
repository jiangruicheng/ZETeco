package com.zkteco.bigboss.bean.json;

/**
 * Created by jiang_ruicheng on 16/11/2.
 */
public class ApplyJoinCmpRequest {

    /**
     * agent : ZK_Boss
     * intfVer : 1.0.0
     * lang : zh-CN
     * platform : appbigboss
     * sys : zkboss
     * tz : +8:00
     * payload : {"params":{"cmpId":"402809815809564a0158095e3f680001","cmpName":"ZKTeco壹号掌柜","username":"111.liu@zkteco.com","password":"25d55ad283aa400af464c76d713c07ad","iscompany":false,"agree":true,"firstName":"111"},"datafmt":1}
     */
    private String agent = "ZK_Boss";
    private String intfVer = "1.0.0";
    private String lang = "zh-CN";
    private String platform = "appbigboss";
    private String sys = "zkboss";
    private String tz = "+8:00";
    /**
     * params : {"cmpId":"402809815809564a0158095e3f680001","cmpName":"ZKTeco壹号掌柜","username":"111.liu@zkteco.com","password":"25d55ad283aa400af464c76d713c07ad","iscompany":false,"agree":true,"firstName":"111"}
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
         * cmpId : 402809815809564a0158095e3f680001
         * cmpName : ZKTeco壹号掌柜
         * username : 111.liu@zkteco.com
         * password : 25d55ad283aa400af464c76d713c07ad
         * iscompany : false
         * agree : true
         * firstName : 111
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
            private String cmpName;
            private String username;
            private String password;
            private boolean iscompany;
            private boolean agree;
            private String firstName;

            public String getCmpId() {
                return cmpId;
            }

            public void setCmpId(String cmpId) {
                this.cmpId = cmpId;
            }

            public String getCmpName() {
                return cmpName;
            }

            public void setCmpName(String cmpName) {
                this.cmpName = cmpName;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
            }

            public boolean isIscompany() {
                return iscompany;
            }

            public void setIscompany(boolean iscompany) {
                this.iscompany = iscompany;
            }

            public boolean isAgree() {
                return agree;
            }

            public void setAgree(boolean agree) {
                this.agree = agree;
            }

            public String getFirstName() {
                return firstName;
            }

            public void setFirstName(String firstName) {
                this.firstName = firstName;
            }
        }
    }
}
