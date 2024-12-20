package lib;

import controllers.AuthController;
import store.Store;

public class Const {

    public static String getMainTip() {
        String displayString = "# 可用動作：\n- 0:結束程式\n";
        if (AuthController.hasLogin()) {
            displayString += "- 3:資訊查詢\n- 4:登出";

            if (Store.currentUser.get("role").equals("老闆")) {
                displayString += "\n- 5:管理商品";
                displayString += "\n- 6:管理使用者";
            } else if (Store.currentUser.get("role").equals("顧客")) {
                displayString += "\n- 7:購買商品";
                displayString += "\n- 8:查看購買記錄";
            }
        } else {
            displayString += "- 1:登入\n" + //
                    "- 2:註冊帳號\n" + //
                    "- 3:資訊查詢";
        }

        return "\n" + displayString + "\n";
    }

    public static String getManageProductTip() {
        String displayString = "# 可用動作：\n- 0:返回上一頁" + //
                "\n- 1:新增商品" + //
                "\n- 2:修改商品" + //
                "\n- 3:刪除商品";
        return displayString + "\n";
    }

    public static String getUserProductTip() {
        String displayString = "# 可用動作：\n- 0:返回上一頁" + //
                "\n- 1:購買商品";
        return displayString + "\n";
    }

    public static String getInformationTip() {
        String displayString = "# 可用動作：\n- 0:返回上一頁" + //
                "\n- 1:查看商品" + //
                "\n- 2:查看優惠";
        return displayString + "\n";
    }

    public static String getManageUserTip() {
        String displayString = "# 可用動作：\n- 0:返回上一頁" + //
                "\n- 1:查看使用者" + //
                "\n- 2:新增使用者";
        return displayString + "\n";
    }

    public static String getPaymentTip() {
        String displayString = "# 可用動作：" + //
                "\n- 0:現金" + //
                "\n- 1:Line Pay付款" + //
                "\n- 2:Apple Pay付款";
        return displayString + "\n";
    }

}
