package com.maro.manager.print.service;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.maro.manager.print.entity.KaiTaiMessage;
import com.maro.manager.print.entity.SettleAccounts;
import com.maro.manager.print.entity.SettleAccountsDishes;


public class PrintTaiQiuService implements Printable {
	
	private Object obj;
	//
	private String printType;
	
	//private SettleAccounts sa;
	private KaiTaiMessage jieZhangMessage;
	
	public static void main(String[] args) {
		List<SettleAccountsDishes> spsList = new ArrayList<SettleAccountsDishes>();
		SettleAccountsDishes sps = new SettleAccountsDishes();
		sps.setDishesName("青椒肉丝1");
		sps.setDishesPrice("1");
		sps.setShuLiang("1");
		sps.setTotalMoney("88.9");
		spsList.add(sps);
		SettleAccountsDishes sps2 = new SettleAccountsDishes();
		sps2.setDishesName("青椒肉丝2");
		sps2.setDishesPrice("1");
		sps2.setShuLiang("2");
		sps2.setTotalMoney("100");
		spsList.add(sps2);
		SettleAccountsDishes sps0 = new SettleAccountsDishes();
		sps0.setDishesName("青椒肉丝3");
		sps0.setDishesPrice("1");
		sps0.setShuLiang("2");
		sps0.setTotalMoney("100");
		spsList.add(sps0);
		SettleAccountsDishes sps3 = new SettleAccountsDishes();
		sps3.setDishesName("青椒肉丝4");
		sps3.setDishesPrice("1");
		sps3.setShuLiang("2");
		sps3.setTotalMoney("100");
		spsList.add(sps3);
		SettleAccountsDishes sps4 = new SettleAccountsDishes();
		sps4.setDishesName("青椒肉丝5");
		sps4.setDishesPrice("1");
		sps4.setShuLiang("2");
		sps4.setTotalMoney("100");
		spsList.add(sps4);
		SettleAccountsDishes sps5 = new SettleAccountsDishes();
		sps5.setDishesName("青椒肉丝6");
		sps5.setDishesPrice("1");
		sps5.setShuLiang("2");
		sps5.setTotalMoney("100");
		spsList.add(sps5);
		SettleAccountsDishes sps6 = new SettleAccountsDishes();
		sps6.setDishesName("青椒肉丝7");
		sps6.setDishesPrice("1");
		sps6.setShuLiang("2");
		sps6.setTotalMoney("100");
		spsList.add(sps6);
		SettleAccountsDishes sps7 = new SettleAccountsDishes();
		sps7.setDishesName("青椒肉丝8");
		sps7.setDishesPrice("1");
		sps7.setShuLiang("2");
		sps7.setTotalMoney("100");
		spsList.add(sps7);
		SettleAccountsDishes sps8 = new SettleAccountsDishes();
		sps8.setDishesName("青椒肉丝9");
		sps8.setDishesPrice("1");
		sps8.setShuLiang("2");
		sps8.setTotalMoney("100");
		spsList.add(sps8);
		
		SettleAccounts sa = new SettleAccounts();
		sa.setWaiter("何善龙");
		sa.setCashier("0001245");
		sa.setZongJie("9862");
		sa.setDishesList(spsList);
		
		new PrintTaiQiuService().print("printSettleAccounts",sa,19);
		
		/*KaiTaiMessage kt = new KaiTaiMessage();

		kt.setTableNum("AA");   
		kt.setTableType("BB");      
		kt.setTableMoney("CC");     
		kt.setShangpinmoney("DD");  
		kt.setChuzumoney("EE");     
		kt.setPeidamoney("FF");     
		kt.setBingrumoney("GG");    
		kt.setTotalmoney("HH");     
		kt.setYingshoumoney("II");  
		kt.setShishoumoney("JJ");   
		kt.setOddNumber("KK");      
		kt.setStartTime("2018-09-11 14:44:55");      
		kt.setEndTime("2018-09-11 14:44:55");    
		kt.setTotalTime("2018-09-11 14:44:55");      */
		
		//new PrintTaiQiuService().print("printSettleAccounts",spsList);
		//new PrintTaiQiuService().printjieZhang(kt, "name");
	}

	public PrintTaiQiuService() {
		
	}

	/* 对应于商品零售的构造方法 */
	public PrintTaiQiuService(String printType,SettleAccounts sa) {
		this.printType = printType;
		this.obj = sa;
	}

	public PrintTaiQiuService(KaiTaiMessage message, String printType) {
		this.jieZhangMessage = message;
		this.printType = printType;
	}

	/**
	 * 打印的方法
	 */
	@Override
	public int print(Graphics gra, PageFormat pf, int pageIndex)throws PrinterException {
		try {
			/**
			 * * @param Graphic指明打印的图形环境 * @param
			 * PageFormat指明打印页格式（页面大小以点为计量单位，1
			 * 点为1英寸的1/72，1英寸为25.4毫米。A4纸大致为595×842点） * @param pageIndex指明页号
			 **/

			// 打印起点坐标
			switch (pageIndex) {
				case 0:
					if(printType.equals("printSettleAccounts")){ //结账单
						printSettleAccounts2(gra,pf,(SettleAccounts)obj);
					}else if(printType.equals("printExpected")){ //预结单
						printSettleAccounts2(gra,pf,(SettleAccounts)obj);
					}
					return PAGE_EXISTS;
				default:
					return NO_SUCH_PAGE;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}
	
	
	/**
	 * 结账单  --  预结单
	 */
	private void printSettleAccounts2(Graphics gra,PageFormat pf,SettleAccounts sa){
		// 转换成Graphics2D
		Graphics2D g2_1 = (Graphics2D) gra;
		// 设置打印颜色为黑色
		g2_1.setColor(Color.black);
		// 设置打印字体（字体名称、样式和点大小）（字体名称可以是物理或者逻辑名称）
		// Java平台所定义的五种字体系列：Serif、SansSerif、Monospaced、Dialog 和
		// DialogInput
		Font font = new Font("宋体", Font.PLAIN, 14);
		Font font2 = new Font("宋体", Font.PLAIN, 9);

		g2_1.setFont(font2); // 设置字体
		// BasicStroke bs_3=new BasicStroke(0.5f);
		float[] dash1 = { 2.0f };
		// 设置打印线的属性。
		// 1.线宽 2、3、不知道，4、空白的宽度，5、虚线的宽度，6、偏移量
		g2_1.setStroke(new BasicStroke(0.5f, BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER, 2.0f, dash1, 0.0f));

		double x = pf.getImageableX() + 2;  //  12
		double y = pf.getImageableY(); //  10
		float heigth1 = font.getSize2D();  //14
		//float heigth = font2.getSize2D() + 2; // 字体高度  11

		/* 如果调用该方法的是要打印"商品零售"的小票的信息，则调用该 方法 */
		Date date = new Date();
		DateFormat df = DateFormat.getDateTimeInstance();
		
		g2_1.setFont(font); // 设置字体
		g2_1.drawString("兔行天下(光华店)", (float) x , (float) y + 1 * heigth1); 
		if(printType.equals("printSettleAccounts")){
			g2_1.drawString("结账单", (float) x , (float) y + 2 * heigth1); 
		}else if(printType.equals("printExpected")){
			g2_1.drawString("预接单", (float) x , (float) y + 2 * heigth1); 
		}
		
		g2_1.drawLine((int) x, (int) (y + 3 * heigth1),(int) x + 180, (int) (y + 3 * heigth1));  //虚线
		
		g2_1.setFont(font);
		g2_1.drawString("桌名：【贵宾桌】", (float) x, (float) y + 4 * heigth1); 
		g2_1.setFont(font2);
		g2_1.drawString("人数：[4]", (float) x, (float) y + 5 * heigth1); 
		g2_1.drawString("开台时间：[2018-09-19 11:18:54]", (float) x, (float)y + 6 * heigth1);
		g2_1.drawString("结账时间：[2018-09-19 11:59:54]", (float) x, (float)y + 7 * heigth1);
		g2_1.drawString("服务员：[张小二]", (float) x, (float)y + 8 * heigth1);
		g2_1.drawString("收银员：[张小二]", (float) x, (float)y + 9 * heigth1);
		g2_1.drawString("会员姓名：[马云]", (float) x, (float)y + 10 * heigth1);
		
		g2_1.drawLine((int) x, (int) (y + 11 * heigth1),(int) x + 180, (int) (y + 11 * heigth1));  //虚线   
		
		g2_1.drawString("菜品：", (float) x, (float) y + 12 * heigth1);  
		g2_1.drawString("单价：", (float) x + 60, (float) y + 12 * heigth1);
		g2_1.drawString("数量：", (float) x + 100, (float) y + 12 * heigth1);
		g2_1.drawString("金额：", (float) x + 140, (float) y + 12 * heigth1); 

		g2_1.drawLine((int) x , (int) (y + 13 * heigth1),(int) x + 180, (int) (y + 13 * heigth1)); //虚线  
		
		int y1 = 0;
		for (SettleAccountsDishes shangPin : sa.getDishesList()) {
			g2_1.drawString(shangPin.getDishesName() + "", (float) x,(float) y + (14 + y1) * heigth1);  
			g2_1.drawString(shangPin.getDishesPrice() + "",(float) x + 60, (float) y + (14 + y1) * heigth1); 
			g2_1.drawString(shangPin.getShuLiang() + "",(float) x + 100, (float) y + (14 + y1) * heigth1);
			g2_1.drawString(shangPin.getTotalMoney() + "",(float) x + 140, (float) y + (14 + y1) * heigth1);  
			y1++;
		}
		
		g2_1.drawLine((int) x,(int) (y + (14 + y1) * heigth1),(int) x + 180,(int) (y + (14 + y1) * heigth1)); //虚线  
		
		y1++;
		g2_1.drawString("总金额：" + sa.getZongJie(), (float) x,(float) y + (14 + y1) * heigth1);  
		y1++;
		g2_1.drawString("收银员：" + sa.getCashier(), (float) x,(float) y + (14 + y1) * heigth1); 
		y1++;
		g2_1.drawString("销售单号：" + sa.getBillNumber(), (float) x,(float) y + (14 + y1) * heigth1);  
		y1++;
		
		g2_1.drawLine((int) x,(int) (y + (14 + y1) * heigth1),(int) x + 180,(int) (y + (14 + y1) * heigth1));  //虚线
		
		y1++;
		g2_1.drawString("谢谢惠顾，欢迎再次光临！", (float) x,(float) y + (14 + y1) * heigth1);
		y1++;
		g2_1.drawString("日期：" + df.format(date), (float) x,(float) y + (14 + y1) * heigth1);
		
		y1++;

	}
	
	
	/**
	 * 消费单
	 */
	private void printSettleAccounts(Graphics gra,PageFormat pf,SettleAccounts sa){
		// 转换成Graphics2D
		Graphics2D g2_1 = (Graphics2D) gra;
		// 设置打印颜色为黑色
		g2_1.setColor(Color.black);
		// 设置打印字体（字体名称、样式和点大小）（字体名称可以是物理或者逻辑名称）
		// Java平台所定义的五种字体系列：Serif、SansSerif、Monospaced、Dialog 和
		// DialogInput
		Font font = new Font("宋体", Font.PLAIN, 14);
		Font font2 = new Font("宋体", Font.PLAIN, 9);

		g2_1.setFont(font2); // 设置字体
		// BasicStroke bs_3=new BasicStroke(0.5f);
		float[] dash1 = { 2.0f };
		// 设置打印线的属性。
		// 1.线宽 2、3、不知道，4、空白的宽度，5、虚线的宽度，6、偏移量
		g2_1.setStroke(new BasicStroke(0.5f, BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER, 2.0f, dash1, 0.0f));

		double x = pf.getImageableX();
		double y = pf.getImageableY();
		float heigth1 = font.getSize2D();
		float heigth = font2.getSize2D() + 2; // 字体高度

		/* 如果调用该方法的是要打印"商品零售"的小票的信息，则调用该 方法 */
		Date date = new Date();
		DateFormat df = DateFormat.getDateTimeInstance();
		g2_1.setFont(font); // 设置字体
		g2_1.drawString("消费单", (float) x + 50, (float) y + 1* heigth1);
		g2_1.drawLine((int) x, (int) (y + 2 * heigth1),(int) x + 180, (int) (y + 2 * heigth1));  //虚线
		g2_1.setFont(font2);
		g2_1.drawString("菜品：", (float) x, (float) y + 3 * heigth1);
		g2_1.setFont(font2); // 设置字体
		g2_1.drawString("单价：", (float) x + 60, (float) y + 3* heigth1);
		g2_1.setFont(font2); // 设置字体
		g2_1.drawString("数量：", (float) x + 100, (float) y + 3* heigth1);
		g2_1.setFont(font2); // 设置字体
		g2_1.drawString("金额：", (float) x + 140, (float) y + 3* heigth1);
		g2_1.setFont(font2); // 设置字体
		g2_1.drawLine((int) x - 2, (int) (y + 5 * (heigth - 2)),(int) x + 183, (int) (y + 5 * (heigth - 2)));

		int y1 = 0;
		g2_1.setFont(font2);
		for (SettleAccountsDishes shangPin : sa.getDishesList()) {
			g2_1.drawString(shangPin.getDishesName(), (float) x,(float) y + ((float) 5.5 + y1) * heigth);
			g2_1.drawString(shangPin.getDishesPrice() + "",(float) x + 60, (float) y + ((float) 5.5 + y1) * heigth);
			g2_1.drawString(shangPin.getShuLiang() + "",(float) x + 100, (float) y + ((float) 5.5 + y1) * heigth);
			g2_1.drawString(shangPin.getTotalMoney() + "",(float) x + 140, (float) y + ((float) 5.5 + y1) * heigth);
			y1++;
			if (y1 == sa.getDishesList().size()) {
				g2_1.drawLine((int) x - 2,
						(int) (y + ((float) 5.5 + y1) * heigth),
						(int) x + 183,
						(int) (y + ((float) 5.5 + y1) * heigth));
				y1++;
				g2_1.drawString("总金额：" + sa.getZongJie(), (float) x,(float) y + ((float) 5.5 + y1) * heigth);
				y1++;
				g2_1.drawString("收银员：" + sa.getCashier(), (float) x,(float) y + ((float) 5.5 + y1) * heigth);
				y1++;
				g2_1.drawString("销售单号：" + sa.getBillNumber(), (float) x,(float) y + ((float) 5.5 + y1) * heigth);
				y1++;
				g2_1.drawLine((int) x - 2,
						(int) (y + ((float) 5.5 + y1) * heigth),
						(int) x + 183,
						(int) (y + ((float) 5.5 + y1) * heigth));
				y1++;
				g2_1.drawString("谢谢惠顾，欢迎再次光临！", (float) x,(float) y + ((float) 5.5 + y1) * heigth);
				y1++;
				g2_1.drawString("日期：" + df.format(date), (float) x,(float) y + ((float) 5.5 + y1) * heigth);
			}

		}
	}
	
	/**
	 * 其它 桌台结账单
	 */
	private void printQiTd(Graphics gra,PageFormat pf){
		// 转换成Graphics2D
		Graphics2D g2_1 = (Graphics2D) gra;
		// 设置打印颜色为黑色
		g2_1.setColor(Color.black);
		// 设置打印字体（字体名称、样式和点大小）（字体名称可以是物理或者逻辑名称）
		// Java平台所定义的五种字体系列：Serif、SansSerif、Monospaced、Dialog 和
		// DialogInput
		Font font = new Font("宋体", Font.PLAIN, 14);
		Font font2 = new Font("宋体", Font.PLAIN, 9);

		g2_1.setFont(font2); // 设置字体
		// BasicStroke bs_3=new BasicStroke(0.5f);
		float[] dash1 = { 2.0f };
		// 设置打印线的属性。
		// 1.线宽 2、3、不知道，4、空白的宽度，5、虚线的宽度，6、偏移量
		g2_1.setStroke(new BasicStroke(0.5f, BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER, 2.0f, dash1, 0.0f));

		double x = pf.getImageableX();
		double y = pf.getImageableY();
		float heigth1 = font.getSize2D();
		float heigth = font2.getSize2D() + 2; // 字体高度
		
		/* 如果调用方法的是 要打印桌台结账时的小票信息时，则调用该 方法 */
		g2_1.setFont(font); // 设置字体
		g2_1.drawString("桌台结账", (float) x + 50, (float) y + 1 * heigth1);
		g2_1.drawLine((int) x, (int) (y + 2 * heigth1),(int) x + 180, (int) (y + 2 * heigth1));
		g2_1.setFont(font2);
		g2_1.drawString("类别：", (float) x, (float) y + 3 * heigth1);

		g2_1.setFont(font2); // 设置字体
		g2_1.drawString("金额：", (float) x + 100, (float) y + 3 * heigth1);

		g2_1.setFont(font2); // 设置字体
		g2_1.drawLine((int) x - 2, (int) (y + 5 * (heigth - 2)),(int) x + 183, (int) (y + 5 * (heigth - 2)));

		int y1 = 0;
		g2_1.setFont(font2);
		g2_1.drawString("桌台号：", (float) x, (float) y + ((float) 5.5 + y1) * heigth);
		g2_1.drawString(jieZhangMessage.getTableNum() + "("+ jieZhangMessage.getTableType() + ")",(float) x + 100, (float) y + ((float) 5.5 + y1)* heigth);
		y1++;
		g2_1.drawString("桌台费：", (float) x, (float) y + ((float) 5.5 + y1) * heigth);
		g2_1.drawString(jieZhangMessage.getTableMoney() + "",(float) x + 100, (float) y + ((float) 5.5 + y1)* heigth);
		y1++;
		g2_1.drawString("商品费：", (float) x, (float) y	+ ((float) 5.5 + y1) * heigth);
		g2_1.drawString(jieZhangMessage.getShangpinmoney() + "",(float) x + 100, (float) y + ((float) 5.5 + y1)* heigth);
		y1++;
		g2_1.drawString("出租费：", (float) x, (float) y + ((float) 5.5 + y1) * heigth);
		g2_1.drawString(jieZhangMessage.getChuzumoney() + "", (float) x + 100, (float) y + ((float) 5.5 + y1) * heigth);
		y1++;
		g2_1.drawString("陪打费：", (float) x, (float) y + ((float) 5.5 + y1) * heigth);
		g2_1.drawString(jieZhangMessage.getPeidamoney() + "", (float) x + 100, (float) y + ((float) 5.5 + y1) * heigth);
		y1++;
		g2_1.drawString("并入台费：", (float) x, (float) y + ((float) 5.5 + y1) * heigth);
		g2_1.drawString(jieZhangMessage.getBingrumoney() + "", (float) x + 100, (float) y + ((float) 5.5 + y1) * heigth);
		y1++;
		g2_1.drawLine((int) x - 2, (int) (y + ((float) 5.5 + y1) * heigth), (int) x + 183, (int) (y + ((float) 5.5 + y1) * heigth));
		y1++;
		g2_1.drawString("总费用：", (float) x, (float) y + ((float) 5.5 + y1) * heigth);
		g2_1.drawString(jieZhangMessage.getTotalmoney() + "", (float) x + 100, (float) y + ((float) 5.5 + y1) * heigth);
		y1++;
		g2_1.drawString("应收金额：", (float) x, (float) y + ((float) 5.5 + y1) * heigth);
		g2_1.drawString(jieZhangMessage.getYingshoumoney() + "", (float) x + 100, (float) y + ((float) 5.5 + y1) * heigth);
		y1++;
		g2_1.drawString("实收金额：", (float) x, (float) y + ((float) 5.5 + y1) * heigth);
		g2_1.drawString(jieZhangMessage.getShishoumoney() + "", (float) x + 100, (float) y + ((float) 5.5 + y1) * heigth);
		y1++;
		g2_1.drawLine((int) x - 2, (int) (y + ((float) 5.5 + y1) * heigth), (int) x + 183, (int) (y + ((float) 5.5 + y1) * heigth));
		y1++;
		g2_1.drawString("小票号：", (float) x, (float) y + ((float) 5.5 + y1) * heigth);
		g2_1.drawString(jieZhangMessage.getOddNumber(), (float) x + 100, (float) y + ((float) 5.5 + y1) * heigth);
		y1++;
		g2_1.drawString("开台时间：", (float) x, (float) y + ((float) 5.5 + y1) * heigth);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		g2_1.drawString(jieZhangMessage.getStartTime(), (float) x + 100, (float) y + ((float) 5.5 + y1)* heigth);
		y1++;
		g2_1.drawString("结束时间：", (float) x, (float) y + ((float) 5.5 + y1) * heigth);
		g2_1.drawString(jieZhangMessage.getEndTime() + "", (float) x + 100, (float) y + ((float) 5.5 + y1) * heigth);
		y1++;
		g2_1.drawString("消费时长：", (float) x, (float) y + ((float) 5.5 + y1) * heigth);
		g2_1.drawString(jieZhangMessage.getTotalTime(), (float) x + 100, (float) y + ((float) 5.5 + y1) * heigth);
		y1++;
		g2_1.drawLine((int) x - 2, (int) (y + ((float) 5.5 + y1) * heigth), (int) x + 183, (int) (y + ((float) 5.5 + y1) * heigth));
		y1++;
		g2_1.drawString("谢谢惠顾，欢迎再次光临！", (float) x, (float) y + ((float) 5.5 + y1) * heigth);
		y1++;
		Date date = new Date();
		DateFormat df = DateFormat.getDateTimeInstance();
		g2_1.drawString("日期：" + df.format(date), (float) x, (float) y + ((float) 5.5 + y1) * heigth);
	}
	
	/**
	 * 打印共用方法
	 * 
	 * @param title
	 * @param shangPin
	 * @param admin
	 * @param danjuh
	 * @param zongjie
	 * @param type
	 */
	//public void print(String title, List<SettleAccountsDishes> shangPin,String admin, String danjuh, String zongjie, String type) {
	public void print(String type,SettleAccounts sa,int row) {
		// 通俗理解就是书、文档
		Book book = new Book();
		// 设置成竖打/
		PageFormat pf = new PageFormat();
		pf.setOrientation(PageFormat.PORTRAIT); // LANDSCAPE表示竖打;PORTRAIT表示横打;REVERSE_LANDSCAPE表示打印空白
		// 通过Paper设置页面的空白边距和可打印区域。必须与实际打印纸张大小相符。
		Paper p = new Paper();

		int length = printSize(sa.getDishesList().size(),23);
		p.setSize(200, length); // 纸张大小(590, 840)表示A4纸
		p.setImageableArea(10, 10, 3227, length); // A4(595 X
		// 842)设置打印区域，其实0，0应该是72，72
		// ，因为A4纸的默认X,Y边距是72

		pf.setPaper(p);
		// // 把 PageFormat 和 Printable 添加到书中，组成一个页面
		book.append(new PrintTaiQiuService(type,sa), pf);
		// // 获取打印服务对象
		PrinterJob job = PrinterJob.getPrinterJob();
		// // 设置打印类
		job.setPageable(book);
		try {
			// // 可以用printDialog显示打印对话框，在用户确认后打印；也可以直接打印
			// boolean a = job.printDialog();
			// if (a) {
			job.print();
		} catch (PrinterException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param size  list大小
	 * @param row   固定持行
	 * @return  得到整个需要打印的高度
	 */
	public Integer printSize(int size,int row) {
		int k = 14;
		if (size != 0) {
			k = k * size;
		}
		k = k * row;
		return 160 + k;
	}

	/**
	 *用于将结账信息进行打印
	 * 
	 */
	public void printjieZhang(KaiTaiMessage message, String name) {
		// 通俗理解就是书、文档
		Book book = new Book();
		// 设置成竖打
		PageFormat pf = new PageFormat();
		pf.setOrientation(PageFormat.PORTRAIT); // LANDSCAPE表示竖打;PORTRAIT表示横打;REVERSE_LANDSCAPE表示打印空白
		// 通过Paper设置页面的空白边距和可打印区域。必须与实际打印纸张大小相符。
		Paper p = new Paper();

		int length = 280;
		p.setSize(200, length); // 纸张大小(590, 840)表示A4纸
		p.setImageableArea(10, 10, 227, length); // A4(595 X
		// 842)设置打印区域，其实0，0应该是72，72
		// ，因为A4纸的默认X,Y边距是72

		pf.setPaper(p);
		// // 把 PageFormat 和 Printable 添加到书中，组成一个页面
		book.append(new PrintTaiQiuService(message, name), pf);
		// // 获取打印服务对象
		PrinterJob job = PrinterJob.getPrinterJob();
		// // 设置打印类
		job.setPageable(book);
		try {
			// // 可以用printDialog显示打印对话框，在用户确认后打印；也可以直接打印
			// boolean a = job.printDialog();
			// if (a) {
			job.print();
		} catch (PrinterException e) {
			e.printStackTrace();
		}
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public String getPrintType() {
		return printType;
	}

	public void setPrintType(String printType) {
		this.printType = printType;
	}

	public KaiTaiMessage getJieZhangMessage() {
		return jieZhangMessage;
	}

	public void setJieZhangMessage(KaiTaiMessage jieZhangMessage) {
		this.jieZhangMessage = jieZhangMessage;
	}

	

}

