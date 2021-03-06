package com.robertx22.mine_and_slash.packets;

import com.robertx22.mine_and_slash.mmorpg.registers.common.ConfigRegister;
import com.robertx22.mine_and_slash.registry.SlashRegistry;
import com.robertx22.mine_and_slash.registry.SlashRegistryPackets;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class OnLoginClientPacket {

    public enum When {
        BEFORE, AFTER
    }

    public When when;

    public OnLoginClientPacket(When when) {
        this.when = when;
    }

    public static OnLoginClientPacket decode(PacketBuffer buf) {
        return new OnLoginClientPacket(When.valueOf(buf.readString(10)));
    }

    public static void encode(OnLoginClientPacket packet, PacketBuffer tag) {
        tag.writeString(packet.when.name(), 10);
    }

    public static void handle(final OnLoginClientPacket pkt, Supplier<NetworkEvent.Context> ctx) {

        ctx.get()
            .enqueueWork(() -> {
                try {
                    DistExecutor.runWhenOn(Dist.CLIENT, () -> () -> {

                        if (pkt.when == When.BEFORE) {
                            ConfigRegister.unregisterFlaggedEntries();
                        }
                        if (pkt.when == When.AFTER) {
                            SlashRegistry.backup();
                            SlashRegistryPackets.registerAll();
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

        ctx.get()
            .setPacketHandled(true);

    }

}