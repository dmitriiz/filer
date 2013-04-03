package ru.dazzled.filer.model.impl;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;
import javax.imageio.ImageIO;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

/**
 *
 * @author dmitriiz
 */
public class PdfEntity extends EbookEntity {

    public PdfEntity(File file) {
        super("application/pdf", file);
    }
    
    public void createIcons() {
        try {
            PDDocument pdf = PDDocument.load(getFile());
            List<PDPage> pages = pdf.getDocumentCatalog().getAllPages();
            BufferedImage image = pages.get(0).convertToImage(BufferedImage.TYPE_INT_RGB, 96);
            pdf.close();
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ImageIO.write(image, "jpeg", out);
            out.toByteArray();
        }
        catch (Exception e) {
            //
        }
    }
}
