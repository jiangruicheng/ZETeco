package com.zkteco.bigboss.bean.json.bean;

import com.zkteco.bigboss.bean.json.QueryAttResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiang_ruicheng on 16/11/27.
 */
public class AttMesg {
    private boolean Iserro;

    public boolean iserro() {
        return Iserro;
    }

    public void setIserro(boolean iserro) {
        Iserro = iserro;
    }

    public List<QueryAttResponse.PayloadBean.ResultsBean.PunchEventListBean> getPunchEventList() {
        return punchEventList;
    }


    private List<QueryAttResponse.PayloadBean.ResultsBean.PunchEventListBean> punchEventList = new ArrayList<>();
}
