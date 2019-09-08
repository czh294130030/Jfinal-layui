package com.qinhailin.common.kit;

import com.jfinal.kit.PropKit;
import com.qinhailin.common.util.XmlConverUtils;
import okhttp3.*;
import org.dom4j.io.SAXReader;
import org.dom4j.Document;

import java.io.File;
import java.io.IOException;

public class HttpKit {

    public static String postXml(String url, String xmlStr) {
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/xml"),xmlStr);
        Request requestOk = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        Response response;
        try {
            response = new OkHttpClient().newCall(requestOk).execute();
            String jsonString = response.body().string();
            if(response.isSuccessful()){
                return jsonString;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
        return "";
    }

    /**
     * get请求接口，返回json
     * @param url 接口地址
     * @return
     */
    public static String getJson(String url){
        Request requestOk = new Request.Builder()
                .url(url)
                .get()
                .build();
        Response response;
        try {
            response = new OkHttpClient().newCall(requestOk).execute();
            String jsonString = response.body().string();
            if(response.isSuccessful()){
                return jsonString;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
        return "";
    }

    public static void main(String[] args) throws Throwable {
        StringBuilder str = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>");
        str.append("<orderOutboundRequest version=\"0.1\" login=\"Eyar6pXG\" password=\"WaZDzfyZvR6pVLpN\">");
        str.append("<queries>");
        str.append("<query>");
        str.append("<attribute>").append("orderStatus").append("</attribute>");
        str.append("<eq>").append("delivered").append("</eq>");
        str.append("</query>");
        str.append("<query>");
        str.append("<attribute>").append("pickupSla").append("</attribute>");
        str.append("<ge>").append("2019-1-1").append("</ge>");
        str.append("<le>").append("2019-6-30").append("</le>");
        str.append("</query>");
        str.append("</queries>");
        str.append("<includeOrderInfo>").append("false").append("</includeOrderInfo>");
        str.append("<includeOrderPosition>").append("false").append("</includeOrderPosition>");
        str.append("<includeLocationHistory>").append("false").append("</includeLocationHistory>");
        str.append("<orderBy>");
        str.append("<desc>").append("pickupSla").append("</desc>");
        str.append("</orderBy>");
        str.append("<start>").append("1").append("</start>");
        str.append("<count>").append("10").append("</count>");
        str.append("</orderOutboundRequest>");
        //PropKit.use("D:\\BaiduNetdiskDownload\\QinHaiSenLin-Jfinal-layui-master\\Jfinal-layui\\src\\main\\resources\\config-dev.txt");
        SAXReader reader = new SAXReader();
        //Document document = reader.read(new File(PropKit.get("OTMSParsFile")));
        Document document = reader.read(new File("D:\\BaiduNetdiskDownload\\QinHaiSenLin-Jfinal-layui-master\\Jfinal-layui\\src\\main\\webapp\\WEB-INF\\OTMS\\pars.xml"));
        //System.out.println(XmlConverUtils.doc2String(document));
        /*String xmlStr = XmlConverUtils.doc2String(document);
        // = xmlStr.replaceAll("> ", ">");
        xmlStr = xmlStr.replaceAll("\"", "\\\"");
        String[] xmlDatas = xmlStr.split("\\r|\\n");
        StringBuilder xmlStrBuffer = new StringBuilder();
        for(int i=0; i< xmlDatas.length; i++) {
            xmlStrBuffer.append(xmlDatas[i].trim());
        }
        System.out.println(xmlStrBuffer.toString());*/
        //System.out.println(XmlConverUtils.xmltoJson(postXml("https://demo.otms.cn/ws/orderOutbound?_wadl", document.asXML())));
        System.out.println(getJson("https://app.360scm.com/SCM.TMS7.WebApi/Oauth/GetTokenByPassword?username=wmsdemo08&password=12345678"));
    }
}
