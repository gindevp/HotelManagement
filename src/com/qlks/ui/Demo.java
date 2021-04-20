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
import com.itextpdf.kernel.color.DeviceRgb;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.VerticalAlignment;
import java.io.IOException;
import java.util.List;

public class Demo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        List<String> listSoLuong = null;

        List<String> listTenLG = null;
        List<String> listTenDV = null;
        List<String> listSoPhong = null;
        List<String> listDGDV = null;
        List<String> listDGPhong = null;
        List<String> listTongTien = null;
        List<String> listTongTienHD = null;
        List<String> listMaLP = null;

        //DAO void
        PDFExportDAO pdfdao = new PDFExportDAO();
        HoaDonDAO hddao = new HoaDonDAO();
        KhachHangDAO khdao = new KhachHangDAO();

        //DAO use
        listSoPhong = pdfdao.selectPhong(10);
        listDGPhong = pdfdao.selectDonGiaPhong(10);
        listTenLG = pdfdao.selectTenLG(10);
        listMaLP = pdfdao.selectMaLP(10);

        listSoLuong = pdfdao.selectSoLuong(10);
        listTenDV = pdfdao.selectTenDV(10);
        listDGDV = pdfdao.selectDGDV(10);
        listTongTien = pdfdao.selectTongTien(10);

        listTongTienHD = pdfdao.selectTongTienHD(10);

        //Object
        HoaDon hd = hddao.selectByID(10);
        KhachHang khachHang = khdao.selectByID(hd.getMaKh());

        //Document create and setting
        String path = "C:\\Users\\huama\\OneDrive\\Desktop\\demo.pdf";
        PdfWriter pdfWriter = new PdfWriter(path);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        Document document = new Document(pdfDocument);
        pdfDocument.setDefaultPageSize(PageSize.A4);

        //Table 1
        float col = 380f;
        float columnWidth[] = {col};
        Table table = new Table(columnWidth);

        table.setBackgroundColor(new DeviceRgb(63, 169, 219));

        table.addCell(new Cell().add("STARTUP HOTEL")
                .setTextAlignment(TextAlignment.CENTER)
                .setVerticalAlignment(VerticalAlignment.MIDDLE)
                .setMarginTop(30f)
                .setFontSize(25f)
                .setBorder(Border.NO_BORDER)
        );
        table.addCell(new Cell().add("INVOICE")
                .setTextAlignment(TextAlignment.CENTER)
                .setVerticalAlignment(VerticalAlignment.MIDDLE)
                .setFontSize(20f)
                .setBorder(Border.NO_BORDER)
        );

        table.addCell(new Cell().add("Information Technology\n#3546 Markhyun\n987654321")
                .setTextAlignment(TextAlignment.RIGHT)
                .setMarginTop(5f)
                .setBorder(Border.NO_BORDER)
                .setMarginRight(10f));

        document.add(table);
        document.add(new Paragraph("\n"));

        //TABLE 2
        float colWidth[] = {180};
        Table inforTbl = new Table(colWidth);
        inforTbl.addCell(new Cell(0, 4)
                .add("Customer Information")
                .setBold()
                .setBorder(Border.NO_BORDER)
        );

        inforTbl.addCell(new Cell().add("Receipt No: " + hd.getMa())
                .setBorder(Border.NO_BORDER)
        );

        inforTbl.addCell(new Cell().add("Date: " + hd.getNgayThanhToan())
                .setBorder(Border.NO_BORDER)
        );

        inforTbl.addCell(new Cell().add("Cashier: " + hd.getMaNv())
                .setBorder(Border.NO_BORDER)
        );
        inforTbl.addCell(new Cell().add("Customer: " + khachHang.getTen())
                .setBorder(Border.NO_BORDER)
        );

        inforTbl.addCell(new Cell().add("Description: ")
                .setBorder(Border.NO_BORDER)
        );
        document.add(inforTbl);
        document.add(new Paragraph("======================================================="));

//TABLE 3
        float itemWidth[] = {180, 100, 100};
        Table itemTable = new Table(itemWidth);
        document.add(new Paragraph("Room is rented: \n"));
        if (listSoPhong.size() != 0) {
            for (int i = 0; i < listSoPhong.size(); i++) {
                itemTable.addCell(new Cell().add("- " + listTenLG.get(i)).setBorder(Border.NO_BORDER));
                itemTable.addCell(new Cell().add(listMaLP.get(i) + " - " + listSoPhong.get(i)).setBorder(Border.NO_BORDER));
                itemTable.addCell(new Cell().add(listDGPhong.get(i) + " VND").setBorder(Border.NO_BORDER));
            }
        }
        document.add(itemTable);

        Table itemTable1 = new Table(itemWidth);
        document.add(new Paragraph("Service used: \n"));
        if (listTenDV.size() != 0) {
            for (int i = 0; i < listTenDV.size(); i++) {
                itemTable1.addCell(new Cell().add("- " + listTenDV.get(i)).setBorder(Border.NO_BORDER));
                itemTable1.addCell(new Cell().add(listSoLuong.get(i) + " x " + listDGDV.get(i)).setBorder(Border.NO_BORDER));
                itemTable1.addCell(new Cell().add(listTongTien.get(i) + " VND").setBorder(Border.NO_BORDER));
            }
        }
        document.add(itemTable1);

        document.add(new Paragraph("__________###################################__________"));
        Table itemTable2 = new Table(itemWidth);
        if (listTongTienHD.size() != 0) {
            itemTable2.addCell(new Cell().add("Total money: ").setBorder(Border.NO_BORDER));
            itemTable2.addCell(new Cell().add("").setBorder(Border.NO_BORDER));
            itemTable2.addCell(new Cell().add(listTongTienHD.get(0) + " VND").setBorder(Border.NO_BORDER).setBold());
        }
        document.add(itemTable2);

        document.close();
        System.out.println("PDF Created!");
    }
}
