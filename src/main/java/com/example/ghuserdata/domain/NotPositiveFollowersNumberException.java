package com.example.ghuserdata.domain;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class NotPositiveFollowersNumberException extends RuntimeException {}
