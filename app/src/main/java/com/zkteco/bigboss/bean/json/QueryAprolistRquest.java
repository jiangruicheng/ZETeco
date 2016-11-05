package com.zkteco.bigboss.bean.json;

/**
 * Created by jiang_ruicheng on 16/11/4.
 */
public class QueryAprolistRquest {

    /**
     * agent : ZK_Boss
     * intfVer : 1.0.0
     * lang : zh-CN
     * platform : appbigboss
     * sys : zkboss
     * tz : +8:00
     * cmpId : ff80808157096c92015744037e51000a
     * sessionId : eb1b506d60392f8d741a0a54c18c2d9d
     * payload : {"params":{"cmpId":"ff80808157096c92015744037e51000a","approveManId":"40287e96574240d00157424bb4400001","approvalRet":0,"curPage":1,"pageSize":20}}
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
     * params : {"cmpId":"ff80808157096c92015744037e51000a","approveManId":"40287e96574240d00157424bb4400001","approvalRet":0,"curPage":1,"pageSize":20}
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
         * cmpId : ff80808157096c92015744037e51000a
         * approveManId : 40287e96574240d00157424bb4400001
         * approvalRet : 0
         * curPage : 1
         * pageSize : 20
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
            private String empId;
            public String getEmpId() {
                return empId;
            }

            public void setEmpId(String empId) {
                this.empId = empId;
            }

            private String approveManId;
            private int approvalRet;
            private int curPage;
            private int pageSize;

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

            public int getApprovalRet() {
                return approvalRet;
            }

            public void setApprovalRet(int approvalRet) {
                this.approvalRet = approvalRet;
            }

            public int getCurPage() {
                return curPage;
            }

            public void setCurPage(int curPage) {
                this.curPage = curPage;
            }

            public int getPageSize() {
                return pageSize;
            }

            public void setPageSize(int pageSize) {
                this.pageSize = pageSize;
            }
        }
    }
}
