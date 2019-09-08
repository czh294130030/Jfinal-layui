package com.qinhailin.task;

import com.jfinal.kit.JsonKit;
import com.jfinal.kit.PropKit;
import com.jfinal.log.Log;
import com.qinhailin.common.kit.HttpKit;
import com.qinhailin.common.util.XmlConverUtils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

import java.io.File;

public class FetchOrderJob implements Runnable{
    @Override
    public void run() {
        /*SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(new File(PropKit.get("OTMSParsFile")));
            String otmsResult = XmlConverUtils.xmltoJson(HttpKit.postXml("https://demo.otms.cn/ws/orderOutbound?_wadl", document.asXML()));
            JSONObject jsonObject = JSONObject.fromObject(otmsResult);
            if(jsonObject!=null) {
                int total = jsonObject.getInt("total");
                int start = jsonObject.getInt("start");
                int count = jsonObject.getInt("count");
                JSONArray orderArray = jsonObject.getJSONArray("orders");
                if(orderArray!=null && orderArray.size()>0) {
                    String tokenResult = HttpKit.getJson(PropKit.get("TMSGetTokenURL"));
                    JSONObject tokenObject = JSONObject.fromObject(tokenResult);
                    String token = "";
                    if(tokenObject!=null && tokenObject.getBoolean("flag")) {
                        token = tokenObject.getString("token");

                    } else {
                    }
                }
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }*/
    }
}
