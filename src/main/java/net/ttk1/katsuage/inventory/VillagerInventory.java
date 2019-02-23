package net.ttk1.katsuage.inventory;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;

public class VillagerInventory implements Inventory {
    private Inventory playerInventory;
    private Inventory villagerInventory;
    private String name;

    public VillagerInventory(Inventory playerInventory, Inventory villagerInventory) {
        this.playerInventory = playerInventory;
        this.villagerInventory = villagerInventory;
        this.name = "Villager's Inventory";
    }

    @Override
    public int getSize() {
        return 9;
    }

    @Override
    public int getMaxStackSize() {
        return villagerInventory.getMaxStackSize();
    }

    @Override
    public void setMaxStackSize(int i) {
        villagerInventory.setMaxStackSize(i);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ItemStack getItem(int i) {
        return villagerInventory.getItem(i);
    }

    @Override
    public void setItem(int i, ItemStack itemStack) {
        // 一番後ろのスロットにセットしようとしたら、止める
        if (i == 8) {
            // アイテムをプレイヤーのインベントリに置き直す

            int playerInventorySize = playerInventory.getSize();

            for(int j = 0; j < playerInventorySize; j++) {
                ItemStack item = playerInventory.getItem(j);

                if (item == null) {
                    playerInventory.setItem(j, itemStack);
                    break;
                }
            }
        }
        else {
            villagerInventory.setItem(i, itemStack);
        }
    }

    @Override
    public HashMap<Integer, ItemStack> addItem(ItemStack... itemStacks) throws IllegalArgumentException {
        return villagerInventory.addItem(itemStacks);
    }

    @Override
    public HashMap<Integer, ItemStack> removeItem(ItemStack... itemStacks) throws IllegalArgumentException {
        return villagerInventory.removeItem(itemStacks);
    }

    @Override
    public ItemStack[] getContents() {
        return villagerInventory.getContents();
    }

    @Override
    public void setContents(ItemStack[] itemStacks) throws IllegalArgumentException {
        villagerInventory.setContents(itemStacks);
    }

    @Override
    public ItemStack[] getStorageContents() {
        return villagerInventory.getStorageContents();
    }

    @Override
    public void setStorageContents(ItemStack[] itemStacks) throws IllegalArgumentException {
        villagerInventory.setStorageContents(itemStacks);
    }

    @Override
    public boolean contains(Material material) throws IllegalArgumentException {
        return villagerInventory.contains(material);
    }

    @Override
    public boolean contains(ItemStack itemStack) {
        return villagerInventory.contains(itemStack);
    }

    @Override
    public boolean contains(Material material, int i) throws IllegalArgumentException {
        return villagerInventory.contains(material, i);
    }

    @Override
    public boolean contains(ItemStack itemStack, int i) {
        return villagerInventory.contains(itemStack, i);
    }

    @Override
    public boolean containsAtLeast(ItemStack itemStack, int i) {
        return villagerInventory.containsAtLeast(itemStack, i);
    }

    @Override
    public HashMap<Integer, ? extends ItemStack> all(Material material) throws IllegalArgumentException {
        return villagerInventory.all(material);
    }

    @Override
    public HashMap<Integer, ? extends ItemStack> all(ItemStack itemStack) {
        return villagerInventory.all(itemStack);
    }

    @Override
    public int first(Material material) throws IllegalArgumentException {
        return villagerInventory.first(material);
    }

    @Override
    public int first(ItemStack itemStack) {
        return villagerInventory.first(itemStack);
    }

    @Override
    public int firstEmpty() {
        return villagerInventory.firstEmpty();
    }

    @Override
    public void remove(Material material) throws IllegalArgumentException {
        villagerInventory.remove(material);
    }

    @Override
    public void remove(ItemStack itemStack) {
        villagerInventory.removeItem(itemStack);
    }

    @Override
    public void clear(int i) {
        villagerInventory.clear(i);
    }

    @Override
    public void clear() {
        villagerInventory.clear();
    }

    @Override
    public List<HumanEntity> getViewers() {
        return villagerInventory.getViewers();
    }

    @Override
    public String getTitle() {
        return villagerInventory.getTitle();
    }

    @Override
    public InventoryType getType() {
        return villagerInventory.getType();
    }

    @Override
    public InventoryHolder getHolder() {
        return villagerInventory.getHolder();
    }

    @Override
    public ListIterator<ItemStack> iterator() {
        return villagerInventory.iterator();
    }

    @Override
    public ListIterator<ItemStack> iterator(int i) {
        return villagerInventory.iterator(i);
    }

    @Override
    public Location getLocation() {
        return villagerInventory.getLocation();
    }
}
