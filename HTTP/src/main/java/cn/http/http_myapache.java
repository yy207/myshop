package cn.http;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

public class http_myapache {
    public static InputStream useApacheMethod(Map<String, String> map,
            String encode) {
        InputStream is = null;
        List<NameValuePair> list = new ArrayList<NameValuePair>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            list.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }
        try {
            // 封装请求参数
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, encode);
            // 设置请求参数
            HttpPost post = new HttpPost(http_get1.path);
            post.setEntity(entity);
            // 执行请求
            DefaultHttpClient client = new DefaultHttpClient();
            HttpResponse response = client.execute(post);
            // 获取状态码
            if (response.getStatusLine().getStatusCode() == 200) {
                is = response.getEntity().getContent();
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return is;
    }
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("username", "admin");
        map.put("password", "123");
        System.out.println(http_get1.getStringFromStream(useApacheMethod(map, "utf-8")));
    } 
}
