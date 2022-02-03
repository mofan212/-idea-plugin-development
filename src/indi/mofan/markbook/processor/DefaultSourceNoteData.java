package indi.mofan.markbook.processor;

import indi.mofan.markbook.data.NoteData;

import java.util.List;

/**
 * @author cheny
 * @date 2022/2/3 20:28
 */
public class DefaultSourceNoteData implements SourceNoteData{

    private String fileName;
    private String topic;
    private List<NoteData> noteList;

    public DefaultSourceNoteData(String fileName, String topic, List<NoteData> noteList) {
        this.fileName = fileName;
        this.topic = topic;
        this.noteList = noteList;
    }

    @Override
    public String getFileName() {
        return this.fileName;
    }

    @Override
    public String getTopic() {
        return this.topic;
    }

    @Override
    public List<NoteData> getNoteList() {
        return this.noteList;
    }
}
