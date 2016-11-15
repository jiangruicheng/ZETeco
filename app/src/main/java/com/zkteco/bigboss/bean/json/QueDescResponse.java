package com.zkteco.bigboss.bean.json;

import java.util.List;

/**
 * Created by jiang_ruicheng on 16/11/13.
 */
public class QueDescResponse {
    /**
     * code : 00000000
     * message : Success
     * payload : {"dataFmt":"1","results":[{"value":"1","desc":"上班签到"},{"value":"2","desc":"下班签退"}]}
     */

    private String code;
    private String message;
    /**
     * dataFmt : 1
     * results : [{"value":"1","desc":"上班签到"},{"value":"2","desc":"下班签退"}]
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
        /**
         * value : 1
         * desc : 上班签到
         */

        private List<ResultsBean> results;

        public String getDataFmt() {
            return dataFmt;
        }

        public void setDataFmt(String dataFmt) {
            this.dataFmt = dataFmt;
        }

        public List<ResultsBean> getResults() {
            return results;
        }

        public void setResults(List<ResultsBean> results) {
            this.results = results;
        }

        public static class ResultsBean {
            private String value;
            private String desc;

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }
        }
    }
}
