package com.zkteco.bigboss.bean.json;

import java.util.List;

/**
 * Created by jiang_ruicheng on 16/11/2.
 */
public class CmpIndusResponse {


    /**
     * code : 00000000
     * message : Success
     * payload : {"dataFmt":"1","results":[{"industryId":170007332,"name":"机械/设备/重工"},{"industryId":216751380,"name":"交通/运输/物流 航天/航空"},{"industryId":262477933,"name":"环保"},{"industryId":269999002,"name":"政府"},{"industryId":288233769,"name":"银行"},{"industryId":293757675,"name":"影视/媒体/艺术"},{"industryId":400361859,"name":"餐饮业"},{"industryId":436795341,"name":"中介服务"},{"industryId":469849332,"name":"房地产开发"},{"industryId":658290939,"name":"酒店/旅游"},{"industryId":663683471,"name":"汽车及零配件"},{"industryId":663969773,"name":"农业/渔业/林业"},{"industryId":771188214,"name":"建筑与工程"},{"industryId":773750898,"name":"采掘业/冶炼"},{"industryId":798050202,"name":"美容/保健"},{"industryId":918986243,"name":"检测，认证"},{"industryId":1112288195,"name":"物业管理/商业中心"},{"industryId":1116977400,"name":"家居/室内设计/装潢"},{"industryId":1136792559,"name":"服装/纺织/皮革"},{"industryId":1250305689,"name":"计算机服务（系统、数据服务）"},{"industryId":1299771878,"name":"教育/培训"},{"industryId":1406223328,"name":"石油/化工/矿产"},{"industryId":1469576939,"name":"互联网/电子商务"},{"industryId":1675529541,"name":"计算机软件"},{"industryId":1782549667,"name":"办公用品及设备"},{"industryId":1809497821,"name":"批发/零售"},{"industryId":1884073263,"name":"保险"},{"industryId":2059868471,"name":"金融/投资/证券"},{"industryId":2144829903,"name":"非盈利机构"},{"industryId":2226336864,"name":"通信/电信运营、增值服务"},{"industryId":2353848879,"name":"法律"},{"industryId":2410605152,"name":"公关/市场推广/会展"},{"industryId":2537221291,"name":"电力/水利"},{"industryId":2538943691,"name":"生活服务"},{"industryId":2573913101,"name":"制药/生物工程"},{"industryId":2703482961,"name":"会计/审计"},{"industryId":2781320057,"name":"广告"},{"industryId":2781847177,"name":"快速消费品(食品，饮料，化妆品)"},{"industryId":2816958055,"name":"其他行业"},{"industryId":2840417052,"name":"多元化业务集团公司"},{"industryId":2957340108,"name":"电子技术/半导体/集成电路"},{"industryId":3033356412,"name":"专业服务（咨询，人力资源）"},{"industryId":3333526072,"name":"学术/科研"},{"industryId":3386456782,"name":"通信/电信/网络设备"},{"industryId":3508267641,"name":"家具/家电/工艺品/玩具"},{"industryId":3528561956,"name":"娱乐/休闲/体育"},{"industryId":3537327258,"name":"贸易/进出口"},{"industryId":3623267985,"name":"网络游戏"},{"industryId":3639534569,"name":"计算机硬件"},{"industryId":3696993722,"name":"医疗/护理/保健/卫生"},{"industryId":3745252271,"name":"原材料和加工"},{"industryId":3813832754,"name":"仪器仪表/工业自动化"},{"industryId":3975968661,"name":"印刷/包装"},{"industryId":4002134551,"name":"医疗设备/器械"},{"industryId":4116763280,"name":"文字媒体/出版"}]}
     */

    private String code;
    private String message;
    /**
     * dataFmt : 1
     * results : [{"industryId":170007332,"name":"机械/设备/重工"},{"industryId":216751380,"name":"交通/运输/物流 航天/航空"},{"industryId":262477933,"name":"环保"},{"industryId":269999002,"name":"政府"},{"industryId":288233769,"name":"银行"},{"industryId":293757675,"name":"影视/媒体/艺术"},{"industryId":400361859,"name":"餐饮业"},{"industryId":436795341,"name":"中介服务"},{"industryId":469849332,"name":"房地产开发"},{"industryId":658290939,"name":"酒店/旅游"},{"industryId":663683471,"name":"汽车及零配件"},{"industryId":663969773,"name":"农业/渔业/林业"},{"industryId":771188214,"name":"建筑与工程"},{"industryId":773750898,"name":"采掘业/冶炼"},{"industryId":798050202,"name":"美容/保健"},{"industryId":918986243,"name":"检测，认证"},{"industryId":1112288195,"name":"物业管理/商业中心"},{"industryId":1116977400,"name":"家居/室内设计/装潢"},{"industryId":1136792559,"name":"服装/纺织/皮革"},{"industryId":1250305689,"name":"计算机服务（系统、数据服务）"},{"industryId":1299771878,"name":"教育/培训"},{"industryId":1406223328,"name":"石油/化工/矿产"},{"industryId":1469576939,"name":"互联网/电子商务"},{"industryId":1675529541,"name":"计算机软件"},{"industryId":1782549667,"name":"办公用品及设备"},{"industryId":1809497821,"name":"批发/零售"},{"industryId":1884073263,"name":"保险"},{"industryId":2059868471,"name":"金融/投资/证券"},{"industryId":2144829903,"name":"非盈利机构"},{"industryId":2226336864,"name":"通信/电信运营、增值服务"},{"industryId":2353848879,"name":"法律"},{"industryId":2410605152,"name":"公关/市场推广/会展"},{"industryId":2537221291,"name":"电力/水利"},{"industryId":2538943691,"name":"生活服务"},{"industryId":2573913101,"name":"制药/生物工程"},{"industryId":2703482961,"name":"会计/审计"},{"industryId":2781320057,"name":"广告"},{"industryId":2781847177,"name":"快速消费品(食品，饮料，化妆品)"},{"industryId":2816958055,"name":"其他行业"},{"industryId":2840417052,"name":"多元化业务集团公司"},{"industryId":2957340108,"name":"电子技术/半导体/集成电路"},{"industryId":3033356412,"name":"专业服务（咨询，人力资源）"},{"industryId":3333526072,"name":"学术/科研"},{"industryId":3386456782,"name":"通信/电信/网络设备"},{"industryId":3508267641,"name":"家具/家电/工艺品/玩具"},{"industryId":3528561956,"name":"娱乐/休闲/体育"},{"industryId":3537327258,"name":"贸易/进出口"},{"industryId":3623267985,"name":"网络游戏"},{"industryId":3639534569,"name":"计算机硬件"},{"industryId":3696993722,"name":"医疗/护理/保健/卫生"},{"industryId":3745252271,"name":"原材料和加工"},{"industryId":3813832754,"name":"仪器仪表/工业自动化"},{"industryId":3975968661,"name":"印刷/包装"},{"industryId":4002134551,"name":"医疗设备/器械"},{"industryId":4116763280,"name":"文字媒体/出版"}]
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
         * industryId : 170007332
         * name : 机械/设备/重工
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
            private long industryId;
            private String name;

            public long getIndustryId() {
                return industryId;
            }

            public void setIndustryId(int industryId) {
                this.industryId = industryId;
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
