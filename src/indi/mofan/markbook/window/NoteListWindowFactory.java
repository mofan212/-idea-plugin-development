package indi.mofan.markbook.window;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import org.jetbrains.annotations.NotNull;

/**
 * @author cheny
 * @date 2022/2/3 11:53
 */
public class NoteListWindowFactory  implements ToolWindowFactory {
    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        // 创建出 NoteListWindow 对象
        NoteListWindow noteListWindow = new NoteListWindow(project, toolWindow);
        // 获取内容工程的实例
        ContentFactory contentFactory = ContentFactory.SERVICE.getInstance();
        // 获取用于 toolWindow 的显示内容
        Content content = contentFactory.createContent(noteListWindow.getContentPanel(), "", false);
        // 给 toolWindow 设置内容
        toolWindow.getContentManager().addContent(content);
    }
}
