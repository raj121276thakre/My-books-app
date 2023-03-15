package com.rajapps.mybooksapp.ebooksSE;

public class EbookDataSE {

    private String name, pdfUrl;

    public EbookDataSE() {
    }

    public EbookDataSE(String name, String pdfUrl) {
        this.name = name;
        this.pdfUrl = pdfUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPdfUrl() {
        return pdfUrl;
    }

    public void setPdfUrl(String pdfUrl) {
        this.pdfUrl = pdfUrl;
    }
}
