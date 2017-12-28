package me.tony.practice.common.json;

import net.sf.json.JSONObject;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.junit.Test;

import java.io.IOException;
import java.util.Map;

public class JsonTest {

    static String toTest = "{\"id\":\"2795808f3f1904837a16b1a41cedc920\",\"imp\":[{\"id\":\"3\",\"tagid\":\"1.1.b.12\",\"admtype\":2,\"bidfloor\":0.0,\"templates\":[{\"id\":\"1.5\",\"width\":1040,\"height\":467}],\"adsCount\":1,\"ext\":\"{\\\"experienceStatus\\\":\\\"0\\\",\\\"experienceDebugOnlineIfo\\\":\\\"{}\\\",\\\"experienceFlag\\\":\\\"LEVEL3\\\",\\\"experienceMessage\\\":\\\"Do not need experience filter!\\\"}\"}],\"app\":{\"name\":\"MiuiVideo\",\"bundle\":\"com.miui.video\",\"ver\":\"2016122090\"},\"device\":{\"ip\":\"27.42.107.89\",\"devicetype\":2,\"make\":\"xiaomi\",\"model\":\"2014812\",\"os\":\"android\",\"osv\":\"4.4.4\",\"h\":1080,\"w\":720,\"js\":0,\"language\":\"zh\",\"connectiontype\":2,\"didmd5\":\"d886621056f9197596797e3002f9074f\",\"dpid\":\"7b0445ae13cbe0d8\"},\"test\":0,\"at\":2,\"tmax\":0,\"ext\":\"[\\\"{\\\\\\\"id\\\\\\\":\\\\\\\"3\\\\\\\",\\\\\\\"slotid\\\\\\\":1145102,\\\\\\\"app_id\\\\\\\":1145}\\\"]\"}";


    @Test
    public void test() {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        try {
            Map<String, Object> map = objectMapper.readValue(toTest, new TypeReference<Map<String, Object>>() {
            });
            System.out.println(map);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testJson() {
        JSONObject p = new JSONObject();
        JSONObject c = new JSONObject();
        p.put("code", 0);
        c.put("ck", "cv");
        p.put("data", c);
        p.getJSONObject("data").put("foo", "bar");
        System.out.println(p);
    }
}
