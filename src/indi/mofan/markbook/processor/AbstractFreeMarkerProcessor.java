package indi.mofan.markbook.processor;

import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.Writer;

/**
 * @author cheny
 * @date 2022/2/3 19:55
 */
public abstract class AbstractFreeMarkerProcessor implements Processor {

    /**
     * 获取数据
     *
     * @param sourceNoteData 文档数据
     * @return 模板数据
     */
    protected abstract Object getModel(SourceNoteData sourceNoteData);

    /**
     * 获取模板
     *
     * @return 模板
     */
    protected abstract Template getTemplate();

    /**
     * 文档生成位置
     *
     * @param sourceNoteData 文档数据
     * @return 文档生成位置
     */
    protected abstract Writer getWriter(SourceNoteData sourceNoteData);

    @Override
    public final void processor(SourceNoteData sourceNoteData) {
        Template template = getTemplate();
        Object model = getModel(sourceNoteData);
        Writer writer = getWriter(sourceNoteData);
        try {
            template.process(model, writer);
        } catch (TemplateException | IOException e) {
            throw new RuntimeException("模板处理异常");
        }
    }
}
