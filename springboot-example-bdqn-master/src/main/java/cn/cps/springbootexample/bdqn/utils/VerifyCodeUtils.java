package cn.cps.springbootexample.bdqn.utils;

import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Random;


public class VerifyCodeUtils {


    //使用到Algerian字体，系统里没有的话需要安装字体，字体只显示大写，去掉了1,0,i,o几个容易混淆的字符
    public static final String VERIFY_CODES = "23456789ABCDEFGHJKLMNPQRSTUVWXYZ";
    public static final String VERIFY_CODE = "verify_code";

    private static Random random = new Random();


    /**
     * 使用系统默认字符源生成验证码
     * @param verifySize    验证码长度
     * @return
     */
    public static String generateVerifyCode(int verifySize){
        return generateVerifyCode(verifySize, VERIFY_CODES);
    }

    /**
     * 使用指定源生成验证码
     * @param verifySize    验证码长度
     * @param sources   验证码字符源
     * @return
     */
    public static String generateVerifyCode(int verifySize, String sources){
        if(sources == null || sources.length() == 0){
            sources = VERIFY_CODES;
        }
        int codesLen = sources.length();
        Random rand = new Random(System.currentTimeMillis());
        StringBuilder verifyCode = new StringBuilder(verifySize);
        for(int i = 0; i < verifySize; i++){
            verifyCode.append(sources.charAt(rand.nextInt(codesLen-1)));
        }
        return verifyCode.toString().toUpperCase();
    }

    /**
     * 生成随机验证码文件,并返回验证码值
     * @param w
     * @param h
     * @param outputFile
     * @param verifySize
     * @return
     * @throws IOException
     */
    public static String outputVerifyImage(int w, int h, File outputFile, int verifySize) throws IOException{
        String verifyCode = generateVerifyCode(verifySize);
        outputImage(w, h, outputFile, verifyCode);
        return verifyCode;
    }

    /**
     * 输出随机验证码图片流,并返回验证码值
     * @param w
     * @param h
     * @param os
     * @param verifySize
     * @return
     * @throws IOException
     */
    public static String outputVerifyImage(int w, int h, OutputStream os, int verifySize) throws IOException{
        String verifyCode = generateVerifyCode(verifySize);
        outputImage(w, h, os, verifyCode);
        return verifyCode;
    }

    /**
     * 生成指定验证码图像文件
     * @param w
     * @param h
     * @param outputFile
     * @param code
     * @throws IOException
     */
    public static void outputImage(int w, int h, File outputFile, String code) throws IOException{
        if(outputFile == null){
            return;
        }
        File dir = outputFile.getParentFile();
        if(!dir.exists()){
            dir.mkdirs();
        }
        try{
            outputFile.createNewFile();
            FileOutputStream fos = new FileOutputStream(outputFile);
            outputImage(w, h, fos, code);
            fos.close();
        } catch(IOException e){
            throw e;
        }
    }

    /**
     * 输出指定验证码图片流
     * @param w
     * @param h
     * @param os
     * @param code
     * @throws IOException
     */
    public static void outputImage(int w, int h, OutputStream os, String code) throws IOException{
        int verifySize = code.length();
        BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_BGR);
        Graphics2D g2 = image.createGraphics();
        g2.setBackground(Color.WHITE);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        Color[] colorSpaces = new Color[] { Color.WHITE, Color.CYAN,
                Color.GRAY, Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE,
                Color.PINK, Color.YELLOW };
//        Color[] colors = new Color[5];
//        float[] fractions = new float[colors.length];
//        for(int i = 0; i < colors.length; i++){
//            colors[i] = colorSpaces[random.nextInt(colorSpaces.length)];
//            fractions[i] = random.nextFloat();
//        }
//        Arrays.sort(fractions);

        //设置背景色
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, w, h);

        //Color c = getRandColor(200, 250);
        //g2.setColor(c);// 设置背景色
        //g2.fillRect(0, 2, w, h-4);

        //绘制干扰线
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            int x = random.nextInt(w - 1);
            int y = random.nextInt(h - 1);
            int xl = random.nextInt(6) + 1;
            int yl = random.nextInt(12) + 1;
            g2.setColor(colorSpaces[random.nextInt(colorSpaces.length)]);// 设置线条的颜色
            g2.drawLine(x, y, x + xl + 40, y + yl + 20);
        }

        /*
         * 绘制表格(横线、竖线)
         * 设置表格线条的颜色
         */
        g2.setColor(new Color(134,192,253));

        /*
         * 绘制横线
         * 循环横线切割的次数 但因为切割竖线，所以这里的尾坐标跟竖线有关
         * (0,0) -> (20,0)
         * (0,5) -> (20,5)
         * (0,10) -> (20,10)
         *  ······
         */
        for (int i = 0; i < h; i+=5) {
            g2.drawLine(0, i, w, i);
        }

        /*
         * 绘制竖线
         * 循环横线切割的次数 但因为切割横线，所以这里的尾坐标跟横线有关
         * (0,0) -> (0,15)
         * (5,0) -> (5,15)
         * (10,0) -> (10,15)
         *  ······
         */
        for (int i = 0; i < w; i+=5) {
            g2.drawLine(i, 0, i, h);
        }


        // 添加噪点
        float yawpRate = 0.05f;// 噪声率
        int area = (int) (yawpRate * w * h);
        for (int i = 0; i < area; i++) {
            int x = random.nextInt(w);
            int y = random.nextInt(h);
            int rgb = getRandomIntColor();
            image.setRGB(x, y, rgb);
        }

        //shear(g2, w, h, Color.WHITE);// 使图片扭曲

        g2.setColor(getRandColor(100, 160));
        int fontSize = h-4;
        Font font = new Font("Times New Roman", Font.ROMAN_BASELINE, fontSize);
        g2.setFont(font);
        char[] chars = code.toCharArray();

        //绘制字符串
        for(int i = 0; i < verifySize; i++){
            AffineTransform affine = new AffineTransform();
            affine.setToRotation(Math.PI / 4 * random.nextDouble() * (random.nextBoolean() ? 1 : -1), (w / verifySize) * i + fontSize/2, h/2);
            g2.setTransform(affine);
            g2.setFont(new Font("Fixedsys", Font.CENTER_BASELINE, 30));
            g2.setColor(new Color(random.nextInt(101), random.nextInt(111), random.nextInt(121)));
            g2.drawChars(chars, i, 1, ((w-10) / verifySize) * i + 5, h/2 + fontSize/2 - 10);
        }

        g2.dispose();
        ImageIO.write(image, "png", os);
    }

    /**
     * 返回ImgBase64验证码图片字符串
     * @param w
     * @param h
     * @param code
     * @throws IOException
     */
    public static String outputImageBase64(int w, int h,String code) throws IOException {
        int verifySize = code.length();
        BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_BGR);
        Graphics2D g2 = image.createGraphics();
        g2.setBackground(Color.WHITE);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        Color[] colorSpaces = new Color[] { Color.WHITE, Color.CYAN,
                Color.GRAY, Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE,
                Color.PINK, Color.YELLOW };
//        Color[] colors = new Color[5];
//        float[] fractions = new float[colors.length];
//        for(int i = 0; i < colors.length; i++){
//            colors[i] = colorSpaces[random.nextInt(colorSpaces.length)];
//            fractions[i] = random.nextFloat();
//        }
//        Arrays.sort(fractions);

        //设置背景色
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, w, h);

        //Color c = getRandColor(200, 250);
        //g2.setColor(c);// 设置背景色
        //g2.fillRect(0, 2, w, h-4);

        //绘制干扰线
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            int x = random.nextInt(w - 1);
            int y = random.nextInt(h - 1);
            int xl = random.nextInt(6) + 1;
            int yl = random.nextInt(12) + 1;
            g2.setColor(colorSpaces[random.nextInt(colorSpaces.length)]);// 设置线条的颜色
            g2.drawLine(x, y, x + xl + 40, y + yl + 20);
        }

        /**
         * 绘制表格(横线、竖线)
         * 设置表格线条的颜色
         */
        g2.setColor(new Color(134,192,253));

        /**
         * 绘制横线
         * 循环横线切割的次数 但因为切割竖线，所以这里的尾坐标跟竖线有关
         * (0,0) -> (20,0)
         * (0,5) -> (20,5)
         * (0,10) -> (20,10)
         *  ······
         */
        for (int i = 0; i < h; i+=5) {
            g2.drawLine(0, i, w, i);
        }

        /**
         * 绘制竖线
         * 循环横线切割的次数 但因为切割横线，所以这里的尾坐标跟横线有关
         * (0,0) -> (0,15)
         * (5,0) -> (5,15)
         * (10,0) -> (10,15)
         *  ······
         */
        for (int i = 0; i < w; i+=5) {
            g2.drawLine(i, 0, i, h);
        }


        // 添加噪点
        float yawpRate = 0.05f;// 噪声率
        int area = (int) (yawpRate * w * h);
        for (int i = 0; i < area; i++) {
            int x = random.nextInt(w);
            int y = random.nextInt(h);
            int rgb = getRandomIntColor();
            image.setRGB(x, y, rgb);
        }

        //shear(g2, w, h, Color.WHITE);// 使图片扭曲

        g2.setColor(getRandColor(100, 160));
        int fontSize = h-4;
        Font font = new Font("Times New Roman", Font.ROMAN_BASELINE, fontSize);
        g2.setFont(font);
        char[] chars = code.toCharArray();

        //绘制字符串
        for(int i = 0; i < verifySize; i++){
            AffineTransform affine = new AffineTransform();
            affine.setToRotation(Math.PI / 4 * random.nextDouble() * (random.nextBoolean() ? 1 : -1), (w / verifySize) * i + fontSize/2, h/2);
            g2.setTransform(affine);
            g2.setFont(new Font("Fixedsys", Font.CENTER_BASELINE, 30));
            g2.setColor(new Color(random.nextInt(101), random.nextInt(111), random.nextInt(121)));
            g2.drawChars(chars, i, 1, ((w-10) / verifySize) * i + 5, h/2 + fontSize/2 - 10);
        }

        g2.dispose();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "png", baos);
        byte[] bytes = baos.toByteArray();
        String format =  "data:image/png;base64,";
        String base64 = new BASE64Encoder().encodeBuffer(bytes).trim().replaceAll("\n", "").replaceAll("\r", "");

        return format.concat(base64);
    }

    private static Color getRandColor(int fc, int bc) {
        if (fc > 255)
            fc = 255;
        if (bc > 255)
            bc = 255;
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }

    private static int getRandomIntColor() {
        int[] rgb = getRandomRgb();
        int color = 0;
        for (int c : rgb) {
            color = color << 8;
            color = color | c;
        }
        return color;
    }

    private static int[] getRandomRgb() {
        int[] rgb = new int[3];
        for (int i = 0; i < 3; i++) {
            rgb[i] = random.nextInt(255);
        }
        return rgb;
    }

    private static void shear(Graphics g, int w1, int h1, Color color) {
        shearX(g, w1, h1, color);
        shearY(g, w1, h1, color);
    }

    private static void shearX(Graphics g, int w1, int h1, Color color) {

        int period = random.nextInt(2);

        boolean borderGap = true;
        int frames = 1;
        int phase = random.nextInt(2);

        for (int i = 0; i < h1; i++) {
            double d = (double) (period >> 1)
                    * Math.sin((double) i / (double) period
                    + (6.2831853071795862D * (double) phase)
                    / (double) frames);
            g.copyArea(0, i, w1, 1, (int) d, 0);
            if (borderGap) {
                g.setColor(color);
                g.drawLine((int) d, i, 0, i);
                g.drawLine((int) d + w1, i, w1, i);
            }
        }

    }

    private static void shearY(Graphics g, int w1, int h1, Color color) {

        int period = random.nextInt(40) + 10; // 50;

        boolean borderGap = true;
        int frames = 20;
        int phase = 7;
        for (int i = 0; i < w1; i++) {
            double d = (double) (period >> 1)
                    * Math.sin((double) i / (double) period
                    + (6.2831853071795862D * (double) phase)
                    / (double) frames);
            g.copyArea(i, 0, 1, h1, 0, (int) d);
            if (borderGap) {
                g.setColor(color);
                g.drawLine(i, (int) d, i, 0);
                g.drawLine(i, (int) d + h1, i, h1);
            }

        }
    }
    public static void main(String[] args) throws IOException{
        File dir = new File("C:/");
        int w = 200, h = 80;
        String verifyCode = generateVerifyCode(4);
        File file = new File(dir, verifyCode + ".png");
        outputImage(w, h, file, verifyCode);
    }
}