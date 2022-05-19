package com.doubleclick;

import java.lang.System;

/**
 * Created By Eslam Ghazy on 3/12/2022
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u000b"}, d2 = {"Lcom/doubleclick/OnCartLisnter;", "", "OnAddItemOrder", "", "cart", "Lcom/doubleclick/marktinhome/Model/Cart;", "pos", "", "OnDeleteItemOrder", "OnMinsItemOrder", "getCart", "app_debug"})
public abstract interface OnCartLisnter {
    
    public abstract void getCart(@org.jetbrains.annotations.NotNull()
    com.doubleclick.marktinhome.Model.Cart cart);
    
    public abstract void OnAddItemOrder(@org.jetbrains.annotations.NotNull()
    com.doubleclick.marktinhome.Model.Cart cart, int pos);
    
    public abstract void OnMinsItemOrder(@org.jetbrains.annotations.NotNull()
    com.doubleclick.marktinhome.Model.Cart cart, int pos);
    
    public abstract void OnDeleteItemOrder(@org.jetbrains.annotations.NotNull()
    com.doubleclick.marktinhome.Model.Cart cart, int pos);
}