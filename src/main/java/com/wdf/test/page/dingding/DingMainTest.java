package com.wdf.test.page.dingding;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiGettokenRequest;
import com.dingtalk.api.request.OapiMessageCorpconversationAsyncsendV2Request;
import com.dingtalk.api.request.OapiUserGetByMobileRequest;
import com.dingtalk.api.response.OapiGettokenResponse;
import com.dingtalk.api.response.OapiMessageCorpconversationAsyncsendV2Response;
import com.dingtalk.api.response.OapiUserGetByMobileResponse;
import com.taobao.api.ApiException;

/**
 * @ClassName: DingMainTest
 * @Author WDF
 * @Description //TODO
 * @Date 2020/11/10 14:30
 * @Copyright Dareway 2020/11/10
 * @Version 1.0
 **/
public class DingMainTest {

        public static void main(String[] args) {
            try {
                //获取access_token
                DefaultDingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/gettoken");
                OapiGettokenRequest request = new OapiGettokenRequest();
                request.setAppkey("dingtmxapbfluxgjzunb");//appkey
                request.setAppsecret("fN3fKALWNdVVyzO7JsyeMVgJPAOWFNdGYetI7Cm5JycTxpJa3gr5nU_Tt9pqOXuM");//appsecret
                request.setHttpMethod("GET");
                OapiGettokenResponse response = client.execute(request);
                String accessToken = response.getAccessToken();


                System.out.println(response.getBody());
            } catch (ApiException e) {
                e.printStackTrace();
            }

            //根据手机号获取UserId
            try {
                DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/user/get_by_mobile");
                OapiUserGetByMobileRequest req = new OapiUserGetByMobileRequest();
                req.setMobile("17865316817");
                req.setHttpMethod("GET");
                OapiUserGetByMobileResponse rsp = client.execute(req, "081ead71c906341783706b1cd1c18a42");
                System.out.println(rsp.getBody());
            } catch (ApiException e) {
                e.printStackTrace();
            }

            try {
                DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/message/corpconversation/asyncsend_v2");
                OapiMessageCorpconversationAsyncsendV2Request req = new OapiMessageCorpconversationAsyncsendV2Request();
                req.setAgentId(969328899L);//配置应用中获取(AgentId),应用凭证获取
                req.setUseridList("manager9315");//推送用户的UserId
                req.setToAllUser(true);
                OapiMessageCorpconversationAsyncsendV2Request.Msg obj1 = new OapiMessageCorpconversationAsyncsendV2Request.Msg();
                obj1.setMsgtype("text");
                OapiMessageCorpconversationAsyncsendV2Request.Text obj2 = new OapiMessageCorpconversationAsyncsendV2Request.Text();
                obj2.setContent("测试推送");
                obj1.setText(obj2);
                req.setMsg(obj1);
                OapiMessageCorpconversationAsyncsendV2Response rsp = client.execute(req, "081ead71c906341783706b1cd1c18a42");
                System.out.println(rsp.getBody());
            } catch (ApiException e) {
                e.printStackTrace();
            }
            //发送消息 原生app
          /*  try {
                DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/message/send_to_conversation");
                OapiMessageSendToConversationRequest req = new OapiMessageSendToConversationRequest();
                req.setSender("manager9315");//UserId
                OapiMessageSendToConversationRequest.Text obj1 = new OapiMessageSendToConversationRequest.Text();
                obj1.setContent("测试内容");
                req.setText(obj1);
                req.setMsgtype("text");//内容类型
                req.setCid("91345933fb89344eb8afd16c22401146");
                OapiMessageSendToConversationResponse rsp = client.execute(req, "081ead71c906341783706b1cd1c18a42");
                System.out.println(rsp.getBody());
            } catch (ApiException e) {
                e.printStackTrace();
            }*/



        }


}
