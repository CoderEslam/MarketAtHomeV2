package com.doubleclick.marktinhome.ui.MainScreen.ViewMore;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0015J\u0012\u0010\u0010\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/doubleclick/marktinhome/ui/MainScreen/ViewMore/ViewMoreActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/doubleclick/OnProduct;", "()V", "loadMoreViewModel", "Lcom/doubleclick/ViewModel/LoadMoreViewModel;", "products", "Ljava/util/ArrayList;", "Lcom/doubleclick/marktinhome/Model/Product;", "Lkotlin/collections/ArrayList;", "viewMoreRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onItemProduct", "product", "app_debug"})
public final class ViewMoreActivity extends androidx.appcompat.app.AppCompatActivity implements com.doubleclick.OnProduct {
    private androidx.recyclerview.widget.RecyclerView viewMoreRecyclerView;
    private com.doubleclick.ViewModel.LoadMoreViewModel loadMoreViewModel;
    private java.util.ArrayList<com.doubleclick.marktinhome.Model.Product> products;
    private java.util.HashMap _$_findViewCache;
    
    public ViewMoreActivity() {
        super();
    }
    
    @android.annotation.SuppressLint(value = {"NotifyDataSetChanged"})
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onItemProduct(@org.jetbrains.annotations.Nullable()
    com.doubleclick.marktinhome.Model.Product product) {
    }
}