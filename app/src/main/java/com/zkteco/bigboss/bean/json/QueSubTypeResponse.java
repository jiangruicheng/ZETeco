package com.zkteco.bigboss.bean.json;

import java.util.List;

/**
 * Created by jiang_ruicheng on 16/11/11.
 */
public class QueSubTypeResponse {

    /**
     * code : 00000000
     * message : Success
     * payload : {"results":[{"title":"探亲假","subType":"40287e96574a897e01574a8a19cb0000"},{"title":"假期","subType":"40287e96574a897e01574a8a1a190001"},{"title":"陪产假","subType":"40287e96574a897e01574a8a1a1c0002"},{"title":"产假","subType":"40287e96574a897e01574a8a1a220003"},{"title":"丧假","subType":"40287e96574a897e01574a8a1a250004"},{"title":"婚假","subType":"40287e96574a897e01574a8a1a280005"},{"title":"病假","subType":"40287e96574a897e01574a8a1a2a0006"},{"title":"事假","subType":"40287e96574a897e01574a8a1a2d0007"}],"dataFmt":1}
     */

    private String code;
    private String message;
    /**
     * results : [{"title":"探亲假","subType":"40287e96574a897e01574a8a19cb0000"},{"title":"假期","subType":"40287e96574a897e01574a8a1a190001"},{"title":"陪产假","subType":"40287e96574a897e01574a8a1a1c0002"},{"title":"产假","subType":"40287e96574a897e01574a8a1a220003"},{"title":"丧假","subType":"40287e96574a897e01574a8a1a250004"},{"title":"婚假","subType":"40287e96574a897e01574a8a1a280005"},{"title":"病假","subType":"40287e96574a897e01574a8a1a2a0006"},{"title":"事假","subType":"40287e96574a897e01574a8a1a2d0007"}]
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
         * title : 探亲假
         * subType : 40287e96574a897e01574a8a19cb0000
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
            private String title;
            private String subType;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getSubType() {
                return subType;
            }

            public void setSubType(String subType) {
                this.subType = subType;
            }
        }
    }
}
