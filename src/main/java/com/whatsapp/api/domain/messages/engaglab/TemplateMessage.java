package com.whatsapp.api.domain.messages.engaglab;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.whatsapp.api.domain.messages.Component;
import com.whatsapp.api.domain.messages.Language;
import com.whatsapp.api.domain.templates.type.LanguageType;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Template message.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TemplateMessage {
    private List<Component> components;
    private String name;
    private LanguageType language;

    /**
     * Gets components.
     *
     * @return the components
     */
    public List<Component> getComponents() {
        return components;
    }

    /**
     * Sets components.
     *
     * @param components the components
     * @return the components
     */
    public TemplateMessage setComponents(List<Component> components) {
        this.components = components;
        return this;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     * @return the name
     */
    public TemplateMessage setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Gets language.
     *
     * @return the language
     */
    public LanguageType getLanguage() {
        return language;
    }

    /**
     * Sets language.
     *
     * @param language the language
     * @return the language
     */
    public TemplateMessage setLanguage(LanguageType language) {
        this.language = language;
        return this;
    }


    /**
     * Add component template message.
     *
     * @param component the component
     * @return the template message
     */
    public TemplateMessage addComponent(Component component) {
        if (this.components == null) this.components = new ArrayList<>();

        this.components.add(component);
        return this;

    }


}