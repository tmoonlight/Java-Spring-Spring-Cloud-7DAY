package com.cyyz.spt.platform.common.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 压缩
 * @author Administrator
 *
 */
public class SealYS {

    public static byte[] toByteArray(InputStream input) throws IOException {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096];
        int n = 0;
        while (-1 != (n = input.read(buffer))) {
            output.write(buffer, 0, n);
        }
        return output.toByteArray();
    }

    public static Map<String, Object>  compressionImage(byte[] image,String sealId) throws IOException {
        try {
            //InputStream msxx,
            //byte[] tempByte = toByteArray(msxx);
            int[] imgByte = byteToInt(image);
            ByteArrayInputStream buffin = new ByteArrayInputStream(image, 0, imgByte.length);

            BufferedImage bitmap = ImageIO.read(buffin);
            //BufferedImage bitmap = ImageIO.read(msxx);
            //Bitmap bitmap = new Bitmap(msxx);
            int width = bitmap.getWidth(null);
            int height = bitmap.getHeight(null);
            int width3 = width * 3;
            if (width3 % 4 != 0)
                width3 += 4 - width3 % 4;

            Color forecolor = new Color(255, 0, 0);//印章前景
            Color blockcolor = new Color(255, 255, 255);//印章背景
//        Color idcolor = new Color(0, 0, 255);//印章编码
//        Color foreflagcolor = new Color(192, 88, 207);//背景中的辅助识别特征
//        Color blockflagcolor = new Color(0, 255, 0);//前景中的辅助识别特征
            int[] imgMem = new int[22 + width * height];

            final byte m_foreground = 0x00;//印章前景
            final byte m_blockground = 0x01;//印章背景
//        final byte m_stampIDColor = 0x02;//印章编码
//        final byte m_foregroundflag = 0x03;//前景中的辅助识别特征
//        final byte m_backgroundflag = 0x04;//背景中的辅助识别特征

            int[] m_width = byteToInt(String.valueOf(width).getBytes());
            int[] m_height = byteToInt(String.valueOf(height).getBytes());
            int[] m_sid = byteToInt(String.valueOf(sealId).getBytes());
            for (int i1 = 0; i1 < 13; i1++) {
                imgMem[i1] = (byte) m_sid[i1];

            }
            for (int i1 = 13; i1 < 13 + m_width.length; i1++) {
                imgMem[i1] = (byte) m_width[i1 - 13];

            }
            for (int i1 = 17; i1 < 17 + m_height.length; i1++) {
                imgMem[i1] = (byte) m_height[i1 - 17];
            }

            String t = "2";
            imgMem[21] = (byte) t.charAt(0);


            for (int i = height - 1; i >= 0; i--) {
                for (int j = 0; j < width; j++) {
                    int bmpHeadLen = 54;
                    int m_blue = imgByte[width3 * i + j * 3 + bmpHeadLen];//width像素宽
                    int m_greed = imgByte[width3 * i + j * 3 + 1 + bmpHeadLen];//width像素宽
                    int m_red = imgByte[width3 * i + j * 3 + 2 + bmpHeadLen];//width像素宽
                    Color rgb = new Color(m_red, m_greed, m_blue);

                    if (rgb.equals(blockcolor))//印章背景
                        imgMem[22 + width * (height - i - 1) + j] = (byte) m_blockground;
                    else//印章前景
                        imgMem[22 + width * (height - i - 1) + j] = (byte) m_foreground;


//                if (rgb.equals(blockcolor))//印章背景
//                    imgMem[22 + width * (height - i - 1) + j] = (byte)m_blockground;
//
//                else if (rgb.equals(foreflagcolor))////背景中的辅助识别特征
//                    imgMem[22 + width * (height - i - 1) + j] = (byte)m_backgroundflag;
//
//                else if (rgb.equals(blockflagcolor))//前景中的辅助识别特征
//                    imgMem[22 + width * (height - i - 1) + j] = (byte)m_foregroundflag;
//
//                else if (rgb.equals(forecolor) || (m_blue < 189 && m_greed < 189 && m_red < 189))//印章前景
//                    imgMem[22 + width * (height - i - 1) + j] = (byte)m_foreground;
//
//                else if (rgb.equals(idcolor) || (m_greed == 255 && m_blue < 255 && m_red < 255))//印章编码
//                    imgMem[22 + width * (height - i - 1) + j] = (byte)m_stampIDColor;
//
//                else
//                    imgMem[22 + width * (height - i - 1) + j] = (byte)m_blockground;//印章背景
                }
            }

//        private byte[] data;
//        private double width;
//        private double height;

            int[] ysBitmap = imgys(width, height, imgMem);
            if (null != ysBitmap && ysBitmap.length > 0) {
                byte[] byteImage = intToByte(ysBitmap);
                if (null != byteImage && byteImage.length > 0) {
                    Map<String, Object> resMap = new HashMap<String, Object>();
                    resMap.put("data", byteImage);
                    resMap.put("width", width);
                    resMap.put("height", height);
                    return resMap;
                }
            }
        } catch (RuntimeException e) {
        }
        return null;
    }

    private static int[] byteToInt(byte[] byt){
        int[] it = new int[byt.length];
        for(int i=0;i<byt.length;i++){
            it[i]=byt[i] & 0xff;
        }
        return it;
    }

    public static byte[] intToByte(int[] it){
        byte[] byt = new byte[it.length];
        for(int i=0;i<it.length;i++){
            byt[i]=(byte)it[i];
        }
        return byt;
    }

    private static int[] imgys(int nWidth, int nHeight, int[] imgByte){
        int fristDataLen = 22;
        //int fristDataLen = 1;
        int[] binByte = new int[nWidth * nHeight];

        for (int i = 0; i < fristDataLen - 1; i++)
            binByte[i] = imgByte[i];
        String t = "3";

        //BinByte[fristDataLen-1] = (byte)t[1];
        binByte[fristDataLen - 1] = t.charAt(0);
        int imgQJ = 0;
        int imgBJ = 0x20;
        //byte ImgBM = 0x40;
        //byte ImgQJTZ = 0x60;
        //byte ImgBJTZ = 0x80;
        int nByte, tZ;
        int j = 0;
        int k, temp;
        int templen = 0;
        k = 0;


        for (int i = 0; i < nHeight; i++)
        {
            while (j < nWidth)
            {
                int tempValue = fristDataLen + i * nWidth + j;
                temp = imgByte[tempValue];

                tZ = imgQJ;
                switch (temp)
                {
                    case 0://前景颜色
                    {
                        while ((fristDataLen + i * nWidth + j < imgByte.length) && (imgByte[fristDataLen + i * nWidth + j] == 0) && (j < nWidth))
                        {
                            templen++;
                            j++;
                        }

                        if (templen < 32)
                        {

                            //BinByte[fristDataLen + k] = TZ + templen;
                            binByte[fristDataLen + k] = (tZ + templen);

                            templen = 0;
                            nByte = 0;
                            k++;
                        }
                        else
                        {
                            tZ = 0xc0;
                            //nByte = templen / 256; //取得倍数；
                            nByte = (templen / 256);

                            //BinByte[fristDataLen + k] = TZ + nByte;
                            binByte[fristDataLen + k] = (tZ + nByte);

                            k++;
                            //nByte = templen % 256;
                            nByte = (templen % 256);

                            binByte[fristDataLen + k] = nByte;
                            k++;
                            templen = 0;
                            nByte = 0;
                        };
                        if (j == nWidth) //行结束0
                        {
                            binByte[fristDataLen + k] = 0;
                            templen = 0;
                            nByte = 0;
                            k++;

                        }
                    }
                    break;
                    case 1:      //背景
                    {
                        tZ = imgBJ;

                        while ((fristDataLen + i * nWidth + j < imgByte.length) && (imgByte[fristDataLen + i * nWidth + j] == 1) && (j < nWidth))
                        {
                            templen++;
                            j++;
                        }

                        if (j >= nWidth - 1)
                        {
                            binByte[fristDataLen + k] = 0;
                            templen = 0;
                            nByte = 0;
                            k++;
                        }
                        else
                        {
                            if (templen < 32)
                            {
                                //BinByte[fristDataLen + k] = TZ + templen;
                                binByte[fristDataLen + k] = (tZ + templen);

                                templen = 0;
                                k++;
                            }
                            else
                            {
                                tZ = 0xa0;
                                //nByte = templen / 256; //取得倍数；
                                nByte = (templen / 256);

                                //BinByte[fristDataLen + k] = TZ + nByte;
                                binByte[fristDataLen + k] = (tZ + nByte);

                                k++;
                                //nByte = templen % 256;
                                nByte = (templen % 256);

                                binByte[fristDataLen + k] = nByte;
                                k++;
                                templen = 0;
                                nByte = 0;
                                //k := k+1
                            }
                        }
                    }
                    break;
                    case 2:
                    {
                        tZ = 0x40;
                        while ((fristDataLen + i * nWidth + j < imgByte.length) && (imgByte[fristDataLen + i * nWidth + j] == 2) && (j < nWidth) && (templen < 31))
                        {
                            templen++;
                            j++;

                        }
                        //BinByte[fristDataLen + k] = TZ + templen;
                        binByte[fristDataLen + k] = (tZ + templen);

                        k++;
                        templen = 0;
                        if (j == nWidth)
                        {
                            binByte[fristDataLen + k] = 0;
                            templen = 0;
                            nByte = 0;
                            k++;
                        }
                    }
                    break;
                    case 3:
                    {
                        tZ = 0x60;
                        while ((fristDataLen + i * nWidth + j < imgByte.length) && (imgByte[fristDataLen + i * nWidth + j] == 3) && (j < nWidth) & (templen < 31))
                        {
                            templen++;
                            j++;

                        }
                        //BinByte[fristDataLen + k] = TZ + templen;
                        binByte[fristDataLen + k] = (tZ + templen);

                        k++;
                        templen = 0;
                        if (j == nWidth)
                        {
                            binByte[fristDataLen + k] = 0;
                            templen = 0;
                            nByte = 0;
                            k++;
                        }
                    }
                    break;
                    case 4:
                    {
                        tZ = 0x80;
                        while ((fristDataLen + i * nWidth + j < imgByte.length) && (imgByte[fristDataLen + i * nWidth + j] == 4) && (j < nWidth) && (templen < 31))
                        {
                            templen++;
                            j++;

                        }
                        //BinByte[fristDataLen + k] = TZ + templen;
                        binByte[fristDataLen + k] = (tZ + templen);

                        templen = 0;
                        k++;
                        if (j == nWidth)
                        {
                            binByte[fristDataLen + k] = 0;
                            templen = 0;
                            nByte = 0;
                            k++;
                        }
                    }
                    break;
                    default:
                    {
                        j++;
                    }
                    break;
                }
            }
            j = 0;

        }
        k += fristDataLen;
        //int nBackL = k;

        //byte* pBuf=new byte[k] ;
        //memcpy(pBuf,BinByte,k);
        //delete BinByte;
        //return pBuf;

        int[] rbt = new int[k];
        System.arraycopy(binByte, 0, rbt, 0, k);

        return rbt;
    }

    public static void main(String[] args) {
//        try {
//            File file = new File("D:\\image\\lAPPBbCc1VPGKHTNAX7NAYs_395_382.bmp");
//            FileInputStream fis = new FileInputStream(file);
//            int[] bt = getEYsByte(fis,"e440301000010");
//            byte[] byte1=intToByte(bt);
//            SealJY.jyTest(byte1,"D://image//xxddddsdsfsd.bmp");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

}
