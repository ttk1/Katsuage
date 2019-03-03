package net.ttk1.katsuage.inventory;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantInventory;
import org.bukkit.inventory.MerchantRecipe;

import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;

public class MyMerchantInventory implements MerchantInventory {
    private MerchantInventory merchantInventory;

    public MyMerchantInventory(MerchantInventory merchantInventory) {
        this.merchantInventory = merchantInventory;
    }

    @Override
    public int getSelectedRecipeIndex() {
        return merchantInventory.getSelectedRecipeIndex();
    }

    @Override
    public MerchantRecipe getSelectedRecipe() {
        return merchantInventory.getSelectedRecipe();
    }

    @Override
    public int getSize() {
        return merchantInventory.getSize();
    }

    @Override
    public int getMaxStackSize() {
        return merchantInventory.getMaxStackSize();
    }

    @Override
    public void setMaxStackSize(int i) {
        merchantInventory.setMaxStackSize(i);
    }

    @Override
    public String getName() {
        return merchantInventory.getName();
    }

    @Override
    public ItemStack getItem(int i) {
        return merchantInventory.getItem(i);
    }

    @Override
    public void setItem(int i, ItemStack itemStack) {
        merchantInventory.setItem(i, itemStack);
    }

    @Override
    public HashMap<Integer, ItemStack> addItem(ItemStack... itemStack) throws IllegalArgumentException {
        return merchantInventory.addItem(itemStack);
    }

    @Override
    public HashMap<Integer, ItemStack> removeItem(ItemStack... itemStack) throws IllegalArgumentException {
        return merchantInventory.removeItem(itemStack);
    }

    @Override
    public ItemStack[] getContents() {
        return merchantInventory.getContents();
    }

    @Override
    public void setContents(ItemStack[] itemStack) throws IllegalArgumentException {
        merchantInventory.setContents(itemStack);
    }

    @Override
    public ItemStack[] getStorageContents() {
        return merchantInventory.getStorageContents();
    }

    @Override
    public void setStorageContents(ItemStack[] itemStack) throws IllegalArgumentException {
        merchantInventory.setStorageContents(itemStack);
    }

    @Override
    public boolean contains(Material material) throws IllegalArgumentException {
        return merchantInventory.contains(material);
    }

    @Override
    public boolean contains(ItemStack itemStack) {
        return merchantInventory.contains(itemStack);
    }

    @Override
    public boolean contains(Material material, int i) throws IllegalArgumentException {
        return merchantInventory.contains(material, i);
    }

    @Override
    public boolean contains(ItemStack itemStack, int i) {
        return merchantInventory.contains(itemStack, i);
    }

    @Override
    public boolean containsAtLeast(ItemStack itemStack, int i) {
        return merchantInventory.containsAtLeast(itemStack, i);
    }

    @Override
    public HashMap<Integer, ? extends ItemStack> all(Material material) throws IllegalArgumentException {
        return merchantInventory.all(material);
    }

    @Override
    public HashMap<Integer, ? extends ItemStack> all(ItemStack itemStack) {
        return merchantInventory.all(itemStack);
    }

    @Override
    public int first(Material material) throws IllegalArgumentException {
        return merchantInventory.first(material);
    }

    @Override
    public int first(ItemStack itemStack) {
        return merchantInventory.first(itemStack);
    }

    @Override
    public int firstEmpty() {
        return merchantInventory.firstEmpty();
    }

    @Override
    public void remove(Material material) throws IllegalArgumentException {
        merchantInventory.remove(material);
    }

    @Override
    public void remove(ItemStack itemStack) {
        merchantInventory.remove(itemStack);
    }

    @Override
    public void clear(int i) {
        merchantInventory.clear(i);
    }

    @Override
    public void clear() {
        merchantInventory.clear();
    }

    @Override
    public List<HumanEntity> getViewers() {
        return merchantInventory.getViewers();
    }

    @Override
    public String getTitle() {
        return merchantInventory.getTitle();
    }

    @Override
    public InventoryType getType() {
        return merchantInventory.getType();
    }

    @Override
    public InventoryHolder getHolder() {
        return merchantInventory.getHolder();
    }

    @Override
    public ListIterator<ItemStack> iterator() {
        return merchantInventory.iterator();
    }

    @Override
    public ListIterator<ItemStack> iterator(int i) {
        return merchantInventory.iterator(i);
    }

    @Override
    public Location getLocation() {
        return merchantInventory.getLocation();
    }
}
