/*
* IBM Confidential
*
* OCO Source Materials
*
* WLP Copyright IBM Corp. 2017
*
* The source code for this program is not published or otherwise divested
* of its trade secrets, irrespective of what has been deposited with the
* U.S. Copyright Office.
*/
package com.ibm.websphere.simplicity.config.wim;

import javax.xml.bind.annotation.XmlAttribute;

import com.ibm.websphere.simplicity.config.ConfigElement;

/**
 * Configuration for the following nested elements:
 *
 * <ul>
 * <li>federatedRepository --> extendedProperty</li>
 * </ul>
 */
public class ExtendedProperty extends ConfigElement {

    private String dataType;
    private String defaultValue;
    private String entityType;
    private Boolean multiValued;
    private String name;

    public ExtendedProperty() {}

    public ExtendedProperty(String name, String dataType, Boolean multiValued, String defaultValue, String entityType) {
        this.name = name;
        this.dataType = dataType;
        this.multiValued = multiValued;
        this.defaultValue = defaultValue;
        this.entityType = entityType;
    }

    /**
     * @return the dataType
     */
    public String getDataType() {
        return dataType;
    }

    /**
     * @return the defaultValue
     */
    public String getDefaultValue() {
        return defaultValue;
    }

    /**
     * @return the entityType
     */
    public String getEntityType() {
        return entityType;
    }

    /**
     * @return the multiValued
     */
    public Boolean getMultiValued() {
        return multiValued;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param dataType the dataType to set
     */
    @XmlAttribute(name = "dataType")
    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    /**
     * @param defaultValue the defaultValue to set
     */
    @XmlAttribute(name = "defaultValue")
    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    /**
     * @param entityType the entityType to set
     */
    @XmlAttribute(name = "entityType")
    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    /**
     * @param multiValued the multiValued to set
     */
    @XmlAttribute(name = "multiValued")
    public void setMultiValued(Boolean multiValued) {
        this.multiValued = multiValued;
    }

    /**
     * @param name the name to set
     */
    @XmlAttribute(name = "name")
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();

        sb.append(getClass().getSimpleName()).append("{ ");

        if (dataType != null) {
            sb.append("dataType=\"").append(dataType).append("\" ");
        }
        if (defaultValue != null) {
            sb.append("defaultValue=\"").append(defaultValue).append("\" ");;
        }
        if (entityType != null) {
            sb.append("entityType=").append(entityType).append("\" ");;
        }
        if (multiValued != null) {
            sb.append("multiValued=\"").append(multiValued).append("\" ");;
        }
        if (name != null) {
            sb.append("name=\"").append(name).append("\" ");;
        }

        sb.append("}");

        return sb.toString();
    }
}