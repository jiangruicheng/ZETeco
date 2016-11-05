package com.zkteco.bigboss.bean.json;

import java.util.List;

/**
 * Created by jiang_ruicheng on 16/11/4.
 */
public class QueryAproResponse {
    /**
     * code : 00000000
     * message : Success
     * payload : {"results":[{"type":7,"uid":"40287e96574bad8201574bb370630001","name":"Nick","title":"申请外出","reason":"个人事情","startTime":1475215200000,"commitDate":1474443833440,"approveStatus":0,"updateTimestamp":1474443833440,"empId":"40287e96574240d00157424bb4400001","endTime":1475229600000,"jobNumber":"1000"},{"type":4,"uid":"40287e96574bad8201574bb095780000","name":"Nick","title":"申请出差","reason":"客户需要","address":"中国山东省青岛市黄岛区长江中路419号永旺(黄岛店)2层","startTime":1475215200000,"commitDate":1474443646306,"approveStatus":0,"updateTimestamp":1474443646307,"empId":"40287e96574240d00157424bb4400001","endTime":1475229600000,"jobNumber":"1000"}],"curPage":1,"pageSize":20,"totalRecords":2,"dataFmt":1,"totalPages":1}
     */

    private String code;
    private String message;
    /**
     * results : [{"type":7,"uid":"40287e96574bad8201574bb370630001","name":"Nick","title":"申请外出","reason":"个人事情","startTime":1475215200000,"commitDate":1474443833440,"approveStatus":0,"updateTimestamp":1474443833440,"empId":"40287e96574240d00157424bb4400001","endTime":1475229600000,"jobNumber":"1000"},{"type":4,"uid":"40287e96574bad8201574bb095780000","name":"Nick","title":"申请出差","reason":"客户需要","address":"中国山东省青岛市黄岛区长江中路419号永旺(黄岛店)2层","startTime":1475215200000,"commitDate":1474443646306,"approveStatus":0,"updateTimestamp":1474443646307,"empId":"40287e96574240d00157424bb4400001","endTime":1475229600000,"jobNumber":"1000"}]
     * curPage : 1
     * pageSize : 20
     * totalRecords : 2
     * dataFmt : 1
     * totalPages : 1
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
        private int curPage;
        private int pageSize;
        private int totalRecords;
        private int dataFmt;
        private int totalPages;
        /**
         * type : 7
         * uid : 40287e96574bad8201574bb370630001
         * name : Nick
         * title : 申请外出
         * reason : 个人事情
         * startTime : 1475215200000
         * commitDate : 1474443833440
         * approveStatus : 0
         * updateTimestamp : 1474443833440
         * empId : 40287e96574240d00157424bb4400001
         * endTime : 1475229600000
         * jobNumber : 1000
         */

        private List<ResultsBean> results;

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

        public int getTotalRecords() {
            return totalRecords;
        }

        public void setTotalRecords(int totalRecords) {
            this.totalRecords = totalRecords;
        }

        public int getDataFmt() {
            return dataFmt;
        }

        public void setDataFmt(int dataFmt) {
            this.dataFmt = dataFmt;
        }

        public int getTotalPages() {
            return totalPages;
        }

        public void setTotalPages(int totalPages) {
            this.totalPages = totalPages;
        }

        public List<ResultsBean> getResults() {
            return results;
        }

        public void setResults(List<ResultsBean> results) {
            this.results = results;
        }

        public static class ResultsBean {
            private int type;
            private String uid;
            private String name;
            private String title;
            private String reason;
            private String address;
            private long startTime;
            private long commitDate;
            private int approveStatus;
            private long updateTimestamp;
            private String empId;
            private long endTime;
            private String jobNumber;

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getReason() {
                return reason;
            }

            public void setReason(String reason) {
                this.reason = reason;
            }

            public long getStartTime() {
                return startTime;
            }

            public void setStartTime(long startTime) {
                this.startTime = startTime;
            }

            public long getCommitDate() {
                return commitDate;
            }

            public void setCommitDate(long commitDate) {
                this.commitDate = commitDate;
            }

            public int getApproveStatus() {
                return approveStatus;
            }

            public void setApproveStatus(int approveStatus) {
                this.approveStatus = approveStatus;
            }

            public long getUpdateTimestamp() {
                return updateTimestamp;
            }

            public void setUpdateTimestamp(long updateTimestamp) {
                this.updateTimestamp = updateTimestamp;
            }

            public String getEmpId() {
                return empId;
            }

            public void setEmpId(String empId) {
                this.empId = empId;
            }

            public long getEndTime() {
                return endTime;
            }

            public void setEndTime(long endTime) {
                this.endTime = endTime;
            }

            public String getJobNumber() {
                return jobNumber;
            }

            public void setJobNumber(String jobNumber) {
                this.jobNumber = jobNumber;
            }
        }
    }
}
