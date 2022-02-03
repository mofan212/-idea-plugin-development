package indi.mofan.markbook.window;

import com.intellij.notification.Notification;
import com.intellij.notification.NotificationDisplayType;
import com.intellij.notification.NotificationGroup;
import com.intellij.notification.Notifications;
import com.intellij.openapi.fileChooser.FileChooser;
import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.MessageType;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.wm.ToolWindow;
import indi.mofan.markbook.data.DataCenter;
import indi.mofan.markbook.processor.DefaultSourceNoteData;
import indi.mofan.markbook.processor.MdFreeMarkerProcessor;
import indi.mofan.markbook.processor.Processor;

import javax.swing.*;
import java.io.File;

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
            String topic = tfTopic.getText();
            String fileName = topic + ".md";
            if (topic == null || "".equals(topic)) {
                Messages.showMessageDialog("笔记标题未输入", "警告", Messages.getWarningIcon());
                return;
            }
            VirtualFile virtualFile = FileChooser.chooseFile(FileChooserDescriptorFactory.createSingleFolderDescriptor(), project, project.getBaseDir());
            if (virtualFile != null) {
                String path = virtualFile.getPath();
                String fileFullPath = path + File.separator + fileName;
                Processor processor = new MdFreeMarkerProcessor();
                processor.processor(new DefaultSourceNoteData(fileFullPath, topic, DataCenter.NODE_LIST));
                NotificationGroup group = new NotificationGroup("markbook_id", NotificationDisplayType.BALLOON, true);
                Notification notification = group.createNotification("生成文档成功" + fileFullPath, MessageType.INFO);
                Notifications.Bus.notify(notification);
            }
        });
        btnClear.addActionListener(actionEvent -> {
            DataCenter.reset();
        });
        btnClose.addActionListener(actionEvent -> {
            toolWindow.hide();
        });
    }

    public JPanel getContentPanel() {
        return contentPanel;
    }
}
