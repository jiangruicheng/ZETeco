package com.zkteco.bigboss.mvp.api;

import com.zkteco.bigboss.bean.json.ApplyCmpResponse;
import com.zkteco.bigboss.bean.json.ApplyJoinCmpRequest;
import com.zkteco.bigboss.bean.json.AskForLeaveRequest;
import com.zkteco.bigboss.bean.json.AskForLeaveResponse;
import com.zkteco.bigboss.bean.json.CheckoutCmpindusRequest;
import com.zkteco.bigboss.bean.json.CmpIndusResponse;
import com.zkteco.bigboss.bean.json.LoginRequest;
import com.zkteco.bigboss.bean.json.LoginResponse;
import com.zkteco.bigboss.bean.json.QueDescRequest;
import com.zkteco.bigboss.bean.json.QueDescResponse;
import com.zkteco.bigboss.bean.json.QueSubTypeRequest;
import com.zkteco.bigboss.bean.json.QueSubTypeResponse;
import com.zkteco.bigboss.bean.json.QueryAproResponse;
import com.zkteco.bigboss.bean.json.QueryAprolistRquest;
import com.zkteco.bigboss.bean.json.QueryAttRequest;
import com.zkteco.bigboss.bean.json.QueryAttResponse;
import com.zkteco.bigboss.bean.json.QueryReviewersRequest;
import com.zkteco.bigboss.bean.json.QueryReviewersResponse;
import com.zkteco.bigboss.bean.json.QueryStatiResponse;
import com.zkteco.bigboss.bean.json.QueryStatiRequest;
import com.zkteco.bigboss.bean.json.ReviewRequireRequest;
import com.zkteco.bigboss.bean.json.ReviewRequireResponse;
import com.zkteco.bigboss.bean.json.SearchCompanyRequest;
import com.zkteco.bigboss.bean.json.SearchCompanyResponse;
import com.zkteco.bigboss.bean.json.SendSmsCaptchaRequest;
import com.zkteco.bigboss.bean.json.SendSmsCaptchaResponse;
import com.zkteco.bigboss.bean.json.SetupCmpRequest;
import com.zkteco.bigboss.bean.json.SetupCmpResponse;
import com.zkteco.bigboss.bean.json.SignCardRequest;
import com.zkteco.bigboss.bean.json.SignCardResponse;
import com.zkteco.bigboss.bean.json.VerifyCaptchaRequest;
import com.zkteco.bigboss.bean.json.VerifyCaptchaResponse;
import com.zkteco.bigboss.bean.json.VerifyRequest;
import com.zkteco.bigboss.bean.json.VerifyResponse;

import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by jiang_ruicheng on 16/10/27.
 */
public interface ZKTecoApi {
    @POST("apiv1/account/login")
    Observable<LoginResponse> login(@Body LoginRequest loginRequest);

    @POST("apiv1/account/sendcaptcha")
    Observable<SendSmsCaptchaResponse> sendsmscaptcha(@Body SendSmsCaptchaRequest sendSmsCaptcha);

    @POST("apiv1/account/verify")
    Observable<VerifyResponse> verify(@Body VerifyRequest sendSmsCaptcha);

    @POST
    Observable<VerifyCaptchaResponse> verifycaptcha(@Url String url, @Body VerifyCaptchaRequest request);

    @POST("apiv1/account/retrievecompinfobycmpnumber")
    Observable<SearchCompanyResponse> searchcompany(@Body SearchCompanyRequest searchCompanyRequest);

    @POST("apiv1/account/applyJoinCompany")
    Observable<ApplyCmpResponse> applyjoincompany(@Body ApplyJoinCmpRequest searchCompanyRequest);

    @POST("base/listindustries")
    Observable<CmpIndusResponse> checkoutindu(@Body CheckoutCmpindusRequest searchCompanyRequest);

    @POST("apiv1/account/register")
    Observable<SetupCmpResponse> setupcmp(@Body SetupCmpRequest searchCompanyRequest);

    @POST("apiv1/attendance/queryPersonalAttLogs")
    Observable<QueryAttResponse> queryatt(@Body QueryAttRequest queryAttRequest);

    @POST("apiv1/attendance/myStatistics")
    Observable<QueryStatiResponse> querystati(@Body QueryStatiRequest quryStatiRequest);

    @POST("apiv1/approve/queryApprovalList")
    Observable<QueryAproResponse> queryaprolist(@Body QueryAprolistRquest quryStatiRequest);

    @POST("apiv1/approve/queryReviewers")
    Observable<QueryReviewersResponse> queryreviewers(@Body QueryReviewersRequest queryReviewersRequest);

    @POST("apiv1/approve/askForLeave")
    Observable<AskForLeaveResponse> askforleave(@Body AskForLeaveRequest askForLeaveRequest);

    @POST("apiv1/approve/queryAttSubeventByType")
    Observable<QueSubTypeResponse> quesubtype(@Body QueSubTypeRequest queSubTypeRequest);

    @POST("apiv1/approve/signCard")
    Observable<SignCardResponse> signcard(@Body SignCardRequest request);

    @POST("apiv1/sys/queryDictionaries")
    Observable<QueDescResponse> quedesc(@Body QueDescRequest request);

    @POST("apiv1/approve/reviewRequire")
    Observable<ReviewRequireResponse> reviewrequire(@Body ReviewRequireRequest request);

}
