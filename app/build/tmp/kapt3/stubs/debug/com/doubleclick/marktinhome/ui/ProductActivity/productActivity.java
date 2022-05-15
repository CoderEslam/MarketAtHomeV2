package com.doubleclick.marktinhome.ui.ProductActivity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010P\u001a\u00020QJ\u0012\u0010R\u001a\u00020Q2\b\u0010S\u001a\u0004\u0018\u00010TH\u0015J\u0010\u0010U\u001a\u00020Q2\b\u0010V\u001a\u0004\u0018\u00010\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\u0006X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\u0012X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0014\"\u0004\b\"\u0010\u0016R\u000e\u0010#\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010$\u001a\u00020%X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\'\"\u0004\b(\u0010)R\u000e\u0010*\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010+\u001a\u00020,X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u00101\u001a\u00020\u0006X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u000b\"\u0004\b3\u0010\rR\u000e\u00104\u001a\u000205X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u00106\u001a\u00020\u0006X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u000b\"\u0004\b8\u0010\rR\u001a\u00109\u001a\u00020\u0012X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0014\"\u0004\b;\u0010\u0016R\u000e\u0010<\u001a\u00020=X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010>\u001a\u00020?X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u001a\u0010D\u001a\u00020?X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bE\u0010A\"\u0004\bF\u0010CR\u000e\u0010G\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010H\u001a\u00020IX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u000e\u0010N\u001a\u00020OX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006W"}, d2 = {"Lcom/doubleclick/marktinhome/ui/ProductActivity/productActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "ToggleItem", "", "TotalRating", "Landroid/widget/TextView;", "banner_slier_view_pager", "Landroidx/viewpager/widget/ViewPager;", "comments", "getComments", "()Landroid/widget/TextView;", "setComments", "(Landroid/widget/TextView;)V", "fab", "Lcom/google/android/material/floatingactionbutton/FloatingActionButton;", "lastPrice", "mins", "Landroid/widget/ImageView;", "getMins", "()Landroid/widget/ImageView;", "setMins", "(Landroid/widget/ImageView;)V", "nestedScrollColor", "Landroidx/core/widget/NestedScrollView;", "nestedScrollSize", "pieChartView", "Llecho/lib/hellocharts/view/PieChartView;", "getPieChartView", "()Llecho/lib/hellocharts/view/PieChartView;", "setPieChartView", "(Llecho/lib/hellocharts/view/PieChartView;)V", "plus", "getPlus", "setPlus", "price", "product", "Lcom/doubleclick/marktinhome/Model/Product;", "getProduct", "()Lcom/doubleclick/marktinhome/Model/Product;", "setProduct", "(Lcom/doubleclick/marktinhome/Model/Product;)V", "productName", "qNumber", "", "getQNumber", "()I", "setQNumber", "(I)V", "quantity", "getQuantity", "setQuantity", "rateViewModel", "Lcom/doubleclick/ViewModel/RateViewModel;", "ratingSeller", "getRatingSeller", "setRatingSeller", "share", "getShare", "setShare", "speedView", "Lcom/github/anastr/speedviewlib/AwesomeSpeedometer;", "toggleColors", "Lcom/nex3z/togglebuttongroup/SingleSelectToggleGroup;", "getToggleColors", "()Lcom/nex3z/togglebuttongroup/SingleSelectToggleGroup;", "setToggleColors", "(Lcom/nex3z/togglebuttongroup/SingleSelectToggleGroup;)V", "toggleSizes", "getToggleSizes", "setToggleSizes", "trarmark", "webView", "Landroid/webkit/WebView;", "getWebView", "()Landroid/webkit/WebView;", "setWebView", "(Landroid/webkit/WebView;)V", "yourRate", "Landroid/widget/RatingBar;", "ShareProduct", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setBannerSliderViewPager", "list", "app_debug"})
public final class productActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.google.android.material.floatingactionbutton.FloatingActionButton fab;
    private androidx.viewpager.widget.ViewPager banner_slier_view_pager;
    private android.widget.TextView productName;
    private android.widget.TextView trarmark;
    private android.widget.TextView price;
    private android.widget.TextView lastPrice;
    private android.widget.TextView TotalRating;
    private android.widget.RatingBar yourRate;
    private com.doubleclick.ViewModel.RateViewModel rateViewModel;
    public android.widget.ImageView plus;
    public android.widget.ImageView mins;
    public android.widget.TextView quantity;
    private int qNumber = 0;
    public android.widget.ImageView share;
    public lecho.lib.hellocharts.view.PieChartView pieChartView;
    public android.widget.TextView ratingSeller;
    private java.lang.String ToggleItem = "";
    public android.widget.TextView comments;
    public com.doubleclick.marktinhome.Model.Product product;
    public com.nex3z.togglebuttongroup.SingleSelectToggleGroup toggleSizes;
    public com.nex3z.togglebuttongroup.SingleSelectToggleGroup toggleColors;
    public android.webkit.WebView webView;
    private com.github.anastr.speedviewlib.AwesomeSpeedometer speedView;
    private androidx.core.widget.NestedScrollView nestedScrollColor;
    private androidx.core.widget.NestedScrollView nestedScrollSize;
    private java.util.HashMap _$_findViewCache;
    
    public productActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.ImageView getPlus() {
        return null;
    }
    
    public final void setPlus(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.ImageView getMins() {
        return null;
    }
    
    public final void setMins(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.TextView getQuantity() {
        return null;
    }
    
    public final void setQuantity(@org.jetbrains.annotations.NotNull()
    android.widget.TextView p0) {
    }
    
    public final int getQNumber() {
        return 0;
    }
    
    public final void setQNumber(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.ImageView getShare() {
        return null;
    }
    
    public final void setShare(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final lecho.lib.hellocharts.view.PieChartView getPieChartView() {
        return null;
    }
    
    public final void setPieChartView(@org.jetbrains.annotations.NotNull()
    lecho.lib.hellocharts.view.PieChartView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.TextView getRatingSeller() {
        return null;
    }
    
    public final void setRatingSeller(@org.jetbrains.annotations.NotNull()
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.TextView getComments() {
        return null;
    }
    
    public final void setComments(@org.jetbrains.annotations.NotNull()
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.doubleclick.marktinhome.Model.Product getProduct() {
        return null;
    }
    
    public final void setProduct(@org.jetbrains.annotations.NotNull()
    com.doubleclick.marktinhome.Model.Product p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.nex3z.togglebuttongroup.SingleSelectToggleGroup getToggleSizes() {
        return null;
    }
    
    public final void setToggleSizes(@org.jetbrains.annotations.NotNull()
    com.nex3z.togglebuttongroup.SingleSelectToggleGroup p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.nex3z.togglebuttongroup.SingleSelectToggleGroup getToggleColors() {
        return null;
    }
    
    public final void setToggleColors(@org.jetbrains.annotations.NotNull()
    com.nex3z.togglebuttongroup.SingleSelectToggleGroup p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.webkit.WebView getWebView() {
        return null;
    }
    
    public final void setWebView(@org.jetbrains.annotations.NotNull()
    android.webkit.WebView p0) {
    }
    
    @android.annotation.SuppressLint(value = {"SetTextI18n", "ResourceType"})
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.M)
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public final void setBannerSliderViewPager(@org.jetbrains.annotations.Nullable()
    java.lang.String list) {
    }
    
    public final void ShareProduct() {
    }
}