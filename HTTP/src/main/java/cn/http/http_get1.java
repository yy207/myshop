package cn.http;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

 public class http_get1 {
    // public static final String path =
    // "http://192.168.137.103:8080/MyHttp/servlet/LoginAction";
    public static final String path = "http://localhost:8080/MyHttp/servlet/LoginAction";
    public static String getStringFromStream(InputStream is) {
        String str = "";
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        int len = 0;
        byte[] data = new byte[1024];
        if(is!=null){
            try {
                while ((len = is.read(data)) != -1) {
                    bos.write(data, 0, len);
                }
                str = new String(bos.toByteArray(), "utf-8");
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
         }
        return str;
    }
 public static InputStream useGetMethod(Map<String, String> map, String encode) {
        InputStream is = null;
        StringBuffer sb = new StringBuffer(path);
        sb.append("?");
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, String> entry : map.entrySet()) {     
            	sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
            sb.deleteCharAt(sb.length() - 1);
            System.out.println(sb.toString());
            URL url = null;
            OutputStream os = null;
            try {
                url = new URL(sb.toString());
                if (url != null) {
                    HttpURLConnection con = (HttpURLConnection) url
                            .openConnection();
                    con.setRequestMethod("GET");
                    con.setConnectTimeout(3000);
                    con.setDoInput(true);
                    con.setDoOutput(true);
                    os = con.getOutputStream();
                    os.write(sb.toString().getBytes(encode));
                    os.close();
                    if (con.getResponseCode() == 200) {
                        is = con.getInputStream();
                    }
                }
             } catch (Exception e) {
               }
         }
         return is;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Map<String, String> map = new HashMap<String, String>();
        map.put("username", "admin");
        map.put("password", "1243");
        String str = getStringFromStream(useGetMethod(map, "utf-8"));
        System.out.println(str);
    }
 } 