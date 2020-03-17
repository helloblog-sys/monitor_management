package com.microthings.monitor_management.util;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * @ClassName CheckCode
 * Description 验证码工具类
 * @Author hms
 * @Date 2019/11/6 20:04
 * @Version 1.0
 **/
public class CheckCode {

    private int width = 108;// 定义图片的width
    private int height = 35;// 定义图片的height
    private int codeCount = 4;// 定义图片上显示验证码的个数
    private int xx = 17;//字符间距
    private int fontHeight = 28;//字符高度
    private int codeY = 30;//字符Y轴高度
    private char[] codeSequence = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
            'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getCodeCount() {
        return codeCount;
    }

    public void setCodeCount(int codeCount) {
        this.codeCount = codeCount;
    }

    public int getXx() {
        return xx;
    }

    public void setXx(int xx) {
        this.xx = xx;
    }

    public int getFontHeight() {
        return fontHeight;
    }

    public void setFontHeight(int fontHeight) {
        this.fontHeight = fontHeight;
    }

    public int getCodeY() {
        return codeY;
    }

    public void setCodeY(int codeY) {
        this.codeY = codeY;
    }

    public char[] getCodeSequence() {
        return codeSequence;
    }

    public void setCodeSequence(char[] codeSequence) {
        this.codeSequence = codeSequence;
    }

   /** 
   * @Description: 生成指定长度的字符
   * @Param: []
   * @return: java.lang.String 
   * @Author: hms
   * @Date: 2019/11/6 20:06
   */ 
    public String getRandomCodeStr() {
        // 创建一个随机数生成器类
        Random random = new Random();
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < codeCount; i++) {
            String code = String.valueOf(codeSequence[random.nextInt(codeSequence.length - 1)]);
            result.append(code);
        }
        return result.toString();
    }

    /**
    * @Description: 生成图像
    * @Param: [code]
    * @return: java.awt.image.BufferedImage
    * @Author: hms
    * @Date: 2019/11/6 20:07
    */
    public BufferedImage getImgCode(String code) {
        // 定义图像buffer
        BufferedImage buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics gd = buffImg.getGraphics();
        // 将图像填充为白色
        gd.setColor(Color.WHITE);
        gd.fillRect(0, 0, width, height);
        // 创建字体，字体的大小应该根据图片的高度来定。
        Font font = new Font("Fixedsys", Font.BOLD, fontHeight);
        // 设置字体。
        gd.setFont(font);
        // 画边框。
        gd.setColor(Color.BLACK);
        // 创建一个随机数生成器类
        Random random = new Random();
        gd.drawRect(0, 0, width - 1, height - 1);
        // 随机产生40条干扰线，使图象中的认证码不易被其它程序探测到。
        gd.setColor(Color.BLACK);
        for (int i = 0; i < 40; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(20);
            int yl = random.nextInt(12);
            gd.drawLine(x, y, x + xl, y + yl);
        }
        int red = 0, green = 0, blue = 0;
        // 随机产生codeCount数字的验证码。
        for (int i = 0; i < code.length(); i++) {
            // 产生随机0-188的颜色分量来构造颜色值，这样输出的每位数字的颜色值都将不同,取188是为了避免字体颜色太亮与白底难以区分。
            String codeOne = code.substring(i, i + 1);
            red = random.nextInt(188);//
            green = random.nextInt(188);
            blue = random.nextInt(188);
            // 用随机产生的颜色将验证码绘制到图像中。
            gd.setColor(new Color(red, green, blue));
            gd.drawString(codeOne, (i + 1) * xx, codeY);
        }
        return buffImg;
    }
}
