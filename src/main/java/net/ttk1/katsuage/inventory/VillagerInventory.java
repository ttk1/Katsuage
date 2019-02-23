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
    private Inventory originalInventory;
    private String name;

    public VillagerInventory (Inventory inventory) {
        this.originalInventory = inventory;
        this.name = "Villager's Inventory";
    }

    @Override
    public int getSize() {
        return 9;
    }

    @Override
    public int getMaxStackSize() {
        return originalInventory.getMaxStackSize();
    }

    @Override
    public void setMaxStackSize(int i) {
        originalInventory.setMaxStackSize(i);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ItemStack getItem(int i) {
        return originalInventory.getItem(i);
    }

    @Override
    public void setItem(int i, ItemStack itemStack) {
        originalInventory.setItem(i, itemStack);
    }

    @Override
    public HashMap<Integer, ItemStack> addItem(ItemStack... itemStacks) throws IllegalArgumentException {
        return originalInventory.addItem(itemStacks);
    }

    @Override
    public HashMap<Integer, ItemStack> removeItem(ItemStack... itemStacks) throws IllegalArgumentException {
        return originalInventory.removeItem(itemStacks);
    }

    @Override
    public ItemStack[] getContents() {
        return originalInventory.getContents();
    }

    @Override
    public void setContents(ItemStack[] itemStacks) throws IllegalArgumentException {
        originalInventory.setContents(itemStacks);
    }

    @Override
    public ItemStack[] getStorageContents() {
        return originalInventory.getStorageContents();
    }

    @Override
    public void setStorageContents(ItemStack[] itemStacks) throws IllegalArgumentException {
        originalInventory.setStorageContents(itemStacks);
    }

    @Override
    public boolean contains(Material material) throws IllegalArgumentException {
        return originalInventory.contains(material);
    }

    @Override
    public boolean contains(ItemStack itemStack) {
        return originalInventory.contains(itemStack);
    }

    @Override
    public boolean contains(Material material, int i) throws IllegalArgumentException {
        return originalInventory.contains(material, i);
    }

    @Override
    public boolean contains(ItemStack itemStack, int i) {
        return originalInventory.contains(itemStack, i);
    }

    @Override
    public boolean containsAtLeast(ItemStack itemStack, int i) {
        return originalInventory.containsAtLeast(itemStack, i);
    }

    @Override
    public HashMap<Integer, ? extends ItemStack> all(Material material) throws IllegalArgumentException {
        return originalInventory.all(material);
    }

    @Override
    public HashMap<Integer, ? extends ItemStack> all(ItemStack itemStack) {
        return originalInventory.all(itemStack);
    }

    @Override
    public int first(Material material) throws IllegalArgumentException {
        return originalInventory.first(material);
    }

    @Override
    public int first(ItemStack itemStack) {
        return originalInventory.first(itemStack);
    }

    @Override
    public int firstEmpty() {
        return originalInventory.firstEmpty();
    }

    @Override
    public void remove(Material material) throws IllegalArgumentException {
        originalInventory.remove(material);
    }

    @Override
    public void remove(ItemStack itemStack) {
        originalInventory.removeItem(itemStack);
    }

    @Override
    public void clear(int i) {
        originalInventory.clear(i);
    }

    @Override
    public void clear() {
        originalInventory.clear();
    }

    @Override
    public List<HumanEntity> getViewers() {
        return originalInventory.getViewers();
    }

    @Override
    public String getTitle() {
        return originalInventory.getTitle();
    }

    @Override
    public InventoryType getType() {
        return originalInventory.getType();
    }

    @Override
    public InventoryHolder getHolder() {
        return originalInventory.getHolder();
    }

    @Override
    public ListIterator<ItemStack> iterator() {
        return originalInventory.iterator();
    }

    @Override
    public ListIterator<ItemStack> iterator(int i) {
        return originalInventory.iterator(i);
    }

    @Override
    public Location getLocation() {
        return originalInventory.getLocation();
    }
}
