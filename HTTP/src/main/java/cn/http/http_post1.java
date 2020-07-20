package cn.http;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class http_post1 {
    // 使用POST请求与GET请求的区别就是POST请求不需要封装请求路径，只需要封装请求参数
    public static InputStream usePostMethod(Map<String, String> map,
            String encode) {
        StringBuffer buffer = new StringBuffer();
        InputStream is = null;
        OutputStream os = null;
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                try {
                    buffer.append(entry.getKey()).append("=")
                            .append(entry.getValue())
                            // .append(URLEncoder.encode(entry.getValue(),
                            // encode))
                            .append("&");
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            buffer.deleteCharAt(buffer.length() - 1);
            System.out.println(buffer.toString());
        }
        try {
            URL url = new URL(http_get1.path);
            if (url != null) {
                HttpURLConnection con = (HttpURLConnection) url
                        .openConnection();
                con.setDoInput(true);
                con.setDoOutput(true);
                con.setRequestMethod("POST");
                con.setConnectTimeout(3000);
                byte[] tdata = buffer.toString().getBytes();
                // con.setRequestProperty("Content-Type",
                // "application/x-www-form-urlencoded");
                // con.setRequestProperty("Content-Length",
                // String.valueOf(tdata.length));
                os = con.getOutputStream();
                os.write(tdata);
                os.close();
                if (con.getResponseCode() == 200) {
                    is = con.getInputStream();
                }
            }
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return is;
    }
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("username", "admin");
        map.put("password", "123");        System.out.println(http_get1.getStringFromStream(usePostMethod(map,
                "utf-8")));
    }
 } 