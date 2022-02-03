package indi.mofan.markbook.processor;

/**
 * @author cheny
 * @date 2022/2/3 19:50
 */
public interface Processor {

    /**
     * 文档生成处理器
     *
     * @param sourceNoteData 文档来源数据
     */
    void processor(SourceNoteData sourceNoteData);
}
