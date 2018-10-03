package com.cyyz.spt.platform.common.util.pdf;

import java.util.Map;

public class PDFBean {

    private String htmlFile;

    private String pdfName;

    private Map<String, Object> data;

    public PDFBean() {
    }

    public PDFBean(String htmlFile, String pdfName, Map<String, Object> data) {
        this.htmlFile = htmlFile;
        this.pdfName = pdfName;
        this.data = data;
    }

    public String getHtmlFile() {
        return htmlFile;
    }

    public void setHtmlFile(String htmlFile) {
        this.htmlFile = htmlFile;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public String getPdfName() {
        return pdfName;
    }

    public void setPdfName(String pdfName) {
        this.pdfName = pdfName;
    }
}
