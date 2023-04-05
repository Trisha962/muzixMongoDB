package com.example.muzix.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT,reason = "Music Already Exists")
public class MusicAlreadyExistException extends Exception {
}
