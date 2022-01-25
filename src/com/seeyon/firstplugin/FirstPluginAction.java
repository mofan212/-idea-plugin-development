package com.seeyon.firstplugin;

import com.intellij.notification.Notification;
import com.intellij.notification.NotificationDisplayType;
import com.intellij.notification.NotificationGroup;
import com.intellij.notification.Notifications;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.ui.MessageType;
import org.jetbrains.annotations.NotNull;

/**
 * @author cheny
 * @date 2022/1/25 20:30
 */
public class FirstPluginAction extends AnAction {

    @Override
    public void update(@NotNull AnActionEvent e) {
        super.update(e);
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        NotificationGroup group = new NotificationGroup("firstplugin_id", NotificationDisplayType.BALLOON, true);
        Notification notification = group.createNotification("点击测试", MessageType.INFO);
        Notifications.Bus.notify(notification);
    }
}
