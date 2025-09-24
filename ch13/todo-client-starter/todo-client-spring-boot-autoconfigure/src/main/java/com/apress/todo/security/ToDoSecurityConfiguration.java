package com.apress.todo;

import com.apress.todo.annotation.Algorithm;
import com.apress.todo.annotation.EnableToDoSecurity;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

public class ToDoSecurityConfiguration implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        AnnotationAttributes attributes = AnnotationAttributes.fromMap(annotationMetadata.getAnnotationAttributes(EnableToDoSecurity.class.getName(), false));
        Algorithm algorithm = attributes.getEnum("algorithm");
        // A cleaner version using a Java 17's feature
        return switch (algorithm) {
            case PBKDF2 -> new String[]{"com.apress.todo.security.Pbkdf2Encoder"};
            case BCRYPT -> new String[]{"com.apress.todo.security.BCryptEncoder"};
        };
    }
}
