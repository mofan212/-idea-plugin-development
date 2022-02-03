package indi.mofan.markbook.processor;

import indi.mofan.markbook.data.NoteData;

import java.util.List;

/**
 * @author cheny
 * @date 2022/2/3 19:51
 */
public interface SourceNoteData {
    /**
     * 获取笔记文件名称
     *
     * @return 文件名称
     */
    String getFileName();

    /**
     * 获取文件标题
     *
     * @return 文件标题
     */
    String getTopic();

    /**
     * 获取笔记内容
     *
     * @return 笔记内容
     */
    List<NoteData> getNoteList();


}
