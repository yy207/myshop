package cn.http;

import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.Charsets;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;

public class MHttpClient {
    public void get(String url) throws Exception {
        // 创建HttpClient实例
        HttpClient client =  HttpClientBuilder.create().build();
        // 根据URL创建HttpGet实例
        HttpGet get = new HttpGet(url);
        // 执行get请求，得到返回体
        HttpResponse response = client.execute(get);
        // 判断是否正常返回
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            // 解析数据
            String data = EntityUtils.toString(response.getEntity(),Charsets.UTF_8);
            System.out.println(data);
        }
    }
 
    public void post(String url) throws Exception {
        // 创建HttpClient实例
        HttpClient client = HttpClientBuilder.create().build();
        // 根据URL创建HttpPost实例
        HttpPost post = new HttpPost(url);
        // 构造post参数
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("name", "11"));
        // 编码格式转换
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params);
        // 传入请求体
        post.setEntity(entity);
        // 发送请求，得到响应体
        HttpResponse response = client.execute(post);
        // 判断是否正常返回
        if (response.getStatusLine().getStatusCode() == 200) {
            // 解析数据
            HttpEntity resEntity = response.getEntity();
            String data = EntityUtils.toString(resEntity);
            System.out.println(data);
        }
    }
    
    public static void main(String[] args) throws Exception {
        MHttpClient cl = new MHttpClient();
        String url = "http://www.xbiquge.la/xiaoshuodaquan/";
        cl.get(url);
    }

}