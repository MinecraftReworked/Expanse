package net.bettermc.expanse.blocks.entity;

import net.bettermc.expanse.blocks.custom.MachineBlockSetup;
import net.bettermc.expanse.items.inventory.ImplementedInventory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.Nullable;
import team.reborn.energy.api.EnergyStorage;
import team.reborn.energy.api.EnergyStorageUtil;
import team.reborn.energy.api.base.SimpleSidedEnergyContainer;

public class BlockEntitySetup extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory,
                                                                 SidedInventory
{
    public final SimpleSidedEnergyContainer energyStorage = new SimpleSidedEnergyContainer() {
        @Override
        public long getCapacity() {
            return BlockEntitySetup.this.getMaxGeneration();
        }

        @Override
        public long getMaxInsert(@Nullable Direction side) {
            return BlockEntitySetup.this.getMaxEnergyInsert();
        }

        @Override
        public long getMaxExtract(@Nullable Direction side) {
            return BlockEntitySetup.this.getMaxEnergyExtract();
        }

        @Override
        protected void onFinalCommit() {
            BlockEntitySetup.this.markDirty();
        }
    };
    private final DefaultedList<ItemStack> inventory;

    public BlockEntitySetup(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState);
        this.inventory = DefaultedList.ofSize(this.getInventorySize(), ItemStack.EMPTY);
    }

    public int getInventorySize() {
        return 0;
    }

    public void tick() {
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return null;
    }

    public long getMaxEnergyInsert() {
        return 0;
    }

    public long getMaxEnergyExtract() {
        return 0;
    }

    public void setActive(boolean active) {
        if (this.getCachedState().contains(MachineBlockSetup.LIT)) {
            this.world.setBlockState(this.getPos(), this.getCachedState().with(MachineBlockSetup.LIT, active));
        }
    }

    public void cumulateEnergy() {
        if (this.energyStorage.amount < this.getMaxGeneration()) {
            this.energyStorage.amount += this.getEnergyPerTick();
        } else if (this.energyStorage.amount > this.getMaxGeneration()) {
            this.energyStorage.amount = this.getMaxGeneration();
        }
        this.markDirty();
    }

    public long getMaxGeneration() {
        return 0;
    }

    public long getEnergyPerTick() {
        return 0;
    }

    public boolean drainEnergy() {
        return this.drainEnergy(this.getEnergyPerTick());
    }

    public boolean drainEnergy(long amount) {
        if (this.energyStorage.amount - amount > 0) {
            this.energyStorage.amount -= amount;
            this.markDirty();
            return true;
        } else {
            this.energyStorage.amount = 0;
            this.markDirty();
            return false;
        }
    }

    // Send energy to surrounding machines.
    public void energyOut() {
        if (this.usesEnergy()) {
            for (Direction direction : Direction.values()) {
                EnergyStorageUtil.move(this.getSideEnergyStorage(direction), EnergyStorage.SIDED.find(
                    this.world,
                    this.pos.offset(direction), direction.getOpposite()
                ), Long.MAX_VALUE, null);
            }
        }
    }

    public boolean usesEnergy() {
        return false;
    }

    public EnergyStorage getSideEnergyStorage(@Nullable Direction side) {
        return this.energyStorage.getSideStorage(side);
    }

    public long getEnergy() {
        return this.energyStorage.amount;
    }

    public boolean hasEnergy() {
        return this.usesEnergy() && this.energyStorage.amount > this.getEnergyPerTick();
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable(this.getCachedState().getBlock().getTranslationKey());
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        if (this.getInventorySize() > 0) {
            Inventories.readNbt(nbt, this.inventory);
        }
        if (this.usesEnergy()) {
            this.energyStorage.amount = nbt.getLong("energy");
        }
    }

    @Override
    public void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        if (this.getInventorySize() > 0) {
            Inventories.writeNbt(nbt, this.inventory);
        }
        if (this.usesEnergy()) {
            nbt.putLong("energy", this.energyStorage.amount);
        }
    }

    // Updates the chunk every time the energy is changed. Important for updating
    // the screen to show the latest energy value.
    @Override
    public void markDirty() {
        super.markDirty();

        if (this.world instanceof ServerWorld world) {
            world.getChunkManager().markForUpdate(this.pos);
        }
    }

    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt() {
        return this.createNbt();
    }

    @Override
    public int[] getAvailableSlots(Direction side) {
        int[] result = new int[this.getItems().size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = i;
        }
        return result;
    }

    @Override
    public boolean canInsert(int slot, ItemStack stack, Direction dir) {
        ItemStack slotStack = this.getStack(slot);
        return slotStack.isEmpty() || (slotStack.isOf(stack.getItem()) && slotStack.getCount() <= slotStack.getMaxCount());
    }

    @Override
    public boolean canExtract(int slot, ItemStack stack, Direction dir) {
        return true;
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return this.inventory;
    }
}

