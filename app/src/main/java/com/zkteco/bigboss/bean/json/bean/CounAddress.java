package com.zkteco.bigboss.bean.json.bean;

import java.util.List;

/**
 * Created by jiang_ruicheng on 16/11/2.
 */
public class CounAddress {

    /**
     * areaId : 2
     * code : 110000
     * name : 北京市
     * subArea : [{"areaId":2,"code":"110000","name":"北京市","subArea":[{"areaId":3,"code":"110101","name":"东城区"},{"areaId":4,"code":"110102","name":"西城区"},{"areaId":5,"code":"110105","name":"朝阳区"},{"areaId":6,"code":"110106","name":"丰台区"},{"areaId":7,"code":"110107","name":"石景山区"},{"areaId":8,"code":"110108","name":"海淀区"},{"areaId":9,"code":"110109","name":"门头沟区"},{"areaId":10,"code":"110111","name":"房山区"},{"areaId":11,"code":"110112","name":"通州区"},{"areaId":12,"code":"110113","name":"顺义区"},{"areaId":13,"code":"110114","name":"昌平区"},{"areaId":14,"code":"110115","name":"大兴区"},{"areaId":15,"code":"110116","name":"怀柔区"},{"areaId":16,"code":"110117","name":"平谷区"},{"areaId":17,"code":"110228","name":"密云县"},{"areaId":18,"code":"110229","name":"延庆县"}]}]
     */

    private int areaId;
    private String code;
    private String name;
    /**
     * areaId : 2
     * code : 110000
     * name : 北京市
     * subArea : [{"areaId":3,"code":"110101","name":"东城区"},{"areaId":4,"code":"110102","name":"西城区"},{"areaId":5,"code":"110105","name":"朝阳区"},{"areaId":6,"code":"110106","name":"丰台区"},{"areaId":7,"code":"110107","name":"石景山区"},{"areaId":8,"code":"110108","name":"海淀区"},{"areaId":9,"code":"110109","name":"门头沟区"},{"areaId":10,"code":"110111","name":"房山区"},{"areaId":11,"code":"110112","name":"通州区"},{"areaId":12,"code":"110113","name":"顺义区"},{"areaId":13,"code":"110114","name":"昌平区"},{"areaId":14,"code":"110115","name":"大兴区"},{"areaId":15,"code":"110116","name":"怀柔区"},{"areaId":16,"code":"110117","name":"平谷区"},{"areaId":17,"code":"110228","name":"密云县"},{"areaId":18,"code":"110229","name":"延庆县"}]
     */

    private List<SubAreaBean> subArea;

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SubAreaBean> getSubArea() {
        return subArea;
    }

    public void setSubArea(List<SubAreaBean> subArea) {
        this.subArea = subArea;
    }

    public static class SubAreaBean {
        private int areaId;
        private String code;
        private String name;
        /**
         * areaId : 3
         * code : 110101
         * name : 东城区
         */

        private List<SubAreaBean2> subArea;

        public int getAreaId() {
            return areaId;
        }

        public void setAreaId(int areaId) {
            this.areaId = areaId;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<SubAreaBean2> getSubArea() {
            return subArea;
        }

        public void setSubArea(List<SubAreaBean2> subArea) {
            this.subArea = subArea;
        }

        public static class SubAreaBean2 {
            private int areaId;
            private String code;
            private String name;

            public int getAreaId() {
                return areaId;
            }

            public void setAreaId(int areaId) {
                this.areaId = areaId;
            }

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
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
