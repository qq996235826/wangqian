package com.contract.Utils;

import org.apache.poi.POIXMLDocument;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.*;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlToken;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
import org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTInline;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;



/**
 *
 * @author zhoulian
 * @time    2018/6/8 15:30:22
 */
public class WordUtils {

    private static FileInputStream in;
    private static FileOutputStream out;


//    public  static void replaceAll(String filePath,Map<String,String> map){
//
//        try {
//            in = new FileInputStream(filePath);
//            XWPFDocument doc = new XWPFDocument(in);
//
//            //处理段落
//            //------------------------------------------------------------------
//            List<XWPFParagraph> paragraphs = doc.getParagraphs();
//            for (XWPFParagraph paragraph : paragraphs) {
//                List<XWPFRun> runs = paragraph.getRuns();
//                for (XWPFRun run : runs) {
//                    String text = run.getText(0);
//                    if(text!=null){
//                        boolean isSetText = false;
//                        for (Entry<String, String> entry : map.entrySet()) {
//                            String key = entry.getKey();
//                            String value = entry.getValue();
//                            if(text.indexOf(key)!=-1){
//                                isSetText = true;
//                                text = text.replaceAll(key, value);
//                            }
//                            if (isSetText) {
//                                run.setText(text, 0);
//                            }
//                        }
//
//                    }
//
//                }
//            }
//
//            //------------------------------------------------------------------
//
//            //处理表格
//            //------------------------------------------------------------------
//            List<XWPFTable> tables = doc.getTables();
//            for (XWPFTable table : tables) {
//                List<XWPFTableRow> rows = table.getRows();
//                for (XWPFTableRow row : rows) {
//                    List<XWPFTableCell> cells = row.getTableCells();
//                    for (XWPFTableCell cell : cells) {
//
//                        String text = cell.getText();
//                        if(text!=null){
//                            for(Entry<String,String> entry:map.entrySet()){
//                                String key = entry.getKey();
//                                String value = entry.getValue();
//                                if(text.equals(key)){
//                                    //删除原单元格值
//                                    cell.removeParagraph(0);
//                                    //设置新单元格的值
//                                    cell.setText(value);
//                                }
//                            }
//                        }
//                    }
//
//                }
//            }
//            //------------------------------------------------------------------
//
//            out = new FileOutputStream(filePath);
//            doc.write(out);
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//        finally{
//            try {
//                in.close();
//                out.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//    }


    // 替换word中需要替换的特殊字符
//    public static boolean replaceAndGenerateWord(String srcPath, String destPath, Map<String, String> map) {
//        String[] sp = srcPath.split("\\.");
//        String[] dp = destPath.split("\\.");
//        if ((sp.length > 0) && (dp.length > 0)) {// 判断文件有无扩展名
//            // 比较文件扩展名
//            if (sp[sp.length - 1].equalsIgnoreCase("docx")) {
//                try {
//                    XWPFDocument document = new XWPFDocument(
//                            POIXMLDocument.openPackage(srcPath));
//                    // 替换段落中的指定文字
//                    Iterator<XWPFParagraph> itPara = document
//                            .getParagraphsIterator();
//                    while (itPara.hasNext()) {
//                        XWPFParagraph paragraph = (XWPFParagraph) itPara.next();
//                        List<XWPFRun> runs = paragraph.getRuns();
//                        for (int i = 0; i < runs.size(); i++) {
//                            String oneparaString = runs.get(i).getText(
//                                    runs.get(i).getTextPosition());
//                            for (Map.Entry<String, String> entry : map
//                                    .entrySet()) {
//                                oneparaString = oneparaString.replace(
//                                        entry.getKey(), entry.getValue());
//                            }
//                            runs.get(i).setText(oneparaString, 0);
//                        }
//                    }
//
//                    // 替换表格中的指定文字
//                    Iterator<XWPFTable> itTable = document.getTablesIterator();
//                    while (itTable.hasNext()) {
//                        XWPFTable table = (XWPFTable) itTable.next();
//                        int rcount = table.getNumberOfRows();
//                        for (int i = 0; i < rcount; i++) {
//                            XWPFTableRow row = table.getRow(i);
//                            List<XWPFTableCell> cells = row.getTableCells();
//                            for (XWPFTableCell cell : cells) {
//                                String cellTextString = cell.getText();
//                                for (Entry<String, String> e : map.entrySet()) {
//                                    if (cellTextString.contains(e.getKey()))
//                                        cellTextString = cellTextString
//                                                .replace(e.getKey(),
//                                                        e.getValue());
//                                }
//                                cell.removeParagraph(0);
//                                cell.setText(cellTextString);
//                            }
//                        }
//                    }
//                    FileOutputStream outStream = null;
//                    outStream = new FileOutputStream(destPath);
//                    document.write(outStream);
//                    outStream.close();
//                    return true;
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    return false;
//                }
//
//            } else
//                // doc只能生成doc，如果生成docx会出错
//                if ((sp[sp.length - 1].equalsIgnoreCase("doc"))
//                        && (dp[dp.length - 1].equalsIgnoreCase("doc"))) {
//                    HWPFDocument document = null;
//                    try {
//                        document = new HWPFDocument(new FileInputStream(srcPath));
//                        Range range = document.getRange();
//                        for (Map.Entry<String, String> entry : map.entrySet()) {
//                            range.replaceText(entry.getKey(), entry.getValue());
//                        }
//                        FileOutputStream outStream = null;
//                        outStream = new FileOutputStream(destPath);
//                        document.write(outStream);
//                        outStream.close();
//                        return true;
//                    } catch (FileNotFoundException e) {
//                        e.printStackTrace();
//                        return false;
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                        return false;
//                    }
//                } else {
//                    return false;
//                }
//        } else {
//            return false;
//        }
//    }



    //******************************
    public static XWPFDocument generateWord(Map<String, Object> param, String template) {
        XWPFDocument doc = null;
        try {
            OPCPackage pack = POIXMLDocument.openPackage(template);//通过路径获取word模板
            doc = new CustomXWPFDocument(pack);
            //通过InputStream 获取模板，此方法适用于jar包部署
            //  doc = new CustomXWPFDocument(template);
            if (param != null && param.size() > 0) {
                //处理段落
                List<XWPFParagraph> paragraphList = doc.getParagraphs();
                processParagraphs(paragraphList, param, doc);
                //处理表格
                Iterator<XWPFTable> it = doc.getTablesIterator();
                while (it.hasNext()) {
                    XWPFTable table = it.next();
                    List<XWPFTableRow> rows = table.getRows();
                    for (XWPFTableRow row : rows) {
                        List<XWPFTableCell> cells = row.getTableCells();
                        for (XWPFTableCell cell : cells) {
                            List<XWPFParagraph> paragraphListTable = cell.getParagraphs();
                            processParagraphs(paragraphListTable, param, doc);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doc;
    }

    /**
     * 处理段落
     * @param paragraphList
     * @throws FileNotFoundException
     * @throws InvalidFormatException
     */
    public static void processParagraphs(List<XWPFParagraph> paragraphList, Map<String, Object> param, XWPFDocument doc) throws InvalidFormatException, FileNotFoundException {
        if (paragraphList != null && paragraphList.size() > 0) {
            for (XWPFParagraph paragraph : paragraphList) {
                List<XWPFRun> runs = paragraph.getRuns();
                for (XWPFRun run : runs) {
                    String text = run.getText(0);
                    if (text != null) {
                        boolean isSetText = false;
                        for (Entry<String, Object> entry : param.entrySet()) {
                            String key =entry.getKey();
                            if (text.indexOf(key) != -1) {
                                isSetText = true;
                                Object value = entry.getValue();
                                if (value instanceof String) {//文本替换
                                    text = text.replace(key, value.toString());
                                } else if (value instanceof Map) {    //图片替换
                                    text = text.replace(key, "");
                                    Map pic = (Map) value;
                                    int width = Integer.parseInt(pic.get("width").toString());
                                    int height = Integer.parseInt(pic.get("height").toString());
                                    int picType = getPictureType(pic.get("type").toString());
                                    //获取图片流，因本人项目中适用流
                                    //InputStream is = (InputStream) pic.get("content");
                                    String byteArray = (String) pic.get("content");
                                    CTInline inline = run.getCTR().addNewDrawing().addNewInline();
                                    insertPicture(doc, byteArray, inline, width, height,picType);
                                }
                            }
                        }
                        if (isSetText) {
                            run.setText(text, 0);
                        }
                    }
                }
            }
        }
    }

    /**
     * 获取图片对应类型代码
     * @param picType
     * @return int
     */
    private static int getPictureType(String picType) {
        int res = CustomXWPFDocument.PICTURE_TYPE_PICT;
        if (picType != null) {
            if (picType.equalsIgnoreCase("png")) {
                res = CustomXWPFDocument.PICTURE_TYPE_PNG;
            } else if (picType.equalsIgnoreCase("dib")) {
                res = CustomXWPFDocument.PICTURE_TYPE_DIB;
            } else if (picType.equalsIgnoreCase("emf")) {
                res = CustomXWPFDocument.PICTURE_TYPE_EMF;
            } else if (picType.equalsIgnoreCase("jpg") || picType.equalsIgnoreCase("jpeg")) {
                res = CustomXWPFDocument.PICTURE_TYPE_JPEG;
            } else if (picType.equalsIgnoreCase("wmf")) {
                res = CustomXWPFDocument.PICTURE_TYPE_WMF;
            }
        }
        return res;
    }

    /**
     * insert Picture
     * @param document
     * @param filePath
     * @param inline
     * @param width
     * @param height
     * @throws InvalidFormatException
     * @throws FileNotFoundException
     */
    private static void insertPicture(XWPFDocument document, String filePath,
                                      CTInline inline, int width,
                                      int height,int imgType) throws InvalidFormatException,
            FileNotFoundException {
        //通过流获取图片，因本人项目中，是通过流获取
        //document.addPictureData(imgFile,imgType);
        document.addPictureData(new FileInputStream(filePath),imgType);
        int id = document.getAllPictures().size() - 1;
        final int EMU = 9525;
        width *= EMU;
        height *= EMU;
        String blipId =
                document.getAllPictures().get(id).getPackageRelationship().getId();
        String picXml = getPicXml(blipId, width, height);
        XmlToken xmlToken = null;
        try {
            xmlToken = XmlToken.Factory.parse(picXml);
        } catch (XmlException xe) {
            xe.printStackTrace();
        }
        inline.set(xmlToken);
        inline.setDistT(0);
        inline.setDistB(0);
        inline.setDistL(0);
        inline.setDistR(0);
        CTPositiveSize2D extent = inline.addNewExtent();
        extent.setCx(width);
        extent.setCy(height);
        CTNonVisualDrawingProps docPr = inline.addNewDocPr();
        docPr.setId(id);
        docPr.setName("IMG_" + id);
        docPr.setDescr("IMG_" + id);
    }

    /**
     * get the xml of the picture
     *
     * @param blipId
     * @param width
     * @param height
     * @return
     */
    private static String getPicXml(String blipId, int width, int height) {
        String picXml =
                "" + "<a:graphic xmlns:a=\"http://schemas.openxmlformats.org/drawingml/2006/main\">" +
                        "   <a:graphicData uri=\"http://schemas.openxmlformats.org/drawingml/2006/picture\">" +
                        "      <pic:pic xmlns:pic=\"http://schemas.openxmlformats.org/drawingml/2006/picture\">" +
                        "         <pic:nvPicPr>" + "            <pic:cNvPr id=\"" + 0 +
                        "\" name=\"Generated\"/>" + "            <pic:cNvPicPr/>" +
                        "         </pic:nvPicPr>" + "         <pic:blipFill>" +
                        "            <a:blip r:embed=\"" + blipId +
                        "\" xmlns:r=\"http://schemas.openxmlformats.org/officeDocument/2006/relationships\"/>" +
                        "            <a:stretch>" + "               <a:fillRect/>" +
                        "            </a:stretch>" + "         </pic:blipFill>" +
                        "         <pic:spPr>" + "            <a:xfrm>" +
                        "               <a:off x=\"0\" y=\"0\"/>" +
                        "               <a:ext cx=\"" + width + "\" cy=\"" + height +
                        "\"/>" + "            </a:xfrm>" +
                        "            <a:prstGeom prst=\"rect\">" +
                        "               <a:avLst/>" + "            </a:prstGeom>" +
                        "         </pic:spPr>" + "      </pic:pic>" +
                        "   </a:graphicData>" + "</a:graphic>";
        return picXml;
    }



}
