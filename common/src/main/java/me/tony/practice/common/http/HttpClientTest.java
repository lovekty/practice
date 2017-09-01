package me.tony.practice.common.http;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;

import java.io.IOException;

public class HttpClientTest {
    public static final String TEST_URL = "https://advtest.yidianzixun.com/dsp/adsrequest";

    @Test
    public void test() {
        HttpPost post = new HttpPost(TEST_URL);
        post.setHeader("Content-Type", "application/json; charset=UTF-8");
        post.setHeader("MaxRTB-version", "1.0");
        try (CloseableHttpClient client = HttpClients.createDefault(); CloseableHttpResponse response = client.execute(post)) {
            int statusCode = response.getStatusLine().getStatusCode();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
