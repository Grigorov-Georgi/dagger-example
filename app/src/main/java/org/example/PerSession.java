package org.example;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import javax.inject.Scope;

@Retention(RUNTIME)
@Scope
@Documented
public @interface PerSession {}
