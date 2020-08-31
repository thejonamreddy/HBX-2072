package com.jonamlabs.hibernatetoolsdemo;

import org.hibernate.cfg.reveng.DefaultReverseEngineeringStrategy;
import org.hibernate.cfg.reveng.TableIdentifier;

public class CustomReverseEngineeringStrategy extends DefaultReverseEngineeringStrategy {

    private static final String ENTITY_SUFFIX = "Entity";

    @Override
    public String tableToClassName(TableIdentifier tableIdentifier) {
        String baseName = super.tableToClassName(tableIdentifier);
        return baseName + ENTITY_SUFFIX;
    }

}