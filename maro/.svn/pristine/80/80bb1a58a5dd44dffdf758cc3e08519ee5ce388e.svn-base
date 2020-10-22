package com.maro.common.util;

import com.maro.common.print.api.BasePrinter;
import com.maro.common.print.api.Connection;
import com.maro.common.print.api.PrinterDriver;
import com.maro.common.print.api.content.Doucument;
import com.maro.common.print.api.content.Printable;
import com.maro.common.print.api.content.printable.*;
import com.maro.common.print.api.exception.PrinterException;
import com.maro.common.print.xprinter.demo.connection.IPconnection;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alpha on 2018-9-29.
 */
public class PrintUtil {
    public static boolean print(String xml,String ip,int port){
        try {
            // 封装文档内容
            Doucument document = new Doucument();
            document = docConvert(xml);

            Socket sc = new Socket(ip, port);
            sc.setSoTimeout(10000);
            final Connection ipConn = new IPconnection(sc);

            // 加载驱动
            BasePrinter p = null;
            p = PrinterDriver.newInstanse("com.maro.common.print.xprinter.WTPrinter", "");
            //设置IP连接
            p.setConnection(ipConn);

            // 打印文档内容
            p.print(document);

            // 关闭连接
            ipConn.close();
            return true;
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (PrinterException pe) {
            pe.printStackTrace();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return false;
    }
    public static synchronized boolean isOnline(String ip,int port){
        try {
            Socket sc = new Socket(ip, port);
            sc.setSoTimeout(10000);
            Connection ipConn = new IPconnection(sc);

            // 加载驱动
            BasePrinter p = null;
            p = PrinterDriver.newInstanse("com.maro.common.print.xprinter.WTPrinter", "");
            //设置IP连接
            p.setConnection(ipConn);

            // 打印文档内容
            int result = p.checkStatus(1);
            // 关闭连接
            if (result==22){
        	   ipConn.close();
               sc.close();
               return true;
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }catch (PrinterException pe) {
            pe.printStackTrace();
        }catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    private static Doucument docConvert(String xmlStr)
    {
        Doucument document = new Doucument();

        try {
            //不设置行距了，反应行距太大。
            //document.addContent(new LineSpace());
            Document doc = DocumentHelper.parseText(xmlStr);
            Element rootElement = doc.getRootElement();
            List<Element> els = rootElement.elements();
            List<Printable> contents = new ArrayList<>();
            for(Element el:els){
                String name = el.getName();
                String xml = el.asXML();
                if(name.equals("keyvalue")){
                    KeyValue kv = JaxbUtil.convertToJavaBean(KeyValue.class,xml);
                    contents.add(kv);
                }else if(name.equals("section")){
                    Section sec = JaxbUtil.convertToJavaBean(Section.class,xml);
                    contents.add(sec);
                }else if(name.equals("blankRow")){
                    BlankRow br = JaxbUtil.convertToJavaBean(BlankRow.class,xml);
                    contents.add(br);
                }else if(name.equals("table")){
                    Table table= JaxbUtil.convertToJavaBean(Table.class,xml);
                    contents.add(table);
                }else if(name.equals("nolineTable")){
                    NolineTable nolineTable= JaxbUtil.convertToJavaBean(NolineTable.class,xml);
                    contents.add(nolineTable);
                }else if(name.equals("line")){
                	Line table= JaxbUtil.convertToJavaBean(Line.class,xml);
                    contents.add(table);
                }
            }
            if(contents.size()>0)
                document.addContents(contents);
            document.addContent(new CutPage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return document;
    }
}
