package com.example.xiaoheihe.TestMain;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.data.MergeCellRule;
import com.deepoove.poi.data.RowRenderData;
import com.deepoove.poi.data.Rows;
import com.deepoove.poi.data.Tables;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PoiTest {
//    public static void main(String[] args) throws IOException {
//        String filePath = PoiTest.class.getResource("/templates/doc-template.docx").getPath();
//
//        String targetPath = "D:\\testpoitl\\testdoc.docx";
//        new File(targetPath).delete();
//        // 表头
//        RowRenderData tableHead = Rows.of("名称", "图片").center().create();
//        // 第一行
//        CellRenderData cellRenderData = new CellRenderData();
//        ParagraphRenderData paragraphRenderData = new ParagraphRenderData();
//        String path = "http://dygzjc-bucket.oss-cn-hangzhou.aliyuncs.com/goshine/pdsbqgc_prod/ELECTRIC_SAMPLE_03/bcf6b46c-bb70-4278-ad9a-4200caed8bbc/图片/1.PNG";
//        paragraphRenderData.addPicture(Pictures.of(path).fitSize().create());
//        cellRenderData.addParagraph(paragraphRenderData);
//
//        RowRenderData row1 = Rows.of("给力.gif").verticalCenter().horizontalCenter().create().addCell(cellRenderData);
//        // 第二行
////        RowRenderData row2 = Rows.create("李四", "男", "广东深圳", "liziba_98");
//
//        List<RowRenderData> rowList = new ArrayList<>();
//        rowList.add(tableHead);
//        rowList.add(row1);
////        rowList.add(row2);
//
//
//
//        // 合并第一行和第二行的第二列与第三列
////        MergeCellRule rule = MergeCellRule.builder().map(MergeCellRule.Grid.of(1, 1), MergeCellRule.Grid.of(2, 1))
////                .map(MergeCellRule.Grid.of(1, 2), MergeCellRule.Grid.of(2, 2)).build();
//        XWPFTemplate template = XWPFTemplate.compile(filePath).render(
//                new HashMap<String, Object>() {
//                    {
////                        put("table", Tables.of(rowList.toArray(new RowRenderData[0])).mergeRule(rule).center().create());
//                        put("images_table",Tables.of(tableHead).addRow(row1).center().create());
//                    }
//                });
//        boolean newFile = new File(targetPath).createNewFile();
//        if (newFile){
//            template.writeAndClose(new FileOutputStream(targetPath));
//        }
//
//    }
public static void main(String[] args) throws IOException {
    String filePath = PoiTest.class.getResource("/templates/doc-template.docx").getPath();

    String targetPath = "D:\\testpoitl\\testdoc.docx";
    new File(targetPath).delete();
    // 表头
    RowRenderData head = Rows.of("委托单位:", "测试单位", "", "", "", "检验检测性质:", "预防性试验", "", "", "").center().create();
    RowRenderData tableHead = Rows.of("序号", "安全工器具编号","自编号","安全工器具名称","规格型号名称","样品状态","异常说明","厂商名称","检测项目","执行标准").center().create();
//    Tables.TableBuilder tableBuilder = Tables.of(tableHead);
    // 第二行
//        RowRenderData row2 = Rows.create("李四", "男", "广东深圳", "liziba_98");

    List<RowRenderData> rowList = new ArrayList<>();
    rowList.add(head);
    rowList.add(tableHead);
//        rowList.add(row2);


    // 合并第一行和第二行的第二列与第三列
//        MergeCellRule rule = MergeCellRule.builder().map(MergeCellRule.Grid.of(1, 1), MergeCellRule.Grid.of(2, 1))
//                .map(MergeCellRule.Grid.of(1, 2), MergeCellRule.Grid.of(2, 2)).build();
    MergeCellRule rule = MergeCellRule.builder()
            .map(MergeCellRule.Grid.of(1, 1), MergeCellRule.Grid.of(1, 2)).build();
    XWPFTemplate template = XWPFTemplate.compile(filePath).render(
            new HashMap<String, Object>() {
                {
//                        put("table", Tables.of(rowList.toArray(new RowRenderData[0])).mergeRule(rule).center().create());
                    put("images_table", Tables.of(head).addRow(tableHead).center().create());
                }
            });
    boolean newFile = new File(targetPath).createNewFile();
    if (newFile) {
        template.writeAndClose(new FileOutputStream(targetPath));
    }

}
}


