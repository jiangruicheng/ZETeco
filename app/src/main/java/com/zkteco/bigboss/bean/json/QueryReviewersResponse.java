package com.zkteco.bigboss.bean.json;

import java.util.List;

/**
 * Created by jiang_ruicheng on 16/11/11.
 */
public class QueryReviewersResponse {

    /**
     * code : 00000000
     * message : Success
     * payload : {"results":[{"name":"Nick","empId":"40287e96574240d00157424bb4400001"}],"dataFmt":1}
     */

    private String code;
    private String message;
    /**
     * results : [{"name":"Nick","empId":"40287e96574240d00157424bb4400001"}]
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
        private int dataFmt;
        /**
         * name : Nick
         * empId : 40287e96574240d00157424bb4400001
         */

        private List<ResultsBean> results;

        public int getDataFmt() {
            return dataFmt;
        }

        public void setDataFmt(int dataFmt) {
            this.dataFmt = dataFmt;
        }

        public List<ResultsBean> getResults() {
            return results;
        }

        public void setResults(List<ResultsBean> results) {
            this.results = results;
        }

        public static class ResultsBean {
            private String name;
            private String empId;

            public String getFirstLetter() {
                return firstLetter;
            }

            public void setFirstLetter(String firstLetter) {
                this.firstLetter = firstLetter;
            }

            private String firstLetter;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getEmpId() {
                return empId;
            }

            public void setEmpId(String empId) {
                this.empId = empId;
            }
        }
    }
}
