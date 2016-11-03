package com.zkteco.bigboss.bean.json;

/**
 * Created by jiang_ruicheng on 16/11/2.
 */
public class SearchCompanyResponse {

    /**
     * code : 00000000
     * message : Success
     * payload : {"results":{"coorLongitude":0,"outsideEffectRadius":5000,"cmpAddress":"五和大道4010","preSignCardNeedAudit":0,"preSignCardAlowDelayMins":10,"city":"140400","country":"100001","preSignCardAlowEarlyMins":0,"cmpName":"ZKTeco壹号掌柜","province":"140000","industryDesc":"计算机软件","coorWeft":0,"cmpId":"402809815809564a0158095e3f680001","adSwitch":1,"industryId":1675529541,"preSignCardRadius":5000,"cmpNumber":"100000005"},"dataFmt":"1"}
     */

    private String code;
    private String message;
    /**
     * results : {"coorLongitude":0,"outsideEffectRadius":5000,"cmpAddress":"五和大道4010","preSignCardNeedAudit":0,"preSignCardAlowDelayMins":10,"city":"140400","country":"100001","preSignCardAlowEarlyMins":0,"cmpName":"ZKTeco壹号掌柜","province":"140000","industryDesc":"计算机软件","coorWeft":0,"cmpId":"402809815809564a0158095e3f680001","adSwitch":1,"industryId":1675529541,"preSignCardRadius":5000,"cmpNumber":"100000005"}
     * dataFmt : 1
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

    public PayloadBean getPayload() {
        return payload;
    }

    public void setPayload(PayloadBean payload) {
        this.payload = payload;
    }

    public static class PayloadBean {
        /**
         * coorLongitude : 0
         * outsideEffectRadius : 5000
         * cmpAddress : 五和大道4010
         * preSignCardNeedAudit : 0
         * preSignCardAlowDelayMins : 10
         * city : 140400
         * country : 100001
         * preSignCardAlowEarlyMins : 0
         * cmpName : ZKTeco壹号掌柜
         * province : 140000
         * industryDesc : 计算机软件
         * coorWeft : 0
         * cmpId : 402809815809564a0158095e3f680001
         * adSwitch : 1
         * industryId : 1675529541
         * preSignCardRadius : 5000
         * cmpNumber : 100000005
         */

        private ResultsBean results;
        private String dataFmt;

        public ResultsBean getResults() {
            return results;
        }

        public void setResults(ResultsBean results) {
            this.results = results;
        }

        public String getDataFmt() {
            return dataFmt;
        }

        public void setDataFmt(String dataFmt) {
            this.dataFmt = dataFmt;
        }

        public static class ResultsBean {
            private int coorLongitude;
            private int outsideEffectRadius;
            private String cmpAddress;
            private int preSignCardNeedAudit;
            private int preSignCardAlowDelayMins;
            private String city;
            private String country;
            private int preSignCardAlowEarlyMins;
            private String cmpName;
            private String province;
            private String industryDesc;
            private int coorWeft;
            private String cmpId;
            private int adSwitch;
            private int industryId;
            private int preSignCardRadius;
            private String cmpNumber;

            public int getCoorLongitude() {
                return coorLongitude;
            }

            public void setCoorLongitude(int coorLongitude) {
                this.coorLongitude = coorLongitude;
            }

            public int getOutsideEffectRadius() {
                return outsideEffectRadius;
            }

            public void setOutsideEffectRadius(int outsideEffectRadius) {
                this.outsideEffectRadius = outsideEffectRadius;
            }

            public String getCmpAddress() {
                return cmpAddress;
            }

            public void setCmpAddress(String cmpAddress) {
                this.cmpAddress = cmpAddress;
            }

            public int getPreSignCardNeedAudit() {
                return preSignCardNeedAudit;
            }

            public void setPreSignCardNeedAudit(int preSignCardNeedAudit) {
                this.preSignCardNeedAudit = preSignCardNeedAudit;
            }

            public int getPreSignCardAlowDelayMins() {
                return preSignCardAlowDelayMins;
            }

            public void setPreSignCardAlowDelayMins(int preSignCardAlowDelayMins) {
                this.preSignCardAlowDelayMins = preSignCardAlowDelayMins;
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

            public int getPreSignCardAlowEarlyMins() {
                return preSignCardAlowEarlyMins;
            }

            public void setPreSignCardAlowEarlyMins(int preSignCardAlowEarlyMins) {
                this.preSignCardAlowEarlyMins = preSignCardAlowEarlyMins;
            }

            public String getCmpName() {
                return cmpName;
            }

            public void setCmpName(String cmpName) {
                this.cmpName = cmpName;
            }

            public String getProvince() {
                return province;
            }

            public void setProvince(String province) {
                this.province = province;
            }

            public String getIndustryDesc() {
                return industryDesc;
            }

            public void setIndustryDesc(String industryDesc) {
                this.industryDesc = industryDesc;
            }

            public int getCoorWeft() {
                return coorWeft;
            }

            public void setCoorWeft(int coorWeft) {
                this.coorWeft = coorWeft;
            }

            public String getCmpId() {
                return cmpId;
            }

            public void setCmpId(String cmpId) {
                this.cmpId = cmpId;
            }

            public int getAdSwitch() {
                return adSwitch;
            }

            public void setAdSwitch(int adSwitch) {
                this.adSwitch = adSwitch;
            }

            public int getIndustryId() {
                return industryId;
            }

            public void setIndustryId(int industryId) {
                this.industryId = industryId;
            }

            public int getPreSignCardRadius() {
                return preSignCardRadius;
            }

            public void setPreSignCardRadius(int preSignCardRadius) {
                this.preSignCardRadius = preSignCardRadius;
            }

            public String getCmpNumber() {
                return cmpNumber;
            }

            public void setCmpNumber(String cmpNumber) {
                this.cmpNumber = cmpNumber;
            }
        }
    }
}
