package cn.cps.springbootexample.bdqn.utils;

import cn.cps.springbootexample.bdqn.core.R;
import cn.cps.springbootexample.bdqn.core.Result;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author: Cai Peishen
 * @Date: 2020/6/29 12:04
 * @Description: 文件工具类
 */
public class FileUtils {

    /**
     * 单文件上传，文件名是input标签的value属性值
     * @param upLoadPath 上传到服务器的目录
     * @param request request请求
     * @return
     */
    public static Result upLoadFile(String upLoadPath, HttpServletRequest request) {
        //获取目录路径
        String dirPath = request.getSession().getServletContext().getRealPath(upLoadPath);
        //图片访问的URI
        String returnUrl = request.getScheme() + ":" + File.separator + File.separator + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + upLoadPath;
        try {
            List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
            if (files.size() < 1) {
                return R.genFailResult("请选择文件!");
            }
            MultipartFile upLoadFile = files.get(0);
            if (upLoadFile.isEmpty()) {
                return R.genFailResult("文件为空");
            }
            if (upLoadFile.getSize() > (3 * 1024 * 1024)) {//如果大于3M的话不上传
                return R.genFailResult("文件大小超过3M");
            }
            // 获取文件名带后缀
            String fileName = upLoadFile.getOriginalFilename();
            // 获取文件名
            String prefixName = fileName.substring(0, fileName.lastIndexOf("."));
            // 获取后缀名
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            if(!suffixName.equalsIgnoreCase(".BMP") && !suffixName.equalsIgnoreCase(".JPG") && !suffixName.equalsIgnoreCase(".JPEG") && !suffixName.equalsIgnoreCase(".PNG")){
                return R.genFailResult("请选择图片!");
            }
            //上传到服务器文件名
            fileName = prefixName + "_" + new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()) + suffixName;
            // 文件路径
            String realPath = dirPath + File.separator + fileName;

            System.out.println(realPath);
            System.out.println(returnUrl+File.separator+fileName);
            //System.out.println("文件大小:" + upLoadFile.getSize() / 1024 + "KB");

            File dest = new File(realPath);
            // 检测是否存在目录
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();// 新建文件夹
            }
            upLoadFile.transferTo(dest);// 文件写入
            return R.genSuccessResult(returnUrl+File.separator+fileName);
        } catch (Exception e) {
            return R.genFailResult("出现异常:" + e);
        }
    }


    /**
     * 下载文件
     * @param fileName 文件名
     * @param upLoadPath 文件所在的目录
     * @param response
     * @return
     */
    public static Result downLoadFile(String fileName, String upLoadPath,HttpServletRequest request, HttpServletResponse response) {

        //获取目录路径
        String dirPath = request.getSession().getServletContext().getRealPath(upLoadPath);

        FileInputStream fis = null;
        BufferedInputStream bis = null;
        try {
            // 设置文件路径
            String filePath = dirPath + File.separator + fileName;
            File file = new File(filePath);
            if (file.exists()) {
                //响应到客户端
                try {
                    setResponseHeader(fileName,response);
                    byte[] buffer = new byte[1024];
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    os.flush();
                    os.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return R.genSuccessResult("下载成功!");
            }
            return R.genFailResult("文件不存在，下载失败!");
        } catch (Exception e) {
            return R.genFailResult("出现异常:" + e);
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 删除文件
     * @param fileName 文件名
     * @param upLoadPath 文件所在的目录
     * @return
     */
    public static boolean removeFile(String fileName, String upLoadPath,HttpServletRequest request) {
        //获取目录路径
        String dirPath = request.getSession().getServletContext().getRealPath(upLoadPath);
        boolean result = false;
        File file = null;
        String filePath = dirPath + File.separator + fileName;
        if (filePath!=null && !"".equals(filePath)) {
            file = new File(filePath);
        }
        // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
        if (file.exists() && file.isFile()) {
            if (!file.delete()) {
                return result;
            }
            result = true;
        }
        return result;
    }

    //发送响应流方法
    public static void setResponseHeader(String fileName, HttpServletResponse response) {
        try {
            try {
                fileName = new String(fileName.getBytes("GBK"), "ISO8859-1");
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            response.setContentType("application/octet-stream;charset=ISO8859-1");
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}