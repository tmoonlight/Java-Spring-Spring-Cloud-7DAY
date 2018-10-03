package com.cyyz.spt.platform.common.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ImgUtil {

	/**
	 * 实现图像的等比缩放
	 * 
	 * @param source
	 * @param targetW
	 * @param targetH
	 * @return
	 */
	public static BufferedImage resize(BufferedImage source, int targetW,
			int targetH) {
		// targetW，targetH分别表示目标长和宽
		int type = source.getType();
		BufferedImage target = null;
		double sx = (double) targetW / source.getWidth();
		double sy = (double) targetH / source.getHeight();
		// 这里想实现在targetW，targetH范围内实现等比缩放。如果不需要等比缩放
		// 则将下面的if else语句注释即可
		if (sx < sy) {
			sx = sy;
			targetW = (int) (sx * source.getWidth());
		} else {
			sy = sx;
			targetH = (int) (sy * source.getHeight());
		}
		if (type == BufferedImage.TYPE_CUSTOM) { // handmade
			ColorModel cm = source.getColorModel();
			WritableRaster raster = cm.createCompatibleWritableRaster(targetW,
					targetH);
			boolean alphaPremultiplied = cm.isAlphaPremultiplied();
			target = new BufferedImage(cm, raster, alphaPremultiplied, null);
		} else
			target = new BufferedImage(targetW, targetH, type);
		Graphics2D g = target.createGraphics();
		// smoother than exlax:
		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
				RenderingHints.VALUE_INTERPOLATION_BICUBIC);
		g.drawRenderedImage(source, AffineTransform.getScaleInstance(sx, sy));
		g.dispose();
		return target;
	}

	/**
	 * 实现图像的等比缩放和缩放后的截取
	 * 
	 * @param inFilePath
	 *            要截取文件的路径
	 * @param outFilePath
	 *            截取后输出的路径
	 * @param width
	 *            要截取宽度
	 * @param hight
	 *            要截取的高度
	 * @param proportion
	 * @throws Exception
	 */

	public static void saveImageAsJpg(String inFilePath, String outFilePath,
			int width, int hight, boolean proportion) throws Exception {
		File file = new File(inFilePath);
		InputStream in = new FileInputStream(file);
		File saveFile = new File(outFilePath);

		BufferedImage srcImage = ImageIO.read(in);
		if (width > 0 || hight > 0) {
			// 原图的大小
			int sw = srcImage.getWidth();
			int sh = srcImage.getHeight();
			// 如果原图像的大小小于要缩放的图像大小，直接将要缩放的图像复制过去
			if (sw > width && sh > hight) {
				srcImage = resize(srcImage, width, hight);
			} else {
				String fileName = saveFile.getName();
				String formatName = fileName.substring(fileName
						.lastIndexOf('.') + 1);
				ImageIO.write(srcImage, formatName, saveFile);
				return;
			}
		}
		// 缩放后的图像的宽和高
		int w = srcImage.getWidth();
		int h = srcImage.getHeight();
		// 如果缩放后的图像和要求的图像宽度一样，就对缩放的图像的高度进行截取
		if (w == width) {
			// 计算X轴坐标
			int x = 0;
			int y = h / 2 - hight / 2;
			saveSubImage(srcImage, new Rectangle(x, y, width, hight), saveFile);
		}
		// 否则如果是缩放后的图像的高度和要求的图像高度一样，就对缩放后的图像的宽度进行截取
		else if (h == hight) {
			// 计算X轴坐标
			int x = w / 2 - width / 2;
			int y = 0;
			saveSubImage(srcImage, new Rectangle(x, y, width, hight), saveFile);
		}
		in.close();
	}

	/**
	 * 实现缩放后的截图
	 * 
	 * @param image
	 *            缩放后的图像
	 * @param subImageBounds
	 *            要截取的子图的范围
	 * @param subImageFile
	 *            要保存的文件
	 * @throws IOException
	 */
	private static void saveSubImage(BufferedImage image,
			Rectangle subImageBounds, File subImageFile) throws IOException {
		if (subImageBounds.x < 0 || subImageBounds.y < 0
				|| subImageBounds.width - subImageBounds.x > image.getWidth()
				|| subImageBounds.height - subImageBounds.y > image.getHeight()) {
			System.out.println("Bad   subimage   bounds");
			return;
		}
		BufferedImage subImage = image.getSubimage(subImageBounds.x,
				subImageBounds.y, subImageBounds.width, subImageBounds.height);
		String fileName = subImageFile.getName();
		String formatName = fileName.substring(fileName.lastIndexOf('.') + 1);
		ImageIO.write(subImage, formatName, subImageFile);
	}

	/**
	 * 处理图片 ss
	 * 
	 * @param src
	 * @param new_w
	 * @param new_h
	 * @return
	 */
	public synchronized static BufferedImage disposeImage(BufferedImage src,
			int new_w, int new_h) {
		// 得到图片
		int old_w = src.getWidth();
		// 得到源图宽
		int old_h = src.getHeight();
		// 得到源图长
		BufferedImage newImg = null;
		// 判断输入图片的类型
		switch (src.getType()) {
		case 13:
			// png,gifnewImg = new BufferedImage(new_w, new_h,
			// BufferedImage.TYPE_4BYTE_ABGR);
			break;
		default:
			newImg = new BufferedImage(new_w, new_h, BufferedImage.TYPE_INT_RGB);
			break;
		}

		if (newImg != null) {
			Graphics2D g = newImg.createGraphics();
			// 从原图上取颜色绘制新图
			g.drawImage(src, 0, 0, old_w, old_h, null);
			g.dispose();
			// 根据图片尺寸压缩比得到新图的尺寸
			newImg.getGraphics().drawImage(
					src.getScaledInstance(new_w, new_h, Image.SCALE_SMOOTH), 0,
					0, null);
		}
		// 调用方法输出图片文件
		return newImg;
	}

	// 从服务器获得一个输入流(本例是指从服务器获得一个image输入流)
	public static InputStream getInputStream(String url_path) throws Exception {
		InputStream inputStream = null;
		HttpURLConnection httpURLConnection = null;
		URL url = new URL(url_path);
		httpURLConnection = (HttpURLConnection) url.openConnection();
		// 设置网络连接超时时间
		httpURLConnection.setConnectTimeout(6000);
		// 设置应用程序要从网络连接读取数据
		httpURLConnection.setDoInput(true);

		httpURLConnection.setRequestMethod("GET");
		int responseCode = httpURLConnection.getResponseCode();
		if (responseCode == 200) {
			// 从服务器返回一个输入流
			inputStream = httpURLConnection.getInputStream();

			return inputStream;

		}
		return null;
	}

	/**
	 * 图像切成圆形
	 * 
	 * @param src
	 *            源图片
	 * @return
	 */
	public static BufferedImage getCircleImage(BufferedImage src)
			throws IOException, Exception {

		BufferedImage master = src;
		int diameter = Math.min(master.getWidth(), master.getHeight());
		BufferedImage mask = new BufferedImage(master.getWidth(),
				master.getHeight(), BufferedImage.TYPE_INT_ARGB);

		Graphics2D g2d = mask.createGraphics();
		applyQualityRenderingHints(g2d);
		g2d.fillOval(0, 0, diameter - 1, diameter - 1);
		g2d.dispose();

		BufferedImage masked = new BufferedImage(diameter, diameter,
				BufferedImage.TYPE_INT_ARGB);
		g2d = masked.createGraphics();
		applyQualityRenderingHints(g2d);
		int x = (diameter - master.getWidth()) / 2;
		int y = (diameter - master.getHeight()) / 2;
		g2d.drawImage(master, x, y, null);
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.DST_IN));
		g2d.drawImage(mask, 0, 0, null);
		g2d.dispose();
		return masked;
	}
	
	/**
	 * 生成占位图片，图片颜色根据c颜色指定
	 * @param width
	 * @param height
	 * @param c
	 * @return
	 */
	public static BufferedImage createDumpImage(int width, int height, Color c) {
		BufferedImage bufferedImage = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		Graphics2D g2 = bufferedImage.createGraphics();
		g2.setColor(c);
		g2.fill(new Rectangle(width, height));
		g2.dispose();
		return bufferedImage;
	}

	private static void applyQualityRenderingHints(Graphics2D g2d) {
		g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION,
				RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING,
				RenderingHints.VALUE_COLOR_RENDER_QUALITY);
		g2d.setRenderingHint(RenderingHints.KEY_DITHERING,
				RenderingHints.VALUE_DITHER_ENABLE);
		g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS,
				RenderingHints.VALUE_FRACTIONALMETRICS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
				RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING,
				RenderingHints.VALUE_RENDER_QUALITY);
		g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL,
				RenderingHints.VALUE_STROKE_PURE);
	}
}