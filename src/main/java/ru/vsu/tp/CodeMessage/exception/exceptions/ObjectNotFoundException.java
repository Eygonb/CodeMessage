package ru.vsu.tp.CodeMessage.exception.exceptions;

import org.springframework.http.HttpStatus;
import ru.vsu.tp.CodeMessage.exception.ApiError;
import ru.vsu.tp.CodeMessage.exception.BaseException;

public class ObjectNotFoundException extends BaseException {

    private static ObjectNotFoundException INSTANCE;

    public static ObjectNotFoundException getInstance() {
        if (INSTANCE == null)
            INSTANCE = new ObjectNotFoundException();
        return INSTANCE;
    }

    private ObjectNotFoundException() {
        super(new ApiError(
                        "object-not-found-in-database",
                        "Объект не был найден в базе данных."
                ), HttpStatus.NOT_FOUND
        );
    }
}
