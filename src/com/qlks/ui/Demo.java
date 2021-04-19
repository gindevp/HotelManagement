/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.ui;

/**
 *
 * @author markhyun
 */
import com.qlks.dao.PDFExportDAO;
import com.qlks.dao.HoaDonDAO;
import com.qlks.dao.KhachHangDAO;
import com.qlks.entity.HoaDon;
import com.qlks.entity.KhachHang;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.color.DeviceRgb;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.VerticalAlignment;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class Demo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        PDFExportDAO pdfdao = new PDFExportDAO();
        HoaDonDAO hddao = new HoaDonDAO();
        KhachHangDAO khdao = new KhachHangDAO();
        
        HoaDon hd = hddao.selectByID(14);
        String ngay = hd.getNgayThanhToan().toString();
        KhachHang khachHang = khdao.selectByID(hd.getMaKh());
        String tenKH = khachHang.getTen();
        
        String path = "C:\\Users\\huama\\OneDrive\\Desktop\\demo.pdf";
        PdfWriter pdfWriter = new PdfWriter(path);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        Document document = new Document(pdfDocument);

        pdfDocument.setDefaultPageSize(PageSize.A4);

        float col = 260f;
        float columnWidth[] = {col, col};
        Table table = new Table(columnWidth);

        table.setBackgroundColor(new DeviceRgb(63, 169, 219));

        table.addCell(new Cell().add("STARTUP HOTEL")
                .setTextAlignment(TextAlignment.CENTER)
                .setVerticalAlignment(VerticalAlignment.MIDDLE)
                .setMarginTop(30f)
                .setMarginBottom(30f)
                .setFontSize(30f)
                .setBorder(Border.NO_BORDER)
        );

        table.addCell(new Cell().add("Information Technology\n#3546 Markhyun\n987654321")
                .setTextAlignment(TextAlignment.RIGHT)
                .setMarginTop(30f)
                .setMarginBottom(30f)
                .setBorder(Border.NO_BORDER)
                .setMarginRight(10f));

////////////////////////////////////////////////
        float colWidth[] = {180};
        Table customerInfoTable = new Table(colWidth);

        customerInfoTable.addCell(new Cell(0, 4)
                .add("Customer Information")
                .setBold()
                .setBorder(Border.NO_BORDER)
        );

        customerInfoTable.addCell(new Cell().add("Receipt No: " + hd.getMa())
                .setBorder(Border.NO_BORDER)
        );

        customerInfoTable.addCell(new Cell().add("Date: " + ngay)
                .setBorder(Border.NO_BORDER)
        );

        customerInfoTable.addCell(new Cell().add("Cashier: " + hd.getMaNv())
                .setBorder(Border.NO_BORDER)
        );
        customerInfoTable.addCell(new Cell().add("Customer: "+ tenKH)
                .setBorder(Border.NO_BORDER)
        );

        customerInfoTable.addCell(new Cell().add("Description: ")
                .setBorder(Border.NO_BORDER)
        );
//        customerInfoTable.addCell(new Cell().add("========================================")
//                .setBorder(Border.NO_BORDER)
//        );
        customerInfoTable.addCell(new Cell().add("Room is rented: ")
                .setBorder(Border.NO_BORDER)
        );
        customerInfoTable.addCell(new Cell().add("Type of rental: ")
                .setBorder(Border.NO_BORDER)
        );
        customerInfoTable.addCell(new Cell().add("Service used: ")
                .setBorder(Border.NO_BORDER)
        );

        //////////////////////////
        float itemInforColWidth[] = {130, 130, 130, 130};
        Table itemInforTable = new Table(itemInforColWidth);

        itemInforTable.addCell(new Cell().add("Service")
                .setBackgroundColor(new DeviceRgb(63, 169, 219))
                .setFontColor(Color.WHITE)
        );
        itemInforTable.addCell(new Cell().add("Hrs.")
                .setBackgroundColor(new DeviceRgb(63, 169, 219))
                .setFontColor(Color.WHITE)
        );
        itemInforTable.addCell(new Cell().add("Unit Price (INR)")
                .setBackgroundColor(new DeviceRgb(63, 169, 219))
                .setFontColor(Color.WHITE)
        );
        itemInforTable.addCell(new Cell().add("Amount")
                .setBackgroundColor(new DeviceRgb(63, 169, 219))
                .setFontColor(Color.WHITE)
        );

        itemInforTable.addCell(new Cell().add("App Creation"));
        itemInforTable.addCell(new Cell().add("20"));
        itemInforTable.addCell(new Cell().add("200"));
        itemInforTable.addCell(new Cell().add("" + 20 * 200));

        itemInforTable.addCell(new Cell().add("Website Design"));
        itemInforTable.addCell(new Cell().add("10"));
        itemInforTable.addCell(new Cell().add("100"));
        itemInforTable.addCell(new Cell().add("" + 10 * 100));

        itemInforTable.addCell(new Cell().add(""));
        itemInforTable.addCell(new Cell().add(""));
        itemInforTable.addCell(new Cell().add("Total Amount"));
        itemInforTable.addCell(new Cell().add("" + (1000 + 4000)));

        document.add(table);
        document.add(new Paragraph("\n"));
        document.add(customerInfoTable);
        document.add(new Paragraph("\n"));
        document.add(itemInforTable);
        document.close();
        System.out.println("PDF Created!");
    }
}
