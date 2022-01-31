package indi.mofan.chickensoup;

import com.intellij.openapi.ui.DialogWrapper;
import indi.mofan.util.ContentUtil;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * @author cheny
 * @date 2022/1/28 19:03
 */
public class ChickenSoupDialog extends DialogWrapper {

    private JLabel jLabel;

    protected ChickenSoupDialog() {
       super(true);
       setTitle("每天一碗毒鸡汤");
       init();
    }

    @Override
    protected @Nullable JComponent createCenterPanel() {
        JPanel jPanel = new JPanel();
        jLabel = new JLabel(getContent());
        jPanel.add(jLabel);
        return jPanel;
    }

    @Override
    protected JComponent createSouthPanel() {
        JPanel jPanel = new JPanel();
        JButton jButton = new JButton("再干一碗");
        jPanel.add(jButton);
        jButton.addActionListener(e -> jLabel.setText(getContent()));
        return jPanel;
    }

    private String getContent() {
        return ContentUtil.getChickSoupContent().orElse("api 调用失败 :(");
    }
}
