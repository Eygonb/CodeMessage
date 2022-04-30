package ru.vsu.tp.CodeMessage.exception.exceptions;

import org.springframework.http.HttpStatus;
import ru.vsu.tp.CodeMessage.exception.ApiError;
import ru.vsu.tp.CodeMessage.exception.BaseException;

public class PageNotFoundException extends BaseException {

    private static PageNotFoundException INSTANCE;

    public static PageNotFoundException getInstance() {
        if (INSTANCE == null)
            INSTANCE = new PageNotFoundException();
        return INSTANCE;
    }

    private PageNotFoundException() {
        super(new ApiError(
                        "page-not-found",
                        "Страница не найдена."
                ), HttpStatus.NOT_FOUND
        );
    }
}
