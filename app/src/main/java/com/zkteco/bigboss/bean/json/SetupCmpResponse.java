package com.zkteco.bigboss.bean.json;

/**
 * Created by jiang_ruicheng on 16/11/3.
 */
public class SetupCmpResponse {

    /**
     * code : 00000000
     * message : Success
     * payload : {"results":{},"dataFmt":"1"}
     */

    private String code;
    private String message;
    /**
     * results : {}
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
        }
    }
}
