package com.doubleclick.marktinhome.ui.MainScreen.Parents;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0016\u0010#\u001a\u00020$2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\'0&H\u0002J\b\u0010(\u001a\u00020$H\u0002J\u0012\u0010)\u001a\u00020$2\b\u0010*\u001a\u0004\u0018\u00010+H\u0014J\u0012\u0010,\u001a\u00020$2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\u0014\u0010/\u001a\u00020$2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\'0&J\b\u00100\u001a\u00020$H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082D\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u00020\u001eX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"\u00a8\u00061"}, d2 = {"Lcom/doubleclick/marktinhome/ui/MainScreen/Parents/ParentActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/doubleclick/OnProduct;", "()V", "DELAY_TIME", "", "PERIOD_TIME", "binding", "Lcom/doubleclick/marktinhome/databinding/ActivityParentBinding;", "getBinding", "()Lcom/doubleclick/marktinhome/databinding/ActivityParentBinding;", "setBinding", "(Lcom/doubleclick/marktinhome/databinding/ActivityParentBinding;)V", "classificationPC", "Lcom/doubleclick/marktinhome/Model/ClassificationPC;", "getClassificationPC", "()Lcom/doubleclick/marktinhome/Model/ClassificationPC;", "setClassificationPC", "(Lcom/doubleclick/marktinhome/Model/ClassificationPC;)V", "currentPage", "", "productViewModel", "Lcom/doubleclick/ViewModel/ProductViewModel;", "getProductViewModel", "()Lcom/doubleclick/ViewModel/ProductViewModel;", "setProductViewModel", "(Lcom/doubleclick/ViewModel/ProductViewModel;)V", "timer", "Ljava/util/Timer;", "viewPagerParentAdapter", "Lcom/doubleclick/marktinhome/Adapters/ViewPagerParentAdapter;", "getViewPagerParentAdapter", "()Lcom/doubleclick/marktinhome/Adapters/ViewPagerParentAdapter;", "setViewPagerParentAdapter", "(Lcom/doubleclick/marktinhome/Adapters/ViewPagerParentAdapter;)V", "StartbannerSlideShow", "", "list", "", "", "StopBannerSlideShow", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onItemProduct", "product", "Lcom/doubleclick/marktinhome/Model/Product;", "setBannerSliderViewPager", "setupPagerFragment", "app_debug"})
public final class ParentActivity extends androidx.appcompat.app.AppCompatActivity implements com.doubleclick.OnProduct {
    public com.doubleclick.marktinhome.databinding.ActivityParentBinding binding;
    public com.doubleclick.marktinhome.Model.ClassificationPC classificationPC;
    public com.doubleclick.ViewModel.ProductViewModel productViewModel;
    private int currentPage = 0;
    private java.util.Timer timer;
    private final long DELAY_TIME = 2000L;
    private final long PERIOD_TIME = 2000L;
    public com.doubleclick.marktinhome.Adapters.ViewPagerParentAdapter viewPagerParentAdapter;
    private java.util.HashMap _$_findViewCache;
    
    public ParentActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.doubleclick.marktinhome.databinding.ActivityParentBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    com.doubleclick.marktinhome.databinding.ActivityParentBinding p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.doubleclick.marktinhome.Model.ClassificationPC getClassificationPC() {
        return null;
    }
    
    public final void setClassificationPC(@org.jetbrains.annotations.NotNull()
    com.doubleclick.marktinhome.Model.ClassificationPC p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.doubleclick.ViewModel.ProductViewModel getProductViewModel() {
        return null;
    }
    
    public final void setProductViewModel(@org.jetbrains.annotations.NotNull()
    com.doubleclick.ViewModel.ProductViewModel p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.doubleclick.marktinhome.Adapters.ViewPagerParentAdapter getViewPagerParentAdapter() {
        return null;
    }
    
    public final void setViewPagerParentAdapter(@org.jetbrains.annotations.NotNull()
    com.doubleclick.marktinhome.Adapters.ViewPagerParentAdapter p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public final void setBannerSliderViewPager(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> list) {
    }
    
    private final void StartbannerSlideShow(java.util.List<java.lang.String> list) {
    }
    
    private final void StopBannerSlideShow() {
    }
    
    private final void setupPagerFragment() {
    }
    
    @java.lang.Override()
    public void onItemProduct(@org.jetbrains.annotations.Nullable()
    com.doubleclick.marktinhome.Model.Product product) {
    }
}