package net.minecraft.world;

import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import it.unimi.dsi.fastutil.longs.LongSet;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.storage.WorldSavedData;

public class ForcedChunksSaveData extends WorldSavedData {
   private LongSet chunks = new LongOpenHashSet();

   public ForcedChunksSaveData() {
      super("chunks");
   }

   /**
    * reads in data from the NBTTagCompound into this MapDataBase
    */
   public void read(CompoundNBT nbt) {
      this.chunks = new LongOpenHashSet(nbt.getLongArray("Forced"));
      this.blockForcedChunks = new net.minecraftforge.common.world.ForgeChunkManager.TicketTracker<>();
      this.entityForcedChunks = new net.minecraftforge.common.world.ForgeChunkManager.TicketTracker<>();
      net.minecraftforge.common.world.ForgeChunkManager.readForgeForcedChunks(nbt, this.blockForcedChunks, this.entityForcedChunks);
   }

   public CompoundNBT write(CompoundNBT compound) {
      compound.putLongArray("Forced", this.chunks.toLongArray());
      net.minecraftforge.common.world.ForgeChunkManager.writeForgeForcedChunks(compound, this.blockForcedChunks, this.entityForcedChunks);
      return compound;
   }

   public LongSet getChunks() {
      return this.chunks;
   }

   /* ======================================== FORGE START =====================================*/
   private net.minecraftforge.common.world.ForgeChunkManager.TicketTracker<net.minecraft.util.math.BlockPos> blockForcedChunks = new net.minecraftforge.common.world.ForgeChunkManager.TicketTracker<>();
   private net.minecraftforge.common.world.ForgeChunkManager.TicketTracker<java.util.UUID> entityForcedChunks = new net.minecraftforge.common.world.ForgeChunkManager.TicketTracker<>();

   public net.minecraftforge.common.world.ForgeChunkManager.TicketTracker<net.minecraft.util.math.BlockPos> getBlockForcedChunks() {
      return this.blockForcedChunks;
   }

   public net.minecraftforge.common.world.ForgeChunkManager.TicketTracker<java.util.UUID> getEntityForcedChunks() {
      return this.entityForcedChunks;
   }
}
