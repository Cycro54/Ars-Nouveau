package com.hollingsworth.arsnouveau.network;

import com.hollingsworth.arsnouveau.api.ArsNouveauAPI;
import com.hollingsworth.arsnouveau.client.gui.GuiSpellBook;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class PacketOpenGUI{
    public CompoundNBT tag;
    public int tier;
    //Decoder
    public PacketOpenGUI(PacketBuffer buf){
        tag = buf.readCompoundTag();
        tier = buf.readInt();
    }

    //Encoder
    public void toBytes(PacketBuffer buf){
        buf.writeCompoundTag(tag);
        buf.writeInt(tier);
    }

    public PacketOpenGUI(CompoundNBT tag, int tier){
        this.tag = tag;
        this.tier = tier;
    }

    public void handle(Supplier<NetworkEvent.Context> ctx){
        ctx.get().enqueueWork(()-> GuiSpellBook.open(ArsNouveauAPI.getInstance(), tag, tier));
        ctx.get().setPacketHandled(true);
    }

}