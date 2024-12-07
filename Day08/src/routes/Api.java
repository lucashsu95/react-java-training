package routes;

import static lib.Functions.*;
import static lib.Const.*;

import controllers.UserController;
import controllers.AuthController;
import controllers.ProductController;

public class Api {

    public static void main() {
        boolean action = true;
        while (action) {
            action = Api.api();
        }
    }

    public static boolean api() {
        String nextAction = "";
        nextAction = OutAndInput(getMainTip());
        switch (nextAction) {
            case "0":
                return false;
            case "1":
                AuthController.login();
                return true;
            case "2":
                UserController.signUp();
                return true;
            case "3":
                infomationApi();
                return true;
            case "4":
                AuthController.logout();
                return true;
            case "5":
                manageProductApi();
                return true;
            case "6":
                manageUserApi();
                return true;
            case "7":
                userProductApi();
                return true;
            case "8":
                UserController.viewRecord();
                return true;
            default:
                break;
        }
        return false;
    }

    public static void infomationApi() {
        String key = OutAndInput(getInformationTip());

        switch (key) {
            case "0":
                break;
            case "1":
                ProductController.printProduct();
                break;
            case "2":
                System.out.println("water 折 2 元，最低 1 元；juice 二杯 8折");
                break;
            default:
                break;
        }
    }

    public static void manageProductApi() {
        if (!AuthController.hasLogin()) {
            System.out.println("請先登入");
            return;
        }
        if (!AuthController.checkPermission()) {
            System.out.println("權限不足");
            return;
        }

        String key = OutAndInput(getManageProductTip());
        switch (key) {
            case "0":
                break;
            case "1":
                ProductController.addProduct();
                break;
            case "2":
                ProductController.updateProduct();
                break;
            case "3":
                ProductController.deleteProduct();
                break;
            default:
                break;
        }
    }

    public static void manageUserApi() {
        if (!AuthController.hasLogin()) {
            System.out.println("請先登入");
            return;
        }
        if (!AuthController.checkPermission()) {
            System.out.println("權限不足");
            return;
        }
        String key = OutAndInput(getManageUserTip());
        switch (key) {
            case "0":
                break;
            case "1":
                UserController.printAllUser();
                break;
            case "2":
                UserController.addUser();
                break;
            default:
                break;
        }
    }

    public static void userProductApi() {
        if (!AuthController.hasLogin()) {
            System.out.println("請先登入");
            return;
        }

        String key = OutAndInput(getUserProductTip());
        switch (key) {
            case "0":
                break;
            case "1":
                ProductController.buyProduct();
                break;
            default:
                break;
        }
    }

}
