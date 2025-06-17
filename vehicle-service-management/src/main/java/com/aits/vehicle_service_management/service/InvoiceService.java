package com.aits.vehicle_service_management.service;

import com.aits.vehicle_service_management.model.BillItem;
import com.aits.vehicle_service_management.model.ServiceRecord;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.OutputStream;
import java.util.List;

@Service
public class InvoiceService {

    @Autowired
    private BillItemService billItemService;

    public void generateInvoice(ServiceRecord record, HttpServletResponse response) {
        try {
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=invoice_" + record.getId() + ".pdf");

            OutputStream out = response.getOutputStream();
            Document document = new Document();
            PdfWriter.getInstance(document, out);
            document.open();

            document.add(new Paragraph("Invoice for Service #" + record.getId()));
            document.add(new Paragraph("Vehicle: " + record.getVehicle().getVehicleNumber()));
            document.add(new Paragraph("Date: " + record.getServiceDate()));
            document.add(new Paragraph("Customer ID: " + record.getUser().getId()));
            document.add(new Paragraph("--------------------------------------------------"));

            PdfPTable table = new PdfPTable(3);
            table.addCell("Work Item");
            table.addCell("Quantity");
            table.addCell("Cost");

            double total = 0.0;
            List<BillItem> items = billItemService.getItemsByService(record);

            for (BillItem item : items) {
                double cost = item.getQuantity() * item.getWorkItem().getPrice();
                total += cost;

                table.addCell(item.getWorkItem().getItemName());
                table.addCell(String.valueOf(item.getQuantity()));
                table.addCell("₹ " + cost);
            }

            document.add(table);
            document.add(new Paragraph("--------------------------------------------------"));
            document.add(new Paragraph("Total: ₹ " + total));
            document.close();

        } catch (Exception e) {
            throw new RuntimeException("Error generating invoice", e);
        }
    }
}