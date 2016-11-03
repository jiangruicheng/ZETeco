package com.zkteco.bigboss.bean.json;

/**
 * Created by jiang_ruicheng on 16/11/2.
 */
public class ApplyCmpResponse {

    /**
     * code : 00000000
     * message : Success
     * payload : {"dataFmt":"1","results":{}}
     */

    private String code;
    private String message;
    /**
     * dataFmt : 1
     * results : {}
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
        private String dataFmt;
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
        }
    }
}
