package com.zkteco.bigboss.bean.json;

import java.util.List;

/**
 * Created by jiang_ruicheng on 16/11/11.
 */
public class QueryReviewersResponse {


    /**
     * code : 00000000
     * message : 成功
     * payload : {"dataFmt":"1","results":{"totalRecords":1,"curPage":1,"dataFmt":1,"totalPages":1,"pageSize":10,"dataLists":[{"empId":"5a91ab6458f1d74b0159005dcbb00116","phone":"15001372759","name":"小姜"}]}}
     */

    private String code;
    private String message;
    /**
     * dataFmt : 1
     * results : {"totalRecords":1,"curPage":1,"dataFmt":1,"totalPages":1,"pageSize":10,"dataLists":[{"empId":"5a91ab6458f1d74b0159005dcbb00116","phone":"15001372759","name":"小姜"}]}
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
         * totalRecords : 1
         * curPage : 1
         * dataFmt : 1
         * totalPages : 1
         * pageSize : 10
         * dataLists : [{"empId":"5a91ab6458f1d74b0159005dcbb00116","phone":"15001372759","name":"小姜"}]
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
            private int totalRecords;
            private int curPage;
            private int dataFmt;
            private int totalPages;
            private int pageSize;
            /**
             * empId : 5a91ab6458f1d74b0159005dcbb00116
             * phone : 15001372759
             * name : 小姜
             */

            private List<DataListsBean> dataLists;

            public int getTotalRecords() {
                return totalRecords;
            }

            public void setTotalRecords(int totalRecords) {
                this.totalRecords = totalRecords;
            }

            public int getCurPage() {
                return curPage;
            }

            public void setCurPage(int curPage) {
                this.curPage = curPage;
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

            public int getPageSize() {
                return pageSize;
            }

            public void setPageSize(int pageSize) {
                this.pageSize = pageSize;
            }

            public List<DataListsBean> getDataLists() {
                return dataLists;
            }

            public void setDataLists(List<DataListsBean> dataLists) {
                this.dataLists = dataLists;
            }

            public static class DataListsBean {
                private String empId;
                private String phone;
                private String name;

                public String getPingyinfirst() {
                    return pingyinfirst;
                }

                public void setPingyinfirst(String pingyinfirst) {
                    this.pingyinfirst = pingyinfirst;
                }

                private String pingyinfirst;

                public String getFirstLetter() {
                    return firstLetter;
                }

                public void setFirstLetter(String firstLetter) {
                    this.firstLetter = firstLetter;
                }

                private String firstLetter;

                public String getEmpId() {
                    return empId;
                }

                public void setEmpId(String empId) {
                    this.empId = empId;
                }

                public String getPhone() {
                    return phone;
                }

                public void setPhone(String phone) {
                    this.phone = phone;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }
            }
        }
    }
}
