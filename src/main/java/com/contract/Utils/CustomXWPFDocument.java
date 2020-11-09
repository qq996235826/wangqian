package com.contract.Utils;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author deng
 * @version 1.0
 * @description
 * @date 2020/11/9 0:07
 */
public class CustomXWPFDocument extends XWPFDocument{
    public CustomXWPFDocument(InputStream in) throws IOException {
        super(in);
    }

    public CustomXWPFDocument() {
        super();
    }

    public CustomXWPFDocument(OPCPackage pkg) throws IOException {
        super(pkg);
    }
}
