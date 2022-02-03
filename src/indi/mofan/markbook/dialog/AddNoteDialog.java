package indi.mofan.markbook.dialog;

import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.ui.EditorTextField;
import indi.mofan.markbook.data.DataCenter;
import indi.mofan.markbook.data.DataConvert;
import indi.mofan.markbook.data.NoteData;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;

/**
 * @author cheny
 * @date 2022/1/31 18:44
 */
public class AddNoteDialog extends DialogWrapper {
    private EditorTextField tfTitle;
    private EditorTextField tfMark;

    public AddNoteDialog() {
        super(true);
        setTitle("添加笔记注释");
        init();
    }

    @Override
    protected @Nullable
    JComponent createCenterPanel() {
        // 使用边界布局
        JPanel jPanel = new JPanel(new BorderLayout());
        // 设置两个编辑框，用于输入笔记标题和内容
        tfTitle = new EditorTextField("笔记标题");
        tfMark = new EditorTextField("笔记内容");
        tfMark.setPreferredSize(new Dimension(200, 200));
        // 组件添加并设置布局
        jPanel.add(tfTitle, BorderLayout.NORTH);
        jPanel.add(tfMark, BorderLayout.CENTER);
        return jPanel;
    }

    @Override
    protected JComponent createSouthPanel() {
        // 设置弹框下边的按钮内容
        JPanel jPanel = new JPanel();
        JButton jButton = new JButton("添加笔记到列表");
        jButton.addActionListener(e -> {
            String title = tfTitle.getText();
            String mark = tfMark.getText();
            String fileType = DataCenter.FILE_NAME.substring(DataCenter.FILE_NAME.lastIndexOf(".") + 1);
            NoteData noteData = new NoteData(title, mark, DataCenter.SELECT_TEXT, DataCenter.FILE_NAME, fileType);
            DataCenter.NODE_LIST.add(noteData);
            DataCenter.TABLE_MODEL.addRow(DataConvert.convert(noteData));
        });
        jPanel.add(jButton);
        return jPanel;
    }
}
