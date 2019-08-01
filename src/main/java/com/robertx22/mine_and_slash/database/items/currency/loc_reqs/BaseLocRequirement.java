package com.robertx22.mine_and_slash.database.items.currency.loc_reqs;

import net.minecraft.util.text.ITextComponent;

public abstract class BaseLocRequirement {

    public abstract ITextComponent getText();

    public abstract boolean isAllowed(Object object);

    public boolean isNotAllowed(Object object) {
        return this.isAllowed(object) == false;
    }

}