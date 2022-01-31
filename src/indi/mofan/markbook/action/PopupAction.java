package indi.mofan.markbook.action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;
import indi.mofan.markbook.data.DataCenter;
import indi.mofan.markbook.dialog.AddNoteDialog;
import org.jetbrains.annotations.NotNull;

/**
 * @author cheny
 * @date 2022/1/31 18:37
 */
public class PopupAction extends AnAction {

    @Override
    public void actionPerformed(@NotNull AnActionEvent event) {
        // 获取选择的文字
        Editor editor = event.getRequiredData(CommonDataKeys.EDITOR);
        SelectionModel selectionModel = editor.getSelectionModel();
        DataCenter.SELECT_TEXT = selectionModel.getSelectedText();
        // 获取选择文字所在的文件
        DataCenter.FILE_NAME = event.getRequiredData(CommonDataKeys.PSI_FILE).getViewProvider().getVirtualFile().getName();
        // 创建编写的笔记框
        AddNoteDialog addNoteDialog = new AddNoteDialog();
        addNoteDialog.show();
    }
}
