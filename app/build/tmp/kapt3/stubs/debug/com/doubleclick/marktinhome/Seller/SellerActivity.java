package com.doubleclick.marktinhome.Seller;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0012\u0010 \u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0012\u0010!\u001a\u00020\u001d2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0014R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006$"}, d2 = {"Lcom/doubleclick/marktinhome/Seller/SellerActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/doubleclick/OnOrder;", "()V", "MyOrder", "Landroidx/recyclerview/widget/RecyclerView;", "getMyOrder", "()Landroidx/recyclerview/widget/RecyclerView;", "setMyOrder", "(Landroidx/recyclerview/widget/RecyclerView;)V", "cartViewModel", "Lcom/doubleclick/ViewModel/CartViewModel;", "getCartViewModel", "()Lcom/doubleclick/ViewModel/CartViewModel;", "setCartViewModel", "(Lcom/doubleclick/ViewModel/CartViewModel;)V", "orderViewModel", "Lcom/doubleclick/ViewModel/OrderViewModel;", "getOrderViewModel", "()Lcom/doubleclick/ViewModel/OrderViewModel;", "setOrderViewModel", "(Lcom/doubleclick/ViewModel/OrderViewModel;)V", "reference", "Lcom/google/firebase/database/DatabaseReference;", "getReference", "()Lcom/google/firebase/database/DatabaseReference;", "setReference", "(Lcom/google/firebase/database/DatabaseReference;)V", "OnCancelItemOrder", "", "orders", "Lcom/doubleclick/marktinhome/Model/Orders;", "OnOKItemOrder", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"})
public final class SellerActivity extends androidx.appcompat.app.AppCompatActivity implements com.doubleclick.OnOrder {
    public androidx.recyclerview.widget.RecyclerView MyOrder;
    public com.doubleclick.ViewModel.CartViewModel cartViewModel;
    public com.doubleclick.ViewModel.OrderViewModel orderViewModel;
    public com.google.firebase.database.DatabaseReference reference;
    private java.util.HashMap _$_findViewCache;
    
    public SellerActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.recyclerview.widget.RecyclerView getMyOrder() {
        return null;
    }
    
    public final void setMyOrder(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.doubleclick.ViewModel.CartViewModel getCartViewModel() {
        return null;
    }
    
    public final void setCartViewModel(@org.jetbrains.annotations.NotNull()
    com.doubleclick.ViewModel.CartViewModel p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.doubleclick.ViewModel.OrderViewModel getOrderViewModel() {
        return null;
    }
    
    public final void setOrderViewModel(@org.jetbrains.annotations.NotNull()
    com.doubleclick.ViewModel.OrderViewModel p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.firebase.database.DatabaseReference getReference() {
        return null;
    }
    
    public final void setReference(@org.jetbrains.annotations.NotNull()
    com.google.firebase.database.DatabaseReference p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void OnOKItemOrder(@org.jetbrains.annotations.Nullable()
    com.doubleclick.marktinhome.Model.Orders orders) {
    }
    
    @java.lang.Override()
    public void OnCancelItemOrder(@org.jetbrains.annotations.Nullable()
    com.doubleclick.marktinhome.Model.Orders orders) {
    }
}