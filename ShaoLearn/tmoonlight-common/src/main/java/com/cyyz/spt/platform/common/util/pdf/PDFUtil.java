package com.cyyz.spt.platform.common.util.pdf;


import com.itextpdf.text.pdf.BaseFont;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Map;

public class PDFUtil {

    public static final float DEFAULT_DPI=105;
    public static final String TMP_DIR = System.getProperty("java.io.tmpdir");
    public static final String FONT = "font/msyh.ttf";
    private static final Logger LOGGER = LoggerFactory.getLogger(PDFUtil.class);

    /**
     * freemarker渲染html
     */
    public static String freeMarkerRender(Map<String, Object> data, String htmlFile) {
        LOGGER.info("[info]创建HTML模板");
        Configuration freemarkerCfg = new Configuration();
        freemarkerCfg.setClassForTemplateLoading(PDFUtil.class, "/");
        try (Writer out = new StringWriter()) {
            // 获取模板,并设置编码方式
            Template template = freemarkerCfg.getTemplate(htmlFile);
            template.setEncoding("UTF-8");
            // 合并数据模型与模板
            template.process(data, out);
            //将合并后的数据和模板写入到流中，这里使用的字符流
            out.flush();
            return out.toString();
        } catch (Exception e) {
            LOGGER.error("[error]创建HTML模板失败");
        }
        return "";
    }

    /**
     * 创建PDF，返回pdf路径
     * bean.htmlFile   html模板（包含路径、文件名）、必填
     * bean.pdfName    生成pdf的文件名、必填
     * bean.data       填充到html模板中的数据、必填
     */
    public static String createPdf(PDFBean bean) throws IOException, com.lowagie.text.DocumentException {

        String htmlString = freeMarkerRender(bean.getData(), bean.getHtmlFile());

        ITextRenderer render = new ITextRenderer();
        ITextFontResolver fontResolver = render.getFontResolver();
        fontResolver.addFont(FONT, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        // 解析html生成pdf
        render.setDocumentFromString(htmlString);
        render.layout();

        //服务器/tmp路径
        File file = new File(TMP_DIR);
        if (!file.exists()) {
            file.mkdirs();
        }
        String pdfFile = TMP_DIR + File.separator + bean.getPdfName();
        LOGGER.info("[info]开始创建pdf：" + pdfFile);

        render.createPDF(new FileOutputStream(pdfFile));

        LOGGER.info("[info]pdf创建成功：" + pdfFile);

        return pdfFile;
    }

    /**
     * pdf转图片，只能生成一张涂片
     * @param pdfPath PDF路径
     * @return 图片路径
     */
    public static String pdfToImage(String pdfPath){
        String imgPath = "";
        try{
            if(pdfPath==null||"".equals(pdfPath)||!pdfPath.endsWith(".pdf"))
                return "";

            //图像合并使用参数
            int width = 0; // 总宽度
            int[] singleImgRGB; // 保存一张图片中的RGB数据
            int shiftHeight = 0;
            BufferedImage imageResult = null;//保存每张图片的像素值
            //利用PdfBox生成图像
            PDDocument pdDocument = PDDocument.load(new File(pdfPath));
            PDFRenderer renderer = new PDFRenderer(pdDocument);
            //循环每个页码
            for(int i=0,len=pdDocument.getNumberOfPages(); i<len; i++){
                BufferedImage image=renderer.renderImageWithDPI(i, DEFAULT_DPI, ImageType.RGB);
                int imageHeight=image.getHeight();
                int imageWidth=image.getWidth();
                if(i==0){//计算高度和偏移量
                    width=imageWidth;//使用第一张图片宽度;
                    //保存每页图片的像素值
                    imageResult= new BufferedImage(width, imageHeight*len, BufferedImage.TYPE_INT_RGB);
                }else{
                    shiftHeight += imageHeight; // 计算偏移高度
                }
                singleImgRGB= image.getRGB(0, 0, width, imageHeight, null, 0, width);
                imageResult.setRGB(0, shiftHeight, width, imageHeight, singleImgRGB, 0, width); // 写入流中
            }
            pdDocument.close();
            //File outFile = new File(pdfPath.replace(".pdf", "_"+DEFAULT_DPI+".jpg"));
            imgPath = pdfPath.replace(".pdf", ".jpg");
            File outFile = new File(imgPath);
            ImageIO.write(imageResult, "jpg", outFile);// 写图片
        }catch (Exception e) {
            e.printStackTrace();
        }
        return imgPath;

    }
}



