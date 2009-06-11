package org.ourproject.kune.platf.client.actions.ui;

public class BasicGuiBinding {

    public BasicGuiBinding(final GuiBindingsRegister bindings) {
        bindings.register(MenuDescriptor.class, new MenuBinding());
        final MenuItemBinding menuItemBinding = new MenuItemBinding();
        bindings.register(MenuRadioItemDescriptor.class, menuItemBinding);
        bindings.register(MenuCheckItemDescriptor.class, menuItemBinding);
        bindings.register(MenuItemDescriptor.class, menuItemBinding);
        bindings.register(MenuSeparatorDescriptor.class, new MenuSeparatorBinding());
        bindings.register(PushButtonDescriptor.class, new PushButtonBinding());
        bindings.register(ButtonDescriptor.class, new ButtonBinding());
        bindings.register(ToolbarSeparatorDescriptor.class, new ToolbarSeparatorBinding());
    }
}