package com.example.xiaoheihe.TestMain;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.data.*;
import com.example.xiaoheihe.domain.TestDocData;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class TestLearn {
    public static void main(String[] args) throws IOException {
        String filePath = PoiTest.class.getResource("/templates/doc-template.docx").getPath();
        String targetPath = "D:\\testpoitl\\testdoc.docx";


        TestDocData testDocData = new TestDocData();
        testDocData.setId("1");
        testDocData.setValue(",YH5WS-17/45,（投标人填写）");
        testDocData.setKey("型号");
        testDocData.setPrekey("复合外套无间隙金属氧化物避雷器");
        testDocData.setNum(3);

        TestDocData testDocData2 = new TestDocData();
        testDocData2.setId("2");
        testDocData2.setValue(",普通支柱式,（投标人填写）");
        testDocData2.setKey("型式");
        testDocData2.setPrekey("复合外套无间隙金属氧化物避雷器");
        testDocData2.setNum(0);

        TestDocData testDocData3 = new TestDocData();
        testDocData3.setId("2");
        testDocData3.setValue(",普通支柱式,（投标人填写）");
        testDocData3.setKey("型式");
        testDocData3.setPrekey("复合外套无间隙金属氧化物避雷器");
        testDocData3.setNum(0);

        TestDocData testDocData4 = new TestDocData();
        testDocData4.setId("2");
        testDocData4.setValue(",普通支柱式,（投标人填写）");
        testDocData4.setKey("型式2");
        testDocData4.setPrekey(null);
        testDocData4.setNum(0);

        List<TestDocData> testDocDataList = new ArrayList<>();
        testDocDataList.add(testDocData);
        testDocDataList.add(testDocData2);
        testDocDataList.add(testDocData3);
        testDocDataList.add(testDocData4);

        //数据处理
        List<RowRenderData> rowList = new ArrayList<>();
        String[] title = {"序号","参数名称","参数名称","单位","标准参数值","投标人保证值"};
        rowList.add(Rows.create(title));
        MergeCellRule.MergeCellRuleBuilder builder = MergeCellRule.builder();
        builder.map(MergeCellRule.Grid.of(0,1),MergeCellRule.Grid.of(0,2));
        for (int i = 0; i < testDocDataList.size() ; i++ ){

            TestDocData temp = testDocDataList.get(i);


            RowRenderData rowRenderData;
            //水平合并
            if(temp.getPrekey()==null){
                rowRenderData = Rows.create(((i + ","  + temp.getKey() + "," + "" + "," + temp.getValue()).split(",")));
                builder.map(MergeCellRule.Grid.of(i + 1,1),MergeCellRule.Grid.of(i + 1,2));
            }else {
                rowRenderData = Rows.create(((i + "," + temp.getPrekey()) + "," + temp.getKey() + "," + temp.getValue()).split(","));
            }

            rowList.add(rowRenderData);
            //rule
            //合并的数据为第一列
            //合并的行个数为i+n-1行  map(行,列)
            //向下合并
            if (temp.getNum()>0){
                //1 2 1 2
                builder.map(MergeCellRule.Grid.of(i + 1,1),MergeCellRule.Grid.of(i + temp.getNum(),1));
            }
        }
        MergeCellRule rule = builder.build();

        //合并单元格
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
