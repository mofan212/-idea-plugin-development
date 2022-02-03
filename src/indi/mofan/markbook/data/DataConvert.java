package indi.mofan.markbook.data;

import java.util.Arrays;

/**
 * @author cheny
 * @date 2022/2/3 12:25
 */
public class DataConvert {
    /**
     * 将 NoteData 中的数据转换为数组形式，用于填充在 table 中
     *
     * @param noteData 笔记数据
     * @return 数组形式的笔记数据
     */
    public static String[] convert(NoteData noteData) {
        return Arrays.asList(noteData.getTitle(), noteData.getMark(), noteData.getFileName(), noteData.getContent()).toArray(new String[0]);
    }
}
