package com.zkteco.bigboss.bean.json;

/**
 * Created by jiang_ruicheng on 16/11/4.
 */
public class QueryStatiResponse {

    /**
     * code : 00000000
     * message : Success
     * payload : {"dataFmt":"1","results":{"myStatistics":{"totalLeaveMins":0,"absenceMins":0,"earlyOutMins":5,"lateInMins":0,"tripMins":0,"totalOtMins":0},"myTotal":{"realMins":3780,"normalMins":3775}}}
     */

    private String code;
    private String message;
    /**
     * dataFmt : 1
     * results : {"myStatistics":{"totalLeaveMins":0,"absenceMins":0,"earlyOutMins":5,"lateInMins":0,"tripMins":0,"totalOtMins":0},"myTotal":{"realMins":3780,"normalMins":3775}}
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
         * myStatistics : {"totalLeaveMins":0,"absenceMins":0,"earlyOutMins":5,"lateInMins":0,"tripMins":0,"totalOtMins":0}
         * myTotal : {"realMins":3780,"normalMins":3775}
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
            /**
             * totalLeaveMins : 0
             * absenceMins : 0
             * earlyOutMins : 5
             * lateInMins : 0
             * tripMins : 0
             * totalOtMins : 0
             */

            private MyStatisticsBean myStatistics;
            /**
             * realMins : 3780
             * normalMins : 3775
             */

            private MyTotalBean myTotal;

            public MyStatisticsBean getMyStatistics() {
                return myStatistics;
            }

            public void setMyStatistics(MyStatisticsBean myStatistics) {
                this.myStatistics = myStatistics;
            }

            public MyTotalBean getMyTotal() {
                return myTotal;
            }

            public void setMyTotal(MyTotalBean myTotal) {
                this.myTotal = myTotal;
            }

            public static class MyStatisticsBean {
                private int totalLeaveMins;
                private int absenceMins;
                private int earlyOutMins;
                private int lateInMins;
                private int tripMins;
                private int totalOtMins;

                public int getTotalLeaveMins() {
                    return totalLeaveMins;
                }

                public void setTotalLeaveMins(int totalLeaveMins) {
                    this.totalLeaveMins = totalLeaveMins;
                }

                public int getAbsenceMins() {
                    return absenceMins;
                }

                public void setAbsenceMins(int absenceMins) {
                    this.absenceMins = absenceMins;
                }

                public int getEarlyOutMins() {
                    return earlyOutMins;
                }

                public void setEarlyOutMins(int earlyOutMins) {
                    this.earlyOutMins = earlyOutMins;
                }

                public int getLateInMins() {
                    return lateInMins;
                }

                public void setLateInMins(int lateInMins) {
                    this.lateInMins = lateInMins;
                }

                public int getTripMins() {
                    return tripMins;
                }

                public void setTripMins(int tripMins) {
                    this.tripMins = tripMins;
                }

                public int getTotalOtMins() {
                    return totalOtMins;
                }

                public void setTotalOtMins(int totalOtMins) {
                    this.totalOtMins = totalOtMins;
                }
            }

            public static class MyTotalBean {
                private int realMins;
                private int normalMins;

                public int getRealMins() {
                    return realMins;
                }

                public void setRealMins(int realMins) {
                    this.realMins = realMins;
                }

                public int getNormalMins() {
                    return normalMins;
                }

                public void setNormalMins(int normalMins) {
                    this.normalMins = normalMins;
                }
            }
        }
    }
}
