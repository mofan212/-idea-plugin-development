package indi.mofan.markbook.processor;

import com.intellij.ide.fileTemplates.impl.UrlUtil;
import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * @author cheny
 * @date 2022/2/3 20:04
 */
public class MdFreeMarkerProcessor extends AbstractFreeMarkerProcessor {
    @Override
    protected Object getModel(SourceNoteData sourceNoteData) {
        Map<String, Object> map = new HashMap<>(16);
        map.put("topic", sourceNoteData.getTopic());
        map.put("noteList", sourceNoteData.getNoteList());
        return map;
    }

    @Override
    protected Template getTemplate() {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_28);
        String templateContent = null;
        try {
            templateContent = UrlUtil.loadText(MdFreeMarkerProcessor.class.getResource("/template/md.ftl"));
        } catch (IOException e) {
            throw new RuntimeException("模板加载失败");
        }
        StringTemplateLoader stringTemplateLoader = new StringTemplateLoader();
        stringTemplateLoader.putTemplate("MDTemplate", templateContent);
        configuration.setTemplateLoader(stringTemplateLoader);
        try {
            return configuration.getTemplate("MDTemplate");
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    protected Writer getWriter(SourceNoteData sourceNoteData) {
        String fileName = sourceNoteData.getFileName();
        File file = new File(fileName);
        try {
            return new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("文档生成失败");
        }
    }
}
