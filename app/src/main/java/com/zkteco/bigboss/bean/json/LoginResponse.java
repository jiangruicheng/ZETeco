package com.zkteco.bigboss.bean.json;

/**
 * Created by jiang_ruicheng on 16/10/27.
 */
public class LoginResponse {

    /**
     * code : 00000000
     * message : 恭喜您，登录成功！
     * sessionId : 003ab8dd2a38f692fc9b9d396af71abb
     * payload : {"dataFmt":"1","results":{"zkCloudId":"18465381910649f7afe59d4315a8f4a9","agentCode":"ZK","cmpId":"ff80808156a25e830156b5499d620002","cmpName":"1号掌柜","agentName":"中控科技","isFinishedCompanyInfo":true,"isFinishedPersonalInfo":false,"name":"企业创建者","accountSessionId":"b757014e8f63280d2e4143bc0258d664","logo":"","cmpType":2,"cmpStatus":1,"headPortrait":"","email":"Green.liu@zkteco.com","isIotAdmin":false,"empId":"","isAdmin":false,"come_from":"2"}}
     */

    private String code;
    private String message;
    private String sessionId;
    /**
     * dataFmt : 1
     * results : {"zkCloudId":"18465381910649f7afe59d4315a8f4a9","agentCode":"ZK","cmpId":"ff80808156a25e830156b5499d620002","cmpName":"1号掌柜","agentName":"中控科技","isFinishedCompanyInfo":true,"isFinishedPersonalInfo":false,"name":"企业创建者","accountSessionId":"b757014e8f63280d2e4143bc0258d664","logo":"","cmpType":2,"cmpStatus":1,"headPortrait":"","email":"Green.liu@zkteco.com","isIotAdmin":false,"empId":"","isAdmin":false,"come_from":"2"}
     */

    private PayloadBean payload;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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
        private String dataFmt;
        /**
         * zkCloudId : 18465381910649f7afe59d4315a8f4a9
         * agentCode : ZK
         * cmpId : ff80808156a25e830156b5499d620002
         * cmpName : 1号掌柜
         * agentName : 中控科技
         * isFinishedCompanyInfo : true
         * isFinishedPersonalInfo : false
         * name : 企业创建者
         * accountSessionId : b757014e8f63280d2e4143bc0258d664
         * logo :
         * cmpType : 2
         * cmpStatus : 1
         * headPortrait :
         * email : Green.liu@zkteco.com
         * isIotAdmin : false
         * empId :
         * isAdmin : false
         * come_from : 2
         */

        private ResultsBean results;

        public String getDataFmt() {
            return dataFmt;
        }

        public void setDataFmt(String dataFmt) {
            this.dataFmt = dataFmt;
        }

        public ResultsBean getResults() {
            return results;
        }

        public void setResults(ResultsBean results) {
            this.results = results;
        }

        public static class ResultsBean {
            private String zkCloudId;
            private String agentCode;
            private String cmpId;
            private String cmpName;
            private String agentName;
            private boolean isFinishedCompanyInfo;
            private boolean isFinishedPersonalInfo;
            private String name;
            private String accountSessionId;
            private String logo;
            private int cmpType;
            private int cmpStatus;
            private String headPortrait;
            private String email;
            private boolean isIotAdmin;
            private String empId;
            private boolean isAdmin;
            private String come_from;

            public String getZkCloudId() {
                return zkCloudId;
            }

            public void setZkCloudId(String zkCloudId) {
                this.zkCloudId = zkCloudId;
            }

            public String getAgentCode() {
                return agentCode;
            }

            public void setAgentCode(String agentCode) {
                this.agentCode = agentCode;
            }

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

            public String getAgentName() {
                return agentName;
            }

            public void setAgentName(String agentName) {
                this.agentName = agentName;
            }

            public boolean isIsFinishedCompanyInfo() {
                return isFinishedCompanyInfo;
            }

            public void setIsFinishedCompanyInfo(boolean isFinishedCompanyInfo) {
                this.isFinishedCompanyInfo = isFinishedCompanyInfo;
            }

            public boolean isIsFinishedPersonalInfo() {
                return isFinishedPersonalInfo;
            }

            public void setIsFinishedPersonalInfo(boolean isFinishedPersonalInfo) {
                this.isFinishedPersonalInfo = isFinishedPersonalInfo;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getAccountSessionId() {
                return accountSessionId;
            }

            public void setAccountSessionId(String accountSessionId) {
                this.accountSessionId = accountSessionId;
            }

            public String getLogo() {
                return logo;
            }

            public void setLogo(String logo) {
                this.logo = logo;
            }

            public int getCmpType() {
                return cmpType;
            }

            public void setCmpType(int cmpType) {
                this.cmpType = cmpType;
            }

            public int getCmpStatus() {
                return cmpStatus;
            }

            public void setCmpStatus(int cmpStatus) {
                this.cmpStatus = cmpStatus;
            }

            public String getHeadPortrait() {
                return headPortrait;
            }

            public void setHeadPortrait(String headPortrait) {
                this.headPortrait = headPortrait;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public boolean isIsIotAdmin() {
                return isIotAdmin;
            }

            public void setIsIotAdmin(boolean isIotAdmin) {
                this.isIotAdmin = isIotAdmin;
            }

            public String getEmpId() {
                return empId;
            }

            public void setEmpId(String empId) {
                this.empId = empId;
            }

            public boolean isIsAdmin() {
                return isAdmin;
            }

            public void setIsAdmin(boolean isAdmin) {
                this.isAdmin = isAdmin;
            }

            public String getCome_from() {
                return come_from;
            }

            public void setCome_from(String come_from) {
                this.come_from = come_from;
            }
        }
    }
}
