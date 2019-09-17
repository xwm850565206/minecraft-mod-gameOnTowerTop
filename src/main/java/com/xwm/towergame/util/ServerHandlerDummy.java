package com.xwm.towergame.util;

import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class ServerHandlerDummy implements IMessageHandler<ParticlePacket, IMessage>
{

    @Override
    public IMessage onMessage(ParticlePacket message, MessageContext ctx)
    {
        return null;
    }

}