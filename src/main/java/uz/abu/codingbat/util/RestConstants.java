package uz.abu.codingbat.util;

import uz.abu.codingbat.controller.cotract.AttachmentController;
import uz.abu.codingbat.controller.cotract.AuthController;
import uz.abu.codingbat.controller.cotract.LanguageController;

public interface RestConstants {
    String DEFAULT_PAGE_NUMBER = "0";
    String DEFAULT_PAGE_SIZE = "10";

    String AUTHENTICATION_HEADER = "Authorization";

    String[] OPEN_PAGES = {
            "/*",
            AuthController.AUTH_CONTROLLER_BASE_PATH + "/**",
            LanguageController.BASE_PATH+ LanguageController.LIST_FOR_USERS_PATH,
            AttachmentController.BASE_PATH+"/load-db/*",
            AttachmentController.BASE_PATH+"/load-fs/*",
            "/api/user/test",
    };
}
