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
    public static void main(String[] args) throws IOException {
        String filePath = PoiTest.class.getResource("/templates/doc-template.docx").getPath();
        String targetPath = "D:\\testpoitl\\testdoc.docx";
        // 表头
        RowRenderData tableHead = Rows.of("姓名", "性别", "地址", "微信公众号").center().bgColor("4472c4").create();
        // 第一行
        RowRenderData row1 = Rows.create("张三", "男", "广东深圳", "liziba_98");
        // 第二行
        RowRenderData row2 = Rows.create("李四", "男", "广东深圳", "liziba_98");

        List<RowRenderData> rowList = new ArrayList<>();
        rowList.add(tableHead);
        rowList.add(row1);
        rowList.add(row2);
        // 合并第一行和第二行的第二列与第三列
        MergeCellRule rule = MergeCellRule.builder().map(MergeCellRule.Grid.of(1, 1), MergeCellRule.Grid.of(2, 1))
                .map(MergeCellRule.Grid.of(1, 2), MergeCellRule.Grid.of(2, 2)).build();
        XWPFTemplate template = XWPFTemplate.compile(filePath).render(
                new HashMap<String, Object>() {
                    {
                        put("table", Tables.of(rowList.toArray(new RowRenderData[0])).mergeRule(rule).center().create());
                    }
                });
        boolean newFile = new File(targetPath).createNewFile();
        if (newFile){
            template.writeAndClose(new FileOutputStream(targetPath));
        }

    }

}


