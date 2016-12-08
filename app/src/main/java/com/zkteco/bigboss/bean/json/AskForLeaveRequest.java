package com.zkteco.bigboss.bean.json;

/**
 * Created by jiang_ruicheng on 16/11/11.
 */
public class AskForLeaveRequest {
    /**
     * agent : ZK_Boss
     * intfVer : 1.0.0
     * lang : zh-CN
     * platform : appbigboss
     * sys : zkboss
     * tz : +8:00
     * cmpId : ff80808157096c92015744037e51000a
     * sessionId : b6ece45303f2b5e1ff806d749752eef3
     * payload : {"params":{"cmpId":"ff80808157096c92015744037e51000a","empId":"40287e96574240d00157424bb4400001","approveManId":"40287e96574240d00157424bb4400001","startTime":1475215200000,"endTime":1475229600000,"leaveType":"40287e96574a897e01574a8a1a190001","reason":"外出办事"}}
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
     * params : {"cmpId":"ff80808157096c92015744037e51000a","empId":"40287e96574240d00157424bb4400001","approveManId":"40287e96574240d00157424bb4400001","startTime":1475215200000,"endTime":1475229600000,"leaveType":"40287e96574a897e01574a8a1a190001","reason":"外出办事"}
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
         * empId : 40287e96574240d00157424bb4400001
         * approveManId : 40287e96574240d00157424bb4400001
         * startTime : 1475215200000
         * endTime : 1475229600000
         * leaveType : 40287e96574a897e01574a8a1a190001
         * reason : 外出办事
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
            private String approveManId;
            private long startTime = -1;
            private long endTime = -1;
            private String leaveType;
            private String reason;

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

            public String getApproveManId() {
                return approveManId;
            }

            public void setApproveManId(String approveManId) {
                this.approveManId = approveManId;
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

            public String getLeaveType() {
                return leaveType;
            }

            public void setLeaveType(String leaveType) {
                this.leaveType = leaveType;
            }

            public String getReason() {
                return reason;
            }

            public void setReason(String reason) {
                this.reason = reason;
            }
        }
    }
}
