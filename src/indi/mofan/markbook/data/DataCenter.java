package indi.mofan.markbook.data;

import javax.swing.table.DefaultTableModel;
import java.util.LinkedList;
import java.util.List;

/**
 * @author cheny
 * @date 2022/1/31 19:11
 */
public class DataCenter {
    public static String SELECT_TEXT;
    public static String FILE_NAME;
    public static List<NoteData> NODE_LIST = new LinkedList<>();

    /**
     * 表头
     */
    private static final String[] TABLE_HEAD = {"标题", "备注", "文件名", "代码段"};

    /**
     * 表格模型
     * 第一个参数表示表格中的数据，第二个参数表示表格的表头
     */
    public static final DefaultTableModel TABLE_MODEL = new DefaultTableModel(null, TABLE_HEAD);

    /**
     * 笔记列表数据清空
     */
    public static void reset() {
        NODE_LIST.clear();
        TABLE_MODEL.setDataVector(null, TABLE_HEAD);
    }
}
