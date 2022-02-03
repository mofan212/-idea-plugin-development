package indi.mofan.markbook.window;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import indi.mofan.markbook.data.DataCenter;

import javax.swing.*;

/**
 * @author cheny
 * @date 2022/1/31 19:28
 */
public class NoteListWindow {
    private JTextField tfTopic;
    private JTable tbContent;
    private JButton btnCreate;
    private JButton btnClear;
    private JButton btnClose;
    private JPanel contentPanel;

    private void init() {
        this.tbContent.setModel(DataCenter.TABLE_MODEL);
        this.tbContent.setEnabled(true);
    }

    public NoteListWindow(Project project, ToolWindow toolWindow) {
        init();
        btnCreate.addActionListener(actionEvent -> {

        });
        btnClear.addActionListener(actionEvent -> {

        });
        btnClose.addActionListener(actionEvent -> {

        });
    }

    public JPanel getContentPanel() {
        return contentPanel;
    }
}
