package com.robertx22.mine_and_slash.database.talent_tree;

import com.robertx22.mine_and_slash.saveclasses.gearitem.gear_bases.ITooltipList;
import net.minecraft.util.ResourceLocation;

public abstract class BasePerkEffect implements ITooltipList {

    protected String guid;
    protected ResourceLocation TEXTURE;

    public PerkType type = PerkType.SMALL;
    public boolean hasTexture = false;

    protected boolean isGameChanger = false;
    public boolean isStart = false;

    public abstract PerkType getPerkType();

    public boolean isGameChanger() {
        return isGameChanger;
    }

    public <T extends BasePerkEffect> T type(PerkType type) {
        this.type = type;
        return (T) this;
    }

    public void render(int x, int y) {
        if (hasTexture) {
            RenderUtils.renderIcon(this.TEXTURE, x, y);
        }
    }

}



