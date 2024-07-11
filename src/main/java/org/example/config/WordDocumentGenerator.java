package org.example.config;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.util.List;

public class WordDocumentGenerator<T> {

    public XWPFDocument generateDocument(String examName, List<T> dataObjects, DataObjectHandler<T> handler) {
        // 创建一个新的 Word 文档
        XWPFDocument document = new XWPFDocument();

        // 设置文档标题
        XWPFParagraph titleParagraph = document.createParagraph();
        titleParagraph.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun titleRun = titleParagraph.createRun();
        titleRun.setText(examName);
        titleRun.setBold(true);
        titleRun.setFontSize(20);

        // 添加题目和选项
        int questionNumber = 1;
        for (T dataObject : dataObjects) {
            // 使用 DataObjectHandler 处理数据对象
            handler.handleDataObject(document, dataObject, questionNumber);
            questionNumber++;
        }

        return document;
    }

    public interface DataObjectHandler<T> {
        void handleDataObject(XWPFDocument document, T dataObject, int questionNumber);
    }
}
