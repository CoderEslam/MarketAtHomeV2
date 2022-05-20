package com.doubleclick.marktinhome.ui.MainScreen.Frgments;

import java.lang.System;

/**
 * A simple [Fragment] subclass.
 * Use the [CartFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001cH\u0017J\u0018\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001cH\u0017J\u0018\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001cH\u0017J\u0006\u0010\u001f\u001a\u00020\u0019J\u0010\u0010 \u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000eH\u0016J\u0012\u0010!\u001a\u00020\u00192\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J&\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020\'2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0017J\b\u0010*\u001a\u00020\u0019H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0005X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006+"}, d2 = {"Lcom/doubleclick/marktinhome/ui/MainScreen/Frgments/CartFragment;", "Lcom/doubleclick/marktinhome/BaseFragment;", "Lcom/doubleclick/OnCartLisnter;", "()V", "Continue", "Landroid/widget/TextView;", "cartAdapter", "Lcom/doubleclick/marktinhome/Adapters/CartAdapter;", "cartRecycler", "Landroidx/recyclerview/widget/RecyclerView;", "cartViewModel", "Lcom/doubleclick/ViewModel/CartViewModel;", "carts", "Ljava/util/ArrayList;", "Lcom/doubleclick/marktinhome/Model/Cart;", "Lkotlin/collections/ArrayList;", "myOrder", "getMyOrder", "()Landroid/widget/TextView;", "setMyOrder", "(Landroid/widget/TextView;)V", "total", "", "totalPrice", "OnAddItemOrder", "", "cart", "pos", "", "OnDeleteItemOrder", "OnMinsItemOrder", "calculatePrice", "getCart", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onPause", "app_debug"})
public final class CartFragment extends com.doubleclick.marktinhome.BaseFragment implements com.doubleclick.OnCartLisnter {
    private com.doubleclick.ViewModel.CartViewModel cartViewModel;
    private androidx.recyclerview.widget.RecyclerView cartRecycler;
    private com.doubleclick.marktinhome.Adapters.CartAdapter cartAdapter;
    private android.widget.TextView Continue;
    private android.widget.TextView totalPrice;
    private double total = 0.0;
    public android.widget.TextView myOrder;
    private java.util.ArrayList<com.doubleclick.marktinhome.Model.Cart> carts;
    private java.util.HashMap _$_findViewCache;
    
    public CartFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.TextView getMyOrder() {
        return null;
    }
    
    public final void setMyOrder(@org.jetbrains.annotations.NotNull()
    android.widget.TextView p0) {
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @android.annotation.SuppressLint(value = {"NotifyDataSetChanged"})
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    public final void calculatePrice() {
    }
    
    @java.lang.Override()
    public void onPause() {
    }
    
    @java.lang.Override()
    public void getCart(@org.jetbrains.annotations.NotNull()
    com.doubleclick.marktinhome.Model.Cart cart) {
    }
    
    @android.annotation.SuppressLint(value = {"NotifyDataSetChanged"})
    @java.lang.Override()
    public void OnAddItemOrder(@org.jetbrains.annotations.NotNull()
    com.doubleclick.marktinhome.Model.Cart cart, int pos) {
    }
    
    @android.annotation.SuppressLint(value = {"NotifyDataSetChanged"})
    @java.lang.Override()
    public void OnMinsItemOrder(@org.jetbrains.annotations.NotNull()
    com.doubleclick.marktinhome.Model.Cart cart, int pos) {
    }
    
    @android.annotation.SuppressLint(value = {"NotifyDataSetChanged"})
    @java.lang.Override()
    public void OnDeleteItemOrder(@org.jetbrains.annotations.NotNull()
    com.doubleclick.marktinhome.Model.Cart cart, int pos) {
    }
}