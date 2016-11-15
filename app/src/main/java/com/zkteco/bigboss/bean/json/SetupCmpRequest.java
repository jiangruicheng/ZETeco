package com.zkteco.bigboss.bean.json;

/**
 * Created by jiang_ruicheng on 16/11/3.
 */
public class SetupCmpRequest {

    /**
     * agent : ZK_Boss
     * intfVer : 1.0.0
     * lang : zh-CN
     * platform : appbigboss
     * sys : zkboss
     * tz : +8:00
     * payload : {"params":{"username":"15280306989","firstName":"Nick","password":"25d55ad283aa400af464c76d713c07ad","iscompany":true,"cmpName":"壹号掌柜","agree":true,"district":"440307","province":"440000","city":"440300","country":"100001","cmpAddress":"五和大道4010","industryId":"170007332"},"datafmt":1}
     */
    private String agent = "ZK_Boss";
    private String intfVer = "1.0.0";
    private String lang = "zh-CN";
    private String platform = "appbigboss";
    private String sys = "zkboss";
    private String tz = "+8:00";
    /**
     * params : {"username":"15280306989","firstName":"Nick","password":"25d55ad283aa400af464c76d713c07ad","iscompany":true,"cmpName":"壹号掌柜","agree":true,"district":"440307","province":"440000","city":"440300","country":"100001","cmpAddress":"五和大道4010","industryId":"170007332"}
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
         * username : 15280306989
         * firstName : Nick
         * password : 25d55ad283aa400af464c76d713c07ad
         * iscompany : true
         * cmpName : 壹号掌柜
         * agree : true
         * district : 440307
         * province : 440000
         * city : 440300
         * country : 100001
         * cmpAddress : 五和大道4010
         * industryId : 170007332
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
            private String firstName;
            private String password;
            private boolean iscompany;
            private String cmpName;
            private boolean agree;
            private String district;
            private String province;
            private String city;
            private String country = "100001";
            private String cmpAddress;
            private String industryId;

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getFirstName() {
                return firstName;
            }

            public void setFirstName(String firstName) {
                this.firstName = firstName;
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

            public String getCmpName() {
                return cmpName;
            }

            public void setCmpName(String cmpName) {
                this.cmpName = cmpName;
            }

            public boolean isAgree() {
                return agree;
            }

            public void setAgree(boolean agree) {
                this.agree = agree;
            }

            public String getDistrict() {
                return district;
            }

            public void setDistrict(String district) {
                this.district = district;
            }

            public String getProvince() {
                return province;
            }

            public void setProvince(String province) {
                this.province = province;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getCountry() {
                return country;
            }

            public void setCountry(String country) {
                this.country = country;
            }

            public String getCmpAddress() {
                return cmpAddress;
            }

            public void setCmpAddress(String cmpAddress) {
                this.cmpAddress = cmpAddress;
            }

            public String getIndustryId() {
                return industryId;
            }

            public void setIndustryId(String industryId) {
                this.industryId = industryId;
            }
        }
    }
}
