package indi.mofan.chickensoup;

import com.intellij.openapi.components.ApplicationComponent;

/**
 * @author mofan
 * @date 2022/1/26 16:22
 */
public class MyApplicationComponent implements ApplicationComponent {

    @Override
    public void initComponent() {
        System.out.println("initComponent");
        ChickenSoupDialog dialog = new ChickenSoupDialog();
        dialog.show();
    }
}
