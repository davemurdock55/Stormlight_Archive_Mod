/*
 * Minecraft Forge
 * Copyright (c) 2016-2021.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation version 2.1
 * of the License.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */

package net.minecraftforge.common.util;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import com.mojang.authlib.GameProfile;

import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.IPacket;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.PacketDirection;
import net.minecraft.network.play.ServerPlayNetHandler;
import net.minecraft.network.play.client.*;
import net.minecraft.network.play.server.SPlayerPositionLookPacket;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.PlayerInteractionManager;
import net.minecraft.stats.Stat;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fml.server.ServerLifecycleHooks;

import java.util.Set;
import java.util.UUID;

//Preliminary, simple Fake Player class
public class FakePlayer extends ServerPlayerEntity
{
    public FakePlayer(ServerWorld world, GameProfile name)
    {
        super(world.getServer(), world, name, new PlayerInteractionManager(world));
        this.connection = new FakePlayerNetHandler(world.getServer(), this);
    }

    @Override public Vector3d getPositionVec(){ return new Vector3d(0, 0, 0); }
    @Override public BlockPos getPosition(){ return BlockPos.ZERO; }
    @Override public void sendStatusMessage(ITextComponent chatComponent, boolean actionBar){}
    @Override public void sendMessage(ITextComponent component, UUID senderUUID) {}
    @Override public void addStat(Stat par1StatBase, int par2){}
    //@Override public void openGui(Object mod, int modGuiId, World world, int x, int y, int z){}
    @Override public boolean isInvulnerableTo(DamageSource source){ return true; }
    @Override public boolean canAttackPlayer(PlayerEntity player){ return false; }
    @Override public void onDeath(DamageSource source){ return; }
    @Override public void tick(){ return; }
    @Override public void handleClientSettings(CClientSettingsPacket pkt){ return; }
    @Override @Nullable public MinecraftServer getServer() { return ServerLifecycleHooks.getCurrentServer(); }

    @ParametersAreNonnullByDefault
    private static class FakePlayerNetHandler extends ServerPlayNetHandler {
        private static final NetworkManager DUMMY_NETWORK_MANAGER = new NetworkManager(PacketDirection.CLIENTBOUND);

        public FakePlayerNetHandler(MinecraftServer server, ServerPlayerEntity player) {
            super(server, DUMMY_NETWORK_MANAGER, player);
        }

        @Override public void tick() { }
        @Override public void captureCurrentPosition() { }
        @Override public void disconnect(ITextComponent message) { }
        @Override public void processInput(CInputPacket packet) { }
        @Override public void processVehicleMove(CMoveVehiclePacket packet) { }
        @Override public void processConfirmTeleport(CConfirmTeleportPacket packet) { }
        @Override public void handleRecipeBookUpdate(CMarkRecipeSeenPacket packet) { }
        @Override public void func_241831_a(CUpdateRecipeBookStatusPacket packet) { }
        @Override public void handleSeenAdvancements(CSeenAdvancementsPacket packet) { }
        @Override public void processTabComplete(CTabCompletePacket packet) { }
        @Override public void processUpdateCommandBlock(CUpdateCommandBlockPacket packet) { }
        @Override public void processUpdateCommandMinecart(CUpdateMinecartCommandBlockPacket packet) { }
        @Override public void processPickItem(CPickItemPacket packet) { }
        @Override public void processRenameItem(CRenameItemPacket packet) { }
        @Override public void processUpdateBeacon(CUpdateBeaconPacket packet) { }
        @Override public void processUpdateStructureBlock(CUpdateStructureBlockPacket packet) { }
        @Override public void func_217262_a(CUpdateJigsawBlockPacket packet) { }
        @Override public void func_230549_a_(CJigsawBlockGeneratePacket packet) { }
        @Override public void processSelectTrade(CSelectTradePacket packet) { }
        @Override public void processEditBook(CEditBookPacket packet) { }
        @Override public void processNBTQueryEntity(CQueryEntityNBTPacket packet) { }
        @Override public void processNBTQueryBlockEntity(CQueryTileEntityNBTPacket packet) { }
        @Override public void processPlayer(CPlayerPacket packet) { }
        @Override public void setPlayerLocation(double x, double y, double z, float yaw, float pitch) { }
        @Override public void setPlayerLocation(double x, double y, double z, float yaw, float pitch, Set<SPlayerPositionLookPacket.Flags> flags) { }
        @Override public void processPlayerDigging(CPlayerDiggingPacket packet) { }
        @Override public void processTryUseItemOnBlock(CPlayerTryUseItemOnBlockPacket packet) { }
        @Override public void processTryUseItem(CPlayerTryUseItemPacket packet) { }
        @Override public void handleSpectate(CSpectatePacket packet) { }
        @Override public void handleResourcePackStatus(CResourcePackStatusPacket packet) { }
        @Override public void processSteerBoat(CSteerBoatPacket packet) { }
        @Override public void onDisconnect(ITextComponent message) { }
        @Override public void sendPacket(IPacket<?> packet) { }
        @Override public void sendPacket(IPacket<?> packet, @Nullable GenericFutureListener<? extends Future<? super Void>> futureListeners) { }
        @Override public void processHeldItemChange(CHeldItemChangePacket packet) { }
        @Override public void processChatMessage(CChatMessagePacket packet) { }
        @Override public void handleAnimation(CAnimateHandPacket packet) { }
        @Override public void processEntityAction(CEntityActionPacket packet) { }
        @Override public void processUseEntity(CUseEntityPacket packet) { }
        @Override public void processClientStatus(CClientStatusPacket packet) { }
        @Override public void processCloseWindow(CCloseWindowPacket packet) { }
        @Override public void processClickWindow(CClickWindowPacket packet) { }
        @Override public void processPlaceRecipe(CPlaceRecipePacket packet) { }
        @Override public void processEnchantItem(CEnchantItemPacket packet) { }
        @Override public void processCreativeInventoryAction(CCreativeInventoryActionPacket packet) { }
        @Override public void processConfirmTransaction(CConfirmTransactionPacket packet) { }
        @Override public void processUpdateSign(CUpdateSignPacket packet) { }
        @Override public void processKeepAlive(CKeepAlivePacket packet) { }
        @Override public void processPlayerAbilities(CPlayerAbilitiesPacket packet) { }
        @Override public void processClientSettings(CClientSettingsPacket packet) { }
        @Override public void processCustomPayload(CCustomPayloadPacket packet) { }
        @Override public void func_217263_a(CSetDifficultyPacket packet) { }
        @Override public void func_217261_a(CLockDifficultyPacket packet) { }
    }
}
