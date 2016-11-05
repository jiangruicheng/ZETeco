package com.zkteco.bigboss.bean.json;

import java.util.List;

/**
 * Created by jiang_ruicheng on 16/11/3.
 */
public class QueryAttResponse {
    /**
     * code : 00000000
     * message : Success
     * payload : {"dataFmt":"1","results":{"id":"1","punchEventListCount":3,"punchEventList":[{"subType":0,"subAttTypeName":"签到","name":"John","empId":"8aad387e56927587015696002b750013","attDate":"20160927","timeShift":"8aad34c2571dfbf201574a7774da1037","startTime":"00:00","endTime":"00:00","jobNumber":"1000","punchTime":"09:00","value":"09:00","order":1},{"subType":1,"subAttTypeName":"签退","name":"John","empId":"8aad387e56927587015696002b750013","attDate":"20160927","timeShift":"8aad34c2571dfbf201574a7774da1037","startTime":"00:00","endTime":"00:00","jobNumber":"1000","punchTime":"17:55","value":"17:55","order":2},{"subType":3,"subAttTypeName":"早退","name":"John","empId":"8aad387e56927587015696002b750013","attDate":"20160927","timeShift":"8aad34c2571dfbf201574a7774da1037","jobNumber":"1000","value":"5","order":8}]}}
     */

    private String code;
    private String message;
    /**
     * dataFmt : 1
     * results : {"id":"1","punchEventListCount":3,"punchEventList":[{"subType":0,"subAttTypeName":"签到","name":"John","empId":"8aad387e56927587015696002b750013","attDate":"20160927","timeShift":"8aad34c2571dfbf201574a7774da1037","startTime":"00:00","endTime":"00:00","jobNumber":"1000","punchTime":"09:00","value":"09:00","order":1},{"subType":1,"subAttTypeName":"签退","name":"John","empId":"8aad387e56927587015696002b750013","attDate":"20160927","timeShift":"8aad34c2571dfbf201574a7774da1037","startTime":"00:00","endTime":"00:00","jobNumber":"1000","punchTime":"17:55","value":"17:55","order":2},{"subType":3,"subAttTypeName":"早退","name":"John","empId":"8aad387e56927587015696002b750013","attDate":"20160927","timeShift":"8aad34c2571dfbf201574a7774da1037","jobNumber":"1000","value":"5","order":8}]}
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
         * id : 1
         * punchEventListCount : 3
         * punchEventList : [{"subType":0,"subAttTypeName":"签到","name":"John","empId":"8aad387e56927587015696002b750013","attDate":"20160927","timeShift":"8aad34c2571dfbf201574a7774da1037","startTime":"00:00","endTime":"00:00","jobNumber":"1000","punchTime":"09:00","value":"09:00","order":1},{"subType":1,"subAttTypeName":"签退","name":"John","empId":"8aad387e56927587015696002b750013","attDate":"20160927","timeShift":"8aad34c2571dfbf201574a7774da1037","startTime":"00:00","endTime":"00:00","jobNumber":"1000","punchTime":"17:55","value":"17:55","order":2},{"subType":3,"subAttTypeName":"早退","name":"John","empId":"8aad387e56927587015696002b750013","attDate":"20160927","timeShift":"8aad34c2571dfbf201574a7774da1037","jobNumber":"1000","value":"5","order":8}]
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
            private String id;
            private int punchEventListCount;
            /**
             * subType : 0
             * subAttTypeName : 签到
             * name : John
             * empId : 8aad387e56927587015696002b750013
             * attDate : 20160927
             * timeShift : 8aad34c2571dfbf201574a7774da1037
             * startTime : 00:00
             * endTime : 00:00
             * jobNumber : 1000
             * punchTime : 09:00
             * value : 09:00
             * order : 1
             */

            private List<PunchEventListBean> punchEventList;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public int getPunchEventListCount() {
                return punchEventListCount;
            }

            public void setPunchEventListCount(int punchEventListCount) {
                this.punchEventListCount = punchEventListCount;
            }

            public List<PunchEventListBean> getPunchEventList() {
                return punchEventList;
            }

            public void setPunchEventList(List<PunchEventListBean> punchEventList) {
                this.punchEventList = punchEventList;
            }

            public static class PunchEventListBean {
                private int subType;
                private String subAttTypeName;
                private String name;
                private String empId;
                private String attDate;
                private String timeShift;
                private String startTime;
                private String endTime;
                private String jobNumber;
                private String punchTime;
                private String value;
                private int order;

                public int getSubType() {
                    return subType;
                }

                public void setSubType(int subType) {
                    this.subType = subType;
                }

                public String getSubAttTypeName() {
                    return subAttTypeName;
                }

                public void setSubAttTypeName(String subAttTypeName) {
                    this.subAttTypeName = subAttTypeName;
                }

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

                public String getAttDate() {
                    return attDate;
                }

                public void setAttDate(String attDate) {
                    this.attDate = attDate;
                }

                public String getTimeShift() {
                    return timeShift;
                }

                public void setTimeShift(String timeShift) {
                    this.timeShift = timeShift;
                }

                public String getStartTime() {
                    return startTime;
                }

                public void setStartTime(String startTime) {
                    this.startTime = startTime;
                }

                public String getEndTime() {
                    return endTime;
                }

                public void setEndTime(String endTime) {
                    this.endTime = endTime;
                }

                public String getJobNumber() {
                    return jobNumber;
                }

                public void setJobNumber(String jobNumber) {
                    this.jobNumber = jobNumber;
                }

                public String getPunchTime() {
                    return punchTime;
                }

                public void setPunchTime(String punchTime) {
                    this.punchTime = punchTime;
                }

                public String getValue() {
                    return value;
                }

                public void setValue(String value) {
                    this.value = value;
                }

                public int getOrder() {
                    return order;
                }

                public void setOrder(int order) {
                    this.order = order;
                }
            }
        }
    }
}
