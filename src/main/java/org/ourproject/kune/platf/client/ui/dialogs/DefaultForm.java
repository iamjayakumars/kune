/*
 *
 * Copyright (C) 2007-2011 The kune development team (see CREDITS for details)
 * This file is part of kune.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 \*/
package org.ourproject.kune.platf.client.ui.dialogs;

import com.gwtext.client.core.Position;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.Component;
import com.gwtext.client.widgets.PaddedPanel;
import com.gwtext.client.widgets.form.Field;
import com.gwtext.client.widgets.form.FieldSet;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.client.widgets.form.Label;
import com.gwtext.client.widgets.form.event.FormPanelListener;

public class DefaultForm {

    public static final int DEF_FIELD_WIDTH = 200;
    public static final int DEF_SMALL_FIELD_WIDTH = 100;
    public static final int DEF_XSMALL_FIELD_WIDTH = 50;
    public static final int DEF_MEDIUM_FIELD_WIDTH = 150;
    public static final int DEF_FIELD_LABEL_WITH = 75;

    private final FormPanel form;

    public DefaultForm() {
        this(Position.RIGHT);
    }

    public DefaultForm(Position buttonAlign) {
        form = new FormPanel();
        form.setFrame(true);
        form.setPaddings(10);
        form.setBorder(false);
        form.setLabelWidth(DEF_FIELD_LABEL_WITH);
        form.setLabelAlign(Position.RIGHT);
        form.setButtonAlign(buttonAlign);
        form.setHeader(false);
    }

    public DefaultForm(String title) {
        this(title, Position.RIGHT);
    }

    public DefaultForm(String title, Position buttonAlign) {
        this(buttonAlign);
        form.setTitle(title);
    }

    public void add(final Field field) {
        form.add(field);
    }

    public void add(final FieldSet fieldset) {
        form.add(fieldset);
    }

    public void add(Label label) {
        form.add(label);
    }

    public void add(PaddedPanel paddedPanel) {
        form.add(paddedPanel);
    }

    public void addButton(final Button button) {
        form.addButton(button);
    }

    public void addListener(FormPanelListener listener) {
        form.addListener(listener);
    }

    public void addStyleName(final String cls) {
        form.addStyleName(cls);
    }

    public Field findField(String id) {
        return form.getForm().findField(id);
    }

    public FormPanel getFormPanel() {
        return form;
    }

    public void insert(int index, Component component) {
        form.insert(index, component);
    }

    public boolean isValid() {
        return form.getForm().isValid();
    }

    public void removeStyleName(final String cls) {
        form.removeStyleName(cls);
    }

    public void reset() {
        form.getForm().reset();
    }

    public void setAutoHeight(final boolean autoHeight) {
        form.setAutoHeight(autoHeight);
    }

    public void setAutoWidth(final boolean autoWidth) {
        form.setAutoWidth(autoWidth);
    }

    public void setFrame(boolean frame) {
        form.setFrame(frame);
    }

    public void setHeight(int height) {
        form.setHeight(height);
    }

    public void setHideLabels(boolean hide) {
        form.setHideLabels(hide);
    }

    public void setIconCls(String iconCls) {
        form.setIconCls(iconCls);
    }

    public void setPaddings(int padding) {
        form.setPaddings(padding);
    }

    public void setWidth(int width) {
        form.setWidth(width);
    }

    public void validate() {
        final Field[] fields = form.getFields();
        for (Field field : fields) {
            field.validate();
        }
    }
}
